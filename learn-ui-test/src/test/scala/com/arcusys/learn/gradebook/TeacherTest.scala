package com.arcusys.learn.gradebook

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, UITestBase}
import org.openqa.selenium.support.ui.Select
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
class TeacherTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport with GradebookManager{
  val driver = _driver

  //10.7
  "Gradebook" should "be able to set mark for student"in {
    driver.findElement(By.linkText("Sign Out")).click()
    loginAsAdmin()
    wait(1)
    driver.get(baseUrl + gradebookUrl)
    new Select(driver.findElement(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")
    new Select(driver.findElement(By.id("gradebookUserChoice"))).selectByVisibleText(studentUserName)

    wait(2)
    val essayIndex = getEssayIndex()
    setEssayMark(essayIndex, "good!", 9)
    assertMark(essayIndex, 90)

    new Select(driver.findElement(By.id("gradebookPackageChoice"))).selectByVisibleText("Whole course")
    driver.findElement(By.id("courseComment")).clear()
    driver.findElement(By.id("courseComment")).sendKeys("You passed course not so bad")
    driver.findElement(By.xpath("//*[@id=\"courseGradePlaceholder\"]/table/tbody/tr[1]/td[4]/input")).click()
    driver.findElement(By.xpath("//*[@id=\"courseGradeWrapper\"]/input")).click()
    assertEquals("Course data saved successfully", closeAlertAndGetItsText)

  }

}
