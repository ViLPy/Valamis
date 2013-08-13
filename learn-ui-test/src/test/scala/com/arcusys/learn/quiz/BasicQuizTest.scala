package com.arcusys.learn.quiz

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium._
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 29.05.13
 */
class BasicQuizTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Quiz Editor" should "be opened correctly" in {
    // 7.1
    driver.get(baseUrl + quizUrl)
    val managementTab = driver.findElement(By.id("quizTabs")).findElement(By.partialLinkText("Management"))
    assertNotNull(managementTab)

    assertTrue(isElementPresent(By.id("SCORMButtonAddQuiz")))
    assertTrue(isElementPresent(By.id("quizSearch")))
  }

  // 7.2
  it should "be able to create new quiz" in{
    driver.findElement(By.id("SCORMButtonAddQuiz")).click()

    val list = driver.findElement(By.id("quizList"))
    assertEquals(1, list.findElements(By.className("availableQuizItem")).toArray.length)

    val title = list.findElement(By.className("quizItemTitle"))
    assertEquals("New quiz", title.getText)
  }

  //7.3
  it should "be able to edit quiz title" in {
    driver.findElement(By.id("quizEdit")).click()
    driver.findElement(By.id("quizTitle")).clear()
    driver.findElement(By.id("quizTitle")).sendKeys("Test quiz")
    driver.findElement(By.id("quizUpdate")).click()

    assertEquals("Test quiz", driver.findElement(By.id("quizList")).findElement(By.className("quizItemTitle")).getText)
  }

  //7.4
  it should "be able to change welcome and final page content" in{
    driver.findElement(By.id("buttonOpen")).click()
    driver.findElement(By.id("SCORMEditButtonWelcome")).click()
    val welcome = "Welcome!!!"
    val end = "THE END!"
    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+welcome+"');")
    driver.findElement(By.xpath("//button[@type='button']")).click()

    driver.findElement(By.id("SCORMEditButtonFinal")).click()
    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+end+"');")
    driver.findElement(By.xpath("//button[@type='button']")).click()

    assertEquals(welcome, driver.findElement(By.id("SCORMQuizWelcomePage")).getText)
    assertEquals(end, driver.findElement(By.id("SCORMQuizFinalPage")).getText)
  }

  // 7.5
  it should "update tab name when quiz name changed" in{
    driver.findElement(By.partialLinkText("Management")).click()
    wait(1)
    driver.findElement(By.id("quizEdit")).click()
    driver.findElement(By.id("quizTitle")).clear()
    driver.findElement(By.id("quizTitle")).sendKeys("Test 1")
    driver.findElement(By.id("quizUpdate")).click()
    assertTrue(isElementPresent(By.partialLinkText("Test 1")))
  }

}
