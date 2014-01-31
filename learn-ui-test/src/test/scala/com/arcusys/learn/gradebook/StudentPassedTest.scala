package com.arcusys.learn.gradebook

import org.openqa.selenium.By
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.openqa.selenium.support.ui.Select

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
class StudentPassedTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport with GradebookManager {
  val driver = _driver

  //10.6
  "Gradebook" should "show 0% if passed incorrectly" in{
    logout()
    loginAsStudent()
    driver.get(baseUrl + gradebookUrl)
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")

    for(index <- 1 to questionsAmount()){
      val title = questionTitle(index)
      assertViewed(index)
      if (title != " "+liferayArticleName && title != " External quiz resource" && title != " test" && title != " essay")
        assertMark(index, 0)
      else{
        assertUnknown(index)
        //if (title == " essay")
        //  assertEquals("Review", driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[3]/span/button")).getText)
      }
    }
  }
}
