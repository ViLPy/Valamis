package com.arcusys.learn.admin

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 03.06.13
 */
class PermissionTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport{
  val driver = _driver

  // 12.1
  it should "not be able to open portlets for non teacher, non admin users" in {
    logout
    loginAsStudent()
    assertNoPermission()
    logout
    assertNoPermission()
  }

  private def assertNoPermission(){
    driver.get(baseUrl + adminUrl)
    assertEquals(noPermissionText, driver.findElement(By.xpath("//*[@id=\"portlet_SCORMApplicationAdmin_WAR_learnweb\"]/div/div/div/div/div")).getText)
    driver.get(baseUrl + questionUrl)
    assertEquals(noPermissionText, driver.findElement(By.xpath("//*[@id=\"portlet_SCORMQuestionBank_WAR_learnweb\"]/div/div/div/div/div")).getText)
    driver.get(baseUrl + quizUrl)
    assertEquals(noPermissionText, driver.findElement(By.xpath("//*[@id=\"portlet_SCORMQuizes_WAR_learnweb\"]/div/div/div/div/div")).getText)
  }

}
