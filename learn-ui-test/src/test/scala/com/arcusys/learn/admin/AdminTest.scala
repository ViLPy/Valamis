package com.arcusys.learn.admin

import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium._
import org.scalatest.{Suite, FlatSpec}
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._
import org.openqa.selenium.By._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities}
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * 3. Basic package management
 * @param _driver
 */
class AdminTest(_driver: WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver


  behavior of "Admin portlet"

  it should "be able to re-init Database" in {
    driver.get(baseUrl + adminUrl)

    driver.getVisibleElementAfterWaitBy(id("SCORMPackageAdminButton")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMRenewDatabaseSettings")).click()
    driver.getAlertTextAndCloseAfterWait should be("This will delete ALL data from ALL packages for ALL users! Are you sure?")
    driver.getAlertTextAndCloseAfterWait should be("Database renewed!")
    driver.findElements(className("ui-dialog-titlebar-close")).asScala.filter(_.isDisplayed).foreach(_.click()) // click on CloseButton
    driver.get(driver.getCurrentUrl) // reload page TODO: remove to check if After reinitialization packages dissapears.
  }

  it should "be able to upload new package" in {
    val packageTitle = "Test package"
    val packageDescription = "Test package description"

    uploadPackage(packageFile2004, packageTitle, packageDescription)

    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]")).getText should be(packageTitle) // Check packageTitle
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[3]")).getText should be(packageDescription) // Check description
  }

  it should "be able to edit package title and description" in {
    val newTitle = "New title"
    val newDescription = "New description"

    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]")).click() // Click uploaded package
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageEdit")).click() // Click on pencil(edit button)

    val titleField = driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]/*[@id='title']")) // find title field
    titleField.clear() // Clear
    titleField.sendKeys(newTitle) // send new title to edit

    //The same as for title
    val descriptionField = driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[3]/*[@id='summary']"))
    descriptionField.clear()
    descriptionField.sendKeys(newDescription)

    driver.getVisibleElementAfterWaitBy(id("SCORMPackageDone")).click() // Click on save button

    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]")).getText should be(newTitle)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[3]")).getText should be(newDescription)
  }

  it should "not remove unselected packages from list" in {
    driver.get(baseUrl + adminUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr"))
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageRemove")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(1)
  }

  it should "be able remove packages from list" in {
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageRemove")).click()
    driver.waitForElementInvisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr"))
  }

  it should "be able to upload SCORM 1.2 packages, SCORM 2004 and Tincan" in {
    uploadPackage(packageFile12, packageTitle12, packageDescription12)
    uploadPackage(packageFileTincan, packageTitleTincan, packageDescriptionTincan)
    uploadPackage(packageFile2004, packageTitle2004, packageDescription2004)

    //Check that loaded in right order
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]")).getText should be(packageTitle12)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[2]/td[2]")).getText should be(packageTitleTincan)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr[3]/td[2]")).getText should be(packageTitle2004)
  }

  it should "be able to sort packages by id" in {
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')/thead/tr/th[1]")).click() // sort by id desc
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]"),packageTitle2004)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[2]/td[2]"),packageTitleTincan)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[3]/td[2]"),packageTitle12)

    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')/thead/tr/th[1]")).click() // sort by id asc
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]"),packageTitle12)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[2]/td[2]"),packageTitleTincan)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[3]/td[2]"),packageTitle2004)
  }

  it should "be able to sort packages by title" in {
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')/thead/tr/th[2]")).click() // sort by name desc
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]"),packageTitleTincan)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[2]/td[2]"),packageTitle2004)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[3]/td[2]"),packageTitle12)

    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')/thead/tr/th[2]")).click() // sort by name asc
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[1]/td[2]"),packageTitle12)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[2]/td[2]"),packageTitle2004)
    driver.waitForElementWithTextBy(xpath("id('SCORMAdminPackagesGrid')/tr[3]/td[2]"),packageTitleTincan)
  }

  it should "reload packages when clicking on reload button after Adding new package" in { // ignored for IE
    driver.doInNewWindow(xpath("//a"),baseUrl + adminUrl){ _ =>
      driver.get(baseUrl + adminUrl)
      uploadPackage(packageFile12, newPackageTitle, packageDescription12)
    }
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageListReload")).click()
    driver.waitForElementVisibleBy(xpath("id('scormPackageTable')//tr/td[text() = '" + newPackageTitle + "']"))
  }

  it should "reload packages when clicking on reload button after Removing new package" in { // ignored for IE
    driver.doInNewWindow(xpath("//a"),baseUrl + adminUrl){ _ =>
      driver.get(baseUrl + adminUrl)
      driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + newPackageTitle + "']")).click()
      driver.getVisibleElementAfterWaitBy(id("SCORMPackageRemove")).click()
    }
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageListReload")).click()
    driver.waitForElementInvisibleBy(xpath("id('scormPackageTable')//tr/td[text() = '" + newPackageTitle + "']"))
  }

  it should "be able to find package" in {
    driver.waitForElementVisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle2004+ "']"))
    driver.getVisibleElementAfterWaitBy(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(3)

    val searchField = driver.getVisibleElementAfterWaitBy(id("packageAdminSearch"))

    checkSearchHelper(packageTitleTincan, packageTitle12, packageTitle2004)
    checkSearchHelper(packageTitle12, packageTitleTincan, packageTitle2004)
    checkSearchHelper(packageTitle2004, packageTitleTincan, packageTitle12)

    searchField.clear()
    searchField.sendKeys(Keys.ENTER)

    // Search all packages(empty search field)
    driver.waitForElementVisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle2004 + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']"))
    driver.getVisibleElementAfterWaitBy(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).asScala.filter(_.isDisplayed).size should be(3)

    def checkSearchHelper(searchPackage: String, invisiblePackage1: String, invisiblePackage2: String) = {
      // search package
      searchField.clear()
      searchField.sendKeys(searchPackage)
      driver.waitForElementInvisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + invisiblePackage1 + "']")) // Wait when SCORM disappears
      driver.waitForElementInvisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + invisiblePackage2 + "']")) // Wait when SCORM disappears
      driver.waitForElementVisibleBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + searchPackage + "']")) // Wait when SCORM disappears

      driver.getVisibleElementAfterWaitBy(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).asScala.filter(_.isDisplayed).size should be(1)
    }
  }

  it should "show uploaded packages in player" in {
    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitle12 + "']")).getText should be(packageTitle12)
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitle2004 + "']")).getText should be(packageTitle2004)
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitleTincan + "']")).getText should be(packageTitleTincan)
    driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(3)
  }

  it should "hide uploaded packages from player view" in {
    driver.get(baseUrl + adminUrl)

    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']")).getText should be(packageTitle12)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle2004 + "']")).getText should be(packageTitle2004)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']")).getText should be(packageTitleTincan)

    driver.getVisibleElementAfterWaitBy(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(3)

    //Tincan has inactive visibility and isDefault checkboxes
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']/../td[4]/*[@id='visibility']")).isEnabled should be(false)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']/../td[5]/*[@id='isDefault']")).isEnabled should be(false)

    // set invisibility
    val visibilityField = driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']/../td[4]/*[@id='visibility']"))
    visibilityField.isSelected should be(true)
    visibilityField.click()

    driver.get(baseUrl + playerUrl)

    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitle2004 + "']")).getText should be(packageTitle2004)
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitleTincan + "']")).getText should be(packageTitleTincan)
    driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(2)

    // set visibility back
    driver.get(baseUrl + adminUrl)

    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']")).getText should be(packageTitle12)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle2004 + "']")).getText should be(packageTitle2004)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']")).getText should be(packageTitleTincan)
    driver.getVisibleElementAfterWaitBy(id("SCORMAdminPackagesGrid")).findElements(tagName("tr")).size should be(3)

    val visibilityField2 = driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']/../td[4]/*[@id='visibility']"))
    visibilityField2.isSelected should be(false)
    visibilityField2.click()

    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitle12 + "']")).getText should be(packageTitle12)
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitle2004 + "']")).getText should be(packageTitle2004)
    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + packageTitleTincan + "']")).getText should be(packageTitleTincan)
    driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(3)
  }

  it should "be able to add and remove Student role" in {
    driver.get(baseUrl + adminUrl)
    driver.getVisibleElementAfterWaitBy(xpath("//*[@href='#rolesTabMenu']")).click()

    addStudentRole
    checkRolesAmount("studentRoleList", 1)

    // unable to delete unselected role
    driver.getVisibleElementAfterWaitBy(id("removeStudent")).click()
    checkRolesAmount("studentRoleList", 1)

    //delete selected role
    driver.getVisibleElementAfterWaitBy(xpath("id('studentRoleList')/tr")).click()
    driver.getVisibleElementAfterWaitBy(id("removeStudent")).click()
    driver.getAlertTextAndCloseAfterWait should be("Are you sure you want to delete role?")
    checkRolesAmount("studentRoleList", 0)

    addStudentRole
  }

  it should "be able to add and remove Teacher role" in {
    driver.get(baseUrl + adminUrl)
    driver.getVisibleElementAfterWaitBy(xpath("//*[@href='#rolesTabMenu']")).click()

    addTeacherRole
    checkRolesAmount("teacherRoleList", 1)

    // unable to delete unselected role
    driver.getVisibleElementAfterWaitBy(id("removeTeacher")).click()
    checkRolesAmount("teacherRoleList", 1)

    //delete selected role
    driver.getVisibleElementAfterWaitBy(xpath("id('teacherRoleList')/tr")).click()
    driver.getVisibleElementAfterWaitBy(id("removeTeacher")).click()
    driver.getAlertTextAndCloseAfterWait should be("Are you sure you want to delete role?")
    checkRolesAmount("teacherRoleList", 0)

    addTeacherRole
  }

  private def checkRolesAmount (id: String, amnt: Int) {
    if (amnt == 0)
      driver.waitForElementInvisibleBy(xpath("id('"+id+"')/tr"))
    else
      driver.getVisibleElementAfterWaitBy(By.xpath("id('"+id+"')/tr"))

    driver.getVisibleElementAfterWaitBy(By.id(id)).findElements(By.tagName("tr")).size should be (amnt)
  }

  //TODO: Check setting(third tab)

  ignore should "show alert at start Tincan package without touching endpoint" in {      // TODO: implement new tincan functionality
    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']/..//*[@id='startPackage']")).click()
    driver.getAlertTextAndCloseAfterWait should be("Tincan lrs is not configured")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
  }

  ignore should "show alert at start Tincan package with empty endpoint setting" in {  // TODO: Save empty endpoint generates no alert.
    def checkDifferentConditions(checkboxShouldBeChecked: Boolean, loginShouldBePresented: Boolean, passwordShouldBePresented: Boolean){
      driver.get(baseUrl + adminUrl)
      driver.getVisibleElementAfterWaitBy(xpath("//*[@href='#settingsTabMenu']")).click()

      driver.getVisibleElementAfterWaitBy(xpath("//input[@name='endpoint']")).clear()

      val checkbox = driver.getVisibleElementAfterWaitBy(id("tincanLrsCommonCredentialsCheckbox"))
      if(checkbox.isSelected) checkbox.click() //unchecked
      if(checkboxShouldBeChecked){
        checkbox.click()
        if(loginShouldBePresented) driver.locateClearAndSendKeys(xpath("//input[@name='loginName']"), TincanUserName)
        if(passwordShouldBePresented) driver.locateClearAndSendKeys(xpath("//input[@name='password']"), TincanUserPassword)
      }

      driver.getVisibleElementAfterWaitBy(id("TincanSaveLrsSettings")).click()

      driver.get(baseUrl + playerUrl)
      driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']/..//*[@id='startPackage']")).click()
      driver.getAlertTextAndCloseAfterWait should be("Tincan lrs is not configured")
      driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
    }
    checkDifferentConditions(true, false, false)
    checkDifferentConditions(true, false, true)
    checkDifferentConditions(true, true, false)
    checkDifferentConditions(true, true, true)
    checkDifferentConditions(false, false, false)
  }

  ignore should "require login/password to start Tincan package" in {     // TODO: implement new tincan functionality
    driver.get(baseUrl + adminUrl)
    driver.getVisibleElementAfterWaitBy(xpath("//*[@href='#settingsTabMenu']")).click()
    driver.getVisibleElementAfterWaitBy(xpath("//input[@name='endpoint']")).sendKeys(TincanEndPoint)
    driver.getVisibleElementAfterWaitBy(id("tincanLrsCommonCredentialsCheckbox")).click()
    driver.getVisibleElementAfterWaitBy(id("tincanLrsCommonCredentialsCheckbox")).isSelected should be(false)
    driver.getVisibleElementAfterWaitBy(id("TincanSaveLrsSettings")).click()

    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']/..//*[@id='startPackage']")).click()
    driver.waitForElementVisibleBy(id("ui-dialog-title-tincanLrsUserCredentials"))
    driver.getVisibleElementAfterWaitBy(xpath("//*[@class='ui-icon ui-icon-closethick']")).click()

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
  }

  ignore should "start Tincan package if endpoint address/login/password credetials are set" in {
    driver.get(baseUrl + adminUrl)
    driver.getVisibleElementAfterWaitBy(xpath("//*[@href='#settingsTabMenu']")).click()
    driver.getVisibleElementAfterWaitBy(xpath("//input[@name='endpoint']")).sendKeys(TincanEndPoint)

    val checkbox = driver.getVisibleElementAfterWaitBy(id("tincanLrsCommonCredentialsCheckbox"))
    if(!checkbox.isSelected) checkbox.click() //checked
    driver.getVisibleElementAfterWaitBy(id("TincanSaveLrsSettings")).click()

    driver.locateClearAndSendKeys(xpath("//input[@name='loginName']"), TincanUserName)
    driver.locateClearAndSendKeys(xpath("//input[@name='password']"), TincanUserPassword)

    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']/..//*[@id='startPackage']")).click()

    //TODO: add playing TinCan packages

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
  }
}
