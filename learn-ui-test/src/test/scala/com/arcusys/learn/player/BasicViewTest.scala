package com.arcusys.learn.player

import org.openqa.selenium.{Keys, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.By._
import scala.collection.JavaConverters._

/**
 * 4. Basic viewing of uploaded packages
 * @param _driver
 */
class BasicViewTest(_driver: WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Player" should "be able to sort 'available packages' list" in {
    driver.get(baseUrl + playerUrl)
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[1]")).getText should be(packageTitle12)
    driver.findElement(xpath("//*[@id=\"scormPackageTable\"]/thead/tr/th[1]")).click() // sort by title
    driver.findElement(xpath("//*[@id=\"scormPackageTable\"]/thead/tr/th[1]")).click() // sort by title twice
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[1]")).getText should be(packageTitle12)
    driver.findElement(xpath("//*[@id=\"scormPackageTable\"]/thead/tr/th[1]")).click() // sort by title
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[1]")).getText should be(packageTitle2004)
  }

  it should "be able to search in 'available packages' list" in {
    driver.findElement(id("SCORMPackagesGrid")).findElements(tagName("tr")).size should be(2)
    val searchField = driver.findElement(id("packageSearch"))
    searchField.clear()
    searchField.sendKeys(packageTitle2004)
    wait(1)

    // search for SCORM 2004
    val visibleStage1 = driver.findElement(id("SCORMPackagesGrid")).findElements(tagName("tr"))
      .asScala.filter(_.isDisplayed)
    visibleStage1.size should be(1)
    visibleStage1.head.findElement(xpath("td[1]")).getText should be(packageTitle2004)

    // search for SCORM 1.2
    searchField.clear()
    searchField.sendKeys(packageTitle12)
    wait(1)
    val visibleStage2 = driver.findElement(id("SCORMPackagesGrid")).findElements(tagName("tr")).asScala.filter(_.isDisplayed)
    visibleStage2.size should be(1)
    visibleStage2.head.findElement(xpath("td[1]")).getText should be(packageTitle12)

    // clear search field
    searchField.clear()
    searchField.sendKeys(Keys.ENTER)
    wait(1)
    driver.findElement(id("SCORMPackagesGrid")).findElements(tagName("tr"))
      .asScala.filter(_.isDisplayed).size should be(2)
  }

  it should "be able to open SCORM 1.2 package" in {
    def checkFirstPage() {
      driver.findElement(partialLinkText("How to Play")).getAttribute("class").contains("jstree-clicked") should be(true)
      driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))
      driver.findElement(xpath("/html/body/h1")).getText should be("Play of the game")
      driver.switchTo().defaultContent()
    }

    def checkScoringPage() {
      driver.findElement(partialLinkText("Keeping Score")).getAttribute("class").contains("jstree-clicked") should be(true)
      driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))
      driver.findElement(xpath("/html/body/h1")).getText should be("Scoring")
      driver.switchTo().defaultContent()
    }

    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[2]/td[3]/*[@id=\"startPackage\"]")).click()
    wait(5)
    driver.findElement(id("currentPackageName")).getText should be(packageTitle12)
    checkFirstPage()

    driver.findElement(partialLinkText("Keeping Score")).click()
    wait(3)
    checkScoringPage()

    driver.findElement(id("SCORMNavigationSuspend")).click()
    wait(2)
    driver.findElements(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"startPackage\"]")).size() should be(0)
    driver.findElements(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"resumePackage\"]")).size() should be(1)
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"resumePackage\"]")).click()
    wait(2)
    checkScoringPage()

    driver.findElement(id("SCORMNavigationExit")).click()
    driver.findElements(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"startPackage\"]")).size() should be(1)
    driver.findElements(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"resumePackage\"]")).size() should be(0)
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"startPackage\"]")).click()
    wait(2)
    checkFirstPage()

    driver.findElement(id("SCORMNavigationExit")).click()
    wait(2)
  }


  //12.12
  it should "start from the same place after refreshing page" in {
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"startPackage\"]")).click()
    wait(5)
    driver.findElement(id("currentPackageName")).getText should be(packageTitle12)
    checkPage("How to Play", "Play of the game")

    driver.findElement(partialLinkText("Keeping Score")).click()
    wait(4)
    checkPage("Keeping Score", "Scoring")

    driver.get(baseUrl + playerUrl)
    wait(4)
    checkPage("Keeping Score", "Scoring")

    driver.findElement(id("SCORMNavigationExit")).click()
  }

  it should "be able to open different pages" in {
    wait(5)
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"startPackage\"]")).click()
    wait(5)
    driver.findElement(id("currentPackageName")).getText should be(packageTitle12)
    checkPage("How to Play", "Play of the game")

    driver.findElement(partialLinkText("Keeping Score")).click()
    wait(4)
    checkPage("Keeping Score", "Scoring")

    driver.findElement(partialLinkText("Taking Care of the Course")).click()
    wait(4)
    checkPage("Taking Care of the Course", "Etiquette - Care For the Course")

    driver.findElement(partialLinkText("Handicapping Example")).click()
    wait(3)
    checkPage("Handicapping Example", "Handicaping Example")

    driver.findElement(id("SCORMNavigationExit")).click()
    wait(5)
  }

  private def checkPage(link: String, title: String) {
    driver.findElement(partialLinkText(link)).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))
    driver.findElement(xpath("/html/body/h1")).getText should be(title)
    driver.switchTo().defaultContent()
  }

}
