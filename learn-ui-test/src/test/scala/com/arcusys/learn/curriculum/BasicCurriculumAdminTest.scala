package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, JavascriptExecutor, By}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.junit.Assert._


class BasicCurriculumAdminTest  (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with UICurriculumBase {
  val driver = _driver
  val shortDescription = "some description"

  "Curriculum " should "be opened correctly" in {
    driver.get(baseUrl + curriculumUrl)
    val managementTab = driver.getVisibleElementAfterWaitBy(By.id("certificateTabs")).findElement(By.partialLinkText(manager))
    assertNotNull(managementTab)

    driver.waitForElementVisibleBy(By.id("SCORMButtonAddCertificate"))
    driver.waitForElementVisibleBy(By.id("certificateSearch"))
  }

  it should "be able to create new certificate" in {
    addEmptyCertificate()

    val newCertificateName = "New certificate"
    val newCertificateDescription = "Description info"

    driver.waitForNumberOfElementsWithFilterToEqual(_=>true, By.xpath("id('certificateList')//*[@class='availableQuizItem']"), 1)

    assertTitleAndDescription(newCertificateName, newCertificateDescription, 0)
    assertSiteAmountInManagement(newCertificateName, 0)
    assertMembersAmountInManagement(newCertificateName, 0)
    assertImage("default", 0)
  }

  it should "be able to edit certificate" in{
    val name = "Test cert1"
    val certificateId = updateTitleAndReturnCertificateID(name)
    val title = driver.getVisibleElementAfterWaitBy(By.id("editSitesCertificateTitle_"+certificateId)).getText
    assertEquals(name, title)
    val tabTitle = driver.getVisibleElementAfterWaitBy(By.xpath("//a[@href='#certificateTab"+certificateId+"']/span")).getText
    assertEquals("Edit: "+name, tabTitle)

    driver.getVisibleElementAfterWaitBy(By.id("SCORMEditDescription")).click()
    val description = "test info"
    driver.asInstanceOf[JavascriptExecutor].executeScript("tinyMCE.activeEditor.setContent('"+description+"');")
    driver.waitForElementInvisibleBy(By.xpath("//*[text()='Complete']"))
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'SCORMRichTextEdit')]/..//button[1]")).click()

    val newDescription = driver.getVisibleElementAfterWaitBy(By.id("certificateDescription_" + certificateId)).getText
    assertEquals(description, newDescription)

    driver.getVisibleElementAfterWaitBy(By.className("ui-tabs-close")).click()
    assertTitleAndDescription(name, description, 0)
  }

  it should "be able to create and delete certificate" in {
    addEmptyCertificate()
    val certificates = driver.getVisibleElementAfterWaitBy(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(certificates)
    assertEquals(2, certificates.size)

    deleteCertificate("New certificate")

    val newCertificateList = driver.getVisibleElementAfterWaitBy(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(newCertificateList)
    assertEquals(1, newCertificateList.size)
  }

  it should "be able to change other properties in different tabs" in{
    val description1 = "permanent test info"
    val description2 = "year test info"

    val permanentCertificateId = addCertificateWithNameAndDescriptionAndReturnId(permanentCertificateName, description1)

    getCertificateElement(permanentCertificateId, "validPeriod", 0)
    getCertificateElement(permanentCertificateId, "publishBadgeCheckbox", 0).click()
    getCertificateElement(permanentCertificateId, "shortDescription", 0).sendKeys(shortDescription)

    // set image
    driver.findElement(By.xpath("//*[@class='upload']/input")).sendKeys(testImage)

    openManagement()
    val yearCertificateId = addCertificateWithNameAndDescriptionAndReturnId(yearCertificateName, description2)
    driver.waitForElementInvisibleBy(By.xpath("//*[text()='Complete']"))

    getCertificateElement(yearCertificateId, "validPeriod", 1).click()
    getCertificateElement(yearCertificateId, "publishBadgeCheckbox", 0)

    // close tabs
    driver.getVisibleElementAfterWaitBy(By.className("ui-tabs-close")).click()
    driver.getVisibleElementAfterWaitBy(By.className("ui-tabs-close")).click()

//    openManagement()        // need for remote forefox

    assertTitleAndDescription(yearCertificateName, description2, 0)
    assertTitleAndDescription(permanentCertificateName, description1, 1)
    assertImage("default", 0)
    assertImage(trimTestImage, 1)

//    verify that it really saves data
    assertSavedData(permanentCertificateId, permanentCertificateName, description1, 0)
    assertSavedData(yearCertificateId, yearCertificateName, description2, 1)
  }

  it should "be able to add site" in{
    openCertManager(permanentCertificateName)
    addSiteByName("Liferay")
    assertSiteAmount(1)

    openManagement()
    driver.waitForElementWithTextBy(By.xpath("//div[text()='"+permanentCertificateName+"']/../../div[2]/div/div/div[2]/div[3]/div[1]"), "1")
    assertSiteAmountInManagement(permanentCertificateName, 1)
  }

  it should "be able to edit sites in certificate" in{
    openCertManager(permanentCertificateName)

    addSiteByName(testSite1)
    assertSiteAmount(2)

    driver.getVisibleElementAfterWaitBy(By.id("addSites")).click()

    def isPresentInList(name: String): Boolean = {
      var isPresent = false
      driver.getVisibleElementAfterWaitBy(By.id("siteList")).findElements(By.id("liferaySiteElement")).toArray
        .foreach(x => if (x.asInstanceOf[WebElement].findElement(By.xpath("div/b")).getText == name) isPresent = true)
      isPresent
    }

    assertFalse(isPresentInList(testSite1))
    assertTrue(isPresentInList(site2name))
    assertEquals(site2Description, getSiteDescription(site2name))

    driver.getVisibleElementAfterWaitBy(By.xpath("id('CurriculumLiferaySiteDialog')/..//a")).click()

    addSiteByName(site2name)
    addSiteByName(testSite2)

    assertSiteAmount(4)
  }

  it should "be able to remove site " in {
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[text()='Liferay']/..//button")).click()
    driver.getAlertTextAndCloseAfterWait.matches("^Are you sure want to delete course[\\s\\S]$")
    driver.waitForElementInvisibleBy(By.xpath("//*[text()='Complete']"))
    assertSiteAmount(3)

    driver.getVisibleElementAfterWaitBy(By.className("ui-tabs-close")).click()
//    openManagement()       // need for remote forefox
    driver.waitForElementWithTextBy(By.xpath("//div[text()='"+permanentCertificateName+"']/../../div[2]/div/div/div[2]/div[3]/div[1]"), "3")
    assertSiteAmountInManagement(permanentCertificateName,3)
  }

  it should "show sites in correct order" in {
    openCertManager(permanentCertificateName)
    val sitesList = driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@class,'siteSortableList')]"))
    assertEquals(testSite1, sitesList.findElement(By.xpath("li[1]/div[2]")).getText)
    assertEquals(site2name, sitesList.findElement(By.xpath("li[2]/div[2]")).getText)
    assertEquals(testSite2, sitesList.findElement(By.xpath("li[3]/div[2]")).getText)
  }

  private def addCertificateWithNameAndDescriptionAndReturnId(name: String, description: String) = {
    addEmptyCertificate()
    val id = updateTitleAndReturnCertificateID(name)

    driver.getVisibleElementAfterWaitBy(By.xpath("id('editSitesCertificateTitle_"+id+"')/../..//*[@id='SCORMEditDescription']")).click()

    driver.asInstanceOf[JavascriptExecutor].executeScript("tinyMCE.activeEditor.setContent('"+description+"');")
    driver.waitForElementInvisibleBy(By.xpath("//*[text()='Complete']"))
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'SCORMRichTextEdit')]/..//button[1]")).click()
    id
  }

  private def assertSavedData (id: Int, name: String, description: String, valid: Int) {
    openCertManager(name)
    val title1 = getCertificateElement(id, "quizItemTitle", 0).getText
    assertEquals(name, title1)

    val newDescription1 = driver.getVisibleElementAfterWaitBy(By.id("certificateDescription_" + id)).getText
    assertEquals(description, newDescription1)

    assertTrue(getCertificateElement(id, "validPeriod", valid).isSelected)
    assertFalse(getCertificateElement(id, "validPeriod", 1-valid).isSelected)
    val imageSrc = getCertificateElement(id, "logo", 0).getAttribute("src")
    if (name == yearCertificateName)     // year certificate
    {
      assertFalse(getCertificateElement(id, "publishBadgeCheckbox", 0).isSelected)
      assertEquals(defaultImageSrc, imageSrc)
    }
    else                // permanent certificate
    {
      assertTrue(getCertificateElement(id, "publishBadgeCheckbox", 0).isSelected)
      //assertEquals(shortDescription, driver.getVisibleElementAfterWaitBy(By.id("shortDescription_"+id)).getAttribute("value"))
      assertEquals(trimTestImage, getUploadedImageName(imageSrc))
    }
    driver.getVisibleElementAfterWaitBy(By.className("ui-tabs-close")).click()
  }

  private def getCertificateElement (certId: Int, elemName: String, index: Int) = {
    driver.getVisibleElementAfterWaitBy(By.xpath("id('editSitesCertificateTitle_"+certId+"')/../..")).findElements(By.className(elemName)).get(index)
  }

  private def getSiteDescription (name: String) = {
    driver.waitForElementVisibleBy(By.id("liferaySiteDialog"))
    val description = driver.getVisibleElementAfterWaitBy(By.xpath("id('siteList')//*[text()='restricted-1']/../../div[2]")).getText
    description
  }
}
