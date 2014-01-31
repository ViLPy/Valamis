package com.arcusys.learn.gradebook

import org.openqa.selenium.By
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
class StudentNotPassedTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport{
  val driver = _driver

  //10.4
  "Gradebook" should "show No data if user did not pass test"in {
    logout()
    loginAsStudent()
    driver.get(baseUrl + gradebookUrl)
    driver.waitForElementInvisibleBy(By.id("gradebookUserChoice"))
    val packages = driver.getVisibleElementAfterWaitBy(By.id("gradebookPackageChoice"))

    assertEquals("Whole course", packages.findElement(By.xpath("//option")).getText)
    assertEquals(studentUserName, driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"gradebookSettings\"]/div[1]/b")).getText)

    assertEquals("Nothing to display", driver.findElement(By.id("jsTreeGradebook")).getText)
  }
}
