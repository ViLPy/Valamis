package com.arcusys.learn.questionbank

import org.openqa.selenium._
import interactions.Actions
import org.junit.Assert._
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import org.openqa.selenium.By._

class CategoryTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Question Editor" should "be able to create and edit categories" in {
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(id("questionbankAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).sendKeys("Category")

    driver.getVisibleElementAfterWaitBy(id("questionbankUpdate")).click()

    driver.getVisibleElementAfterWaitBy(id("questionbankEditBottom")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).sendKeys("Category test")
    driver.getVisibleElementAfterWaitBy(id("questionbankUpdateBottom")).click()

    driver.getVisibleElementAfterWaitBy(partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(partialLinkText("Category test")).click()
    driver.getVisibleElementAfterWaitBy(id("questionbankEdit")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMEditButtonDescription")).click()
    driver.asInstanceOf[JavascriptExecutor].executeScript("tinyMCE.activeEditor.setContent('Test description');")
    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()
    driver.getVisibleElementAfterWaitBy(id("questionbankUpdate")).click()

    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryDescription")).getText should be("Test description")
    driver.getVisibleElementAfterWaitBy(id("SCORMQuestionBankTree")).findElements(By.tagName("li")).size should be(2)
  }

  it should  "work correctly with child categories" in {
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(id("questionbankAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).sendKeys("New category2")

    driver.getVisibleElementAfterWaitBy(id("questionbankUpdateBottom")).click()
    val source = driver.getVisibleElementAfterWaitBy(partialLinkText("New category2"))
    val target = driver.getVisibleElementAfterWaitBy(partialLinkText("Category test"))
    new Actions(driver).dragAndDrop(source, target).perform()
    driver.getVisibleElementAfterWaitBy(id("questionbankRemoveElement")).click()

    driver.getAlertTextAndCloseAfterWait should be("This will delete all included elements!")
    driver.getVisibleElementAfterWaitBy(id("questionbankAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(id("SCORMCategoryNameEdit")).sendKeys("Child")

    driver.getVisibleElementAfterWaitBy(id("questionbankUpdate")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMQuestionBankTree")).findElements(By.tagName("li")).size should be(3)
    driver.getVisibleElementAfterWaitBy(partialLinkText("Category test")).click()
    driver.getVisibleElementAfterWaitBy(id("questionbankRemoveElement")).click()

    driver.getAlertTextAndCloseAfterWait should be("This will delete all included elements!")
    driver.getVisibleElementAfterWaitBy(id("SCORMQuestionBankTree")).findElements(By.tagName("li")).size should be(1)
  }
}