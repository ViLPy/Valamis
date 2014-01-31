package com.arcusys.learn.quiz

import org.openqa.selenium.{JavascriptExecutor, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 29.05.13
 */
class QuizQuestionTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  //7.10
  "Quiz Editor" should "be able to add questions" in{
    driver.get(baseUrl + quizUrl)
    driver.getVisibleElementAfterWaitBy(By.id("buttonOpen")).click()

    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Quiz base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizAddQuestions")).click()

    driver.getVisibleElementAfterWaitBy(By.xpath("id('questionChooseDialog')/ul/li[1]")).findElement(By.cssSelector("ins.jstree-checkbox")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("id('questionChooseDialog')/..//button/span[text()='Add']")).click()
    
    assertTrue(driver.isElementPresentBy(By.partialLinkText("choise")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("choise radio")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("short case sensitive")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("short")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("numeric")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("positioning question")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("matching")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("essay")))
    assertTrue(driver.isElementPresentBy(By.partialLinkText("categorization")))

  }

  it should "be able to add external resource" in {
    //7.11
    driver.getVisibleElementAfterWaitBy(By.id("quizAddExternalResource")).click()
    assertEquals("Add external resource", driver.getVisibleElementAfterWaitBy(By.id("ui-dialog-title-QuizAddExternalResourceDialog")).getText)
    assertTrue(driver.isElementPresentBy(By.id("QuizAddExternalResourceDialog")))
    //7.12
    driver.getVisibleElementAfterWaitBy(By.id("externalResourceUrl")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("externalResourceUrl")).sendKeys(externalResourceURL)
    driver.getVisibleElementAfterWaitBy(By.id("previewExternalResource")).click()
    // verify preview is working
    assertEquals("http://"+externalResourceURL+"/", driver.getVisibleElementAfterWaitBy(By.xpath("id('QuizAddExternalResourceDialog')/iframe")).getAttribute("src"))
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(By.xpath("id('QuizAddExternalResourceDialog')/iframe")))
    driver.getVisibleElementAfterWaitBy(By.xpath("/html/body/div/h1")).getText should be("Example Domain")
    driver.switchTo().defaultContent()

    //7.13
    driver.getVisibleElementAfterWaitBy(By.xpath("id('QuizAddExternalResourceDialog')/..//button/span[text()='Add']")).click()
    assertEquals("http://"+externalResourceURL,  driver.getVisibleElementAfterWaitBy(By.id("externalContentURL")).getAttribute("value"))
    driver.getVisibleElementAfterWaitBy(By.id("elementUpdate")).click()

    //7.14 verify preview is ok
    driver.getVisibleElementAfterWaitBy(By.id("elementPreview")).click()
    assertTrue(driver.getVisibleElementAfterWaitBy(By.id("QuizPreviewDialog")).isDisplayed)
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(By.xpath("id('QuizPreviewDialog')/iframe")))
    driver.getVisibleElementAfterWaitBy(By.xpath("/html/body/div/h1")).getText should be("Example Domain")
    driver.switchTo().defaultContent()
    driver.getVisibleElementAfterWaitBy(By.xpath("//div[@aria-labelledby=\"ui-dialog-title-QuizPreviewDialog\"]/div/a")).click()
  }

  //7.15
  it should "show question content" in {
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("short case sensitive")).click()
    assertEquals("Question type:", driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionTypeDiv")).findElement(By.className("quizSectionType")).getText)
//    val image = driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionContentDiv")).findElement(By.xpath("//img"))
//    assertTrue(image.isDisplayed)
  }

  it should "be able to add Liferay article" in{
    //7.16
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Quiz base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("quizAddLiferayResource")).click()
    assertTrue(driver.isElementPresentBy(By.id("ui-dialog-title-QuizLiferayArticleDialog")))
    assertTrue(driver.isElementPresentBy(By.id("QuizLiferayArticleDialog")))
    assertTrue(driver.getVisibleElementAfterWaitBy(By.id("QuizLiferayArticleDialog")).findElement(By.id("liferayArticleDialog"))
      .findElement(By.id("articleList")).findElements(By.id("liferayArticleElement")).toArray.length > 0)

    // TODO: 7.17, 7.18 - Languages, Preview ?
    // can search
    val searchField = driver.getVisibleElementAfterWaitBy(By.id("articleFilterInput"))
    searchField.clear()
    searchField.sendKeys(liferayArticleName)

    driver.findElements(By.id("liferayArticleElement")).size should be(1)

    driver.getVisibleElementAfterWaitBy(By.id("selectArticleButton")).click()
    driver.getVisibleElementAfterWaitBy(By.partialLinkText(liferayArticleName))
  }

  it should "count questions amount correctly" in{
    //7.19
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Quiz base")).click()
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Management")).click()
    driver.waitForElementWithTextBy(By.className("quizQuestionAmount"), "11 questions selected.")
//    assertEquals("11 questions selected.", driver.getVisibleElementAfterWaitBy(By.className("quizQuestionAmount")).getText)
  }

}
