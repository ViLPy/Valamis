package com.arcusys.learn.quiz

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium._
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 30.05.13
 */
class MainQuizTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  //7.20, 7.21
  "Quiz Editor" should "be able to search across the quizzes" in {
    driver.get(baseUrl + quizUrl)
    createNew("abc")
    createNew("Test ab")

    assertAmount(3)
    search("ab")
    assertAmount(2)
    search("test")
    assertAmount(2)
    search("1")
    assertAmount(1)
    search("x")
    assertAmount(0)
    search("")
    assertAmount(3)

    driver.getVisibleElementAfterWaitBy(By.id("sortList")).click()
    assertOrder("Test 1", "Test ab", "abc")

    driver.getVisibleElementAfterWaitBy(By.id("sortList")).click()
    assertOrder("abc", "Test ab", "Test 1")
  }

  //7.22
  it should "remove quiz coorectly" in {
    driver.getVisibleElementAfterWaitBy(By.id("quizDelete")).click()
    driver.getAlertTextAndCloseAfterWait.matches("^This will delete quiz from the system\\. Are you sure[\\s\\S]$")
    driver.getVisibleElementAfterWaitBy(By.id("quizDelete")).click()
    driver.getAlertTextAndCloseAfterWait.matches("^This will delete quiz from the system\\. Are you sure[\\s\\S]$")
    assertAmount(1)
    search("ab")
    assertAmount(0)
    search("")
    assertAmount(1)
    driver.getVisibleElementAfterWaitBy(By.id("sortList")).click()
    assertAmount(1)
  }

  //TODO: 7.23 download quiz

  //7.24
  it should "install quiz" in {
    driver.getVisibleElementAfterWaitBy(By.id("buttonInstall")).click()
    driver.getAlertTextAndCloseAfterWait should be("Package has been installed!")
  }

  private def createNew(name: String){
    driver.getVisibleElementAfterWaitBy(By.id("SCORMButtonAddQuiz")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizEdit")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).sendKeys(name)
    driver.getVisibleElementAfterWaitBy(By.id("quizUpdate")).click()
  }
  private def assertAmount(amount: Int){
//    assertEquals(amount, driver.findElements(By.className("availableQuizItem")).toArray.filter(x=>(x.asInstanceOf[WebElement]).isDisplayed).length)
//    TODO: temporal solution   Switch to Invisible element
    driver.waitForNumberOfElementsWithFilterToEqual(x=>x.isDisplayed, By.className("availableQuizItem"), amount)
  }
  private def search(filter: String){
    driver.getVisibleElementAfterWaitBy(By.id("quizSearch")).clear()
    if (filter != "") driver.getVisibleElementAfterWaitBy(By.id("quizSearch")).sendKeys(filter)
    else driver.getVisibleElementAfterWaitBy(By.id("quizSearch")).sendKeys(Keys.ENTER)
  }

  private def assertOrder(val1: String, val2: String, val3: String){
    assertEquals(val1, driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"quizList\"]/li[1]/div/div[1]/div[1]")).getText)
    assertEquals(val2, driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"quizList\"]/li[2]/div/div[1]/div[1]")).getText)
    assertEquals(val3, driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"quizList\"]/li[3]/div/div[1]/div[1]")).getText)
  }
}
