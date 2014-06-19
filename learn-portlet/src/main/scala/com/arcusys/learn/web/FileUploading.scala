package com.arcusys.learn.web

import org.scalatra.servlet.HasMultipartConfig
import org.scalatra.ScalatraBase
import org.scalatra.util._
import org.apache.commons.fileupload.servlet.ServletFileUpload
import org.apache.commons.fileupload.{ FileItemFactory, FileItem }
import org.apache.commons.fileupload.disk.DiskFileItemFactory

import java.util.{ List => JList, HashMap => JHashMap }
import javax.servlet.http._
import scala.collection.JavaConverters._

trait FileUploading extends ServletBase with HasMultipartConfig {
  import FileUploading._

  /* Called for any exceptions thrown by handling file uploads
   * to detect whether it signifies a too large file being
   * uploaded or a too large request in general.
   *
   * This can be overriden for the container being used if it
   * doesn't throw `IllegalStateException` or if it throws
   * `IllegalStateException` for some other reason.
   */
  protected def isSizeConstraintException(e: Exception) = e match {
    case _: IllegalStateException => true
    case _                        => false
  }

  override def handle(req: HttpServletRequest, res: HttpServletResponse) {
    val req2 = try {
      if (isMultipartRequest(req)) {
        val bodyParams = extractMultipartParams(req)
        val mergedFormParams = mergeFormParamsWithQueryString(req, bodyParams)

        wrapRequest(req, mergedFormParams)
      } else req
    } catch {
      case e: Exception => {
        req.setAttribute(ScalatraBase.PrehandleExceptionKey, e)
        req
      }
    }

    super.handle(req2, res)
  }

  private def isMultipartRequest(req: HttpServletRequest): Boolean = {
    val isPostOrPut = Set("POST", "PUT", "PATCH").contains(req.getMethod)
    isPostOrPut && (req.contentType match {
      case Some(contentType) => contentType.startsWith("multipart/")
      case _                 => false
    })
  }

  private def extractMultipartParams(req: HttpServletRequest): BodyParams = {
    req.get(BodyParamsKey).asInstanceOf[Option[BodyParams]] match {
      case Some(bodyParams) =>
        bodyParams
      case None =>
        val upload = newServletFileUpload
        val items = upload.parseRequest(req).asInstanceOf[JList[FileItem]]
        val bodyParams = items.asScala.foldRight(BodyParams(FileMultiParams(), Map.empty)) { (item, params) =>
          if (item.isFormField)
            BodyParams(params.fileParams, params.formParams + ((item.getFieldName, fileItemToString(item) :: params.formParams.getOrElse(item.getFieldName, List[String]()))))
          else
            BodyParams(params.fileParams + ((item.getFieldName, item +: params.fileParams.getOrElse(item.getFieldName, List[FileItem]()))), params.formParams)
        }
        req(BodyParamsKey) = bodyParams
        bodyParams
    }
  }

  protected def newServletFileUpload: ServletFileUpload =
    new ServletFileUpload(fileItemFactory)

  protected def fileItemFactory: FileItemFactory = new DiskFileItemFactory

  protected def fileItemToString(item: FileItem): String = {
    new String(item.get().map(_.toChar))
  }

  private def mergeFormParamsWithQueryString(req: HttpServletRequest, bodyParams: BodyParams) = {
    var mergedParams = bodyParams.formParams
    val names = req.getParameterNames.asScala.map(_.toString)
    names.foreach {
      case n =>
        val formValues = mergedParams.getOrElse(n, Nil)
        mergedParams += n -> (req.getParameterValues(n).toList ++ formValues)
    }
    mergedParams
  }

  private def wrapRequest(req: HttpServletRequest, formMap: Map[String, Seq[String]]) = {
    val wrapped = new HttpServletRequestWrapper(req) {
      override def getParameter(name: String) = formMap.get(name) map {
        _.head
      } getOrElse null

      override def getParameterNames = formMap.keysIterator.asJavaEnumeration

      override def getParameterValues(name: String) = formMap.get(name) map {
        _.toArray
      } getOrElse null

      override def getParameterMap = (new JHashMap[String, Array[String]].asScala ++ (formMap transform {
        (k, v) => v.toArray
      })).asJava
    }
    wrapped
  }

  def fileMultiParams(implicit request: HttpServletRequest): FileMultiParams = extractMultipartParams(request).fileParams
  def fileMultiParams(key: String)(implicit request: HttpServletRequest): Seq[FileItem] = fileMultiParams(request)(key)

  /**
   * @return a Map, keyed on the names of multipart file upload parameters,
   *         of all multipart files submitted with the request
   */
  def fileParams(implicit request: HttpServletRequest) = new MultiMapHeadView[String, FileItem] {
    protected def multiMap = fileMultiParams
  }

  def fileParams(key: String)(implicit request: HttpServletRequest): FileItem = fileParams(request)(key)

}

object FileUploading {
  private val BodyParamsKey = "org.scalatra.fileupload.bodyParams"
  case class BodyParams(fileParams: FileMultiParams, formParams: Map[String, List[String]])
}

class FileMultiParams(wrapped: Map[String, Seq[FileItem]] = Map.empty) extends Map[String, Seq[FileItem]] {

  def get(key: String): Option[Seq[FileItem]] = {
    (wrapped.get(key) orElse wrapped.get(key + "[]"))
  }

  def get(key: Symbol): Option[Seq[FileItem]] = get(key.name)

  def +[B1 >: Seq[FileItem]](kv: (String, B1)) =
    new FileMultiParams(wrapped + kv.asInstanceOf[(String, Seq[FileItem])])

  def -(key: String) = new FileMultiParams(wrapped - key)

  def iterator = wrapped.iterator

  override def default(a: String): Seq[FileItem] = wrapped.default(a)
}

object FileMultiParams {
  def apply() = new FileMultiParams

  def apply[SeqType <: Seq[FileItem]](wrapped: Map[String, Seq[FileItem]]) =
    new FileMultiParams(wrapped)
}

class FileUploadingException(msg: String) extends Exception(msg)