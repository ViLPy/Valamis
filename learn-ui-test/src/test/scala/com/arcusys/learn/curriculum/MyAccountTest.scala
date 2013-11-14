package com.arcusys.learn.curriculum

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.junit.Assert._
import org.joda.time._


class MyAccountTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase with UICurriculumBase {
  val driver = _driver

  // earn badge and valid period
  "MyAccount" should "be on page" in {
    logout()
    loginAsAdmin()
    driver.get(baseUrl + myAccountUrl)
    wait(1)
    assertTrue(isElementPresent(By.id("userData")))
    assertTrue(isElementPresent(By.id("myCertificatesTabs")))
  }

  it should "show user data" in{
    assertTrue(isElementPresent(By.xpath("//*[@id=\"userData\"]/div[1]/img")))
    val text = driver.findElement(By.xpath("//*[@id=\"userData\"]/div[2]")).getText
    assertTrue(text.contains(studentLogin))
    studentUserName
  }

  it should "show certificates" in {
    assertEquals(1, driver.findElement(By.id("userCertificatesList")).findElements(By.className("badge-item")).size)

    assertTrue(driver.findElement(By.xpath("//*[@id=\"userCertificatesList\"]/div[2]/div/img")).
      getAttribute("src").contains("/learn-portlet/img/certificate-default.png"))

    val expireDate = "Expire date: " + DateTime.now.plusYears(1).toString("yyyy-MM-dd")
    assertEquals(expireDate, driver.findElement(By.xpath("//*[@id=\"userCertificatesList\"]/div[2]/div/p[1]")).getText)

    assertEquals("C# expert", driver.findElement(By.className("issuer")).getText)
  }



}
