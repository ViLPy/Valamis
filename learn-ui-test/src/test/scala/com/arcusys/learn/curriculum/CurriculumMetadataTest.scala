package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.junit.Assert._
import org.joda.time.{Period, DateTime}


class CurriculumMetadataTest  (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with LoginSupport with UITestBase with UICurriculumBase {
  val driver = _driver

  var yearId = "0"
  var permanentId = "0"

  // earn badge and valid period
  "Curriculum" should "not show metadata if certificate is not passed" in {
//    add student and course to 2nd certificate
    openCertManager(yearCertificateName)
    addSiteByName(testSite2)
    openManagement()
    openUserManagement(yearCertificateName)
    addStudentMember()
    driver.getVisibleElementAfterWaitBy(By.className("ui-tabs-close")).click()

    logout()
    loginAsStudent()
    driver.get(baseUrl + curriculumUserUrl)

    val list = driver.getVisibleElementAfterWaitBy(By.id("myCertificateList"))
    assertEquals(2,  list.findElements(By.className("availableQuizItem")).size())

    expandCertificate(yearCertificateName)
    expandCertificate(permanentCertificateName)

    yearId = getId(yearCertificateName)
    permanentId = getId(permanentCertificateName)

    descriptionIsDisplayed(yearId)
    descriptionIsDisplayed(permanentId)

    logout()
  }

  it should "set grades for student" in {
    loginAsAdmin()
    driver.get(baseUrl + curriculumUrl)
    openUserManagement(permanentCertificateName)

    // set missing grades
    driver.getVisibleElementAfterWaitBy(By.className("expandMember")).click()
    setGrade(2, 6, "some comment2")

    // check all grades are set
//    setGrade(1,10, "THIS LINE IS ONLY FOR DEBUGGING!!") // TODO: delete after debugging     FULL TESTS

    assertFalse(allMark)
    checkGrade(1, "90%")
    checkGrade(2, "100%")
    checkGrade(3, "60%")
    driver.getVisibleElementAfterWaitBy(By.className("ui-tabs-close")).click()
    openUserManagement(yearCertificateName)
    driver.getVisibleElementAfterWaitBy(By.className("expandMember")).click()
    assertFalse(allMark)
    checkGrade(1, "60%")
  }

  it should "show metadata for passed certificate" in {
    logout()
    loginAsStudent()

    driver.get(baseUrl + curriculumUserUrl)

    assertEquals(yearCertificateName, driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateList')/div/div/div[1]/div[1]")).getText)
    assertEquals(permanentCertificateName, driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateList')/div[2]/div/div[1]/div[1]")).getText)

    expandCertificate(yearCertificateName)
    expandCertificate(permanentCertificateName)
    driver.getVisibleElementAfterWaitBy(By.id("myCertificateBody_"+yearId))
    driver.getVisibleElementAfterWaitBy(By.id("myCertificateBody_"+permanentId))

    expireIsDisplayed(yearId)
    badgeIsDisplayed(permanentId)

  }

  it should "show certificate images correctly" in {
    checkImage(yearId, "default")
    checkImage(permanentId, trimTestImage)

    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Available certificates")).click()
    assertImage("default", 0)
    assertImage("default", 1)
    assertImage(trimTestImage, 2)
    assertImage("default", 3)

    logout()
  }

  private def checkGrade (site: Int, grade: String) {
    assertEquals(grade, driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='myCertificateGrid']//tr["+site+"]/td[2]/div")).getText)
  }

  private def allMark: Boolean = {
    var isUnset = false
    driver.getVisibleElementAfterWaitBy(By.className("SCORMPackageList")).findElements(By.xpath("//*[contains(@id, 'reviewGrade')]")).toArray
      .foreach(p => if (p.asInstanceOf[WebElement].getText.contains("-")) isUnset = true)
    isUnset
  }

  private def getId(name: String) = {
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='quizItemTitle' and text()='"+name+"']/../..//div[contains(@id, 'myCertificateBody')]")).
      getAttribute("id").replace("myCertificateBody_","")
  }

  private def expireIsDisplayed (quizId: String) {
    assertEquals("Expire date",driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[2]/div/div/div/div/div")).getText)
    assertEquals(DateTime.now.plus(Period.years(1)).toString("yyyy-MM-dd"),
      driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[2]/div/div/div/div[2]")).getText)
    assertEquals("Description", driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[2]/div/div/div[2]/div/div")).getText)
  }

  private def descriptionIsDisplayed (quizId: String) {
    assertEquals("Description",driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[2]/div/div/div/div/div")).getText)
  }

  private def badgeIsDisplayed (quizId: String) {
    assertEquals("Badge",driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[2]/div/div/div/div/div")).getText)
    assertEquals("issueBadge",driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[2]/div/div/div/div[2]/button")).getAttribute("id"))
    assertEquals("Description", driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[2]/div/div/div[2]/div/div")).getText)
  }

  private def checkImage (quizId: String, name: String){
    val imageName = driver.getVisibleElementAfterWaitBy(By.xpath("id('myCertificateBody_"+quizId+"')/div[1]/img")).getAttribute("src")

    if (name == "default")
      assertEquals(defaultImageSrc, imageName)
    else
      assertEquals(name, getUploadedImageName(imageName))
  }

  private def expandCertificate (name: String) {
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='quizItemTitle' and text()='" + name + "']/..//button[contains(@id, 'expand')]")).click()
  }
}
