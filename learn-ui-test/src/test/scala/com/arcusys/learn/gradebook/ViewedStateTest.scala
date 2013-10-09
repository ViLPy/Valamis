package com.arcusys.learn.gradebook

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.By._

/**
 * User: Yulia.Glushonkova
 * Date: 03.06.13
 */
class ViewedStateTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport with GradebookManager {
  val driver = _driver

  //10.9
  "Gradebook" should "show viewed state correctly" in{
    logout()
    loginAsAdmin()

    driver.get(baseUrl + playerUrl)

    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[2]/td[3]/*[@id=\"startPackage\"]")).click()
    wait(5)
    driver.findElement(id("currentPackageName")).getText should be(packageTitle12)
    driver.findElement(partialLinkText("Keeping Score")).click()
    wait(4)
    driver.findElement(partialLinkText("Taking Care of the Course")).click()
    wait(4)
    driver.findElement(partialLinkText("Handicapping Example")).click()
    wait(3)
    driver.findElement(id("SCORMNavigationExit")).click()
    wait(5)

    driver.get(baseUrl + gradebookUrl)
    new Select(driver.findElement(By.id("gradebookUserChoice"))).selectByVisibleText(teacherUserName)
    new Select(driver.findElement(By.id("gradebookPackageChoice"))).selectByVisibleText(packageTitle12)
    wait(1)
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
}
