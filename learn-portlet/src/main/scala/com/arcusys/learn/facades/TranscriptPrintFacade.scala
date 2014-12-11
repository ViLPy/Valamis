package com.arcusys.learn.facades

/*
 *  The facade for printing user's learning transcript.
 *  Admin can choose a user to print a transcript for.
 */

import java.io._
import com.arcusys.learn.bl.services.{ GradeBookServiceContract, CertificateServiceContract }
import javax.xml.transform.TransformerFactory
import javax.xml.transform.sax.SAXResult
import javax.xml.transform.stream.StreamSource
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.CourseResponse
import com.arcusys.learn.models.Gradebook.PackageGradeResponse
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.scorm.certificating.CertificateUserRepositoryContract
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.tincan.model.{ Activity, Statement }
import com.arcusys.learn.util.mustache.Mustache
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import org.apache.fop.apps.FopFactory
import org.apache.xmlgraphics.util.MimeConstants
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class TranscriptPrintFacade(configuration: BindingModule) extends TranscriptPrintFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val gradebookFacade = inject[GradebookFacadeContract]
  val gradeBookService = inject[GradeBookServiceContract]
  val certificateFacade = inject[CertificateFacadeContract]
  val certificateService = inject[CertificateServiceContract]
  val courseFacade = inject[CourseFacadeContract]
  val userFacade = inject[UserFacadeContract]
  private lazy val certificateUserRepository = inject[CertificateUserRepositoryContract]

  def course2Map(course: CourseResponse) = Map(
    "id" -> course.id,
    "title" -> course.title,
    "description" -> course.description,
    "url" -> course.url
  )

  def certificate2Map(certificate: Certificate, i: Int, userID: Int) = Map(
    "id" -> certificate.id,
    "title" -> certificate.title,
    "description" -> certificate.description,
    "logo" -> certificate.logo,
    "isPermanent" -> certificate.isPermanent,
    "shortDescription" -> certificate.shortDescription,
    "companyId" -> certificate.companyId,
    "issueDate" -> DateTimeFormat.forPattern("dd/MM/yyyy HH:mm").print(getCertificateIssueDate(certificate.id, userID)),
    "expires" -> (certificate.validPeriodType match {
      case PeriodType.UNLIMITED =>
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

  def statement2Map(st: Statement, i: Int, userID: Int) = Map(
    "actor" -> st.actor.getName,
    "verb" -> st.verb.display.values.head,
    "object" -> st.obj.asInstanceOf[Activity].name.get.values.head,
    //    "score" -> st.result.get.score.get.scaled.toString,
    //    "response" -> st.result.get.response.get.replace("[", "").replace("]", "").replace(".", "->"),
    "timestamp" -> DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS").parseDateTime(st.timestamp.get.toString).toString(DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss"))
  )

  def getCertificateIssueDate(certificateID: Int, userID: Int): DateTime = {
    val goalsStatuses = certificateFacade.getGoalsStatuses(certificateID, userID)

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

    val finishDates = (activitiesFinishDates ++ coursesFinishDates ++ statementsFinishDates)
    finishDates.sortBy(_.getMillis)
    finishDates.head
  }

  def getCertificateExpirationDate(certificate: Certificate, userID: Int): DateTime = {
    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userID).head._1
    PeriodType.getEndDate(certificate.validPeriodType, Some(certificate.validPeriod), startDate)
  }

  def getPackageFOTemplate[T](templatePath: String, models: Seq[PackageGradeResponse], userID: Int) = {
    val modelTemplate = {
      val modelTemplateFileContents = scala.io.Source.fromFile(templatePath + "/package.fo").mkString
      new Mustache(modelTemplateFileContents)
    }

    var i = 0
    models.map { model =>
      i += 1
      val mappedPackage = package2Map(model, i, userID)
      val mappedPackageStatements = getStatementsFOTemplate(
        model.id,
        templatePath,
        gradeBookService.getStatementGrades(model.id, userID),
        userID
      )
      mappedPackageStatements match {
        case "" => mappedPackage + ("hasStatements" -> false)
        case _  => mappedPackage + ("hasStatements" -> true) + ("statements" -> mappedPackageStatements)
      }
    }.foldLeft("")((acc, model) => acc + modelTemplate.render(model))
  }

  def getStatementsFOTemplate[T](packageID: Int, templatePath: String, models: Seq[Statement], userID: Int) = {
    var attemptStart = -1
    var attemptEnd = 0
    var j = -1
    var i = 0
    var statementsTemplate = ""
    models.map { st =>
      if (st.obj.asInstanceOf[Activity].theType.get.substring(st.obj.asInstanceOf[Activity].theType.get.length - 6) == "course") {
        if (st.verb.id == "http://adlnet.gov/expapi/verbs/attempted") {
          i += 1
        }
      }
    }

    models.map { st =>
      j += 1
      if (st.obj.asInstanceOf[Activity].theType.get.substring(st.obj.asInstanceOf[Activity].theType.get.length - 6) == "course") {
        if (st.verb.id == "http://adlnet.gov/expapi/verbs/attempted") {
          attemptStart = j + 1
          val attemptStatements =
            if (attemptEnd >= 0 && attemptStart <= models.length) {
              models.slice(attemptEnd, attemptStart) /*.filter(s =>
                (s.verb.id == "http://adlnet.gov/expapi/verbs/answered" || s.verb.id == "http://adlnet.gov/expapi/verbs/experienced")
              )*/ .reverse
            } else
              Seq()

          if (j < models.length - 1) {
            if (models(j + 1).verb.id == "http://adlnet.gov/expapi/verbs/completed"
              && models(j + 1).obj.asInstanceOf[Activity].theType.get.substring(models(j + 1).obj.asInstanceOf[Activity].theType.get.length - 6) == "course")
              attemptEnd = j + 1
            else
              attemptEnd = j
          }

          statementsTemplate += getFOTemplate(templatePath + "/statement.fo", attemptStatements, statement2Map, userID, i)
          i -= 1
        }
      }
    }
    statementsTemplate
  }

  def getCourseFOTemplate(templatePath: String, models: Seq[CourseResponse], userID: Int) = {
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
            templatePath,
            gradebookFacade.getGradesForStudent(userID.toInt, model.id.toInt, -1, 0, false).packageGrades,
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

  def getFOTemplate[T](modelTemplateFileName: String, models: Seq[T], model2MapFunc: (T, Int, Int) => Map[String, Any], userID: Int, which: Int) = {
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
              model2MapFunc(model, i, userID) + ("showHeader" -> true) + ("which" -> which)
            else
              model2MapFunc(model, i, userID)
        }.foldLeft("")((acc, model) => acc + modelTemplate.render(model))
    }
  }

  override def printTranscript(companyID: Int, userID: Int, templatesPath: String): ByteArrayOutputStream = {
    val renderedCertificateFOTemplate = getFOTemplate(
      templatesPath + "/cert.fo",
      certificateService.getForUserWithStatus(companyID, -1, 1, "", true, userID, true),
      certificate2Map,
      userID,
      0
    )

    val renderedCourseFOTemplate = getCourseFOTemplate(
      templatesPath,
      courseFacade.getByUserId(userID.toInt),
      userID
    )

    val user = userFacade.byId(userID, true, false).asInstanceOf[UserShortResponse]

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
