package com.arcusys.learn.admin

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 03.06.13
 */
class PermissionTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport{
  val driver = _driver

  // 12.1
  it should "not be able to open portlets for non teacher, non admin users" in {
    logout
    loginAsStudent()
    assertNoPermissionStudent()
    logout
    assertNoPermission()

  }

  private def assertNoPermissionStudent(){
    driver.get(baseUrl + adminUrl)
    assertEquals(noPermissionText, driver.getVisibleElementAfterWaitBy(By.id("noPermission")).getText)
    driver.get(baseUrl + questionUrl)
    assertEquals(noPermissionText, driver.getVisibleElementAfterWaitBy(By.id("noPermission")).getText)
    driver.get(baseUrl + quizUrl)
    assertEquals(noPermissionText, driver.getVisibleElementAfterWaitBy(By.id("noPermission")).getText)
    driver.get(baseUrl + curriculumUrl)
    assertEquals(noPermissionText, driver.getVisibleElementAfterWaitBy(By.id("noPermission")).getText)
  }

  private def assertNoPermission(){
    assertNoPermissionStudent()
    driver.get(baseUrl + gradebookUrl)
    assertEquals(noPermissionText, driver.getVisibleElementAfterWaitBy(By.id("noPermission")).getText)
  }
}
