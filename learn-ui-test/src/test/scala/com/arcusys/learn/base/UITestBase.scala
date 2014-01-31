package com.arcusys.learn.base

import org.openqa.selenium._
import org.openqa.selenium.By._
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions, WebDriverWait}

trait UITestBase {
  val driver: WebDriverArcusys
  protected val adminLogin = "test@liferay.com"
  protected val adminPassword = "test"

  protected val studentLogin = "student@liferay.com"
  protected val studentPassword = "test"

  protected val newPackageTitle = "reallyNewPackageTitle"

  //========================
  // if changing this property to run tests from other workstations. Add to Liferay portal-ext.properties file
  // redirect.url.ips.allowed=127.0.0.1,10.93.97.133,10.93.97.20
  //========================
    protected val baseUrl = "http://localhost:8080"
//  protected val baseUrl = "http://10.93.97.106:8080"
  protected val site2name = "restricted-1"
  protected val testSite1 = "history"      // must have no public pages, only private
  protected val testSite2 = "language"
  protected val testActivitySite = "technics"

  protected val site2Url = baseUrl + "/web/restricted-1"
  protected val site2Description = "restricted-1 description"
  protected val site2PlayerUrl = "/player"
  protected val site2QuestionUrl = "/home"
  protected val site2QuizUrl = "/home"
  protected val site2AdminUrl = "/admin"
  protected val site2GradebookUrl = "/gradebook"

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
  protected val curriculumUserUrl = "/web/guest/curriculumuser"
  protected val myAccountUrl = "/web/student/home"

//  protected val defaultDir = "/home/nikiforo/Projects/learngit/learn-ui-test/src/test/resources/Packages/"
  protected val defaultDir = "/home/luba/projects/learngit/learn-ui-test/src/test/resources/Packages/"
//  protected val defaultDir = "C:\\Packages\\"
//  protected val defaultDir = "/home/vilpy/Projects/LearnLocalGit/learngit/learn-ui-test/src/test/resources/Packages/"

  protected val packageFile2004 = defaultDir + "SCORM20043rdEdition.zip"
  protected val packageFile12 = defaultDir + "SCORM12.zip"
  protected val packageFileTincan = defaultDir + "GolfExample_TCAPI.zip"

  protected val testImage = defaultDir + "arcusys_logo.png"
  protected val trimTestImage = testImage.substring(math.max(testImage.lastIndexOf("/"),testImage.lastIndexOf("\\"))+1)
  protected val defaultImageSrc = baseUrl + "/learn-portlet/img/certificate-default.png"

  protected val packageTitle12     = "Test package SCORM 1.2"
  protected val packageTitle2004   = "Test package SCORM 2004"
  protected val packageTitleTincan = "Test package Tincan"

  protected val packageDescription12 = "Test package description SCORM 1.2"
  protected val packageDescription2004 = "Test package description SCORM 2004"
  protected val packageDescriptionTincan = "Test package description Tincan"

  protected val TincanEndPoint = "https://cloud.scorm.com/tc/QMFPNS78SL/sandbox/"
  protected val TincanUserName = "QMFPNS78SL"
  protected val TincanUserPassword = "DuwPiowihyKXP3xyqIupC4laLEyyK3dJukr6GHbN"

  protected val liferayArticleName = "Welcome"
  protected val externalResourceURL = "www.example.com"

  protected val teacherUserName = "Joe Bloggs"
  protected val studentUserName = "student"
  protected val noPermissionText = "Sorry, you do not have permissions to view that content"

  protected val permanentCertificateName = "Permanent certificate"
  protected val yearCertificateName = "1 year certificate"

  private val waitForEvent = 20
  private val intervalBetweenCheck = 10

  @Deprecated
  def locateClearAndSendKeys(locator: By, textToInsert: String){
    val inputElement = waitAndFindElementVisibleBy(locator)
    inputElement.clear()
    inputElement.sendKeys(textToInsert)
  }

  @Deprecated
  def waitForElementVisibleBy(locator: By) {
    val webWait = new WebDriverWait(driver, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
  }

  @Deprecated
  def waitForElementInvisibleBy(locator: By) {
    val webWait = new WebDriverWait(driver, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.invisibilityOfElementLocated(locator))
  }

  // Should be used in sorts only
  @Deprecated
  def waitForElementWithTextBy(locator: By, text: String) {
    val webWait = new WebDriverWait(driver, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.textToBePresentInElement(locator,text))
  }

  @Deprecated
  def waitAndFindElementVisibleBy(locator: By) = {
    waitForElementVisibleBy(locator)
    driver.getVisibleElementAfterWaitBy(locator)
  }

  @Deprecated
  def waitCloseGetTextAlert = {
    val webWait = new WebDriverWait(driver, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.alertIsPresent)

    val alert = driver.switchTo.alert
    val alertText: String = alert.getText
    alert.accept()
    alertText
  }

  @Deprecated
  def isElementPresent(by: By) = try {
    driver.getVisibleElementAfterWaitBy(by)
    true
  } catch {
    case e: NoSuchElementException => false
  }

  @Deprecated
  def waitForNumberOfWindowsToEqual(numberOfWindows: Int) {
    new WebDriverWait(driver, waitForEvent, intervalBetweenCheck).until(
      new ExpectedCondition[Boolean] {
        def apply(driver: WebDriver): Boolean = {
          driver.getWindowHandles().size() == numberOfWindows
        }
      })
  }


//  @Deprecated
//  protected def uploadPackage(filename: String, title: String, description: String) {
//    waitAndFindElementVisibleBy(id("SCORMPackageUploadButton")).click()
//    waitAndFindElementVisibleBy(id("SCORMPackageTitle")).sendKeys(title)
//    waitAndFindElementVisibleBy(id("scormAdminPackagesummary")).sendKeys(description)
//    waitAndFindElementVisibleBy(id("newPackages")).sendKeys(Thread.currentThread().getContextClassLoader.getResource(filename).getFile)
//    waitAndFindElementVisibleBy(id("SCORMUpload")).click()
//    waitForElementInvisibleBy(xpath("//*[text()='Processing']"))              // Chrome browser
//    waitAndFindElementVisibleBy(xpath("id('scormPackageTable')//tr/td[text() = '" + title + "']"))
//  }

  @Deprecated
  def waitForAlert() {
    val webWait = new WebDriverWait(driver, waitForEvent)
    webWait.until(ExpectedConditions.alertIsPresent)
  }

  @Deprecated
  def closeAlertAndGetItsText = {
    val alert = driver.switchTo.alert
    val alertText: String = alert.getText
    alert.accept()
    alertText
  }

  @Deprecated
  def wait(seconds: Int){
    val milliSeconds: Int = seconds * 1000
    Thread.sleep(milliSeconds)
  }

  // TODO: Move to another trait? Possible in merge with WebDriverArcusys
  def uploadPackage(filename: String, title: String, description: String) {
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageUploadButton")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageTitle")).sendKeys(title)
    driver.getVisibleElementAfterWaitBy(id("scormAdminPackagesummary")).sendKeys(description)
    driver.getVisibleElementAfterWaitBy(id("newPackages")).sendKeys(filename)//Thread.currentThread().getContextClassLoader.getResource(filename).getFile)
    driver.getVisibleElementAfterWaitBy(id("SCORMUpload")).click()
//    driver.waitForElementInvisibleBy(xpath("//*[text()='Processing']"))              //Needed by Chrome browser
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + title + "']"))
  }

  def addStudentRole(){
    driver.getVisibleElementAfterWaitBy(By.id("addStudent")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("//div/b[text() = 'User']/../../button[@id='selectSiteButton']")).click() //TODO: switch to id
  }

  def addTeacherRole(){
    driver.getVisibleElementAfterWaitBy(By.id("addTeacher")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("//div/b[text() = 'Administrator']/../../button[@id='selectSiteButton']")).click()
  }
}