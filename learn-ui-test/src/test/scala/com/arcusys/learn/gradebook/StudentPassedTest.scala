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
class StudentPassedTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport with GradebookManager {
  val driver = _driver

  //10.6
  "Gradebook" should "show 0% if passed incorrectly" in{
    driver.findElement(By.linkText("Sign Out")).click()
    loginAsStudent()
    driver.get(baseUrl + gradebookUrl)
    new Select(driver.findElement(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")
    wait(1)

    for(index <- 1 to 11){
      val title = questionTitle(index)
      assertViewed(index)
      if (title != " Who Is Using Liferay" && title != " External quiz resource" && title != " essay")
        assertMark(index, 0)
      else{
        assertUnknown(index)
        //if (title == " essay")
        //  assertEquals("Review", driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[3]/span/button")).getText)
      }
    }
  }
}
