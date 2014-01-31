package com.arcusys.learn.player

import org.openqa.selenium.{JavascriptExecutor, WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium.By._
import org.junit.Assert._
import org.openqa.selenium.interactions.Actions
import scala.collection.JavaConverters._
import org.openqa.selenium.support.ui.Select

class GeneratedQuizCorrectPass(_driver: WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Generated package" should "be able to randomize matching" in {
    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr[1]/td[3]/*[@id=\"startPackage\"]")).click()
    driver.getVisibleElementAfterWaitBy(id("currentPackageName")).getText should be("Test 1")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Welcome page")).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"SCORMPlayerContentDisplay\"]/p")).getText should be("Welcome!!!")
    driver.switchTo().defaultContent()

    val options1 = getMatchingOptions
    val options2 = getMatchingOptions
    val options3 = getMatchingOptions

    assertTrue((options2 != options1 || options1 != options3 || options2 != options3))

    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationExit")).click()
  }

  "Player" should "be able to pass generated quiz" in {

    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("id('SCORMPackagesGrid')/tr[1]/td[3]/*[@id='startPackage']")).click()
    driver.waitForElementWithTextBy(id("currentPackageName"), "Test 1")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Welcome page")).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"SCORMPlayerContentDisplay\"]/p")).getText should be("Welcome!!!")
    driver.switchTo().defaultContent()

    processTest()
  }

  private def processTest(depth: Int = 0) {
    val possibleTestDepth = 16

    // need this because order can be unpredictable
    wait(6)   // TODO: Remove! That's a temporal solution!
    val currentPage = driver.getVisibleElementAfterWaitBy(className("jstree-clicked")).getText
    currentPage match {
      case "Welcome page" => processWelcome()
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
      case "Welcome" => processLiferay("Welcome")                // must be change if liferayArticleName changed
      case "Final page" => processFinal()
    }
    depth should be < (possibleTestDepth)
    if (!currentPage.equalsIgnoreCase("Final page") && depth < possibleTestDepth) processTest(depth + 1)
  }

  def processWelcome(){
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def getMatchingOptions = {
    driver.getVisibleElementAfterWaitBy(partialLinkText("matching")).click()

    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    wait(6)
    val options = driver.findElements(xpath("//*[@id=\"scormQuestionData\"]/tbody/tr[1]/td[2]/select/option")).asScala.map(_.getText)
    driver.switchTo().defaultContent()

    driver.getVisibleElementAfterWaitBy(partialLinkText("Welcome")).click()
    driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput"))

    options
  }

  private def processMatching() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    new Select(driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"scormQuestionData\"]/tbody/tr[2]/td[2]/select"))).selectByVisibleText("tomato")
    new Select(driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"scormQuestionData\"]/tbody/tr[1]/td[2]/select"))).selectByVisibleText("apple")
    new Select(driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"scormQuestionData\"]/tbody/tr[3]/td[2]/select"))).selectByVisibleText("car")

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processEssay() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("It's ok!")

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processShortCaseSensitive() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("CASE")

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processShortCaseInSensitive() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("a")

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processExternal() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("/html/body/div/h1")).getText should be("Example Domain")
    driver.switchTo().defaultContent()
    driver.getVisibleElementAfterWaitBy(id("SCORMNavigationForward")).click()
  }

  private def processLiferay(title: String) {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("/html/body/div/div/h1")).getText should be(title)
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processCategorization() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    val source1 = driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[1]"))
    val source2 = driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[2]"))
    val source3 = driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[3]"))
    val source4 = driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[4]"))
    val source5 = driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"playerCategorizeAnswers\"]/ul/li[5]"))
    val target1 = driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"categorizationAnswerBoxs\"][1]/tbody/tr[2]/td"))
    val target2 = driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"categorizationAnswerBoxs\"][2]/tbody/tr[2]/td"))
    new Actions(driver).dragAndDrop(source1, target2).build().perform()
    new Actions(driver).dragAndDrop(source2, target1).build().perform()
    new Actions(driver).dragAndDrop(source3, target2).build().perform()
    new Actions(driver).dragAndDrop(source4, target1).build().perform()
    new Actions(driver).dragAndDrop(source5, target1).build().perform()

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processNumeric() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("15")
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processChoiceCheckbox() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    val index = driver.findElements(xpath("//label/p")).asScala.zipWithIndex.find(_._1.getText.contains("A")).map(_._2).getOrElse(throw new Exception("Cannot find correct answer"))
    driver.getVisibleElementAfterWaitBy(xpath("(//*[@class=\"checkbox\"])["+(index+1)+"]")).click()
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processChoiceRadio() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    val index = driver.findElements(xpath("//label/p")).asScala.zipWithIndex.find(_._1.getText.contains("1")).map(_._2).getOrElse(throw new Exception("Cannot find correct answer"))
    driver.getVisibleElementAfterWaitBy(xpath("(//*[@class=\"radio\"])["+(index+1)+"]")).click()
    //driver.findElements(xpath("(//*[@class=\"radio\"])")).asScala.find(_.getText.contains("1")).foreach(_.click())
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processPositioning() {
    def drag(index: Int, delta: Int) {
      val code = "$.getScript(\"https://raw.github.com/mattheworiordan/jquery.simulate.drag-sortable.js/master/jquery.simulate.drag-sortable.js\", function() {" +
        "$(\"#sortable li:nth-child(" + index + ")\").simulateDragSortable({ move: " + delta + "});" +
        "})"
      (driver.asInstanceOf[JavascriptExecutor]).executeScript(code)
    }

    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    val elements = driver.findElements(xpath("//*[@id=\"sortable\"]/li")).asScala.map(_.findElement(tagName("p")).getText)

    if (!elements(0).contains("1")) {
      val firstID = elements.zipWithIndex.find(_._1.contains("1")).get._2 + 1
      drag(firstID, 1-firstID)
    }

    wait(3) // TODO: Remove! That's a temporal solution!
    val elements2 = driver.findElements(xpath("//*[@id=\"sortable\"]/li")).asScala.map(_.findElement(tagName("p")).getText)

    if (!elements2(1).contains("2")) {
      val firstID = elements2.zipWithIndex.find(_._1.contains("2")).get._2 + 1
      drag(firstID, 2-firstID)
    }

    wait(2)  // deleting may cause answer 1,3
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processFinal() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"SCORMPlayerContentDisplay\"]/p")).getText should be("THE END!")
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
    driver.getVisibleElementAfterWaitBy(id("SCORMPackagesGrid"))
  }
}
