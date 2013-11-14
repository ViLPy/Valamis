package com.arcusys.learn.curriculum

import org.openqa.selenium._
import org.openqa.selenium.By._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.junit.Assert._
import com.arcusys.learn.base.UITestBase

trait UICurriculumBase extends UITestBase{
  val driver: WebDriver
  val manager = "Certificate manager"

  def getElement(name: String): WebElement = {
    val element = driver.findElements(By.className(name)).toArray
      .foreach(x => if (x.asInstanceOf[WebElement].isDisplayed) return x.asInstanceOf[WebElement])
    return element.asInstanceOf[WebElement]
  }

  def openManagement(){
    driver.findElement(By.partialLinkText(manager)).click()
    wait(1)
  }
  def openCertManager(){
    driver.findElement(By.id("certificateEdit")).click()
  }
  def openUserManagement(){
    driver.findElements(By.id("certificateEditUsers")).get(0).click()
  }
  def assertSiteAmount(expected: Int){
    val element = driver.findElement(By.className("siteSortableList"))
    val certificateId = element.getAttribute("id").replace("certificateSitesSortable_", "")
    val size = driver.findElements(By.xpath("//*[@id=\"certificateSitesSortable_"+ certificateId +"\"]/li")).size
    assertEquals(expected, size)
  }

  def assertSiteAmountInManagement(expected: Int){
    val sites = driver.findElements(By.className("quizSectionTitle")).get(1).getText
    assertEquals( expected + " Courses", sites)
  }

  def assertTitleAndDescription(title: String, description: String){
    val certificates = driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))

    val certificate = certificates.get(0)
    val title = certificate.findElement(By.className("quizItemTitle")).getText
    assertEquals(title, title)

    val description = certificate.findElement(By.id("SCORMCategoryDescription")).getText
    assertEquals(description, description)

  }

  def assertTitleInList(name: String, index: Int) {
    assertEquals(name, driver.findElement(By.xpath("//*[@id=\"certificateList\"]/li[" + index + "]/div/div[1]/div[1]")).getText)
  }

  def deleteCertificate() {
    deleteCertificate(0)
  }
  def deleteCertificate(index: Int) {
    driver.findElements(By.id("certificateDelete")).get(index).click()
    wait(1)
    assertTrue(closeAlertAndGetItsText.matches("^This will delete certificate from the system\\. Are you sure[\\s\\S]$"))
  }

  def addEmptyCertificate() {
    openManagement()
    driver.findElement(By.id("SCORMButtonAddCertificate")).click()
    wait(1)
  }
  def addCertificate(name: String) {
    addEmptyCertificate()
    updateTitleAndReturnCertificateID(name)
  }

  def addSiteAndReturnName(number: Int) = {
    driver.findElement(By.id("addSites")).click()
    assertTrue(isElementPresent(By.id("liferaySiteDialog")))

    val site = driver.findElement(By.id("siteList")).findElements(By.id("liferaySiteElement")).get(number)
    val name = site.getText
    site.findElement(By.id("selectSiteButton")).click()
    wait(1)
    name
  }

  def addMemberAndReturnName(number: Int)={
    driver.findElement(By.id("addMember")).click()
    wait(1)
    assertTrue(isElementPresent(By.id("CurriculumLiferayUserDialog")))
    val user = driver.findElement(By.id("userList")).findElements(By.id("liferayUserElement")).get(number)
    val username = user.getText

    user.findElement(By.id("selectUserButton")).click()
    driver.findElement(By.partialLinkText("close")).click()
    wait(1)
    username
  }
  def addStudentMember(){
    driver.findElement(By.id("addMember")).click()
    wait(1)

    // require user with name Student and he is not first in the student list
    driver.findElement(By.id("userSearch")).sendKeys(studentUserName)
    wait(1)

    val users = driver.findElements(By.id("liferayUserElement"))

    def userHelper: WebElement={
      val user = users.toArray.foreach(x => {
        if (x.asInstanceOf[WebElement].findElement(By.id("selectUserButton")).isDisplayed) return x.asInstanceOf[WebElement]
      })
      user.asInstanceOf[WebElement]
    }

    val user =  userHelper
    user.findElement(By.id("selectUserButton")).click()
    driver.findElement(By.partialLinkText("close")).click()
    wait(1)
  }


  def setGrade(grade: Int, comment: String){
    setGrade(0, grade, comment)
  }
  def setGrade(reviewNumber: Int, grade: Int, comment: String){
    val reviews = driver.findElements(By.className("userCourseReview"))
    reviews.get(reviewNumber).click()
    assertTrue(isElementPresent(By.id("userCourseGrade")))

    driver.findElement(By.id("certificateCourseComment")).sendKeys(comment)
    driver.findElement(By.xpath("(//input[@name='grade'])["+ grade +"]")).click()
    driver.findElement(By.id("saveCourseGradeButton")).click()

    wait(1)
  }

  def updateTitleAndReturnCertificateID(name: String) = {
    openCertManager()

    getElement("certificateEditTitle").click()
    val input = getElement("quizItemTitle")
    input.clear()
    input.sendKeys(name)
    val id = input.getAttribute("id")
    val certificateId = id.replace("editSitesCertificateTitleInput_", "").toInt
    getElement("certificateTitleUpdate").click()
    wait(1)
    certificateId
  }

  def findActivity(activity: String): Boolean = {
    driver.findElements(By.className("activity-title")).toArray.foreach(p =>{
      if (p.asInstanceOf[WebElement].getText == activity) return true
    })
    false
  }


}