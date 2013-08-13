package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, JavascriptExecutor, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 12.07.13
 */
class BasicCurriculumAdminTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Curriculum " should "be opened correctly" in {
    driver.get(baseUrl + curriculumUrl)
    val managementTab = driver.findElement(By.id("certificateTabs")).findElement(By.partialLinkText("Management"))
    assertNotNull(managementTab)

    assertTrue(isElementPresent(By.id("SCORMButtonAddCertificate")))
    assertTrue(isElementPresent(By.id("certificateSearch")))
  }

  it should "be able to create new certificate" in {
    driver.findElement(By.id("SCORMButtonAddCertificate")).click()

    val certificates = driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(certificates)
    assertEquals(1, certificates.size)

    val certificate = certificates.get(0)
    val title = certificate.findElement(By.className("quizItemTitle")).getText
    assertEquals("New certificate", title)

    val description = certificate.findElement(By.id("SCORMCategoryDescription")).getText
    assertEquals("Certificate info", description)

    //val sites = certificate.findElement(By.className("quizQuestionAmount")).getText
    //assertEquals("0 Sites selected", sites)
    assertSiteAmountInManagement(0)
  }

  it should "be able to edit certificate" in{
    driver.findElement(By.id("certificateEdit")).click()
    driver.findElement(By.className("certificateEditTitle")).click()

    val name = "Test cert1"
    val input = driver.findElements(By.className("quizItemTitle")).get(2)
    input.clear()
    input.sendKeys(name)


    driver.findElement(By.className("certificateTitleUpdate")).click()

    wait(1)
    val title = driver.findElements(By.className("quizItemTitle")).get(1).getText
    assertEquals(name, title)


    driver.findElement(By.id("SCORMEditDescription")).click()
    wait(1)
    val description = "test info"
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+description+"');")
    driver.findElement(By.xpath("//button[@type='button']")).click()

    wait(1)

    val newDescription = driver.findElement(By.id("certificateDescription")).getText
    assertEquals(description, newDescription)

  }

  it should "be able to add site" in{
    driver.findElement(By.id("addSites")).click()
    assertTrue(isElementPresent(By.id("liferaySiteDialog")))

    val site = driver.findElement(By.id("siteList")).findElements(By.id("liferaySiteElement")).get(1)
    site.findElement(By.id("selectSiteButton")).click()

    wait(1)

    assertSiteAmount(1)
  }

  it should "update site info in main view" in{
    openManagement()
    val name = driver.findElement(By.className("quizItemTitle")).getText
    assertEquals("Test cert1", name)

    val desc = driver.findElement(By.id("SCORMCategoryDescription")).getText
    assertEquals("test info", desc)

   // val sites = driver.findElement(By.className("quizQuestionAmount")).getText
   // assertEquals("1 Sites selected", sites)
    assertSiteAmountInManagement(1)

  }

  it should "be able to create and delete certificate" in {
    driver.findElement(By.id("SCORMButtonAddCertificate")).click()
    wait(1)
    val certificates = driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(certificates)
    assertEquals(2, certificates.size)

    val certificate = certificates.get(0)
    certificate.findElement(By.id("certificateDelete")).click()
    wait(1)
    assertTrue(closeAlertAndGetItsText.matches("^This will delete certificate from the system\\. Are you sure[\\s\\S]$"));
    wait(1)

    val newCertificateList = driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
    assertNotNull(newCertificateList)
    assertEquals(1, newCertificateList.size)
  }

  var siteName = ""
  it should "be able to edit sites in certificate" in{
    driver.findElement(By.id("certificateEdit")).click()

    driver.findElement(By.id("addSites")).click()
    assertTrue(isElementPresent(By.id("liferaySiteDialog")))

    val sites = driver.findElement(By.id("siteList")).findElements(By.id("liferaySiteElement"))
    siteName = sites.get(sites.size -1).getText
    sites.get(sites.size -1).findElement(By.id("selectSiteButton")).click()
    wait(1)

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
    val element = driver.findElements(By.className("siteSortableList")).get(2)
    element.click()
    wait(1)
    driver.findElement(By.id("removeSite")).click()
    wait(1)
    assertTrue(closeAlertAndGetItsText.matches("^Are you sure want to delete site[\\s\\S]$"))
   // wait(3)
    assertSiteAmount(2)
   // wait(1)
    openManagement()
   // wait(1)
   // assertSiteAmountInManagement(2)
  }

  def assertSiteAmount(expected: Int){
    val size = driver.findElement(By.className("ui-sortable")).findElements(By.className("siteSortableList")).size
    assertEquals(expected, size)
  }

  def openManagement(){
    driver.findElement(By.partialLinkText("Management")).click()
    wait(1)
  }

  def assertSiteAmountInManagement(expected: Int){
    val sites = driver.findElement(By.className("quizQuestionAmount")).getText
    assertEquals( expected + " Sites selected", sites)
  }
}
