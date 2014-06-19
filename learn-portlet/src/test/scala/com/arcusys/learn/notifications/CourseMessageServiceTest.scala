package com.arcusys.learn.notifications

import com.arcusys.learn.facades.{ CertificateFacadeContract, CourseFacadeContract, PackageFacadeContract, UserFacadeContract }
import com.arcusys.learn.models.response.certificates.CertificateResponse
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.models.{ ValidPeriod, CourseResponse }
import com.arcusys.learn.scorm.tracking.model.PermissionType
import com.arcusys.learn.scorm.manifest.model.Manifest
import com.arcusys.learn.tincan.model.Statement

import com.escalatesoft.subcut.inject.NewBindingModule
import com.liferay.portal.kernel.mail.MailMessage
import java.util.UUID
import org.junit.runner.RunWith
import org.joda.time.DateTime
import org.mockito.Mockito._
import org.scalatest.{ Matchers, FlatSpec, BeforeAndAfter }
import org.scalatest.mock.MockitoSugar

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class CourseMessageServiceTest extends FlatSpec with BeforeAndAfter with Matchers with MockitoSugar {
  import CourseMessageService._

  private val usersMock = mock[UserFacadeContract]
  private val packagesMock = mock[PackageFacadeContract]
  private val coursesMock = mock[CourseFacadeContract]
  private val certificatesMock = mock[CertificateFacadeContract]

  val testingDataLoader = TestingTemplateLoader

  def service(tplLoader: MessageTemplateLoader = testingDataLoader) = new CourseMessageService with TestingMessageSender {
    override implicit def bindingModule = new NewBindingModule({ implicit module =>
      import module._
      bind[MessageTemplateLoader].toSingle(tplLoader)
      bind[UserFacadeContract].toSingle(usersMock)
      bind[PackageFacadeContract].toSingle(packagesMock)
      bind[CourseFacadeContract].toSingle(coursesMock)
      bind[CertificateFacadeContract].toSingle(certificatesMock)
    })
  }

  "CourseMessageService" should "send messages to those teachers whose courses were started by students" in {
    // mocks setup
    Mocks.setupStudents()
    Mocks.setupTeachers()
    Mocks.setupCourses()
    Mocks.setupPackages()
    Mocks.setupCoursesForTeachers()
    Mocks.setupStatements()

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendEnrolledStudentMessage()

    // verify results
    val testingData = testingDataLoader.sendingData.get("data").map(_.asInstanceOf[Seq[StudentRenderView]])
    testingData should not be None
    testingData.get.head.courseName should be("Courage Course")
    testingData.get.head.enrolledStudents should have size 2
    testingData.get.head.enrolledStudents.head should be("Test Student 1")
    testingData.get.head.enrolledStudents.last should be("Test Student 2")
    srv.isMessageSent shouldBe true

  }
  it should "not send any messages to teachers if there are no new students enrolled to courses" in {
    // setup mocks
    Mocks.setupStudents()
    Mocks.setupTeachers()
    Mocks.setupCourses()
    Mocks.setupPackages()
    Mocks.setupCoursesForTeachers()

    when(packagesMock.getStatements(1, 111))
      .thenReturn(Seq(
        Statement(UUID.randomUUID(), null, null, null, None, None, None, Some(DateTime.now.minusDays(3).toDate), None, None, Nil),
        Statement(UUID.randomUUID(), null, null, null, None, None, None, Some(DateTime.now.minusDays(5).toDate), None, None, Nil)
      ))
    when(packagesMock.getStatements(2, 111)).thenReturn(Nil)

    when(packagesMock.getStatements(1, 222))
      .thenReturn(Seq(
        Statement(UUID.randomUUID(), null, null, null, None, None, None, Some(DateTime.now.minusWeeks(1).toDate), None, None, Nil)
      ))
    when(packagesMock.getStatements(2, 222)).thenReturn(Nil)

    when(packagesMock.getStatements(1, 333))
      .thenReturn(Seq(
        Statement(UUID.randomUUID(), null, null, null, None, None, None, Some(DateTime.now.minusDays(2).toDate), None, None, Nil)
      ))
    when(packagesMock.getStatements(2, 333)).thenReturn(Nil)

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendEnrolledStudentMessage()

    // verify results
    srv.isMessageSent shouldBe false
  }
  it should "not send any messages to course teacher if he/she has invalid email address" in {
    // setup mocks
    Mocks.setupStudents()
    Mocks.setupTeachers(invalidateEmail = true)
    Mocks.setupCourses()
    Mocks.setupPackages()
    Mocks.setupCoursesForTeachers()
    Mocks.setupStatements()

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendEnrolledStudentMessage()

    // verify results
    srv.isMessageSent shouldBe false
  }
  it should "not send any messages to course teachers if message template is invalid" in {
    Mocks.setupStudents()
    Mocks.setupTeachers()
    Mocks.setupCourses()
    Mocks.setupPackages()
    Mocks.setupCoursesForTeachers()
    Mocks.setupStatements()

    // send notification
    val srv = service(
      new MessageTemplateLoader {
        def getFor(mtype: MessageType.Value): Option[HTMLTemplate] = None
        def render(tpl: HTMLTemplate, data: Map[String, _]): String = ""
      })

    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendEnrolledStudentMessage()

    // verify results
    srv.isMessageSent shouldBe false
  }

  "CourseMessageService" should "send messages to students if course's certificate is about to expire in 14 days" in {
    // setup mocks
    Mocks.setupStudents()
    Mocks.setupCompanies()
    Mocks.setupCertificates(expirationInDays = 14)

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendCertificateExpirationMessage()

    // verify results
    val testingData = testingDataLoader.sendingData.get("data").map(_.asInstanceOf[Seq[CertificateRenderView]])
    testingData should not be None
    testingData.get.head.days should be("14")
    testingData.get.head.title should be("Test Certificate 1")

    testingData.get.last.days should be("14")
    testingData.get.last.title should be("Test Certificate 1")

    srv.isMessageSent shouldBe true
  }
  it should "send messages to students if course's certificate is about to expire in 7 days" in {
    // setup mocks
    Mocks.setupStudents()
    Mocks.setupCompanies()
    Mocks.setupCertificates(expirationInDays = 7)

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendCertificateExpirationMessage()

    // verify results
    val testingData = testingDataLoader.sendingData.get("data").map(_.asInstanceOf[Seq[CertificateRenderView]])
    testingData should not be None
    testingData.get.head.days should be("7")
    testingData.get.head.title should be("Test Certificate 1")

    testingData.get.last.days should be("7")
    testingData.get.last.title should be("Test Certificate 1")

    srv.isMessageSent shouldBe true
  }
  it should "send messages to students if course's certificate is about to expire today" in {
    // setup mocks
    Mocks.setupStudents()
    Mocks.setupCompanies()
    Mocks.setupCertificates(expirationInDays = 0)

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendCertificateExpirationMessage()

    // verify results
    val testingData = testingDataLoader.sendingData.get("data").map(_.asInstanceOf[Seq[CertificateRenderView]])
    testingData should not be None
    testingData.get.head.days should be("0")
    testingData.get.head.title should be("Test Certificate 1")

    testingData.get.last.days should be("0")
    testingData.get.last.title should be("Test Certificate 1")

    srv.isMessageSent shouldBe true
  }
  it should "not send any message to students if course's certificate is not going to expire in 14, 7, 0 days" in {
    // setup mocks
    Mocks.setupStudents()
    Mocks.setupCompanies()
    Mocks.setupCertificates(expirationInDays = 11)

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendCertificateExpirationMessage()

    // verify results
    val testingData = testingDataLoader.sendingData.get("data").map(_.asInstanceOf[Seq[CertificateRenderView]])
    testingData shouldBe None
    srv.isMessageSent shouldBe false
  }
  it should "not send any message to student about certificate expiration if a student has an invalid email" in {
    // setup mocks
    Mocks.setupStudents(invalidateEmail = true)
    Mocks.setupCompanies()
    Mocks.setupCertificates(expirationInDays = 7)

    // send notification
    val srv = service()
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendCertificateExpirationMessage()

    // verify results
    srv.isMessageSent shouldBe false
  }
  it should "not send any message to student about certificate expiration if message template is invalid" in {
    // setup mocks
    Mocks.setupStudents()
    Mocks.setupCompanies()
    Mocks.setupCertificates(expirationInDays = 7)

    // send notification
    val srv = service(
      new MessageTemplateLoader {
        def getFor(mtype: MessageType.Value): Option[HTMLTemplate] = None
        def render(tpl: HTMLTemplate, data: Map[String, _]): String = ""
      })
    testingDataLoader.flushData()
    srv.flushMessageState()
    srv.sendCertificateExpirationMessage()

    // verify results
    srv.isMessageSent shouldBe false
  }

  object Mocks {
    val course = CourseResponse(1111L, "Courage Course", "http://www.example.com/course.1", "test your courage by cleaning up a dungeon")

    def setupStudents(invalidateEmail: Boolean = false) {
      if (!invalidateEmail) {
        when(usersMock.byPermission(PermissionType.STUDENT))
          .thenReturn(Seq(
            UserShortResponse(111L, "Test Student 1", email = Some("test.student1@example.com")),
            UserShortResponse(222L, "Test Student 2", email = Some("test.student2@example.com")),
            UserShortResponse(333L, "Test Student 3", email = Some("test.student3@example.com"))
          ))
      } else {
        when(usersMock.byPermission(PermissionType.STUDENT))
          .thenReturn(Seq(
            UserShortResponse(111L, "Test Student 1", email = None),
            UserShortResponse(222L, "Test Student 2", email = None),
            UserShortResponse(333L, "Test Student 3", email = None)
          ))
      }
    }

    def setupTeachers(invalidateEmail: Boolean = false) {
      if (invalidateEmail) {
        when(usersMock.byPermission(PermissionType.TEACHER))
          .thenReturn(Seq(UserShortResponse(666L, "Test Teacher", email = None)))
      } else {
        when(usersMock.byPermission(PermissionType.TEACHER))
          .thenReturn(Seq(UserShortResponse(666L, "Test Teacher", email = Some("test.teacher@example.com"))))
      }
    }

    def setupCourses() {
      when(coursesMock.all).thenReturn(Seq(course))
    }

    def setupPackages() {
      when(packagesMock.getPackagesByCourse(course.id.toInt))
        .thenReturn(Seq(
          Manifest(1, None, None, "1.2", None, resourcesBase = None, title = "Package 1", isDefault = true, courseID = Some(course.id.toInt), visibility = Some(true)),
          Manifest(2, None, None, "1.2", None, resourcesBase = None, title = "Package 2", isDefault = true, courseID = Some(course.id.toInt), visibility = Some(true)),
          Manifest(3, None, None, "1.2", None, resourcesBase = None, title = "Package 3", isDefault = true, courseID = Some(course.id.toInt), visibility = Some(false))
        ))
    }

    def setupStatements() {
      when(packagesMock.getStatements(1, 111))
        .thenReturn(Seq(
          Statement(UUID.randomUUID(), null, null, null, None, None, None, Some(DateTime.now.minusHours(3).toDate), None, None, Nil)
        ))
      when(packagesMock.getStatements(2, 111)).thenReturn(Nil)

      when(packagesMock.getStatements(1, 222))
        .thenReturn(Seq(
          Statement(UUID.randomUUID(), null, null, null, None, None, None, Some(DateTime.now.minusHours(6).toDate), None, None, Nil)
        ))
      when(packagesMock.getStatements(2, 222)).thenReturn(Nil)

      when(packagesMock.getStatements(1, 333))
        .thenReturn(Seq(
          Statement(UUID.randomUUID(), null, null, null, None, None, None, Some(DateTime.now.minusDays(2).toDate), None, None, Nil)
        ))
      when(packagesMock.getStatements(2, 333)).thenReturn(Nil)

    }

    def setupCoursesForTeachers() {
      when(coursesMock.getByUserId(666L)).thenReturn(Seq(course))
    }

    def setupCompanies() {
      when(coursesMock.getCompanyIds).thenReturn(Seq(1234L, 5678L))
    }

    def setupCertificates(expirationInDays: Int) {
      when(certificatesMock.getForUser(1234, 111, false))
        .thenReturn(Seq(
          CertificateResponse(
            11, "Test Certificate 1", "", "", "", false, ValidPeriod(Some(expirationInDays + 2), "DAYS"), DateTime.now.minusDays(1), false, Nil, Nil, Nil, Map.empty, None
          )
        ))
      when(certificatesMock.getForUser(5678, 111, false))
        .thenReturn(Seq(
          CertificateResponse(
            11, "Test Certificate 2", "", "", "", false, ValidPeriod(Some(expirationInDays + 2), "DAYS"), DateTime.now.minusDays(1), false, Nil, Nil, Nil, Map.empty, None
          )
        ))
      when(certificatesMock.getForUser(1234, 222, false)).thenReturn(Nil)
      when(certificatesMock.getForUser(5678, 222, false)).thenReturn(Nil)

      when(certificatesMock.getForUser(1234, 333, false))
        .thenReturn(Seq(
          CertificateResponse(
            11, "Test Certificate 1", "", "", "", false, ValidPeriod(Some(expirationInDays + 2), "DAYS"), DateTime.now.minusDays(1), false, Nil, Nil, Nil, Map.empty, None
          )
        ))
      when(certificatesMock.getForUser(5678, 333, false)).thenReturn(Nil)

    }

  }
}

trait TestingMessageSender extends MessageSender {
  @volatile private var isSent: Boolean = false

  def isMessageSent = isSent
  def flushMessageState() { isSent = false }

  override protected def sendMessage(m: MailMessage) {
    isSent = true
  }
}

object TestingTemplateLoader extends MessageTemplateLoader {
  @volatile private var testingData: Map[String, _] = Map.empty

  def sendingData = testingData

  def flushData() { testingData = Map.empty }

  def getFor(mtype: MessageType.Value): Option[this.HTMLTemplate] = Some("testing template")

  def render(tpl: this.HTMLTemplate, data: Map[String, _]): String = {
    testingData = data
    <html><head/><body>rendered template</body></html>.toString()
  }
}