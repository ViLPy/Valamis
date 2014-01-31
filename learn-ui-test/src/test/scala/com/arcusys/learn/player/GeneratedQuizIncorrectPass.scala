package com.arcusys.learn.player

import org.openqa.selenium.{JavascriptExecutor, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, LoginSupport, UITestBase}
import org.openqa.selenium.By._
import org.openqa.selenium.interactions.Actions
import scala.collection.JavaConverters._
import org.openqa.selenium.support.ui.Select

class GeneratedQuizIncorrectPass (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with LoginSupport {
  val driver = _driver

  "Player" should "be able to pass generated quiz incorrectly" in {
    logout()
    loginAsStudent()

    driver.get(baseUrl + playerUrl)
    driver.getVisibleElementAfterWaitBy(xpath("//*[@id=\"SCORMPackagesGrid\"]/tr[1]/td[3]/*[@id=\"startPackage\"]")).click()
    driver.getVisibleElementAfterWaitBy(id("currentPackageName")).getText should be("Test 1")

    driver.getVisibleElementAfterWaitBy(partialLinkText("Welcome page")).getAttribute("class").contains("jstree-clicked") should be(true)
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))
    driver.getVisibleElementAfterWaitBy(xpath("//*[@class=\"SCORMPlayerContentDisplay\"]/p")).getText should be("Welcome!!!")
//    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()

    processTest()

    logout()
    loginAsAdmin()
  }

  private def processTest(depth:Int = 0) {
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
      case "Welcome" => processLiferay("Welcome")        // must be change if liferayArticleName changed
      case "Final page" => processFinal()
      case _ => processLiferay("Unknown article")
    }
    wait(2)
    depth should be < (possibleTestDepth)
    if (!currentPage.equalsIgnoreCase("Final page") && depth < possibleTestDepth) processTest(depth + 1)
  }

  def processWelcome(){
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processMatching() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processEssay() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("It's not ok!")

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processShortCaseSensitive() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("case")

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processShortCaseInSensitive() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("aa")

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
    new Actions(driver).dragAndDrop(source1, target1).build().perform()
    new Actions(driver).dragAndDrop(source2, target2).build().perform()
    new Actions(driver).dragAndDrop(source3, target1).build().perform()
    new Actions(driver).dragAndDrop(source4, target2).build().perform()
    new Actions(driver).dragAndDrop(source5, target2).build().perform()

    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processNumeric() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    driver.getVisibleElementAfterWaitBy(id("scormAnswer")).sendKeys("105")
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processChoiceCheckbox() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    //driver.findElement(xpath("(//*[@class=\"checkbox\"])[1]")).click()
    driver.getVisibleElementAfterWaitBy(tagName("button")).click()
    driver.switchTo().defaultContent()
  }

  private def processChoiceRadio() {
    driver.switchTo().frame(driver.getVisibleElementAfterWaitBy(id("SCORMDataOutput")))

    //driver.findElement(xpath("(//*[@class=\"radio\"])[2]")).click()
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

    if (elements(1) != "1") {
      val firstID = elements.zipWithIndex.find(_._1 == "1").get._2 + 1
      drag(firstID, 2-firstID)
    }

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
