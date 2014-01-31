package com.arcusys.learn.quiz

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium._
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 29.05.13
 */
class BasicQuizTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Quiz Editor" should "be opened correctly" in {
    // 7.1
    driver.get(baseUrl + quizUrl)
    val managementTab = driver.getVisibleElementAfterWaitBy(By.id("quizTabs")).findElement(By.partialLinkText("Management"))
    assertNotNull(managementTab)

    assertTrue(driver.isElementPresentBy(By.id("SCORMButtonAddQuiz")))
    assertTrue(driver.isElementPresentBy(By.id("quizSearch")))
  }

  // 7.2
  it should "be able to create new quiz" in{
    driver.getVisibleElementAfterWaitBy(By.id("SCORMButtonAddQuiz")).click()

    val list = driver.getVisibleElementAfterWaitBy(By.id("quizList"))
    assertEquals(1, list.findElements(By.className("availableQuizItem")).toArray.length)

    val title = list.findElement(By.className("quizItemTitle"))
    assertEquals("New quiz", title.getText)
  }

  //7.3
  it should "be able to edit quiz title" in {
    driver.getVisibleElementAfterWaitBy(By.id("quizEdit")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).sendKeys("Test quiz")
    driver.getVisibleElementAfterWaitBy(By.id("quizUpdate")).click()

    assertEquals("Test quiz", driver.getVisibleElementAfterWaitBy(By.id("quizList")).findElement(By.className("quizItemTitle")).getText)
  }

  //7.4
  it should "be able to change welcome and final page content" in{
    driver.getVisibleElementAfterWaitBy(By.id("buttonOpen")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMEditButtonWelcome")).click()
    val welcome = "Welcome!!!"
    val end = "THE END!"
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+welcome+"');")
    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()

    driver.getVisibleElementAfterWaitBy(By.id("SCORMEditButtonFinal")).click()
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+end+"');")
    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()

    assertEquals(welcome, driver.getVisibleElementAfterWaitBy(By.id("SCORMQuizWelcomePage")).getText)
    assertEquals(end, driver.getVisibleElementAfterWaitBy(By.id("SCORMQuizFinalPage")).getText)
  }

  // 7.5
  it should "update tab name when quiz name changed" in{
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Management")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizEdit")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).sendKeys("Test 1")
    driver.getVisibleElementAfterWaitBy(By.id("quizUpdate")).click()
    driver.waitForElementVisibleBy(By.partialLinkText("Test 1"))
  }

}
