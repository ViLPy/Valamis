package com.arcusys.learn.admin

import org.openqa.selenium.{NoSuchElementException, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.By._
import org.junit.Assert._
import scala.collection.JavaConverters._

class CleanUpTest(_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Admin" should "be able to remove 1.2 quiz" in {
    driver.get(baseUrl + adminUrl)

    driver.findElement(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]")).click()
    driver.findElement(id("SCORMPackageRemove")).click()
    wait(1)
  }

  it should "be able to check that there is no quiz data for 1.2 anymore" in {
    driver.get(baseUrl + gradebookUrl)
    val packages = driver.findElement(By.id("gradebookPackageChoice"))
    assertTrue(packages.isDisplayed)
    packages.findElements(tagName("option")).asScala.find(_.getText == packageTitle12).isEmpty should be (true)
  }

  it should "be able to show empty gradebook after reinitialization" in {
    driver.get(baseUrl + adminUrl)
    driver.findElement(id("SCORMPackageAdminButton")).click()
    driver.findElement(id("SCORMRenewDatabaseSettings")).click()
    closeAlertAndGetItsText should be("This will delete ALL data from ALL packages for ALL users! Are you sure?")
    wait(8)
    closeAlertAndGetItsText should be("Database renewed!")
    driver.findElements(className("ui-dialog-titlebar-close")).asScala.filter(_.isDisplayed).foreach(_.click())
    driver.get(driver.getCurrentUrl) // reload

    driver.get(baseUrl + gradebookUrl)
    driver.findElement(id("gradebookPackageChoice")).findElements(tagName("option")).size should be(1)
    driver.findElement(id("gradebookUserChoice")).findElements(tagName("option")).size should be(0)
  }
}
