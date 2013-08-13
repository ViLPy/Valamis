package com.arcusys.learn.scope

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.{By, WebDriver}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 03.06.13
 */
class QuizScopeTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  //12.2
  "Learn" should "allow to create questions and quizes in scope1" in {
    driver.get(baseUrl + questionUrl)
    val question = "Test question, site 1"
    createQuestion(question)

    driver.get(baseUrl + quizUrl)
    createQuizAndAssertOneQuestion("Quiz site1", question)
    driver.get(baseUrl + quizUrl)
    install()
  }

  //12.3
  it should "allow to create questions and quizes in scope2" in {
    driver.get(site2Url + site2QuestionUrl)
    val question = "Some site2"
    createQuestion(question)
    driver.get(site2Url + site2QuizUrl)
    createQuizAndAssertOneQuestion("Quiz site2", question)
    driver.get(site2Url + site2QuizUrl)
    install()
  }

  private def createQuestion(name: String){
    driver.findElement(By.id("questionbankAddQuestions")).click()
    driver.findElement(By.id("SCORMQuestionTitleEdit")).clear()
    driver.findElement(By.id("SCORMQuestionTitleEdit")).sendKeys(name)
    driver.findElement(By.id("questionbankUpdate")).click()

  }

  private def createQuizAndAssertOneQuestion(name: String, questionName: String){
    driver.findElement(By.id("SCORMButtonAddQuiz")).click()
    driver.findElement(By.id("quizEdit")).click()
    driver.findElement(By.id("quizTitle")).clear()
    driver.findElement(By.id("quizTitle")).sendKeys(name)
    driver.findElement(By.id("quizUpdate")).click()
    wait(1)
    driver.findElement(By.id("buttonOpen")).click()
    driver.findElement(By.id("quizAddQuestions")).click()
    driver.findElement(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]")).findElement(By.cssSelector("ins.jstree-checkbox")).click()
    val questions = driver.findElement(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul")).findElements(By.className("jstree-leaf"))
    assertEquals(1, questions.toArray.length)

    wait(2)
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click()
    assertTrue(isElementPresent(By.partialLinkText(questionName)))
  }

  private def install(){
    driver.findElement(By.id("buttonInstall")).click()
    wait(2)
    assertEquals("Package has been installed!", closeAlertAndGetItsText)
  }


}
