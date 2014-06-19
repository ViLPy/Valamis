package com.arcusys.learn.notifications.services

import com.arcusys.learn.notifications.{ CourseMessageService, MessageType }
import org.joda.time.DateTime
import org.junit.runner.RunWith
import org.scalatest.{ FlatSpec, Matchers }

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ResourceTemplateLoaderSpec extends FlatSpec with Matchers {
  import CourseMessageService._

  "The ResourceTemplateLoader" should "load 'EnrolledStudent' message template" in {
    val tpl = ResourceTemplateLoader.getFor(MessageType.EnrolledStudent)
    tpl should not be None
    tpl.get should equal(
      """
        |<!DOCTYPE html>
        |<html>
        |<body>
        |<h2 style="background-color: #A7C46C;
        |    color: #fff;
        |    padding-top: 10px;
        |    padding-bottom: 10px;
        |    padding-left: 10px;
        |    margin: 0;
        |    font-family: Times New Roman, serif;
        |    margin-bottom: 5px;"> Valamis Course Notifications</h2>
        |<div style="font-family: Helvetica,sans-serif;
        |    padding-left: 10px; font-weight: bold; font-size: 1.3em;">{{date}}</div>
        |{{#data}}
        |<h4 style="font-family: Helvetica,sans-serif; padding-left: 10px; margin-bottom: 3px;">{{courseName}}</h4>
        |<div style="font-family: Helvetica,sans-serif; padding-left: 15px; border-top:1px solid #eee; padding-top: 10px">
        |    <table>
        |        {{#enrolledStudents}}
        |        <tr>
        |            <td valign="top">
        |                {{.}} <b>joined</b> the course
        |            </td>
        |        </tr>
        |        {{/enrolledStudents}}
        |    </table>
        |</div>
        |{{/data}}
        |</body>
        |</html>
      """.stripMargin.trim
    )
  }
  it should "render 'EnrolledStudent' message template properly with given data" in {
    val data = Seq(
      StudentRenderView("Testing Course 1", Seq("Student 1", "Student 2", "Student 3")))
    val tpl = ResourceTemplateLoader.getFor(MessageType.EnrolledStudent)
    val rendered = ResourceTemplateLoader.render(tpl.get, Map("data" -> data, "date" -> DateTime.now.toString("EEEE, MMMM d")))
    rendered.isEmpty shouldBe false
  }

  "The ResourceTemplateLoader" should "load 'CourseCertificateExpiration' message template" in {
    val tpl = ResourceTemplateLoader.getFor(MessageType.CourseCertificateExpiration)
    tpl should not be None
    tpl.get should equal(
      """
        |<!DOCTYPE html>
        |<html>
        |<body>
        |<h2 style="background-color: #A7C46C;
        |    color: #fff;
        |    padding-top: 10px;
        |    padding-bottom: 10px;
        |    padding-left: 10px;
        |    margin: 0;
        |    font-family: Times New Roman, serif;
        |    margin-bottom: 5px;">Valamis Certificate Notifications</h2>
        |<div style="font-family: Helvetica,sans-serif;
        |    padding-left: 10px; font-weight: bold; font-size: 1.3em;">{{date}}</div>
        |<div style="font-family: Helvetica,sans-serif; padding-left: 15px; border-top:1px solid #eee; padding-top: 10px">
        |    <table>
        |        {{#data}}
        |        <tr>
        |            <td valign="top">
        |                {{{title}}}
        |                <br/>
        |                <div style="font-size:smaller">is going to expire in {{days}} days,  at {{date}}</div></td>
        |        </tr>
        |        {{/data}}
        |    </table>
        |</div>
        |</body>
        |</html>
      """.stripMargin.trim)
  }
  it should "render 'CourseCertificateExpiration' message template properly with given data" in {
    val data = Seq(
      CertificateRenderView("Certificate 1", "7", DateTime.now.plusDays(7).toString("EEEE, MMMM d")),
      CertificateRenderView("Certificate 2", "14", DateTime.now.plusDays(14).toString("EEEE, MMMM d")),
      CertificateRenderView("Certificate 3", "0", DateTime.now.toString("EEEE, MMMM d")))
    val tpl = ResourceTemplateLoader.getFor(MessageType.CourseCertificateExpiration)
    val rendered = ResourceTemplateLoader.render(tpl.get, Map("data" -> data, "date" -> DateTime.now.toString("EEEE, MMMM d")))
    println(rendered)
    rendered.isEmpty shouldBe false
  }
}
