package com.arcusys.learn.curriculum

import org.openqa.selenium.By
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.junit.Assert._


class StudentCurriculumTest  (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase {
  val driver = _driver
  val myCertificates = By.partialLinkText("My certificates")
  val available = By.partialLinkText("Available certificates")

  "Curriculum for student" should "be opened correctly" in {
    logout()
    loginAsStudent()
    driver.get(baseUrl + curriculumUserUrl)
    driver.waitForElementVisibleBy(myCertificates)
    driver.waitForElementVisibleBy(available)
  }

  it should "show my certificates" in {
    val list = driver.getVisibleElementAfterWaitBy(By.id("myCertificateList"))
    assertEquals(1,  list.findElements(By.className("availableQuizItem")).size())
    assertEquals(permanentCertificateName, list.findElement(By.className("quizItemTitle")).getText)
  }

  it should "show available certificates" in {
    driver.getVisibleElementAfterWaitBy(available).click()
    val list = driver.getVisibleElementAfterWaitBy(By.id("certificateList"))
    assertEquals(5, list.findElements(By.className("availableQuizItem")).size())
  }

  it should "be able to leave certificate" in{
    driver.getVisibleElementAfterWaitBy(available).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("leaveCertificate")).click()
    assertTrue(driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("joinCertificate")).isDisplayed)
    assertFalse(driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("leaveCertificate")).isDisplayed)

    driver.getVisibleElementAfterWaitBy(myCertificates).click()
    assertEquals(0,  driver.getVisibleElementAfterWaitBy(By.id("myCertificateList")).findElements(By.className("availableQuizItem")).size())
  }

  it should "be able to browse available sertificates if there is no my certificates" in {
    driver.getVisibleElementAfterWaitBy(By.id("browseAvailable")).click()
    driver.getVisibleElementAfterWaitBy(By.id("certificateList"))
    val list = driver.getVisibleElementAfterWaitBy(By.id("certificateList"))
    assertEquals(5, list.findElements(By.className("availableQuizItem")).size())
  }

  it should "be able to join certificate" in {
    assertTrue(driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("joinCertificate")).isDisplayed)
    assertFalse(driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("leaveCertificate")).isDisplayed)

    driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("joinCertificate")).click()
    assertFalse(driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("joinCertificate")).isDisplayed)
    assertTrue(driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateList')//*[@class='quizItemTitle' and text()='"+permanentCertificateName+"']/..")).
      findElement(By.className("leaveCertificate")).isDisplayed)

    driver.getVisibleElementAfterWaitBy(myCertificates).click()
    assertEquals(1,  driver.getVisibleElementAfterWaitBy(By.id("myCertificateList")).findElements(By.className("availableQuizItem")).size())
  }

  it should "show correct grade" in {
    driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateList')//*[@title='Open']/button")).click()
    val grade = driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='myCertificateGrid']/tbody/tr/td[2]")).getText
    assertEquals("90%", grade)
  }

  it should "correct show sites and links" in {
    val site1 = driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='myCertificateGrid']/tbody/tr/td/div/a"))
    assertEquals(testSite1, site1.getText)
//    assertTrue(site1.getAttribute("href").contains(testSite1))
    assertTrue(site1.getAttribute("href").contains(baseUrl + "/group/"+ testSite1))  // it should redirect to private pages if there are no public

    val site2 = driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='myCertificateGrid']/tbody/tr[2]/td/div/a"))
    assertEquals(site2name, site2.getText)
//    assertTrue(site2.getAttribute("href").contains(site2name))
    assertTrue(site2.getAttribute("href").contains(baseUrl + "/web/"+ site2name))

    val site3 = driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='myCertificateGrid']/tbody/tr[3]/td"))
    assertEquals(testSite2, site3.getText)
  }
}
