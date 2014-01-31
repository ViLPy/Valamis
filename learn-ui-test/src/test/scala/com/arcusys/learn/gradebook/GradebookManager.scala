package com.arcusys.learn.gradebook

import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium.By
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
trait GradebookManager extends UITestBase {
  implicit val driver: WebDriverArcusys

  protected def questionTitle(index: Int)={
    driver.getVisibleElementAfterWaitBy(By.xpath("id('jsTreeGradebook')/ul/li/ul/li["+index+"]/a")).getText
  }
  protected def questionsAmount()={
    driver.getVisibleElementAfterWaitBy(By.xpath("id('jsTreeGradebook')/ul/li/ul")).findElements(By.tagName("li")).size
  }
  protected def assertViewed(index: Int){
    assertEquals("+", driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[1]/span")).getText)
  }
  protected def getResponse(index: Int) = {
    driver.getVisibleElementAfterWaitBy(By.xpath("id('jsTreeGradebook')/ul/li/ul/li["+index+"]/div[3]/span")).getText
  }
  protected def openResponse(index: Int) {
    driver.getVisibleElementAfterWaitBy(By.xpath("id('jsTreeGradebook')/ul/li/ul/li["+index+"]/div[3]/span/button")).click()
  }
  protected def assertViewedScorm12(groupIndex: Int, questionIndex: Int){ assertScorm12(groupIndex, questionIndex, "+") }
  protected def assertNotViewedScorm12(groupIndex: Int, questionIndex: Int){ assertScorm12(groupIndex, questionIndex, "-") }
  private def assertScorm12(groupIndex: Int, questionIndex: Int, value: String){
    assertEquals(value, driver.getVisibleElementAfterWaitBy(By.xpath("id('jsTreeGradebook')/ul/li/ul/li["+ groupIndex+"]/ul/li["+questionIndex+"]/div[1]/span")).getText)
  }

  protected def assertCorrect(index: Int){
    assertMark(index, 100)
  }
  protected def assertUnknown(index: Int){
    driver.waitForElementWithTextBy(By.xpath("id('jsTreeGradebook')/ul/li/ul/li["+index+"]/div[2]"), "unknown")
  }
  protected def assertMark(index: Int, mark: Int){
    driver.waitForElementWithTextBy(By.xpath("id('jsTreeGradebook')/ul/li/ul/li["+index+"]/div[2]"), mark+"%")
  }

  protected def assertPackageMark(mark: String){
    driver.waitForElementWithTextBy(By.xpath("//a[@title='Test 1']/../div[2]"), mark)
  }

  protected def setEssayMark(comment: String, mark: Int){
    driver.getVisibleElementAfterWaitBy(By.xpath("id('jsTreeGradebook')//a[@title='essay']/..//button")).click()
    driver.getVisibleElementAfterWaitBy(By.id("essayComment")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("essayComment")).sendKeys(comment)
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@name='grade'])["+(mark+1)+"]")).click()
    driver.getVisibleElementAfterWaitBy(By.cssSelector("div.float-right > input.textbutton")).click()
  }

  protected def getEssayComment(essayIndex: Int)={
    driver.getVisibleElementAfterWaitBy(By.xpath("id('jsTreeGradebook')/ul/li/ul/li["+essayIndex+"]/div[3]/span/button")).click()
    driver.getVisibleElementAfterWaitBy(By.id("essayComment")).getAttribute("value")
  }

  @Deprecated
  protected def getEssayIndex: Int = {
    var essayIndex = 0
    for(index <- 1 to questionsAmount()) if (questionTitle(index) == " essay") essayIndex = index
    essayIndex
  }
}
