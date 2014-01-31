package com.arcusys.learn.gradebook

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.junit.Assert._
import org.openqa.selenium._
import support.ui.Select
import org.openqa.selenium.By._

/**
 * User: Yulia.Glushonkova
 * Date: 30.05.13
 */
class CorrectResultsTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with GradebookManager {
  val driver = _driver

  "Gradebook" should "be opened correctly" in {
    driver.get(baseUrl + gradebookUrl)

    //Check user's Select
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[1]")).getText should be("Select student")
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[2]")).getText should be("All students")
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookUserChoice')/option[3]")).getText should be(teacherUserName)

    //Check All students table
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText("All students")
    driver.getVisibleElementAfterWaitBy(id("studentsOverview"))

    //Check teacher package choices
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText(teacherUserName)
    driver.getVisibleElementAfterWaitBy(xpath("id('gradebookPackageChoice')/option[1]")).getText should be("Whole course")

    driver.waitForElementVisibleBy(xpath("id('gradebookPackageChoice')/option[text()='Test package SCORM 2004']"))
    driver.waitForElementVisibleBy(xpath("id('gradebookPackageChoice')/option[text()='Test package SCORM 1.2']"))
    driver.waitForElementVisibleBy(xpath("id('gradebookPackageChoice')/option[text()='Test 1']"))
  }

  //10.2
  it should "show results" in {
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookUserChoice"))).selectByVisibleText(teacherUserName)
    driver.waitForElementVisibleBy(id("gradebookTable"))
    wait(1)          // TODO: replace by waiting element
    new Select(driver.getVisibleElementAfterWaitBy(By.id("gradebookPackageChoice"))).selectByVisibleText("Test 1")
    wait(1)          // TODO: replace by waiting element
    assertPackageMark("unknown")        // TODO: uncomment       FULL TESTS
    for(index <- 1 to questionsAmount()){
      val title = questionTitle(index)
      assertViewed(index)
      if (!title.equalsIgnoreCase(" "+liferayArticleName) && !title.equalsIgnoreCase(" External quiz resource") && !title.equalsIgnoreCase(" essay"))
        assertCorrect(index)
      else{
        assertUnknown(index)
        if (title.equalsIgnoreCase(" essay"))
          assertEquals("Review", driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[3]/span/button")).getText)
      }
    }
  }

  //10.3
  it should "be able to set marks for essay" in{
    val essayIndex = getEssayIndex

    setEssayMark("good!", 10)
    assertCorrect(essayIndex)
    assertPackageMark("100%")

    setEssayMark("rather well!", 4)
    assertMark(essayIndex, 40)

    setEssayMark("so-so!", 1)
    assertMark(essayIndex, 10)
    assertPackageMark("90%")

    setEssayMark("bad!", 0)
    assertMark(essayIndex, 0)
  }

  it should "be able to show student response" in {
    for(index <- 1 to questionsAmount()){
      questionTitle(index) match {
        case " numeric" => assertEquals("15", getResponse(index))
        case " short case sensitive" => assertEquals("CASE", getResponse(index))
        case " short" => assertEquals("a", getResponse(index))
        case " choise" => {
          openResponse(index)
          val text = driver.getVisibleElementAfterWaitBy(By.xpath("id('reviewAnswer')/p")).getText
          assertEquals("A", text)
          driver.getVisibleElementAfterWaitBy(By.xpath("id('answer-dialog-form')//*[@class='textbutton']")).click()
        }
        case " choise radio" => {
          openResponse(index)
          val text = driver.getVisibleElementAfterWaitBy(By.xpath("id('reviewAnswer')/p")).getText
          assertEquals("1", text)
          driver.getVisibleElementAfterWaitBy(By.xpath("id('answer-dialog-form')//*[@class='textbutton']")).click()
        }
        case _ => {/*do nothning*/}
      }
    }
  }

}
