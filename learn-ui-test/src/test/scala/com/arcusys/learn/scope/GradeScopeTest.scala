package com.arcusys.learn.scope

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.openqa.selenium.By._
import org.openqa.selenium.support.ui.Select
import org.junit.Assert._

class GradeScopeTest(_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport{
  val driver = _driver

  "Student" should "pass package" in {
    logout()
    loginAsStudent()

    driver.get(site2Url + site2PlayerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"startPackage\"]")).click()
    driver.getVisibleElementAfterWaitBy(id("currentPackageName")).getText should be("Quiz site2")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Some site2")).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
    driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid"))
  }

  "Gradebook" should "not show results for package from other site" in {
    driver.get(baseUrl + gradebookUrl)

    val packages = driver.getVisibleElementAfterWaitBy(id("gradebookPackageChoice"))
    assertEquals(1, packages.findElements(xpath("//option")).size)
    assertEquals("Whole course", packages.findElement(xpath("//option")).getText)
    assertEquals("Nothing to display", driver.findElement(id("jsTreeGradebook")).getText)
  }

  "Admin" should "set grade for student" in {
    logout()
    loginAsAdmin()

    driver.get(site2Url + site2GradebookUrl)
    new Select(driver.getVisibleElementAfterWaitBy(id("gradebookUserChoice"))).selectByVisibleText(studentUserName)
    new Select(driver.getVisibleElementAfterWaitBy(id("gradebookPackageChoice"))).selectByVisibleText("Quiz site2")

    new Select(driver.getVisibleElementAfterWaitBy(id("gradebookPackageChoice"))).selectByVisibleText("Whole course")
    driver.getVisibleElementAfterWaitBy(id("courseComment")).clear()
    driver.getVisibleElementAfterWaitBy(id("courseComment")).sendKeys("You passed course!")
    driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"courseGradePlaceholder\"]/table/tbody/tr[1]/td[11]/input")).click()
    driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"courseGradeWrapper\"]/input")).click()
    driver.getAlertTextAndCloseAfterWait should be("Course data saved successfully")
  }

  ignore /*"Gradebook" */ should "show only student who passed packages from current site" in {    // TODO: bug: doesn't work now
    driver.get(baseUrl + gradebookUrl)

    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')")).findElements(tagName("option")).size should be (3)
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[1]")).getText should be("Select student")
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[2]")).getText should be("All students")
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[3]")).getText should be(teacherUserName)

    driver.get(site2Url + site2GradebookUrl)

    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')")).findElements(tagName("option")).size should be (3)
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[1]")).getText should be("Select student")
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[2]")).getText should be("All students")
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[3]")).getText should be(studentUserName)
  }
}
