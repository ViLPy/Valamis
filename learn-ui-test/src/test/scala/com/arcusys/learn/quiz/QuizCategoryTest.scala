package com.arcusys.learn.quiz

import org.openqa.selenium.{JavascriptExecutor, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._
import org.openqa.selenium.interactions.Actions

/**
 * User: Yulia.Glushonkova
 * Date: 29.05.13
 */
class QuizCategoryTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  // 7.6
  "Quiz Editor" should "be able to create category" in{
    driver.get(baseUrl + quizUrl)
    driver.findElement(By.id("buttonOpen")).click()
    driver.findElement(By.id("quizAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("test quiz category")
    driver.findElement(By.id("elementUpdate")).click()
    assertTrue(isElementPresent(By.partialLinkText("test quiz category")))

    driver.findElement(By.id("elementEdit")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("Test category")
    driver.findElement(By.id("elementUpdate")).click()
    assertTrue(isElementPresent(By.partialLinkText("Test category")))
  }

  it should "be able to change category description" in{
    driver.findElement(By.id("elementEdit")).click()
    driver.findElement(By.id("SCORMEditButtonDescription")).click()
    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('This is quiz category');")
    driver.findElement(By.xpath("//button[@type='button']")).click()
    driver.findElement(By.id("elementUpdate")).click()
    wait(1)
    driver.findElement(By.partialLinkText("Quiz base")).click()
    wait(1)
    assertTrue(driver.findElement(By.id("SCORMEditButtonWelcome")).isDisplayed)

    driver.findElement(By.partialLinkText("Test category")).click()
    assertFalse(isElementPresent(By.id("SCORMEditButtonWelcome")))

    val view = driver.findElement(By.id("SCORMCategoryView"))
    assertEquals("This is quiz category", view.findElement(By.id("SCORMCategoryDescription")).getText)
    assertEquals("Test category", view.findElement(By.id("SCORMCategoryNameView")).getText)
  }

  it should "work with child categories" in{
    driver.findElement(By.partialLinkText("Quiz base")).click()
    driver.findElement(By.id("quizAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("New category2")
    driver.findElement(By.id("elementUpdate")).click()

    wait(1)
    val source = driver.findElement(By.partialLinkText("New category2"))
    val target = driver.findElement(By.partialLinkText("Test category"))
    new Actions(driver).dragAndDrop(source, target).perform()
    wait(1)

    driver.findElement(By.partialLinkText("New category2")).click()
    driver.findElement(By.id("quizRemoveElement")).click()
    assertTrue(closeAlertAndGetItsText.matches("^Are you sure want to delete node with all child nodes[\\s\\S]$"))
    wait(1)
    assertFalse(isElementPresent(By.partialLinkText("New category2")))

    driver.findElement(By.id("quizAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("Child category")
    driver.findElement(By.id("elementUpdate")).click()
    assertTrue(isElementPresent(By.partialLinkText("Child category")))

    driver.findElement(By.partialLinkText("Test category")).click()
    driver.findElement(By.id("quizRemoveElement")).click()
    assertTrue(closeAlertAndGetItsText.matches("^Are you sure want to delete node with all child nodes[\\s\\S]$"))
    assertFalse(isElementPresent(By.partialLinkText("Test category")))
    assertFalse(isElementPresent(By.partialLinkText("Child category")))
  }

  //7.7 - 7.9
  it should "add questions to category and delete all correctly" in {
    driver.findElement(By.partialLinkText("Quiz base")).click()
    driver.findElement(By.id("quizAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("Some questions")
    driver.findElement(By.id("elementUpdate")).click()
    driver.findElement(By.id("quizAddQuestions")).click()

    driver.findElement(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul/li[1]/ins")).click()
    wait(2)

    val question1 = driver.findElement(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul/li[1]/ul/li[2]"))
    val question2 = driver.findElement(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul/li[5]"))
    val questionTitle1 = question1.findElement(By.xpath("//a")).getText
    val questionTitle2 = question2.findElement(By.xpath("//a")).getText
    question1.findElement(By.cssSelector("ins.jstree-checkbox")).click()
    question2.findElement(By.cssSelector("ins.jstree-checkbox")).click()
    wait(1)
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click()
    wait(1)
    assertTrue(isElementPresent(By.partialLinkText(questionTitle1)))
    assertTrue(isElementPresent(By.partialLinkText(questionTitle2)))
    driver.findElement(By.partialLinkText("Some questions")).click()
    driver.findElement(By.id("quizRemoveElement")).click()
    assertTrue(closeAlertAndGetItsText.matches("^Are you sure want to delete node with all child nodes[\\s\\S]$"))
    wait(1)
    //assertFalse(driver.findElement(By.partialLinkText(questionTitle1)).isDisplayed)
    //assertFalse(driver.findElement(By.partialLinkText(questionTitle2)).isDisplayed)
    driver.findElement(By.partialLinkText("Quiz base")).click()
    driver.findElement(By.partialLinkText("Management")).click()
    assertEquals("0 questions selected.", driver.findElement(By.className("quizQuestionAmount")).getText)
    driver.findElement(By.partialLinkText("Test 1")).click()
  }



}
