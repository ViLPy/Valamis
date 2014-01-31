package com.arcusys.learn.curriculum

import org.openqa.selenium._
import org.junit.Assert._
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}

trait UICurriculumBase extends UITestBase{
  val driver: WebDriverArcusys
  val manager = "Certificate manager"

  def getElement(name: String): WebElement = {
    val element = driver.findElements(By.className(name)).toArray
      .foreach(x => if (x.asInstanceOf[WebElement].isDisplayed) return x.asInstanceOf[WebElement])
    element.asInstanceOf[WebElement]
  }

  def openManagement(){
    driver.getVisibleElementAfterWaitBy(By.partialLinkText(manager)).click()
  }
  def openCertManager(name: String){
    driver.getVisibleElementAfterWaitBy(By.xpath("//div[@class='availableQuizItem']/div/div[text()='"+ name +"']/..//*[@id='certificateEdit']")).click()
  }
  def openUserManagement(name: String){
    driver.getVisibleElementAfterWaitBy(By.xpath("//div[@class='availableQuizItem']/div/div[text()='"+ name +"']/..//*[@id='certificateEditUsers']")).click()
//    driver.findElements(By.id("certificateEditUsers")).get(0).click()
  }
  def assertSiteAmount(expected: Int){
    val element = driver.getVisibleElementAfterWaitBy(By.className("siteSortableList"))
    val certificateId = element.getAttribute("id").replace("certificateSitesSortable_", "")
    val size = driver.findElements(By.xpath("//*[@id=\"certificateSitesSortable_"+ certificateId +"\"]/li")).size
    assertEquals(expected, size)
  }

  def assertSiteAmountInManagement(name: String, expected: Int){
    driver.getVisibleElementAfterWaitBy(By.xpath("//div[text()='"+name+"']"))
    val sites = driver.getVisibleElementAfterWaitBy(By.xpath("//div[text()='"+name+"']/../..")).findElements(By.className("quizSectionTitle")).get(1).getText
    assertEquals( expected + " Courses", sites)
  }

  def assertMembersAmountInManagement(name: String, expected: Int) {
    driver.getVisibleElementAfterWaitBy(By.xpath("//div[text()='"+name+"']"))
    val members = driver.getVisibleElementAfterWaitBy(By.xpath("//div[text()='"+name+"']/../..")).findElements(By.className("quizSectionTitle")).get(2).getText
    assertEquals(expected + " Members", members)
  }

  def assertTitleAndDescription(title: String, description: String, index: Int){
    val certificates = driver.getVisibleElementAfterWaitBy(By.id("certificateList")).findElements(By.className("availableQuizItem"))

    val certificate = certificates.get(index)
    val title1 = certificate.findElement(By.className("quizItemTitle")).getText
    assertEquals(title, title1)

    val description2 = certificate.findElement(By.id("SCORMCategoryDescription")).getText
    assertEquals(description, description2)
  }

  def assertImage(name: String, index: Int) {
    val certificates = driver.getVisibleElementAfterWaitBy(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    val certificate = certificates.get(index)

    val imageName = certificate.findElement(By.className("logo")).getAttribute("src")

    if (name == "default")
      assertEquals(defaultImageSrc, imageName)
    else
      assertEquals(name, getUploadedImageName(imageName))
  }

  def assertTitleInList(name: String, index: Int) {
    assertEquals(name, driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"certificateList\"]/li[" + index + "]/div/div[1]/div[1]")).getText)
  }

  def deleteCertificate(name: String) {
    driver.getVisibleElementAfterWaitBy(By.xpath("//div[text()='"+name+"']/..//*[@id='certificateDelete']")).click()
    driver.getAlertTextAndCloseAfterWait.matches("^This will delete certificate from the system\\. Are you sure[\\s\\S]$")
  }

  def addEmptyCertificate() {
    openManagement()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMButtonAddCertificate")).click()
  }
  def addCertificate(name: String) {
    addEmptyCertificate()
    updateTitleAndReturnCertificateID(name)
  }

  @deprecated
  def addSiteAndReturnName(number: Int) = {
    driver.getVisibleElementAfterWaitBy(By.id("addSites")).click()
    driver.waitForElementVisibleBy(By.id("liferaySiteDialog"))

    val site = driver.getVisibleElementAfterWaitBy(By.id("siteList")).findElements(By.id("liferaySiteElement")).get(number)
    val name = site.getText
    site.findElement(By.id("selectSiteButton")).click()
    name
  }

  def addSiteByName (name: String) {
    driver.getVisibleElementAfterWaitBy(By.id("addSites")).click()
    driver.waitForElementVisibleBy(By.id("liferaySiteDialog"))

    driver.getVisibleElementAfterWaitBy(By.xpath("id('siteList')//*[text()='"+name+"']/../../button")).click()
  }

  def addNotStudentMemberAndReturnName(number: Int)={
    driver.getVisibleElementAfterWaitBy(By.id("addMember")).click()
    driver.waitForElementVisibleBy(By.id("CurriculumLiferayUserDialog"))
    val user = if (driver.getVisibleElementAfterWaitBy(By.id("userList")).findElements(By.id("liferayUserElement")).get(number).getText.contains(studentLogin))
       driver.getVisibleElementAfterWaitBy(By.id("userList")).findElements(By.id("liferayUserElement")).get(number+1)
    else driver.getVisibleElementAfterWaitBy(By.id("userList")).findElements(By.id("liferayUserElement")).get(number)
    val username = user.getText

    user.findElement(By.id("selectUserButton")).click()
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("close")).click()
    username
  }
  def addStudentMember(){
    driver.getVisibleElementAfterWaitBy(By.id("addMember")).click()

    // require user with name Student and he is not first in the student list
    driver.getVisibleElementAfterWaitBy(By.id("userSearch")).sendKeys(studentUserName)

    val users = driver.findElements(By.id("liferayUserElement"))

    def userHelper: WebElement={
      val user = users.toArray.foreach(x => {
        if (x.asInstanceOf[WebElement].findElement(By.id("selectUserButton")).isDisplayed) return x.asInstanceOf[WebElement]
      })
      user.asInstanceOf[WebElement]
    }

    val user =  userHelper
    user.findElement(By.id("selectUserButton")).click()
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("close")).click()
  }


  def setGrade(grade: Int, comment: String){
    setGrade(0, grade, comment)
  }
  def setGrade(reviewNumber: Int, grade: Int, comment: String){
    driver.getVisibleElementAfterWaitBy(By.className("userCourseReview"))
    val reviews = driver.findElements(By.className("userCourseReview"))
    reviews.get(reviewNumber).click()
    driver.waitForElementVisibleBy(By.id("userCourseGrade"))

    driver.getVisibleElementAfterWaitBy(By.id("certificateCourseComment")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("certificateCourseComment")).sendKeys(comment)
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@name='grade'])["+ (grade+1) +"]")).click()
    driver.getVisibleElementAfterWaitBy(By.id("saveCourseGradeButton")).click()

  }

  def updateTitleAndReturnCertificateID(name: String) = {
    openCertManager("New certificate")

    getElement("certificateEditTitle").click()
    val input = getElement("quizItemTitle")
    input.clear()
    input.sendKeys(name)
    val id = input.getAttribute("id")
    val certificateId = id.replace("editSitesCertificateTitleInput_", "").toInt
    getElement("certificateTitleUpdate").click()
    certificateId
  }

  def findActivity(activity: String): Boolean = {
    driver.findElements(By.className("activity-title")).toArray.foreach(p =>{
      if (p.asInstanceOf[WebElement].getText == activity) return true
    })
    false
  }

  def getUploadedImageName (src: String) = {
    src.substring(src.lastIndexOf("=")+1)
  }
}