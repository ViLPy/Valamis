package com.arcusys.learn.gradebook

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.support.ui.Select

/**
 * User: Yulia.Glushonkova
 * Date: 03.06.13
 */
class ViewedStateTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with GradebookManager {
  val driver = _driver

  //10.9
  "Gradebook" should "show viewed state correctly" in{
    driver.get(baseUrl + gradebookUrl)
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
