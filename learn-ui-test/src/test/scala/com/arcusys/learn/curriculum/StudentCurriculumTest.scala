package com.arcusys.learn.curriculum

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.junit.Assert._


class StudentCurriculumTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase {
  val driver = _driver
  val myCertificates = By.partialLinkText("My certificates")
  val available = By.partialLinkText("Available certificates")

  "Curriculum for student" should "be opened correctly" in {
    driver.findElement(By.linkText("Sign Out")).click()
    loginAsStudent()
    driver.get(baseUrl + curriculumUrl)
    wait(1)
    assertTrue(isElementPresent(myCertificates))
    assertTrue(isElementPresent(available))
  }

  it should "show my certificates" in {
    val list = driver.findElement(By.id("myCertificateList"))
    assertEquals(1,  list.findElements(By.className("availableQuizItem")).size())
    assertEquals("Test cert1", list.findElement(By.className("quizItemTitle")).getText)
  }

  it should "show available certificates" in {
    driver.findElement(available).click()
    wait(1)
    val list = driver.findElement(By.id("certificateList"))
    assertEquals(3, list.findElements(By.className("availableQuizItem")).size())
  }

  it should "be able to join certificate" in {
    assertTrue(driver.findElements(By.className("joinCertificate")).get(1).isDisplayed)
    assertFalse(driver.findElements(By.className("leaveCertificate")).get(1).isDisplayed)

    driver.findElements(By.className("joinCertificate")).get(1).click()
    wait(1)
    assertFalse(driver.findElements(By.className("joinCertificate")).get(1).isDisplayed)
    assertTrue(driver.findElements(By.className("leaveCertificate")).get(1).isDisplayed)

    driver.findElement(myCertificates).click()
    assertEquals(2,  driver.findElement(By.id("myCertificateList")).findElements(By.className("availableQuizItem")).size())
  }

  it should "be able to leave certificate" in{
    driver.findElement(available).click()
    driver.findElement(By.className("leaveCertificate")).click()
    wait(1)
    assertTrue(driver.findElement(By.className("joinCertificate")).isDisplayed)
    assertFalse(driver.findElement(By.className("leaveCertificate")).isDisplayed)
    wait(1)

    driver.findElement(myCertificates).click()
    assertEquals(1,  driver.findElement(By.id("myCertificateList")).findElements(By.className("availableQuizItem")).size())
  }

  it should "show correct grade" in {
    //val gradePath = "//*[@id=\"myCertificateList\"]/div/div/div/div[3]/table/tr[1]/td[2]"
    //assertEquals("-", driver.findElement(By.xpath(gradePath)).getText)
  }
}
