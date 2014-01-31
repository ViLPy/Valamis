package com.arcusys.learn.gradebook

import org.openqa.selenium.By
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.junit.Assert._
import org.openqa.selenium.support.ui.Select

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
class StudentViewMarkTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport  with GradebookManager{
  val driver = _driver

  //10.8
  "Gradebook" should "be able to view marks for student"in{
    logout()
    loginAsStudent()
    wait(1)
    driver.get(baseUrl + gradebookUrl)
    wait(1)
    assertEquals("You passed course not so bad", driver.findElement(By.id("courseComment")).getAttribute("value"))
    assertEquals("true", driver.findElement(By.xpath("//*[@id=\"courseGradePlaceholder\"]/table/tbody/tr[1]/td[4]/input")).getAttribute("checked"))

    new Select(driver.findElement(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")

    wait(2)
    val essayIndex = getEssayIndex

    assertMark(essayIndex, 90)
    assertEquals("good!", getEssayComment(essayIndex))

  }

}
