package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.junit.Assert._



class ActivityCurriculumTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase with UICurriculumBase {
  val driver = _driver
  val activity = "New Certificate is available Test cert1"

  // 15.1 - 15.4
  "Activity portlet" should "be onpage" in {
    driver.findElement(By.linkText("Sign Out")).click()
    loginAsAdmin()
    driver.get(baseUrl + curriculumUrl)
    wait(1)
    def findPortlet: Boolean = {
    driver.findElements(By.className("portlet-title-text")).toArray.foreach(p =>{
      if (p.asInstanceOf[WebElement].getText == "Activities") return true
    })
    false
    }

    assertTrue(findPortlet)
  }

  it should "show certificate activity" in {
    assertTrue(findActivity(activity))
  }

  it should "not show activity if certificate info is not cmplete" in {
    val name = "Java certification"
    addCertificate(name)
    addSiteAndReturnName(0)
    driver.get(baseUrl + curriculumUrl)
    // do not show yet, because no users still
    assertFalse(findActivity("New Certificate is available " + name))
  }

  it should "show activity about passed certificate" in {
    openUserManagement()
    val username = addMemberAndReturnName(0)

    driver.get(baseUrl + curriculumUrl)
    wait(1)
    assertTrue(findActivity("New Certificate is available Java certification"))
    openUserManagement()

    driver.findElement(By.className("expandMember")).click()
    wait(1)

    setGrade(7, "OK")

    driver.get(baseUrl + curriculumUrl)
    wait(1)
    assertTrue(findActivity(username.split("\\n").head + " has passed certificate Java certification"))
  }

  it should "not show activity if certificate is not complete by user" in {
    val certificate ="C# expert"
    addCertificate(certificate)
    addSiteAndReturnName(0)
    addSiteAndReturnName(1)
    openManagement()
    openUserManagement()
    val username = addMemberAndReturnName(1)
    driver.findElement(By.className("expandMember")).click()
    setGrade(2, "BAD")
    driver.get(baseUrl + curriculumUrl)
    wait(1)
    assertFalse(findActivity(username.split("\\n").head + " has passed certificate " + certificate))

    openUserManagement()
    driver.findElement(By.className("expandMember")).click()
    setGrade(1, 4, "Not so bad")
    driver.get(baseUrl + curriculumUrl)
    wait(1)
    assertTrue(findActivity(username.split("\\n").head + " has passed certificate " + certificate))
  }

  it should "delete activities when certificate is deleted" in{
    assertTrue(findActivity(activity))
    deleteCertificate(2) // Test cert1

    driver.get(baseUrl + curriculumUrl)
    assertFalse(findActivity(activity))
  }




}
