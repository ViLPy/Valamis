package com.arcusys.learn.scope

import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{LoginSupport, WebDriverArcusys, UITestBase}
import org.openqa.selenium.{By, WebDriver}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 03.06.13
 */
class QuizScopeTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport{
  val driver = _driver

  //12.2
  "Learn" should "allow to create questions and quizes in scope1" in {
    loginAsAdmin()
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
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionTitleEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionTitleEdit")).sendKeys(name)
    driver.getVisibleElementAfterWaitBy(By.id("questionbankUpdate")).click()

  }

  private def createQuizAndAssertOneQuestion(name: String, questionName: String){
    driver.getVisibleElementAfterWaitBy(By.id("SCORMButtonAddQuiz")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizEdit")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("quizTitle")).sendKeys(name)
    driver.getVisibleElementAfterWaitBy(By.id("quizUpdate")).click()
    driver.getVisibleElementAfterWaitBy(By.id("buttonOpen")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizAddQuestions")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]")).findElement(By.cssSelector("ins.jstree-checkbox")).click()
    val questions = driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]/ul")).findElements(By.className("jstree-leaf"))
    assertEquals(1, questions.toArray.length)
    driver.getVisibleElementAfterWaitBy(By.xpath("id('questionChooseDialog')/..//button/span[text()='Add']")).click()

    driver.waitForElementVisibleBy(By.partialLinkText(questionName))
  }

  private def install(){
    driver.getVisibleElementAfterWaitBy(By.id("buttonInstall")).click()
    driver.getAlertTextAndCloseAfterWait should  be("Package has been installed!")
  }


}
