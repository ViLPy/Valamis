package com.arcusys.learn.gradebook

import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.{By,WebDriver}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 31.05.13
 */
trait GradebookManager extends UITestBase {
  implicit val driver: WebDriver

  protected def questionTitle(index: Int)={
    driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/a")).getText
  }
  protected def assertViewed(index: Int){
    assertEquals("+", driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[1]/span")).getText)
  }
  protected def assertViewedScorm12(groupIndex: Int, questionIndex: Int){ assertScorm12(groupIndex, questionIndex, "+") }
  protected def assertNotViewedScorm12(groupIndex: Int, questionIndex: Int){ assertScorm12(groupIndex, questionIndex, "-") }
  private def assertScorm12(groupIndex: Int, questionIndex: Int, value: String){
    assertEquals(value, driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+ groupIndex+"]/ul/li["+questionIndex+"]/div[1]/span")).getText)
  }

  protected def assertCorrect(index: Int){
    assertMark(index, 100)
  }
  protected def assertUnknown(index: Int){
    assertEquals("unknown", driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[2]/span")).getText)
  }
  protected def assertMark(index: Int, mark: Int){
    assertEquals(mark + "%", driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+index+"]/div[2]/span")).getText)
  }

  protected def setEssayMark(essayIndex:Int, comment: String, mark: Int){
    driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+essayIndex+"]/div[3]/span/button")).click()
    wait(1)
    driver.findElement(By.id("essayComment")).clear()
    driver.findElement(By.id("essayComment")).sendKeys(comment)
    driver.findElement(By.xpath("(//input[@name='grade'])["+(mark+1)+"]")).click()
    driver.findElement(By.cssSelector("div.float-right > input.textbutton")).click()
    wait(1)
  }

  protected def getEssayComment(essayIndex: Int)={
    driver.findElement(By.xpath("//*[@id=\"jsTreeGradebook\"]/ul/li/ul/li["+essayIndex+"]/div[3]/span/button")).click()
    wait(1)
    driver.findElement(By.id("essayComment")).getAttribute("value")
  }

  protected def getEssayIndex(): Int = {
    var essayIndex = 0
    for(index <- 1 to 11) if (questionTitle(index) == " essay") essayIndex = index
    essayIndex
  }
}
