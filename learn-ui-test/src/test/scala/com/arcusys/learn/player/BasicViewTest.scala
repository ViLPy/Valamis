package com.arcusys.learn.player

import org.openqa.selenium.{Keys, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium.By._
import scala.collection.JavaConverters._

/**
 * 4. Basic viewing of uploaded packages
 * @param _driver
 */
class BasicViewTest(_driver: WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  behavior of "Player"

  it should "load the player page" in {
    driver.get(baseUrl + playerUrl)
  }

  ignore should "reload packages when clicking on reload button after Adding new package" in { //TODO: Vitaly fixes player reload and sort by title
    driver.get(baseUrl + playerUrl)
    val newPackageTitle = "reallyNewPackageTitle"
    driver.doInNewWindow(xpath("//a/span[text()=' Admin']/.."),baseUrl + adminUrl){ _ =>
      driver.get(baseUrl + adminUrl)
      uploadPackage(packageFile12, newPackageTitle, packageDescription12)
    }
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageListReload")).click()
    driver.waitForElementVisibleBy(xpath("id('scormPackageTable')//tr/td[text() = '" + newPackageTitle + "']"))
  }

  ignore should "reload packages when clicking on reload button after Removing new package" in { //TODO: Vitaly fixes player reload and sort by title
    val newPackageTitle = "reallyNewPackageTitle"
    driver.doInNewWindow(xpath("//a/span[text()=' Admin']/.."),baseUrl + adminUrl){ _ =>
      driver.get(baseUrl + adminUrl)
      driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')//tr/td[text() = '" + newPackageTitle + "']")).click()
      driver.getVisibleElementAfterWaitBy(id("SCORMPackageRemove")).click()
    }
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageListReload")).click()
    driver.waitForElementInvisibleBy(xpath("id('scormPackageTable')//tr/td[text() = '" + newPackageTitle + "']"))
  }

  it should "be able to sort 'available packages' list" in {
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[1]/td[1]"),packageTitle12)
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[2]/td[1]"),packageTitle2004)
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[3]/td[1]"),packageTitleTincan)

    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')/thead/tr/th[1]")).click() // sort by title
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[1]/td[1]"),packageTitleTincan)
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[2]/td[1]"),packageTitle2004)
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[3]/td[1]"),packageTitle12)

    driver.getVisibleElementAfterWaitBy(xpath("id('scormPackageTable')/thead/tr/th[1]")).click() // sort by title
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[1]/td[1]"),packageTitle12)
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[2]/td[1]"),packageTitle2004)
    driver.waitForElementWithTextBy(xpath("id('SCORMPackagesGrid')/tr[3]/td[1]"),packageTitleTincan)
  }

  it should "be able to search in 'available packages' list" in {
    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle2004+ "']"))
    driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(3)

    val searchField = driver.getVisibleElementAfterWaitBy(id("packageSearch"))

    checkSearchHelper(packageTitleTincan, packageTitle12, packageTitle2004)
    checkSearchHelper(packageTitle12, packageTitleTincan, packageTitle2004)
    checkSearchHelper(packageTitle2004, packageTitleTincan, packageTitle12)

    // Search all packages(empty search field)
    searchField.clear()
    searchField.sendKeys(Keys.ENTER)

    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle2004 + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle12 + "']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitleTincan + "']"))
    driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid")).findElements(tagName("tr")).asScala.filter(_.isDisplayed).size should be(3)

    def checkSearchHelper(searchPackage: String, invisiblePackage1: String, invisiblePackage2: String) = {
      // search package
      searchField.clear()
      searchField.sendKeys(searchPackage)
      driver.waitForElementInvisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + invisiblePackage1 + "']")) // Wait when SCORM disappears
      driver.waitForElementInvisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + invisiblePackage2 + "']")) // Wait when SCORM disappears
      driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + searchPackage + "']")) // Wait when SCORM disappears

      driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid")).findElements(tagName("tr")).asScala.filter(_.isDisplayed).size should be(1)
    }
  }

  it should "be able to open SCORM 1.2 package" in {
    openPackage(packageTitle12)
  }

  it should "start from the same place after refreshing page (SCORM 1.2)" in {
    startAtTheSamePlace(packageTitle12)
  }

  it should "be able to open different pages (SCORM 1.2)" in {
    openDifferentPages(packageTitle12)
  }

  it should "be able to open SCORM 2004 package" in {
    openPackage(packageTitle2004)
  }

  it should "start from the same place after refreshing page (SCORM 2004)" in {
    startAtTheSamePlace(packageTitle2004)
  }

  it should "be able to open different pages (SCORM 2004)" in {
    openDifferentPages(packageTitle2004)
  }

  // TODO: Add tincan package support


  // Functions for player play check
  //TODO: move to UITestBase
  private def checkPage(linkString: String, title: String){
    driver.waitForNumberOfElementsWithFilterToEqual(x=>x.getAttribute("class").contains("jstree-clicked"), partialLinkText(linkString), 1)
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("/html/body/h1")).getText should be(title)
    driver.switchTo().defaultContent()
  }

  private def openPackage(packageTitle: String){
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='startPackage']")).click()
    driver.getVisibleElementAfterWaitBy(id("currentPackageName")).getText should be(packageTitle)

    driver.getVisibleElementAfterWaitBy(partialLinkText("How to Play")).click()
    checkPage("How to Play", "Play of the game")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Keeping Score")).click()
    checkPage("Keeping Score", "Scoring")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationSuspend")).click()
    driver.waitForElementInvisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='startPackage']"))
    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='resumePackage']"))
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='resumePackage']")).click()

    checkPage("Keeping Score", "Scoring")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
    driver.waitForElementVisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='startPackage']"))
    driver.waitForElementInvisibleBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='resumePackage']"))
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='startPackage']")).click()

    driver.getVisibleElementAfterWaitBy(partialLinkText("How to Play")).click()
    checkPage("How to Play", "Play of the game")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
  }

  private def startAtTheSamePlace(packageTitle: String){
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='startPackage']")).click()
    driver.getVisibleElementAfterWaitBy(id("currentPackageName")).getText should be(packageTitle)
    driver.getVisibleElementAfterWaitBy(partialLinkText("How to Play")).click()
    checkPage("How to Play", "Play of the game")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Keeping Score")).click()
    checkPage("Keeping Score", "Scoring")

    driver.get(baseUrl + playerUrl)
    checkPage("Keeping Score", "Scoring")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
  }

  private def openDifferentPages(packageTitle: String){
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr/td[text() = '" + packageTitle + "']/..//*[@id='startPackage']")).click()
    driver.getVisibleElementAfterWaitBy(id("currentPackageName")).getText should be(packageTitle)
    driver.getVisibleElementAfterWaitBy(partialLinkText("How to Play")).click()
    checkPage("How to Play", "Play of the game")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Keeping Score")).click()
    checkPage("Keeping Score", "Scoring")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Taking Care of the Course")).click()
    checkPage("Taking Care of the Course", "Etiquette - Care For the Course")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Handicapping Example")).click()
    checkPage("Handicapping Example", "Handicaping Example")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()

  }
}
