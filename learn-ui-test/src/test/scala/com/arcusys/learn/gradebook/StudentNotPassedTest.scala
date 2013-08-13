package com.arcusys.learn.gradebook

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
class StudentNotPassedTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport{
  val driver = _driver

  //10.4
  "Gradebook" should "show No data if user did not pass test"in {
    driver.findElement(By.linkText("Sign Out")).click()
    loginAsStudent()
    wait(1)
    driver.get(baseUrl + gradebookUrl)
    val packages = driver.findElement(By.id("gradebookPackageChoice"))
    val users = driver.findElement(By.id("gradebookUserChoice"))
    assertTrue(packages.isDisplayed)
    assertFalse(users.isDisplayed)

    assertEquals("Whole course", packages.findElement(By.xpath("//option")).getText)
    assertEquals(studentUserName, driver.findElement(By.xpath("//*[@id=\"gradebookSettings\"]/div[2]/b")).getText)

    assertEquals("Nothing to display", driver.findElement(By.id("jsTreeGradebook")).getText)
  }
}
