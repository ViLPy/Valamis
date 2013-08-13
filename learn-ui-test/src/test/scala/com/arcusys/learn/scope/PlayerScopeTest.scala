package com.arcusys.learn.scope

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.support.ui.Select
import org.junit.Assert._
import org.openqa.selenium.By._

/**
 * User: Yulia.Glushonkova
 * Date: 04.06.13
 */
class PlayerScopeTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Player" should "run default package automatically" in{
    driver.get(baseUrl + playerUrl)
    wait(1)
    val pack= driver.findElement(By.id("currentPackageName"))
    assertTrue(isElementPresent(By.id("currentPackageName")))
    assertTrue(pack.isDisplayed)
    assertEquals("Quiz site1", pack.getText)

    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))
    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
    assertTrue(isElementPresent(By.id("projectLearnCourseIsCompleted")))
    assertEquals("Course is finished", driver.findElement(By.id("projectLearnCourseIsCompleted")).getText)
    wait(2)
  }

  it should  "be able to open prefernces and update scope setting" in{
    driver.findElement(By.id("_SCORMApplication_WAR_learnweb_kldx_menuButton")).click()
    wait(2)
    driver.findElement(By.id("_SCORMApplication_WAR_learnweb_kldx_menu_preferences")).click()
    wait(1)
    new Select(driver.findElement(By.id("scopeOptions"))).selectByVisibleText("Instance Scope")
    wait(1)
    assertNull(driver.findElement(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr/td[4]/input")).getAttribute("checked"))
    assertEquals("true", driver.findElement(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr[2]/td[4]/input")).getAttribute("checked"))
    driver.findElement(By.partialLinkText("Return to Full Page")).click()
    wait(1)

    assertEquals("Quiz site2", driver.findElement(By.xpath("//*[@id=\"SCORMPackagesGrid\"]/tr/td")).getText)
    assertFalse(isElementPresent(By.xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[2]")))
  }

  it should "be able to update visibility settings" in {
    driver.findElement(By.id("_SCORMApplication_WAR_learnweb_kldx_menuButton")).click()
    wait(2)
    driver.findElement(By.id("_SCORMApplication_WAR_learnweb_kldx_menu_preferences")).click()
    wait(1)
    driver.findElement(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr/td[4]/input")).click()
    driver.findElement(By.partialLinkText("Return to Full Page")).click()
    wait(1)

    assertEquals("Quiz site1", driver.findElement(By.xpath("//*[@id=\"SCORMPackagesGrid\"]/tr/td")).getText)
    assertEquals("Quiz site2", driver.findElement(By.xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[2]/td")).getText)
  }


}
