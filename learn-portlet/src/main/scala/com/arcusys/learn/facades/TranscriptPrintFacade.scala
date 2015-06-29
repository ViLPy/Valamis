package com.arcusys.learn.facades

/*
 *  The facade for printing user's learning transcript.
 *  Admin can choose a user to print a transcript for.
 */

import java.io._
import javax.xml.transform.TransformerFactory
import javax.xml.transform.sax.SAXResult
import javax.xml.transform.stream.StreamSource

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.CourseResponse
import com.arcusys.learn.models.Gradebook.PackageGradeResponse
import com.arcusys.learn.models.response.certificates.CertificateResponse
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.certificate.service.CertificateService
import com.arcusys.valamis.certificate.storage.CertificateStateRepository
import com.arcusys.valamis.gradebook.service.GradeBookService
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.tincan._
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.util.mustache.Mustache
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import org.apache.fop.apps.FopFactory
import org.apache.xmlgraphics.util.MimeConstants
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class TranscriptPrintFacade(configuration: BindingModule) extends TranscriptPrintFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  private lazy val gradebookFacade = inject[GradebookFacadeContract]
  private lazy val gradeBookService = inject[GradeBookService]
  private lazy val certificateFacade = inject[CertificateFacadeContract]
  private lazy val certificateService = inject[CertificateService]
  private lazy val courseFacade = inject[CourseFacadeContract]
  private lazy val userFacade = inject[UserFacadeContract]
  private lazy val certificateUserRepository = inject[CertificateStateRepository]

  def course2Map(course: CourseResponse) = Map(
    "id" -> course.id,
    "title" -> course.title,
    "description" -> course.description,
    "url" -> course.url
  )

  def certificate2Map(statementApi: StatementApi, certificate: Certificate, i: Int, userID: Int) = Map(
    "id" -> certificate.id,
    "title" -> certificate.title,
    "description" -> certificate.description,
    "logo" -> certificate.logo,
    "isPermanent" -> certificate.isPermanent,
    "shortDescription" -> certificate.shortDescription,
    "companyId" -> certificate.companyId,
    "isEmpty" -> getCertificateIssueDate(statementApi, certificate.id, userID).keys.head,
    "issueDate" -> DateTimeFormat.forPattern("dd/MM/yyyy HH:mm").print(getCertificateIssueDate(statementApi, certificate.id, userID).head._2),
    "expires" -> (certificate.validPeriodType match {
      case PeriodTypes.UNLIMITED =>
        false
      case _ =>
        true
    }),
    "expirationDate" -> DateTimeFormat.forPattern("dd/MM/yyyy HH:mm").print(getCertificateExpirationDate(certificate, userID))
  )

  def package2Map(pack: PackageGradeResponse, i: Int, userID: Int) = Map(
    "packageName" -> pack.packageName,
    "description" -> pack.description,
    "grade" -> pack.grade
  )

  def statement2Map(statementApi: StatementApi, st: Statement, i: Int, userID: Int) = Map(
    "actor" -> st.actor.name,
    "verb" -> st.verb.display.values.head,
    "object" -> st.obj.asInstanceOf[Activity].name.get.values.head,
    "timestamp" -> st.timestamp.get.toString(DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss"))
  )

  def getCertificateIssueDate(statementApi: StatementApi, certificateID: Int, userID: Int): Map[Boolean, DateTime] = {
    val goalsStatuses = certificateFacade.getGoalsStatuses(statementApi, certificateID, userID)

    val activitiesFinishDates = goalsStatuses.activities.toList.map { activity =>
      activity.dateFinish.substring(activity.dateFinish.length - 2) match {
        case "PM" =>
          val date = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm").parseDateTime(activity.dateFinish.substring(0, activity.dateFinish.length - 3)).plusHours(12)
          if (date.getYear < 1000) date.plusYears(2000) else date
        case _ =>
          val date = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm").parseDateTime(activity.dateFinish.substring(0, activity.dateFinish.length - 3))
          if (date.getYear < 1000) date.plusYears(2000) else date
      }
    }

    val coursesFinishDates = goalsStatuses.courses.toList.map { course =>
      course.dateFinish.substring(course.dateFinish.length - 2) match {
        case "PM" =>
          val date = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm").parseDateTime(course.dateFinish.substring(0, course.dateFinish.length - 3)).plusHours(12)
          if (date.getYear < 1000) date.plusYears(2000) else date
        case _ =>
          val date = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm").parseDateTime(course.dateFinish.substring(0, course.dateFinish.length - 3))
          if (date.getYear < 1000) date.plusYears(2000) else date
      }
    }

    val statementsFinishDates = goalsStatuses.statements.toList.map { statement =>
      statement.dateFinish.substring(statement.dateFinish.length - 2) match {
        case "PM" =>
          val date = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm").parseDateTime(statement.dateFinish.substring(0, statement.dateFinish.length - 3)).plusHours(12)
          if (date.getYear < 1000) date.plusYears(2000) else date
        case _ =>
          val date = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm").parseDateTime(statement.dateFinish.substring(0, statement.dateFinish.length - 3))
          if (date.getYear < 1000) date.plusYears(2000) else date
      }
    }

    val finishDates = activitiesFinishDates ++ coursesFinishDates ++ statementsFinishDates
    finishDates.length match {
      case 0 =>
        Map(true -> DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parseDateTime(certificateFacade.getById(certificateID).asInstanceOf[CertificateResponse].users.filter(x => x._2.id == userID).head._1)
        )
      case _ =>
        finishDates.sortBy(_.getMillis)
        Map(false -> finishDates.head)
    }
  }

  def getCertificateExpirationDate(certificate: Certificate, userId: Int): DateTime = {
    val startDate = certificateUserRepository.getBy(userId, certificate.id).get.userJoinedDate
    PeriodTypes.getEndDate(certificate.validPeriodType, Some(certificate.validPeriod), startDate)
  }

  def getPackageFOTemplate[T](statementApi: StatementApi, templatePath: String, models: Seq[PackageGradeResponse], userID: Int) = {
    val modelTemplate = {
      val modelTemplateFileContents = scala.io.Source.fromFile(templatePath + "/package.fo").mkString
      new Mustache(modelTemplateFileContents)
    }

    var i = 0

    models.map { model =>
      i += 1
      val mappedPackage = package2Map(model, i, userID)
      val mappedPackageStatements = getStatementsFOTemplate(
        statementApi,
        templatePath,
        gradeBookService.getStatementGrades(statementApi, model.id, userID),
        userID
      )
      mappedPackageStatements match {
        case "" => mappedPackage + ("hasStatements" -> false)
        case _  => mappedPackage + ("hasStatements" -> true) + ("statements" -> mappedPackageStatements)
      }
    }.foldLeft("")((acc, model) => acc + modelTemplate.render(model))

  }

  def getStatementsFOTemplate[T](statementApi: StatementApi, templatePath: String, models: Seq[Statement], userID: Int) = {
    var onlyActivities = models.filter(_.obj.isInstanceOf[Activity])
    var attemptStart = -1
    var attemptEnd = 0
    var j = -1
    var i = 0
    var statementsTemplate = ""
    onlyActivities.foreach { st =>
      if (st.obj.asInstanceOf[Activity].theType.get.substring(st.obj.asInstanceOf[Activity].theType.get.length - 6) == "course") {
        if (st.verb.id == "http://adlnet.gov/expapi/verbs/attempted") {
          i += 1
        }
      }
    }

    onlyActivities.foreach { st =>
      j += 1
      if (st.obj.asInstanceOf[Activity].theType.get.substring(st.obj.asInstanceOf[Activity].theType.get.length - 6) == "course") {
        if (st.verb.id == "http://adlnet.gov/expapi/verbs/attempted") {
          attemptStart = j + 1
          val attemptStatements =
            if (attemptEnd >= 0 && attemptStart <= onlyActivities.length) {
              onlyActivities.slice(attemptEnd, attemptStart) /*.filter(s =>
                (s.verb.id == "http://adlnet.gov/expapi/verbs/answered" || s.verb.id == "http://adlnet.gov/expapi/verbs/experienced")
              )*/ .reverse
            } else
              Seq()

          if (j < onlyActivities.length - 1) {
            if (onlyActivities(j + 1).verb.id == "http://adlnet.gov/expapi/verbs/completed"
              && onlyActivities(j + 1).obj.asInstanceOf[Activity].theType.get.substring(onlyActivities(j + 1).obj.asInstanceOf[Activity].theType.get.length - 6) == "course")
              attemptEnd = j + 1
            else
              attemptEnd = j
          }

          statementsTemplate += getFOTemplate(statementApi, templatePath + "/statement.fo", attemptStatements, statement2Map, userID, i)
          i -= 1
        }
      }
    }
    statementsTemplate
  }

  def getCourseFOTemplate(statementApi: StatementApi, templatePath: String, models: Seq[CourseResponse], userID: Int) = {
    val modelTemplate = {
      val modelTemplateFileContents = scala.io.Source.fromFile(templatePath + "/course.fo").mkString
      new Mustache(modelTemplateFileContents)
    }

    var i = 0
    models.length match {
      case 0 =>
        ""
      case _ =>
        models.map { model =>
          i += 1
          var mappedCourse = course2Map(model)
          val mappedCoursePackages = getPackageFOTemplate(
            statementApi,
            templatePath,
            gradebookFacade.getGradesForStudent(statementApi, userID.toInt, model.id.toInt, -1, 0, false).packageGrades,
            userID
          )
          if (i == 1)
            mappedCourse += ("showHeader" -> true)

          mappedCoursePackages match {
            case "" => mappedCourse + ("hasPackages" -> false)
            case _  => mappedCourse + ("hasPackages" -> true) + ("packages" -> mappedCoursePackages)
          }
        }.foldLeft("")((acc, model) => acc + modelTemplate.render(model))
    }

  }

  def getFOTemplate[T](statementApi: StatementApi, modelTemplateFileName: String, models: Seq[T], model2MapFunc: (StatementApi, T, Int, Int) => Map[String, Any], userID: Int, which: Int) = {
    val modelTemplate = {
      val modelTemplateFileContents = scala.io.Source.fromFile(modelTemplateFileName).mkString
      new Mustache(modelTemplateFileContents)
    }

    var i = 0
    models.length match {
      case 0 =>
        ""
      case _ =>
        models.map {
          model =>
            i += 1
            if (i == 1 && which >= 0)
              model2MapFunc(statementApi, model, i, userID) + ("showHeader" -> true) + ("which" -> which)
            else
              model2MapFunc(statementApi, model, i, userID)
        }.foldLeft("")((acc, model) => acc + modelTemplate.render(model))
    }
  }

  override def printTranscript(statementApi: StatementApi, companyID: Int, userID: Int, templatesPath: String): ByteArrayOutputStream = {
    val renderedCertificateFOTemplate = getFOTemplate(
      statementApi,
      templatesPath + "/cert.fo",
      certificateService.getForUserWithStatus(companyID, -1, 1, "", true, userID, true),
      certificate2Map,
      userID,
      0
    )

    val renderedCourseFOTemplate = getCourseFOTemplate(
      statementApi,
      templatesPath,
      courseFacade.getByUserId(userID.toInt),
      userID
    )

    val user = userFacade.byId(statementApi, userID, true, false).asInstanceOf[UserShortResponse]

    val fopFactory = FopFactory.newInstance()

    fopFactory.setUserConfig(new File(templatesPath + "/fop-conf.xml"))
    // Step 3: Construct fop with desired output format
    val out = new ByteArrayOutputStream()
    val fop = fopFactory.newFop(MimeConstants.MIME_PDF, out)

    // Step 4: Setup JAXP using identity transformer
    val factory = TransformerFactory.newInstance()

    val transformer = factory.newTransformer() // identify transformer

    val templateFileName = "/transcript.fo"
    val fullPath = templatesPath + templateFileName
    //    val basePath = fullPath.replace(templateFileName, "")

    val fileContents = scala.io.Source.fromFile(fullPath).mkString
    val template = new Mustache(fileContents)
    val viewModel = Map(
      "username" -> user.name)

    var renderedFOTemplate = template.render(viewModel)

    renderedFOTemplate = renderedFOTemplate.substring(0, renderedFOTemplate.indexOf("</fo:table-cell>")) +
      renderedCourseFOTemplate +
      renderedCertificateFOTemplate +
      renderedFOTemplate.substring(renderedFOTemplate.indexOf("</fo:table-cell>"), renderedFOTemplate.length)

    val src = new StreamSource(new StringReader(renderedFOTemplate))

    // Resulting SAX events (the generated FO) must be piped through to FOP
    val res = new SAXResult(fop.getDefaultHandler)

    // Step 6: Start XSLT transformation and FOP processing
    transformer.transform(src, res)
    out
  }
}
