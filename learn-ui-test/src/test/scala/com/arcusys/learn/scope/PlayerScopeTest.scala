package com.arcusys.learn.scope

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium.support.ui.Select
import org.junit.Assert._
import org.openqa.selenium.By._

/**
 * User: Yulia.Glushonkova
 * Date: 04.06.13
 */
class PlayerScopeTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Player" should "run default package automatically" in{
    driver.get(baseUrl + playerUrl)
    val pack= driver.getVisibleElementAfterWaitBy(By.id("currentPackageName"))
    driver.waitForElementVisibleBy(By.id("currentPackageName"))
    assertTrue(pack.isDisplayed)
    assertEquals("Quiz site1", pack.getText)

    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
    driver.waitForElementVisibleBy(By.id("projectLearnCourseIsCompleted"))
    assertEquals("Course is finished", driver.getVisibleElementAfterWaitBy(By.id("projectLearnCourseIsCompleted")).getText)
  }

  it should  "be able to open preferences and update scope setting" in{
    // replaced 'kldx' by 'tiym' in ids
    driver.getVisibleElementAfterWaitBy(By.id("_SCORMApplication_WAR_learnportlet_kldx_column1_0_menu")).click() // must be 1 column at the page with player
    driver.getVisibleElementAfterWaitBy(By.id("_SCORMApplication_WAR_learnportlet_kldx_column1_0_menu_preferences")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("scopeOptions"))).selectByVisibleText("Instance Scope")
    assertNull(driver.getVisibleElementAfterWaitBy(By.xpath("id('scormPackageTable')/tbody/tr/td[4]/input")).getAttribute("checked"))
    assertEquals("true", driver.getVisibleElementAfterWaitBy(By.xpath("id('scormPackageTable')/tbody/tr[2]/td[4]/input")).getAttribute("checked"))
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Return to Full Page")).click()

    assertEquals("Quiz site2", driver.getVisibleElementAfterWaitBy(By.xpath("id('SCORMPackagesGrid')/tr/td")).getText)
    driver.waitForElementInvisibleBy(By.xpath("id('SCORMPackagesGrid')/tr[2]"))
  }

  it should "be able to update visibility settings" in {
    driver.getVisibleElementAfterWaitBy(By.id("_SCORMApplication_WAR_learnportlet_kldx_column1_0_menu")).click()
    driver.getVisibleElementAfterWaitBy(By.id("_SCORMApplication_WAR_learnportlet_kldx_column1_0_menu_preferences")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("id('scormPackageTable')/tbody/tr/td[4]/input")).click()
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Return to Full Page")).click()

    assertEquals("Quiz site1", driver.getVisibleElementAfterWaitBy(By.xpath("id('SCORMPackagesGrid')/tr/td")).getText)
    assertEquals("Quiz site2", driver.getVisibleElementAfterWaitBy(By.xpath("id('SCORMPackagesGrid')/tr[2]/td")).getText)
  }
}
