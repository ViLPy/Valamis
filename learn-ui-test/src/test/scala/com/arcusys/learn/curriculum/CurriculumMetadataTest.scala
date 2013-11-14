package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.junit.Assert._
import java.util.Date


class CurriculumMetadataTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase with UICurriculumBase {
  val driver = _driver

  // earn badge and valid period
  "Curriculum" should "be able to edit metadata" in {
    // edit c# cert
    openCertManager()
    driver.findElements(By.className("validPeriod")).get(1).click()
    driver.findElement(By.className("publishBadgeCheckbox")).click()
    assertTrue(isElementPresent(By.className("shortDescription")))
    driver.findElement(By.className("shortDescription")).sendKeys("short1")
    // close tab
    driver.findElement(By.className("ui-tabs-close")).click()
    wait(1)
    // verify that it really saves data
    openCertManager()
    assertFalse(driver.findElements(By.className("validPeriod")).get(0).isSelected)
    assertTrue(driver.findElements(By.className("validPeriod")).get(1).isSelected)
  }

  it should "add Student user to certificate" in{
    openManagement()
    openUserManagement()
    addStudentMember()
    driver.findElement(By.className("expandMember")).click()
    wait(1)
    setGrade(0, 8, "some comment")
    setGrade(1, 6, "some comment2")
  }

  it should "be visible in MyCertificates list" in{
    logout()
    loginAsStudent()
    driver.get(baseUrl + curriculumUrl)
    wait(1)
    assertEquals("C# expert", driver.findElement(By.xpath("//*[@id=\"myCertificateList\"]/div/div/div[1]/div[1]")).getText)

    val button = driver.findElement(By.xpath("//*[@id=\"myCertificateList\"]/div/div/div[1]/abbr/button"))
    val id = button.getAttribute("id")
    val certificateID = id.replace("expandCertificate_", "")
    button.click()
    wait(1)
    assertTrue(isElementPresent(By.className("certificateIconDiv")))
    assertTrue(isElementPresent(By.className("SCORMPackageList")))
    assertTrue(isElementPresent(By.id("issueBadge")))

    assertEquals("70%", driver.findElement(By.xpath("//*[@id=\"SCORMMyCertificatesGrid_"+ certificateID +"\"]/tr[1]/td[2]")).getText)
    assertEquals("50%", driver.findElement(By.xpath("//*[@id=\"SCORMMyCertificatesGrid_"+ certificateID +"\"]/tr[2]/td[2]")).getText)



  }

}
