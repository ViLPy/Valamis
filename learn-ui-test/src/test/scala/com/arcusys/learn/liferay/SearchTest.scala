package com.arcusys.learn.liferay

import org.openqa.selenium._
import org.openqa.selenium.By._
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import scala.collection.JavaConverters._

class SearchTest(_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  private def checkPackage() {
    checkPage("How to Play", "Play of the game")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
  }

  //TODO: move to UITestBase
  protected def checkPage(linkString: String, title: String){
    driver.getVisibleElementAfterWaitBy(partialLinkText(linkString)).click()
    driver.getVisibleElementAfterWaitBy(partialLinkText(linkString)).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("/html/body/h1")).getText should be(title)
    driver.switchTo().defaultContent()
  }

  "Search portlet" should "be able to search for uploaded package" in {      //Search portlet 6.1.2 liferay.
    //Reindex first
    driver.get(baseUrl + "/group/control_panel/manage?p_p_id=137")
    driver.getVisibleElementAfterWaitBy(xpath("//tr/td[text()=' Reindex all search indexes. ']/../td/input")).click()
    driver.getVisibleElementAfterWaitBy(xpath("//div[text() = ' Your request completed successfully. ']"))
    wait(5)   // TODO: temporal solution, if no wait -> search will find not all items
    //======

    driver.get(baseUrl + searchUrl)
    driver.getVisibleElementAfterWaitBy(name("_3_keywords")).sendKeys(packageTitle12)
    driver.getVisibleElementAfterWaitBy(name("_3_keywords")).submit()
    driver.waitForNumberOfElementsWithFilterToEqual(_.getText.contains("Deployed SCORM Package"),className("asset-entry-type"),2) //TODO: if TinCan should be found?
    driver.getVisibleElementAfterWaitBy(partialLinkText("Deployed SCORM Package")).click()
    driver.getVisibleElementAfterWaitBy(xpath("//tr[contains(@class,'portlet-section-body') and contains(@class,'results-row')]//a")).click()

    checkPackage()
  }

  "Asset publisher" should "be able to show uploaded packages" in {
    driver.get(baseUrl + assetPublisherUrl)
    driver.waitForElementVisibleBy(linkText(packageTitle12))
    driver.waitForElementVisibleBy(linkText(packageTitle2004))
//    driver.waitForElementVisibleBy(linkText(packageTitleTincan)) // TODO: add when tincan supports this
  }

  it should "be able to show uploaded packages with filtering" in {
    driver.get(baseUrl + assetPublisherScormOnlyUrl)
    driver.waitForElementVisibleBy(linkText(packageTitle12))
    driver.waitForElementVisibleBy(linkText(packageTitle2004))
  }

  it should "be able to open player in context" in {
    driver.getVisibleElementAfterWaitBy(linkText(packageTitle12)).click()
    driver.getVisibleElementAfterWaitBy(linkText("View in Context »")).click()

    checkPackage()
  }

  it should "be able to upload new package" in {
    val testPackageName = "TestPackageFromAssetPublisher"
    val testPackageDescription = "Test package from asset publisher"
    driver.get(baseUrl + assetPublisherUrl)

    driver.getVisibleElementAfterWaitBy(linkText("Add New")).click()
    driver.getVisibleElementAfterWaitBy(linkText("Deployed SCORM Package")).click()
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(By.tagName("iframe")))
    uploadPackage(packageFile12, testPackageName, testPackageDescription)
    driver.switchTo().defaultContent()

    //driver.getVisibleElementAfterWaitBy(id("closethick")).click()

    driver.get(driver.getCurrentUrl)

    driver.waitForNumberOfElementsWithFilterToEqual( _=> true ,linkText(testPackageName), 1)

    // remove uploaded package
    driver.get(baseUrl + adminUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMAdminPackagesGrid')//*[text()='" + testPackageName + "']")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageRemove")).click()
  }
}
