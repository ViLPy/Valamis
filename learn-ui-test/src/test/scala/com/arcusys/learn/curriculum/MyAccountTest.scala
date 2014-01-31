package com.arcusys.learn.curriculum

import org.openqa.selenium.By
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.junit.Assert._
import org.joda.time._


class MyAccountTest  (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase with UICurriculumBase {
  val driver = _driver

  // earn badge and valid period
  "MyAccount" should "be on page" in {
    logout()
    loginAsAdmin()
    driver.get(baseUrl + myAccountUrl)
    driver.waitForElementVisibleBy(By.id("userData"))
    driver.waitForElementVisibleBy(By.id("valamisCertificates"))
  }

  it should "show user data" in{
    driver.waitForElementVisibleBy(By.xpath("id('userData')/div[1]/img"))
    val text = driver.getVisibleElementAfterWaitBy(By.xpath("id('userData')/div[2]")).getText
    assertTrue(text.contains(studentLogin))
    assertTrue(text.contains(studentUserName))
  }

  it should "show certificates" in {
    assertEquals(2, driver.getVisibleElementAfterWaitBy(By.id("userCertificatesList")).findElements(By.className("badge-item")).size)

    val permanentBadge = driver.getVisibleElementAfterWaitBy(By.xpath("id('userCertificatesList')//p[text()='"+permanentCertificateName+"']/.."))
    val imgSrc = permanentBadge.findElement(By.tagName("img")).getAttribute("src")
    assertEquals(trimTestImage, getUploadedImageName(imgSrc))

    val yearBadge = driver.getVisibleElementAfterWaitBy(By.xpath("id('userCertificatesList')//p[text()='"+yearCertificateName+"']/.."))
    val imgSrc1 = yearBadge.findElement(By.tagName("img")).getAttribute("src")
    assertEquals(defaultImageSrc, imgSrc1)

    val expireDate = "Expire date: " + DateTime.now.plusYears(1).toString("yyyy-MM-dd")
    assertEquals(expireDate, yearBadge.findElements(By.tagName("p")).get(0).getText)
  }

}
