package com.arcusys.learn.admin

import org.openqa.selenium.{NoSuchElementException, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium.By._
import org.junit.Assert._
import scala.collection.JavaConverters._
import org.openqa.selenium.support.ui.Select

class CleanUpTest(_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Admin" should "be able to remove 1.2 quiz" in {
    driver.get(baseUrl + adminUrl)

    driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"SCORMAdminPackagesGrid\"]/tr[1]")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageRemove")).click()
  }

  it should "be able to check that there is no quiz data for 1.2 anymore" in {
    driver.get(baseUrl + gradebookUrl)
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText(teacherUserName)
    driver.getVisibleElementAfterWaitBy(By.id("gradebookPackageChoice"))
    val packages = driver.findElement(By.id("gradebookPackageChoice"))
    packages.findElements(tagName("option")).asScala.find(_.getText == packageTitle12).isEmpty should be (true)
  }

  it should "be able to show empty gradebook after reinitialization" in {
    driver.get(baseUrl + adminUrl)
    driver.getVisibleElementAfterWaitBy(id("SCORMPackageAdminButton")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMRenewDatabaseSettings")).click()
    driver.getAlertTextAndCloseAfterWait should be("This will delete ALL data from ALL packages for ALL users! Are you sure?")
    driver.getAlertTextAndCloseAfterWait should be("Database renewed!")
    driver.findElements(className("ui-dialog-titlebar-close")).asScala.filter(_.isDisplayed).foreach(_.click())
    driver.get(driver.getCurrentUrl) // reload

    driver.get(baseUrl + gradebookUrl)
    driver.getVisibleElementAfterWaitBy(id("gradebookUserChoice")).findElements(tagName("option")).size should be(2)

    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText("All students")
    driver.getVisibleElementAfterWaitBy(id("studentsOverview")).findElements(tagName("tr")).size should be(1)
  }
}
