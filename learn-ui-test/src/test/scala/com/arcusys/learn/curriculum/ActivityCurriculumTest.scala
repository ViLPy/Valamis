package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.junit.Assert._



class ActivityCurriculumTest  (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase with UICurriculumBase {
  val driver = _driver
  val activity = "New Certificate is available "
  val certificateJava = "Java certification"
  val certificateC ="C# expert"

  // 15.1 - 15.4
  "Activity portlet" should "be onpage" in {
    logout()
    loginAsAdmin()
    driver.get(baseUrl + curriculumUrl)

    def findPortlet: Boolean = {
    driver.findElements(By.className("portlet-title-text")).toArray.foreach(p =>{
      if (p.asInstanceOf[WebElement].getText == "Activities") return true
    })
    false
    }

    assertTrue(findPortlet)
  }

  it should "show certificate activity" in {
    assertTrue(findActivity(activity+permanentCertificateName))
  }

  it should "not show activity if certificate info is not complete" in {
    addCertificate(certificateJava)
    addSiteByName(testSite1)

    driver.get(baseUrl + curriculumUrl)
    // do not show yet, because no users still
    assertFalse(findActivity("New Certificate is available " + certificateJava))
  }

  it should "show activity about new certificate" in {
    openUserManagement(certificateJava)
    val username = addNotStudentMemberAndReturnName(0)

    driver.get(baseUrl + curriculumUrl)
    assertTrue(findActivity("New Certificate is available "+certificateJava))
    openUserManagement(certificateJava)

    driver.getVisibleElementAfterWaitBy(By.className("expandMember")).click()

    setGrade(7, "OK")

    driver.get(baseUrl + curriculumUrl)

    findUserActivity(username, certificateJava)

//    if (username.equals(teacherUserName))
//      assertTrue(findActivity(username.split(" ").head + " has passed certificate "+certificateJava))
//    else
//      assertTrue(findActivity(username.split("\\n").head + " has passed certificate "+certificateJava))
  }

  it should "not show activity if certificate is not complete by user" in {
    addCertificate(certificateC)
    addSiteByName(testSite1)
    addSiteByName(testSite2)
    openManagement()

    openUserManagement(certificateC)
    val username = addNotStudentMemberAndReturnName(1)
    driver.getVisibleElementAfterWaitBy(By.className("expandMember")).click()
    setGrade(2, "BAD")
    driver.get(baseUrl + curriculumUrl)
//    assertFalse(findActivity(username.split("\\n").head + " has passed certificate " + certificateC))

    dontFindUserActivity(username, certificateC)

    openUserManagement(certificateC)
    driver.getVisibleElementAfterWaitBy(By.className("expandMember")).click()
    setGrade(1, 4, "Not so bad")
    driver.get(baseUrl + curriculumUrl)

    findUserActivity(username, certificateC)
//      val qwe = username.split("\\n").head + " has passed certificate " + certificateC
//    assertTrue(findActivity(qwe))
  }

  it should "delete activities when certificate is deleted" in{
    assertTrue(findActivity(activity+certificateC))
    deleteCertificate(certificateC)

    driver.get(baseUrl + curriculumUrl)
    assertFalse(findActivity(activity+certificateC))
  }

  // need because activities show only user name  TODO: try to get liferay user names
  def findUserActivity(name: String, certificate: String)
  {
    if (name.contains(teacherUserName))
      assertTrue(findActivity(name.split(" ").head + " has passed certificate "+certificate))
    else
      assertTrue(findActivity(name.split("\\n").head + " has passed certificate "+certificate))
  }

  def dontFindUserActivity(name: String, certificate: String)
  {
    if (name.contains(teacherUserName))
      assertFalse(findActivity(name.split(" ").head + " has passed certificate "+certificate))
    else
      assertFalse(findActivity(name.split("\\n").head + " has passed certificate "+certificate))
  }
}
