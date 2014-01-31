package com.arcusys.learn.gradebook

import org.openqa.selenium.By
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.openqa.selenium.support.ui.Select
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
class TeacherTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport with GradebookManager{
  val driver = _driver

  //10.7
  "Gradebook" should "be able to set mark for student"in {
    logout()
    loginAsAdmin()
    wait(1)
    driver.get(baseUrl + gradebookUrl)
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText(studentUserName)
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")
    assertPackageMark("unknown")

    wait(2)
    val essayIndex = getEssayIndex

    setEssayMark("good!", 9)
    assertMark(essayIndex, 90)
    assertPackageMark("10%")

    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookPackageChoice"))).selectByVisibleText("Whole course")
    driver.getVisibleElementAfterWaitBy(By.id("courseComment")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("courseComment")).sendKeys("You passed course not so bad")
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"courseGradePlaceholder\"]/table/tbody/tr[1]/td[6]/input")).click()   // 50%
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"courseGradeWrapper\"]/input")).click()
    driver.getAlertTextAndCloseAfterWait should be("Course data saved successfully")
  }

  it should "be able to show overall result" in {
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText("All students")
    driver.getVisibleElementAfterWaitBy(By.id("GradeTable"))
    driver.getVisibleElementAfterWaitBy(By.id("GradeTable")).findElements(By.tagName("tr")).size should be(3)
    driver.getVisibleElementAfterWaitBy(By.xpath("//tr/td[contains(text(), '"+teacherUserName+"')]"))
    driver.getVisibleElementAfterWaitBy(By.xpath("//tr/td[contains(text(), '"+studentUserName+"')]"))
  }

  it should "be able to show and set total grade in overall table" in {
    assertEquals("50%", driver.getVisibleElementAfterWaitBy(By.xpath("//td[contains(text(), '"+studentUserName+"')]/../td[5]")).getText)

    driver.getVisibleElementAfterWaitBy(By.xpath("//td[contains(text(), '"+studentUserName+"')]/../td[6]/button")).click()
    assertEquals("You passed course not so bad", driver.getVisibleElementAfterWaitBy(By.id("gradeCourseTextarea")).getAttribute("value"))
    driver.getVisibleElementAfterWaitBy(By.xpath("id('courseGrade-dialog-form')//table/tbody/tr/td[4]/input")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("id('courseGrade-dialog-form')//input[@value='Save']")).click()
    driver.waitForElementInvisibleBy(By.id("courseGrade-dialog-form"))
    driver.waitForElementWithTextBy(By.xpath("//td[contains(text(), '"+studentUserName+"')]/../td[5]"), "30%")
  }

}
