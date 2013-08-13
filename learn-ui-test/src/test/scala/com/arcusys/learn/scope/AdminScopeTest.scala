package com.arcusys.learn.scope

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.support.ui.Select
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 04.06.13
 */
class AdminScopeTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Admin" should "allow to set instance scope settings"in {
    driver.get(baseUrl + adminUrl)
    new Select(driver.findElement(By.id("adminScopeSelect"))).selectByVisibleText("Instance Scope")
    wait(1)
    driver.findElement(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr/td[4]/input")).click()
  }

  //12.6
  it should "save instance scope settings"in {
    driver.get(site2Url + site2AdminUrl)
    new Select(driver.findElement(By.id("adminScopeSelect"))).selectByVisibleText("Instance Scope")
    wait(1)
    assertNull(driver.findElement(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr/td[4]/input")).getAttribute("checked"))
    assertEquals("true", driver.findElement(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr[2]/td[4]/input")).getAttribute("checked"))
  }

  it should "allow to set site scope settings" in{
    driver.get(baseUrl + adminUrl)
    new Select(driver.findElement(By.id("adminScopeSelect"))).selectByVisibleText("Site Scope")
    wait(1)
    // set default package
    driver.findElement(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr/td[5]/input")).click()
    assertFalse(isElementPresent(By.xpath("//*[@id=\"scormPackageTable\"]/tbody/tr[2]")))
  }
}
