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
    val users = driver.findElement(By.id("gradebookUserChoice"))
    assertTrue(users.isDisplayed)

    new Select(driver.findElement(By.id("gradebookUserChoice"))).selectByVisibleText("Test Test")
    wait(1)
    assertEquals("Whole course", driver.findElement(By.xpath("//*[@id=\"gradebookPackageChoice\"]/option[1]")).getText)
    //assertEquals("Test 1", packages.findElement(By.xpath("//option[3]")).getText)
    assertEquals(teacherUserName, driver.findElement(By.xpath("//*[@id=\"gradebookUserChoice\"]/option[3]")).getText)
  }

  //10.2
  it should "show results" in {
    new Select(driver.findElement(By.id("gradebookUserChoice"))).selectByVisibleText("Test Test")
    wait(1)
    new Select(driver.findElement(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")
    wait(5)
    for(index <- 1 to 11){
      val title = questionTitle(index)
      assertViewed(index)
      if (!title.equalsIgnoreCase(" Liferay Benefits") && !title.equalsIgnoreCase(" External quiz resource") && !title.equalsIgnoreCase(" Who Is Using Liferay") && !title.equalsIgnoreCase(" essay"))
        assertCorrect(index)
      else{
        assertUnknown(index)
        if (title.equalsIgnoreCase(" essay"))
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

  it should "be able to show student response" in {
    for(index <- 1 to 11){
      questionTitle(index) match {
        case " numeric" => assertEquals("15", getResponse(index))
        case " short case sensitive" => assertEquals("CASE", getResponse(index))
        case " short" => assertEquals("a", getResponse(index))
        case " choise" => {
          openResponse(index)
          val text = driver.findElement(By.xpath("//*[@id=\"reviewAnswer\"]/p")).getText
          assertEquals("A", text)
        }
        case " choise radio" => {
          openResponse(index)
          val text = driver.findElement(By.xpath("//*[@id=\"reviewAnswer\"]/p")).getText
          assertEquals("1", text)
        }
        case _ => {/*do nothning*/}
      }
    }
  }

  it should "be able to show overall result" in {
    new Select(driver.findElement(By.id("gradebookUserChoice"))).selectByVisibleText("All students")
  }
}
