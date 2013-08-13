package com.arcusys.learn.quiz

import org.openqa.selenium.{JavascriptExecutor, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 29.05.13
 */
class QuizQuestionTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  //7.10
  "Quiz Editor" should "be able to add questions" in{
    driver.findElement(By.partialLinkText("Quiz base")).click()
    driver.findElement(By.id("quizAddQuestions")).click()

    driver.findElement(By.xpath("//*[@id=\"questionChooseDialog\"]/ul/li[1]")).findElement(By.cssSelector("ins.jstree-checkbox")).click()
    wait(2)
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click()

    assertTrue(isElementPresent(By.partialLinkText("choise")))
    assertTrue(isElementPresent(By.partialLinkText("choise radio")))
    assertTrue(isElementPresent(By.partialLinkText("short case sensitive")))
    assertTrue(isElementPresent(By.partialLinkText("short")))
    assertTrue(isElementPresent(By.partialLinkText("numeric")))
    assertTrue(isElementPresent(By.partialLinkText("positioning question")))
    assertTrue(isElementPresent(By.partialLinkText("matching")))
    assertTrue(isElementPresent(By.partialLinkText("essay")))
    assertTrue(isElementPresent(By.partialLinkText("categorization")))

  }

  it should "be able to add external resource" in {
    //7.11
    driver.findElement(By.id("quizAddExternalResource")).click()
    wait(1)
    assertEquals("Add external resource", driver.findElement(By.id("ui-dialog-title-QuizAddExternalResourceDialog")).getText)
    assertTrue(isElementPresent(By.id("QuizAddExternalResourceDialog")))
    //7.12
    driver.findElement(By.id("externalResourceUrl")).clear()
    driver.findElement(By.id("externalResourceUrl")).sendKeys("www.example.com")
    driver.findElement(By.id("previewExternalResource")).click()
    wait(1)
    // TODO: verify preview is working
    //driver.findElement(By.id("QuizAddExternalResourceDialog"))

    //7.13
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click()
    wait(1)
    assertEquals("http://www.example.com",  driver.findElement(By.id("externalContentURL")).getAttribute("value"))
    //assertEquals("http://www.example.com",  driver.findElement(By.id("externalContentURL")).getText)
    driver.findElement(By.id("elementUpdate")).click()

    //7.14 TODO: verify preview is ok
    driver.findElement(By.id("elementPreview")).click()
    wait(1)
    assertTrue(driver.findElement(By.id("QuizPreviewDialog")).isDisplayed)
    wait(1)
    driver.findElement(By.xpath("//div[@aria-labelledby=\"ui-dialog-title-QuizPreviewDialog\"]/div/a")).click()
  }

  //7.15
  it should "show question content" in {
    driver.findElement(By.partialLinkText("short case sensitive")).click()
    assertEquals("Question type:", driver.findElement(By.id("SCORMQuestionTypeDiv")).findElement(By.className("quizSectionType")).getText)
    val image = driver.findElement(By.id("SCORMQuestionContentDiv")).findElement(By.xpath("//img"))
    wait(1)
    assertTrue(image.isDisplayed)
  }

  it should "be able to add Liferay article" in{
    //7.16
    driver.findElement(By.partialLinkText("Quiz base")).click()
    driver.findElement(By.id("quizAddLiferayResource")).click();
    wait(1)
    assertTrue(isElementPresent(By.id("ui-dialog-title-QuizLiferayArticleDialog")))
    assertTrue(isElementPresent(By.id("QuizLiferayArticleDialog")))
    assertTrue(driver.findElement(By.id("QuizLiferayArticleDialog")).findElement(By.id("liferayArticleDialog"))
      .findElement(By.id("articleList")).findElements(By.id("liferayArticleElement")).toArray.length > 0)

    // TODO: 7.17, 7.18 - Languages, Preview
    driver.findElement(By.xpath("(//button[@id='selectArticleButton'])[1]")).click()
    wait(1)
  }

  it should "count questions amount correctly" in{
    //7.19
    driver.findElement(By.partialLinkText("Quiz base")).click()
    driver.findElement(By.partialLinkText("Management")).click()
    assertEquals("11 questions selected.", driver.findElement(By.className("quizQuestionAmount")).getText)
  }

}
