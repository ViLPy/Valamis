package com.arcusys.learn.controllers.api.tincan

import java.io.ByteArrayInputStream
import java.security.cert.CertificateFactory
import java.security.interfaces.RSAPublicKey
import java.util.UUID
import javax.security.cert.CertificateException

import com.arcusys.learn.bl.exceptions.{ EntityNotFoundException, DuplicateEntityException }
import com.arcusys.learn.controllers.oauth.BaseLrsClientApiApiController
import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.bl.services.tincan.StatementServiceContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.tincan.StatementRequest
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer.{ JSONDeserializerException, JSONSerializerException, _ }
import com.arcusys.learn.tincan.api.serializer.SerializeFormat
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.arcusys.learn.tincan.lrs.statement.{ StatementLRSAlreadyExistsException, StatementLRSException, _ }
import com.arcusys.learn.tincan.model.{ Statement, StatementResult }
import com.arcusys.learn.web.FileUploading
import com.escalatesoft.subcut.inject.BindingModule
import com.nimbusds.jose.JWSObject
import com.nimbusds.jose.crypto.RSASSAVerifier
import com.nimbusds.jose.util.Base64
import org.apache.commons.fileupload.FileItem
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import org.scalatra.servlet.MultipartConfig

import scala.collection.JavaConverters._

class TincanStatementApiController(configuration: BindingModule) extends BaseLrsClientApiApiController(configuration) with TincanMethodOverride with FileUploading {
  configureMultipartHandling(MultipartConfig(maxFileSize = Some(20 * 1024 * 1024)))
  def this() = this(Configuration)

  private lazy val statementFacade = inject[StatementServiceContract]

  after() {
    response.addHeader("X-Experience-API-Consistent-Through", new DateTime().toString(ISODateTimeFormat.dateTime()))
    response.addHeader("X-Experience-API-Version", "1.0.1")
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
    response.addHeader("Access-Control-Allow-Origin", "*")
  }

  options() {
    response.setHeader("Access-Control-Allow-Methods", "HEAD,GET,POST,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,If-Match,If-None-Match,X-Experience-API-Version,X-Experience-API-Consistent-Through")
    response.setHeader("Access-Control-Expose-Headers", "ETag,Last-Modified,Cache-Control,Content-Type,Content-Length,WWW-Authenticate,X-Experience-API-Version,X-Experience-API-Consistent-Through")
  }

  put("/statements(/)")(action {
    //TODO implement scope permissions. use app.scope
    val statementRequest = StatementRequest(this)
    saveStatement(Option(statementRequest.statementIdRequired), false)
  })

  post("/statements(/)")(action {
    try {
      val statements = deserializeStatements(getStatementRaw)
      saveAttachments(statements)
      OkJson(serializeIds(statementFacade.saveStatements(statements).map(id => id.toString)))
    } catch {
      case e: JSONDeserializerException => {
        // if deserialization of list failed, try to add single statement
        saveStatement(None, true)
      }
      case _: JSONSerializerException => throw new BadRequestException("Service cannot serialize response list of statements uuids")
      case exception: StatementLRSAlreadyExistsException => {
        throw new DuplicateEntityException
      }
      case exception: Exception => {
        exception.printStackTrace()
        throw new BadRequestException(exception.getMessage)
      }
    }
  })

  get("/statements(/)")(action {

    val statementRequest = StatementRequest(this)
    val format = statementRequest.format.map(s => try {
      FormatType.withName(s)
    } catch {
      case e: Exception => throw new BadRequestException("Parameter 'format' is not valid. Valid formats are: ids, exact, canonical")
    })

    val actor = try {
      statementRequest.agent.map(deserializeActor)
    } catch {
      case e: JSONDeserializerException => throw new BadRequestException("Object with name 'actor' could not be created from the provided JSON.")
    }

    val registration = try {
      statementRequest.registration.map(UUID.fromString)
    } catch {
      case _ => throw new BadRequestException("Invalid 'registration' parameter, it must be UUID")
    }

    try {
      val result = statementFacade.getStatements(
        statementRequest.statementId,
        statementRequest.voidedStatementId,
        actor,
        statementRequest.verb,
        statementRequest.activity,
        registration,
        statementRequest.since,
        statementRequest.until,
        statementRequest.related_activities,
        statementRequest.related_agents,
        statementRequest.limit,
        format,
        statementRequest.attachments,
        statementRequest.ascending
      )

      getStatement(result,
        statementRequest.statementId,
        statementRequest.voidedStatementId,
        format,
        statementRequest.attachments
      )
    } catch {
      case e: JSONSerializerException => throw new EntityNotFoundException("Cannot serialize statement object")
      case exception: StatementLRSException => {
        throw new BadRequestException(exception.message)
      }

      case exception: Exception => {
        exception.printStackTrace()
        throw new BadRequestException(exception.getMessage)
      }

    }

  })

  private def saveStatement(statementId: Option[String], responseResult: Boolean): Unit = {
    try {
      val statement = deserializeStatement(getStatementRaw)
      val newId = statementId.map(id => try {
        UUID.fromString(id)
      } catch {
        case _ => throw new BadRequestException("Invalid statementId, it must be UUID")
      })
      saveAttachments(Seq(statement))
      val uuid = statementFacade.saveStatement(statement, newId, getCompanyId)
      if (responseResult)
        OkJson(serializeIds(Seq(uuid.toString)))
      else
        NoContent
    } catch {
      case e: JSONDeserializerException => throw new BadRequestException(e.message)
      case e: JSONSerializerException   => throw new BadRequestException(e.message)
      case exception: StatementLRSAlreadyExistsException => {
        throw new DuplicateEntityException
      }
      case exception: Exception =>
        exception.printStackTrace()
        throw new BadRequestException(exception.getMessage)
    }
  }

  private def isSignatureAndCheckIt(fileItem: FileItem, statement: Statement): Boolean = {
    val hashOfContent = fileItem.getHeaders.getHeader("X-Experience-API-Hash")
    val attachment = statement.attachments.find(a => a.sha2.equalsIgnoreCase(hashOfContent)).get
    if (!attachment.isSignature)
      false

    // if attachment = signature, start to verify it

    // get x.509 certificate and public key of it
    def toPubKey(key: Base64): RSAPublicKey = {
      val res = key.decode
      val certificateFactory = CertificateFactory.getInstance("X.509")
      val cert = certificateFactory.generateCertificate(new ByteArrayInputStream(res))
      cert.getPublicKey().asInstanceOf[RSAPublicKey]
    }

    // parse signature to JWS object
    val jwsObject1 = try {
      JWSObject.parse(fileItem.getString);
    } catch {
      case _: Throwable => throw new BadRequestException(s"Some issue at signature verify (sha2 = $hashOfContent)")
    }

    // get X509CertChain
    val publicKeyDecs = jwsObject1.getHeader.getX509CertChain.asScala.map(x5c => {
      try {
        toPubKey(jwsObject1.getHeader.getX509CertChain.asScala.head)
      } catch {
        case e: CertificateException => null
      }
    }).filter(_ != null)

    if (publicKeyDecs.size == 0)
      throw new BadRequestException(s"No X.509 certificate in JWS Headers (sha2 = $hashOfContent)")

    // verify signature
    publicKeyDecs.foreach(pk => {
      val verifier = new RSASSAVerifier(pk)

      if (!jwsObject1.verify(verifier))
        throw new BadRequestException(s"Signature of statement is not valid (sha2 = $hashOfContent)")

      val statementSign = deserializeStatement(jwsObject1.getPayload.toString)

      if (!statement.equalsWith(statementSign))
        throw new BadRequestException(s"Statement from signature does not equal with original (sha2 = $hashOfContent)")
    })

    true
  }

  // Check and save attachments for statement
  private def saveAttachments(statements: Seq[Statement]): Unit = {
    val statementHashes = statements.map(s => s.attachments).flatMap(a => a).map(_.sha2).filter(!_.isEmpty)
    if (multipartFlag) {
      val attachments = getStatementAttachments.toSeq
      val filesHashes = attachments.map(fi => fi.getHeaders.getHeader("X-Experience-API-Hash")).filter(!_.isEmpty)

      statementHashes.foreach(sh =>
        if (!filesHashes.contains(sh))
          throw new BadRequestException("Attachments with hashes " + sh + " are required, but no attachment data was included")
      )
      filesHashes.foreach(fh =>
        if (!statementHashes.contains(fh))
          throw new BadRequestException("Posted attachment does not correspond to any attachment header in statement JSON. Computed hash is: " + fh + ". ")
      )

      attachments.foreach(fi => {
        val hashOfContent = fi.getHeaders.getHeader("X-Experience-API-Hash")
        if (!isSignatureAndCheckIt(fi, statements.find(s => s.attachments.find(a => a.sha2.equalsIgnoreCase(hashOfContent)).isDefined).get))
          statementFacade.saveAttachment(hashOfContent, fi.get())
      })
    } else {
      statementHashes.foreach(sh => throw new BadRequestException("Attachments with hashes" + sh + " are required, but no attachment data was included"))
    }
  }

  // get attachments parts from request body
  private def getStatementAttachments = {
    if (multipartFlag) {
      val iter = fileMultiParams.iterator
      (for (fi <- iter) yield fi._2).flatMap(f => f)
    } else
      Seq()
  }

  // PRIVATE methods for working with multipart content
  // Scalatra requirements: IN request body you need to separate parts by Content-Disposition: form-data; name=""[; filename="if it is attachment-file part]"

  private def getStatementRaw: String = {
    if (multipartFlag) {
      if (request.getParameterMap.size == 0) {
        throw new BadRequestException("No one part of content with statement(s). Check Content-Disposition in request.")
      }
      if (request.getParameterMap.size > 1) {
        throw new BadRequestException("More than one part of content with statement(s)")
      }
      request.getParameterMap.asScala.head._2.asInstanceOf[Array[String]].head
    } else
      request.body
  }

  private def multipartFlag = request.getContentType != null && request.getContentType.contains("multipart/mixed")

  private def getStatement(result: StatementResult,
    statementId: Option[String],
    voidedStatementId: Option[String],
    format: Option[FormatType.Value],
    attachments: Option[Boolean]) {
    val rawStatement =
      if (statementId.isDefined || voidedStatementId.isDefined) {
        if (result.statements.headOption.isDefined) {
          if (format.isDefined) {
            val lang = request.getHeader("Accept-Language")
            serializeStatement(result.statements.head, SerializeFormat(format.get.toString, lang))
          } else
            serializeStatement(result.statements.head)
        } else {
          if (statementId.isDefined)
            throw new EntityNotFoundException("Statement with id = '" + statementId.get.toString
              + "' is not found")
          else if (voidedStatementId.isDefined)
            throw new EntityNotFoundException("Voided statement with id = '" + voidedStatementId.get.toString
              + "' is not found")
          ""
        }
      } else {
        if (format.isDefined) {
          val lang = request.getHeader("Accept-Language")
          serializeStatementResult(result, SerializeFormat(format.get.toString, lang))
        } else
          serializeStatementResult(result)
      }

    if (!attachments.getOrElse(false))
      OkJson(rawStatement)
    else {
      // response with attachments
      val fileParts = result.statements
        .map(st => st.attachments.filter(!_.fileUrl.isDefined))
        .flatMap(a => a)
      // if all attachments has fileUrl use application/json response
      if (fileParts.size == 0)
        OkJson(rawStatement)
      else {
        // if one or more attachments hasn't fileUrl use mutipart/mixed response
        // TODO: If you know framework to implement mutipart/mixed response, rewrite please this part of code
        val boundary = "boundary"
        var content =
          s"""
            |--boundary
            |Content-Length:${rawStatement.length}
            |Content-Type:application/json; charset=UTF-8
            |
            |${rawStatement}"""
        fileParts.foreach(fp => {
          statementFacade.getAttachment(fp.sha2).map(contentFile => {
            content +=
              s"""
                |--boundary
                |Content-Length:${contentFile.length}
                |X-Experience-API-Hash:${fp.sha2}
                |Content-Type:${fp.contentType}
                |
                |$contentFile"""
          })
        })

        content +=
          s"""
             |--boundary--""".stripMargin

        response.setHeader("Content-Type", "multipart/mixed; boundary=boundary")
        Ok(content.stripMargin)
      }
    }
  }

}
