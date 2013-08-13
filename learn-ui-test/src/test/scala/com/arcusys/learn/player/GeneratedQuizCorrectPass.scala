package com.arcusys.learn.player

import org.openqa.selenium.{JavascriptExecutor, WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.By._
import org.openqa.selenium.interactions.Actions
import scala.collection.JavaConverters._
import org.openqa.selenium.support.ui.Select

class GeneratedQuizCorrectPass(_driver: WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Player" should "be able to pass generated quiz" in {
    driver.get(baseUrl + playerUrl)
    wait(1)
    driver.findElement(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[3]/td[3]/*[@id=\"startPackage\"]")).click()
    wait(5)
    driver.findElement(id("currentPackageName")).getText should be("Test 1")

    driver.findElement(partialLinkText("Welcome page")).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))
    driver.findElement(xpath("//*[@class=\"SCORMPlayerContentDisplay\"]/p")).getText should be("Welcome!!!")
    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)

    processTest()
  }

  private def processTest(depth: Int = 0) {
    val possibleTestDepth = 15

    // need this because order can be unpredictable
    val currentPage = driver.findElement(className("jstree-clicked")).getText
    currentPage match {
      case "matching" => processMatching()
      case "short case sensitive" => processShortCaseSensitive()
      case "positioning question" => processPositioning()
      case "choise radio" => processChoiceRadio()
      case "choise" => processChoiceCheckbox()
      case "numeric" => processNumeric()
      case "essay" => processEssay()
      case "categorization" => processCategorization()
      case "short" => processShortCaseInSensitive()
      case "External quiz resource" => processExternal()
      case "Who Is Using Liferay" => processLiferay()
      case "Final page" => processFinal()
    }
    depth should be < (possibleTestDepth)
    if (!currentPage.equalsIgnoreCase("Final page") && depth < possibleTestDepth) processTest(depth + 1)
  }

  private def processMatching() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    new Select(driver.findElement(xpath("//*[@id=\"scormQuestionData\"]/tbody/tr[2]/td[2]/select"))).selectByVisibleText("tomato")

    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processEssay() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    driver.findElement(id("scormAnswer")).sendKeys("It's ok!")

    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processShortCaseSensitive() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    driver.findElement(id("scormAnswer")).sendKeys("CASE")

    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processShortCaseInSensitive() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    driver.findElement(id("scormAnswer")).sendKeys("a")

    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processExternal() {
    driver.findElement(id("SCORMNavigationForward")).click()
    wait(3)
  }

  private def processLiferay() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processCategorization() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    val source1 = driver.findElement(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[1]"))
    val source2 = driver.findElement(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[2]"))
    val source3 = driver.findElement(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[3]"))
    val source4 = driver.findElement(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[4]"))
    val source5 = driver.findElement(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[5]"))
    val target1 = driver.findElement(xpath("//*[@class=\"categorizationAnswerBoxs\"][1]/tbody/tr[2]/td"))
    val target2 = driver.findElement(xpath("//*[@class=\"categorizationAnswerBoxs\"][2]/tbody/tr[2]/td"))
    new Actions(driver).dragAndDrop(source1, target2).build().perform()
    wait(1)
    new Actions(driver).dragAndDrop(source2, target1).build().perform()
    wait(1)
    new Actions(driver).dragAndDrop(source3, target2).build().perform()
    wait(1)
    new Actions(driver).dragAndDrop(source4, target1).build().perform()
    wait(1)
    new Actions(driver).dragAndDrop(source5, target1).build().perform()
    wait(1)

    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processNumeric() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    driver.findElement(id("scormAnswer")).sendKeys("15")
    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processChoiceCheckbox() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    driver.findElement(xpath("(//*[@class=\"checkbox\"])[2]")).click()
    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processChoiceRadio() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    driver.findElement(xpath("(//*[@class=\"radio\"])[3]")).click()
    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processPositioning() {
    def drag(index: Int, delta: Int) {
      val code = "$.getScript(\"https://raw.github.com/mattheworiordan/jquery.simulate.drag-sortable.js/master/jquery.simulate.drag-sortable.js\", function() {" +
        "$(\"#sortable li:nth-child(" + index + ")\").simulateDragSortable({ move: " + delta + "});" +
        "})"
      (driver.asInstanceOf[JavascriptExecutor]).executeScript(code)
    }

    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))

    val elements = driver.findElements(xpath("//*[@id=\"sortable\"]/li")).asScala.map(_.findElement(tagName("p")).getText)

    if (elements(0) != "1") {
      val firstID = elements.zipWithIndex.find(_._1 == "1").get._2 + 1
      drag(firstID, 1-firstID)
      wait(5)
    }

    if (elements(1) != "2") {
      val firstID = elements.zipWithIndex.find(_._1 == "2").get._2 + 1
      drag(firstID, 2-firstID)
      wait(5)
    }

    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }

  private def processFinal() {
    driver.switchTo().frame(driver.findElement(id("SCORMDataOutput")))
    driver.findElement(xpath("//*[@class=\"SCORMPlayerContentDisplay\"]/p")).getText should be("THE END!")
    driver.findElement(tagName("button")).click()
    driver.switchTo().defaultContent()
    wait(3)
  }
}
