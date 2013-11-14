package com.arcusys.learn.base

import org.openqa.selenium._
import org.openqa.selenium.By._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

trait UITestBase {
  val driver: WebDriver
  protected val baseUrl = "http://localhost:8080"
  protected val site2Url = "http://localhost:8080/group/restricted-1"
  protected val site2PlayerUrl = "/news"
  protected val site2QuestionUrl = "/home"
  protected val site2QuizUrl = "/home"
  protected val site2AdminUrl = "/admin"

  protected val adminUrl = "/"
  protected val playerUrl = "/web/guest/player"

  protected val searchUrl = "/web/guest/search"
  protected val assetPublisherUrl = "/web/guest/asset"
  // asset publisher without filter
  protected val assetPublisherScormOnlyUrl = "/web/guest/asset-scorm" // page with asset publisher with filter to SCORM packages
  protected val questionUrl = "/web/guest/question-edit"
  protected val quizUrl = "/web/guest/quiz"
  protected val gradebookUrl = "/web/guest/gradebook"
  protected val curriculumUrl = "/web/guest/curriculum"
  protected val myAccountUrl = "/web/student/home"

  protected val packageTitle12 = "Test package SCORM 1.2"
  protected val packageDescription12 = "Test package description SCORM 1.2"
  protected val packageTitle2004 = "Test package SCORM 2004"
  protected val packageDescription2004 = "Test package description SCORM 2004"

  protected val teacherUserName = "Test Test"
  protected val studentUserName = "Student"
  protected val noPermissionText = "Sorry, you do not have permissions to view that content"

  def wait(seconds: Int) {
    val milliSeconds: Int = seconds * 1000
    Thread.sleep(milliSeconds)
  }

  def waitForElementBy(locator: By) {
    val webWait = new WebDriverWait(driver, 100)
    webWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
  }

  def waitForAlert() {
    val webWait = new WebDriverWait(driver, 100)
    webWait.until(ExpectedConditions.alertIsPresent)
  }

  def closeAlertAndGetItsText = {
    val alert = driver.switchTo.alert
    val alertText: String = alert.getText
    alert.accept()
    alertText
  }

  def isElementPresent(by: By) = try {
    driver.findElement(by)
    true
  } catch {
    case e: NoSuchElementException => false
  }


  protected def uploadPackage(filename: String, title: String, description: String) {
    //driver.get(baseUrl + adminUrl)
    driver.findElement(id("SCORMPackageUploadButton")).click()
    driver.findElement(id("SCORMPackageTitle")).sendKeys(title)
    driver.findElement(id("scormAdminPackagesummary")).sendKeys(description)
    driver.findElement(id("newPackages")).sendKeys(Thread.currentThread().getContextClassLoader.getResource(filename).getFile)
    driver.findElement(id("SCORMUpload")).click()
    wait(5)
  }
}