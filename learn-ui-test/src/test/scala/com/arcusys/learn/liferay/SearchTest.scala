package com.arcusys.learn.liferay

import org.openqa.selenium._
import org.openqa.selenium.By._
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import scala.collection.JavaConverters._

class SearchTest(_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  private def checkPackage() {
    driver.findElement(partialLinkText("How to Play")).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))
    driver.findElement(xpath("/html/body/h1")).getText should be("Play of the game")
    driver.switchTo().defaultContent()

    driver.findElement(id("SCORMNavigationExit")).click()
    wait(2)
  }

  "Search portlet" should "be able to search for uploaded package" in {
    // reindex first
    driver.get(baseUrl + "/group/control_panel/manage?p_p_id=137")
    wait(5)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("_137_saveServer('reindex');")
    wait(10)

    driver.get(baseUrl + searchUrl)
    driver.findElement(name("_3_keywords")).sendKeys(packageTitle12)
    driver.findElement(name("_3_keywords")).submit()
    wait(2)
    driver.findElements(className("asset-entry-type")).asScala.filter(_.getText.contains("Deployed SCORM Package")).size should be(2)
    driver.findElement(partialLinkText("Deployed SCORM Package")).click()
    wait(1)
    driver.findElements(className("portlet-section-body")).asScala.head.findElement(xpath("//*[@class=\"asset-entry-title\"]/a")).click()
    wait(10)

    checkPackage()
  }

  "Asset publisher" should "be able to show uploaded packages" in {
    driver.get(baseUrl + assetPublisherUrl)
    isElementPresent(linkText(packageTitle12)) should be(true)
    isElementPresent(linkText(packageTitle2004)) should be(true)
  }

  it should "be able to show uploaded packages with filtering" in {
    driver.get(baseUrl + assetPublisherScormOnlyUrl)
    wait(5)
    isElementPresent(linkText(packageTitle12)) should be(true)
    isElementPresent(linkText(packageTitle2004)) should be(true)
  }

  it should "be able to open player in context" in {
    driver.findElement(linkText(packageTitle12)).click()
    wait(2)
    driver.findElement(linkText("View in Context »")).click()
    wait(10)

    checkPackage()
  }

  it should "be able to upload new package" in {
    driver.get(baseUrl + assetPublisherUrl)

    driver.findElement(linkText("Add New")).click()
    wait(1)
    driver.findElement(linkText("Deployed SCORM Package")).click()
    wait(3)
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")))
    uploadPackage("SCORM12.zip", "TestPackageFromAssetPublisher", "Test package from asset publisher")
    driver.switchTo().defaultContent()

    driver.findElement(id("closethick")).click()
    wait(1)
    driver.get(driver.getCurrentUrl)

    driver.findElements(linkText("TestPackageFromAssetPublisher")).size should be(1)

    // remove uploaded package
    driver.get(baseUrl + adminUrl)
    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[3]")).click()
    driver.findElement(id("SCORMPackageRemove")).click()
  }
}
