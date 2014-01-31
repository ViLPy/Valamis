package com.arcusys.learn.quiz

import org.openqa.selenium.{JavascriptExecutor, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.junit.Assert._
import org.openqa.selenium.interactions.Actions

/**
 * User: Yulia.Glushonkova
 * Date: 29.05.13
 */
class QuizCategoryTest  (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  // 7.6
  "Quiz Editor" should "be able to create category" in{
    driver.get(baseUrl + quizUrl)
    driver.getVisibleElementAfterWaitBy(By.id("buttonOpen")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).sendKeys("test quiz category")
    driver.getVisibleElementAfterWaitBy(By.id("elementUpdate")).click()
    driver.waitForElementVisibleBy(By.partialLinkText("test quiz category"))
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'quizTreeView')]")).findElements(By.tagName("li")).size should be(2)

    driver.getVisibleElementAfterWaitBy(By.id("elementEdit")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).sendKeys("Test category")
    driver.getVisibleElementAfterWaitBy(By.id("elementUpdate")).click()
    driver.waitForElementVisibleBy(By.partialLinkText("Test category"))
  }

  it should "be able to change category description" in{
    driver.getVisibleElementAfterWaitBy(By.id("elementEdit")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMEditButtonDescription")).click()
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('This is quiz category');")
    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()
    driver.getVisibleElementAfterWaitBy(By.id("elementUpdate")).click()
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Quiz base")).click()
    assertTrue(driver.getVisibleElementAfterWaitBy(By.id("SCORMEditButtonWelcome")).isDisplayed)

    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Test category")).click()
    driver.waitForElementInvisibleBy(By.id("SCORMEditButtonWelcome"))

    val view = driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryView"))
    assertEquals("This is quiz category", view.findElement(By.id("SCORMCategoryDescription")).getText)
    assertEquals("Test category", view.findElement(By.id("SCORMCategoryNameView")).getText)
  }

  it should "work with child categories" in{
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Quiz base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).sendKeys("New category2")
    driver.getVisibleElementAfterWaitBy(By.id("elementUpdate")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'quizTreeView')]")).findElements(By.tagName("li")).size should be(3)

    val source = driver.getVisibleElementAfterWaitBy(By.partialLinkText("New category2"))
    val target = driver.getVisibleElementAfterWaitBy(By.partialLinkText("Test category"))
    new Actions(driver).dragAndDrop(source, target).perform()
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'quizTreeView')]")).findElements(By.tagName("li")).size should be(3)

    driver.getVisibleElementAfterWaitBy(By.partialLinkText("New category2")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizRemoveElement")).click()
    assertTrue(driver.getAlertTextAndCloseAfterWait.matches("^Are you sure want to delete node with all child nodes[\\s\\S]$"))
    driver.waitForElementInvisibleBy(By.partialLinkText("New category2"))
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'quizTreeView')]")).findElements(By.tagName("li")).size should be(2)

    driver.getVisibleElementAfterWaitBy(By.id("quizAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).sendKeys("Child category")
    driver.getVisibleElementAfterWaitBy(By.id("elementUpdate")).click()
    driver.waitForElementVisibleBy(By.partialLinkText("Child category"))

    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Test category")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizRemoveElement")).click()
    assertTrue(driver.getAlertTextAndCloseAfterWait.matches("^Are you sure want to delete node with all child nodes[\\s\\S]$"))
    driver.waitForElementInvisibleBy(By.partialLinkText("Test category"))
    driver.waitForElementInvisibleBy(By.partialLinkText("Child category"))
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'quizTreeView')]")).findElements(By.tagName("li")).size should be(1)
  }

  //7.7 - 7.9
  it should "add questions to category and delete all correctly" in {
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Quiz base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).sendKeys("Some questions")
    driver.getVisibleElementAfterWaitBy(By.id("elementUpdate")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizAddQuestions")).click()

    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul/li[1]/ins")).click()

    val question1 = driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul/li[1]/ul/li[2]"))
    val question2 = driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul/li[5]"))
    val questionTitle1 = question1.findElement(By.xpath("//a")).getText
    val questionTitle2 = question2.findElement(By.xpath("//a")).getText
    question1.findElement(By.cssSelector("ins.jstree-checkbox")).click()
    question2.findElement(By.cssSelector("ins.jstree-checkbox")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("id('questionChooseDialog')/..//button/span[text()='Add']")).click()
    driver.waitForElementVisibleBy(By.partialLinkText(questionTitle1))
    driver.waitForElementVisibleBy(By.partialLinkText(questionTitle2))
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'quizTreeView')]")).findElements(By.tagName("li")).size should be(4)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Some questions")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizRemoveElement")).click()
    assertTrue(driver.getAlertTextAndCloseAfterWait.matches("^Are you sure want to delete node with all child nodes[\\s\\S]$"))
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'quizTreeView')]")).findElements(By.tagName("li")).size should be(1)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Quiz base")).click()
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Management")).click()
    assertEquals("0 questions selected.", driver.getVisibleElementAfterWaitBy(By.className("quizQuestionAmount")).getText)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Test 1")).click()
  }



}
