package com.arcusys.learn.admin

import com.arcusys.learn.base.UITestBase
import org.openqa.selenium._
import org.scalatest.{Suite, FlatSpec}
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._
import org.openqa.selenium.By._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

/**
 * 3. Basic package management
 * @param _driver
 */
class AdminTest(_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Package admin" should "be able to re-init Database" in {
    driver.get(baseUrl + adminUrl)
    driver.findElement(id("SCORMPackageAdminButton")).click()
    driver.findElement(id("SCORMRenewDatabaseSettings")).click()
    closeAlertAndGetItsText should be("This will delete ALL data from ALL packages for ALL users! Are you sure?")
    //wait(8)
    waitForAlert()
    closeAlertAndGetItsText should be("Database renewed!")
    driver.findElements(className("ui-dialog-titlebar-close")).asScala.filter(_.isDisplayed).foreach(_.click())
    driver.get(driver.getCurrentUrl) // reload
  }

  it should "be able to upload new package" in {
    val packageTitle = "Test package"
    val packageDescription = "Test package description"

    uploadPackage("SCORM20043rdEdition.zip", packageTitle, packageDescription)
    //wait(2)
    waitForElementBy(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[2]"))
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[2]")).getText should be(packageTitle)
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[3]")).getText should be(packageDescription)
  }

  it should "be able to edit package title and description" in {
    val newTitle = "New title"
    val newDescription = "New description"

    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]")).click()
    driver.findElement(id("SCORMPackageEdit")).click()
    val titleField = driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[2]/*[@id=\"title\"]"))
    titleField.clear()
    titleField.sendKeys(newTitle)

    val descriptionField = driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[3]/*[@id=\"summary\"]"))
    descriptionField.clear()
    descriptionField.sendKeys(newDescription)

    driver.findElement(id("SCORMPackageDone")).click()
    wait(1)
    driver.findElement(id("SCORMPackageListReload")).click()
    wait(2)
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[2]")).getText should be(newTitle)
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[3]")).getText should be(newDescription)
  }

  it should "be able remove packages from list" in {
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]")).click()
    driver.findElement(id("SCORMPackageRemove")).click()
    driver.findElement(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(0)
  }

  it should "be able to upload SCORM 1.2 packages and SCORM 2004" in {
    uploadPackage("SCORM12.zip", packageTitle12, packageDescription12)
    uploadPackage("SCORM20043rdEdition.zip", packageTitle2004, packageDescription2004)
  }

  it should "be able to sort packages" in {
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[2]")).getText should be(packageTitle12)
    driver.findElement(xpath("//*[@id=\"scormPackageTable\"]/thead/tr/th[1]")).click() // sort by id
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[2]")).getText should be(packageTitle2004)
    driver.findElement(xpath("//*[@id=\"scormPackageTable\"]/thead/tr/th[1]")).click() // sort by id once more
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[2]")).getText should be(packageTitle12)
  }

  it should "be able to find package" in {
    driver.findElement(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(2)
    val searchField = driver.findElement(id("packageAdminSearch"))
    searchField.clear()
    searchField.sendKeys(packageTitle2004)
    wait(1)

    // search for SCORM 2004
    val visibleStage1 = driver.findElement(id("SCORMAdminPackagesGrid")).findElements(tagName("tr"))
      .asScala.filter(_.isDisplayed)
    visibleStage1.size should be(1)
    visibleStage1.head.findElement(xpath("td[2]")).getText should be(packageTitle2004)

    // clear search field
    searchField.clear()
    searchField.sendKeys(Keys.ENTER)
    wait(1)
    driver.findElement(id("SCORMAdminPackagesGrid")).findElements(tagName("tr"))
      .asScala.filter(_.isDisplayed).size should be(2)

    // search for SCORM 1.2
    searchField.sendKeys(packageTitle12)
    wait(1)
    val visibleStage3 = driver.findElement(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).asScala.filter(_.isDisplayed)
    visibleStage3.size should be(1)
    visibleStage3.head.findElement(xpath("td[2]")).getText should be(packageTitle12)
  }

  it should "show uploaded packages in player" in {
    driver.get(baseUrl + playerUrl)
    driver.findElement(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(2)
  }

  it should "hide uploaded packages from player view" in {
    driver.get(baseUrl + adminUrl)
    driver.findElement(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(2)
    val visibilityField = driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[4]/*[@id=\"visibility\"]"))
    visibilityField.isSelected should be(true)
    visibilityField.click()
    wait(1)

    driver.get(baseUrl + playerUrl)
    driver.findElement(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(1)

    // set visibility back
    driver.get(baseUrl + adminUrl)
    driver.findElement(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(2)
    val visibilityField2 = driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]/td[4]/*[@id=\"visibility\"]"))
    visibilityField2.isSelected should be(false)
    visibilityField2.click()
    wait(1)

    driver.get(baseUrl + playerUrl)
    driver.findElement(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(2)
  }

  it should "be able to add Student role" in {
    driver.get(baseUrl + adminUrl)
    driver.findElement(xpath("//*[@href=\"#rolesTabMenu\"]")).click()
    wait(1)
    driver.findElement(id("addStudent")).click()
    wait(1)
    driver.findElement(xpath("(//button[@id='selectSiteButton'])[11]")).click()
  }

  it should "be able to add Teacher role" in {
    driver.get(baseUrl + adminUrl)
    driver.findElement(xpath("//*[@href=\"#rolesTabMenu\"]")).click()
    wait(1)
    driver.findElement(id("addTeacher")).click()
    wait(1)
    driver.findElement(xpath("(//button[@id='selectSiteButton'])[12]")).click()
  }
}
