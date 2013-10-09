package com.arcusys.learn.quiz

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium._
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 30.05.13
 */
class MainQuizTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  //7.20, 7.21
  "Quiz Editor" should "be able to search across the quizzes" in {
    driver.get(baseUrl + quizUrl)
    createNew("abc")
    wait(3)
    createNew("Test ab")
    wait(3)

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

    driver.findElement(By.id("sortList")).click()
    assertOrder("Test 1", "Test ab", "abc")

    driver.findElement(By.id("sortList")).click()
    assertOrder("abc", "Test ab", "Test 1")
  }

  //7.22
  it should "remove quiz coorectly" in {
    driver.findElement(By.id("quizDelete")).click()
    assertTrue(closeAlertAndGetItsText.matches("^This will delete quiz from the system\\. Are you sure[\\s\\S]$"))
    driver.findElement(By.id("quizDelete")).click()
    assertTrue(closeAlertAndGetItsText.matches("^This will delete quiz from the system\\. Are you sure[\\s\\S]$"))
    wait(1)
    assertAmount(1)
    search("ab")
    assertAmount(0)
    search("")
    assertAmount(1)
    driver.findElement(By.id("sortList")).click()
    assertAmount(1)
  }

  //TODO: 7.23 download quiz

  //7.24
  it should "install quiz" in {
    driver.findElement(By.id("buttonInstall")).click()
    wait(2)
    assertEquals("Package has been installed!", closeAlertAndGetItsText)
  }

  private def createNew(name: String){
    driver.findElement(By.id("SCORMButtonAddQuiz")).click()
    wait(2)
    driver.findElement(By.id("quizEdit")).click()
    driver.findElement(By.id("quizTitle")).clear()
    driver.findElement(By.id("quizTitle")).sendKeys(name)
    driver.findElement(By.id("quizUpdate")).click()
  }
  private def assertAmount(amount: Int){
    assertEquals(amount, driver.findElements(By.className("availableQuizItem")).toArray.filter(x=>(x.asInstanceOf[WebElement]).isDisplayed).length)
  }
  private def search(filter: String){
    driver.findElement(By.id("quizSearch")).clear()
    if (filter != "") driver.findElement(By.id("quizSearch")).sendKeys(filter)
    else driver.findElement(By.id("quizSearch")).sendKeys(Keys.ENTER)
    wait(2)
  }

  private def assertOrder(val1: String, val2: String, val3: String){
    assertEquals(val1, driver.findElement(By.xpath("//*[@id=\"quizList\"]/li[1]/div/div[1]/div[1]")).getText)
    assertEquals(val2, driver.findElement(By.xpath("//*[@id=\"quizList\"]/li[2]/div/div[1]/div[1]")).getText)
    assertEquals(val3, driver.findElement(By.xpath("//*[@id=\"quizList\"]/li[3]/div/div[1]/div[1]")).getText)
  }
}
