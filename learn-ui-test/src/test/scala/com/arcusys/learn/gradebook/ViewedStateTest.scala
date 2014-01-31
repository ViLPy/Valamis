package com.arcusys.learn.gradebook

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.By._

/**
 * User: Yulia.Glushonkova
 * Date: 03.06.13
 */
class ViewedStateTest  (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport with GradebookManager {
  val driver = _driver

  //10.9
  "Gradebook" should "show viewed state correctly" in{
    logout()
    loginAsAdmin()

    driver.get(baseUrl + playerUrl)

    driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[2]/td[3]/*[@id=\"startPackage\"]")).click()
    driver.getVisibleElementAfterWaitBy(id("currentPackageName")).getText should be(packageTitle12)
    goToPageAndCheck("Keeping Score","Scoring")
    goToPageAndCheck("Taking Care of the Course", "Etiquette - Care For the Course")
    goToPageAndCheck("Handicapping Example", "Handicaping Example")

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()

    driver.get(baseUrl + gradebookUrl)
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText(teacherUserName)
    driver.waitForElementVisibleBy(id("gradebookTable"))
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookPackageChoice"))).selectByVisibleText(packageTitle12)
    assertViewedScorm12(1, 1)
    assertViewedScorm12(1, 3)
    assertViewedScorm12(2, 1)
    assertViewedScorm12(3, 4)
    assertNotViewedScorm12(1, 2)
    assertNotViewedScorm12(1, 4)
    assertNotViewedScorm12(1, 5)
    assertNotViewedScorm12(1, 6)
    assertNotViewedScorm12(2, 2)
    assertNotViewedScorm12(2, 3)
    assertNotViewedScorm12(2, 4)
    assertNotViewedScorm12(3, 1)
    assertNotViewedScorm12(3, 2)
    assertNotViewedScorm12(3, 3)
    assertNotViewedScorm12(3, 5)
    assertNotViewedScorm12(4, 1)
    assertNotViewedScorm12(4, 2)
    assertNotViewedScorm12(4, 3)
    assertNotViewedScorm12(4, 4)
  }

  private def goToPageAndCheck (link: String, title: String) {
    driver.getVisibleElementAfterWaitBy(partialLinkText(link)).click()
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("/html/body/h1")).getText should be(title)
    driver.switchTo().defaultContent()
  }
}
