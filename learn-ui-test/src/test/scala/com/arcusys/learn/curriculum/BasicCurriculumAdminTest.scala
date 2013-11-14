package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, JavascriptExecutor, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._


class BasicCurriculumAdminTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with UICurriculumBase {
  val driver = _driver

  "Curriculum " should "be opened correctly" in {
    driver.get(baseUrl + curriculumUrl)
    val managementTab = driver.findElement(By.id("certificateTabs")).findElement(By.partialLinkText(manager))
    assertNotNull(managementTab)

    assertTrue(isElementPresent(By.id("SCORMButtonAddCertificate")))
    assertTrue(isElementPresent(By.id("certificateSearch")))
  }

  it should "be able to create new certificate" in {
    addEmptyCertificate()

    val certificates = driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(certificates)
    assertEquals(1, certificates.size)

    assertTitleAndDescription("New certificate", "Certificate info")
    assertSiteAmountInManagement(0)
  }

  it should "be able to edit certificate" in{
    val name = "Test cert1"
    val certificateId = updateTitleAndReturnCertificateID(name)
    val title = driver.findElements(By.className("quizItemTitle")).get(1).getText
    assertEquals(name, title)

    driver.findElement(By.id("SCORMEditDescription")).click()
    wait(1)
    val description = "test info"
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+description+"');")
    driver.findElement(By.xpath("//button[@type='button']")).click()

    wait(1)

    val newDescription = driver.findElement(By.id("certificateDescription_" + certificateId)).getText
    assertEquals(description, newDescription)

    openManagement()
    assertTitleAndDescription(name, description)
  }

  it should "be able to change other properties" in{
    openCertManager()

    assertTrue(isElementPresent(By.className("validPeriod")))
    assertTrue(isElementPresent(By.className("publishBadgeCheckbox")))

    driver.findElements(By.className("validPeriod")).get(1).click()
    driver.findElement(By.className("publishBadgeCheckbox")).click()

    // close tab
    driver.findElement(By.className("ui-tabs-close")).click()
    wait(1)
    // verify that it really saves data
    openCertManager()
    assertFalse(driver.findElements(By.className("validPeriod")).get(0).isSelected)
    assertTrue(driver.findElements(By.className("validPeriod")).get(1).isSelected)


    // set default values back (permanent and not open badges
    driver.findElements(By.className("validPeriod")).get(0).click()
    driver.findElement(By.className("publishBadgeCheckbox")).click()
  }

  it should "be able to add site" in{
    addSiteAndReturnName(1)
    assertSiteAmount(1)
  }

  it should "update site info in main view" in{
    openManagement()
    val name = driver.findElement(By.className("quizItemTitle")).getText
    assertEquals("Test cert1", name)

    val desc = driver.findElement(By.id("SCORMCategoryDescription")).getText
    assertEquals("test info", desc)

    assertSiteAmountInManagement(1)

  }

  it should "be able to create and delete certificate" in {
    addEmptyCertificate()
    val certificates = driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(certificates)
    assertEquals(2, certificates.size)

    deleteCertificate()

    val newCertificateList = driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(newCertificateList)
    assertEquals(1, newCertificateList.size)
  }

  var siteName = ""
  it should "be able to edit sites in certificate" in{
    openCertManager()

    siteName = addSiteAndReturnName(3)
    assertSiteAmount(2)

    driver.findElement(By.id("addSites")).click()

    def isPresentInList: Boolean ={
      val isPresent = driver.findElement(By.id("siteList")).findElements(By.id("liferaySiteElement")).toArray
        .foreach(x => if (x.asInstanceOf[WebElement].getText == siteName) return true)
      if (isPresent == true) true else false
    }

    assertFalse(isPresentInList)
    driver.findElement(By.id("siteList")).findElements(By.id("liferaySiteElement")).get(1).findElement(By.id("selectSiteButton")).click()
    wait(1)

    assertSiteAmount(3)
  }

  it should "be able to remove site " in {
    driver.findElement(By.className("certificateRemoveSite")).click()
    wait(1)
    assertTrue(closeAlertAndGetItsText.matches("^Are you sure want to delete course[\\s\\S]$"))
    assertSiteAmount(2)
    openManagement()
    assertSiteAmountInManagement(2)
  }
}
