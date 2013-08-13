package com.arcusys.learn.questionbank

import org.openqa.selenium._
import interactions.Actions
import org.junit.Assert._
import com.arcusys.learn.base.UITestBase
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers

class CategoryTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Question Editor" should "be able to create and edit categories" in {
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.id("questionbankAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("Category")
    driver.findElement(By.id("questionbankUpdate")).click()
    driver.findElement(By.id("questionbankEditBottom")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("Category test")
    driver.findElement(By.id("questionbankUpdateBottom")).click()
    wait(1)
    driver.findElement(By.partialLinkText("Question base")).click()
    wait(1)
    driver.findElement(By.partialLinkText("Category test")).click()
    wait(1)
    driver.findElement(By.id("questionbankEdit")).click()
    driver.findElement(By.id("SCORMEditButtonDescription")).click()
    wait(1)
    driver.asInstanceOf[JavascriptExecutor].executeScript("tinyMCE.activeEditor.setContent('Test description');")
    driver.findElement(By.xpath("//button[@type='button']")).click()
    driver.findElement(By.id("questionbankUpdate")).click()

    val description = driver.findElement(By.id("SCORMCategoryDescription")).getText
    assertEquals("Test description", description)
    wait(1)
  }

  it should  " work correctly with child categories" in {
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("New category2")
    driver.findElement(By.id("questionbankUpdateBottom")).click()
    wait(1)
    val source = driver.findElement(By.partialLinkText("New category2"))
    val target = driver.findElement(By.partialLinkText("Category test"))
    new Actions(driver).dragAndDrop(source, target).perform()
    //new Actions(myTestDriver).dragAndDrop(draggable, droppable).build().perform();
    wait(1)
    driver.findElement(By.id("questionbankRemoveElement")).click()
    assertEquals("This will delete all included elements!", closeAlertAndGetItsText)
    driver.findElement(By.id("questionbankAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("Child")
    driver.findElement(By.id("questionbankUpdate")).click()
    wait(1)
    driver.findElement(By.partialLinkText("Category test")).click()
    driver.findElement(By.id("questionbankRemoveElement")).click()


    assertEquals("This will delete all included elements!", closeAlertAndGetItsText)
  }
}