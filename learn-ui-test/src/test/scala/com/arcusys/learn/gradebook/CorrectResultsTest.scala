package com.arcusys.learn.gradebook

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._
import org.openqa.selenium._
import support.ui.Select

/**
 * User: Yulia.Glushonkova
 * Date: 30.05.13
 */
class CorrectResultsTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with GradebookManager {
  val driver = _driver

  //10.1
  "Gradebook" should "be opened correctly" in {
    driver.get(baseUrl + gradebookUrl)
    val packages = driver.findElement(By.id("gradebookPackageChoice"))
    val users = driver.findElement(By.id("gradebookUserChoice"))
    assertTrue(packages.isDisplayed)
    assertTrue(users.isDisplayed)

    assertEquals("Whole course", packages.findElement(By.xpath("//option[1]")).getText)
    assertEquals("Test 1", packages.findElement(By.xpath("//option[2]")).getText)
    assertEquals(teacherUserName, driver.findElement(By.xpath("//*[@id=\"gradebookUserChoice\"]/option")).getText)
  }

  //10.2
  it should "show results" in {
    new Select(driver.findElement(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")
    wait(1)
    for(index <- 1 to 11){
      val title = questionTitle(index)
      assertViewed(index)
      if (title != " Who Is Using Liferay" && title != " External quiz resource" && title != " essay")
        assertCorrect(index)
      else{
        assertUnknown(index)
        if (title == " essay")
          assertEquals("Review", driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[3]/span/button")).getText)
      }
    }
  }

  //10.3
  it should "be able to set marks for essay" in{
    val essayIndex = getEssayIndex()

    setEssayMark(essayIndex, "good!", 10)
    assertCorrect(essayIndex)

    setEssayMark(essayIndex, "so-so!", 4)
    assertMark(essayIndex, 40)

    setEssayMark(essayIndex, "bad!", 0)
    assertMark(essayIndex, 0)
  }
}
