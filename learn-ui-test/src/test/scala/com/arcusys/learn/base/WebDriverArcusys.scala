package com.arcusys.learn.base

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions, WebDriverWait}
import org.openqa.selenium.By._
import scala.collection.JavaConverters._
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.RemoteWebDriver


trait WebDriverArcusys extends WebDriver{
  protected val newWindowKeysChrome =  Keys.chord(Keys.SHIFT,Keys.ENTER)
  protected val newWindowKeysFirefox =  Keys.chord(Keys.CONTROL,"n")

  private val waitForEvent = 10
  private val intervalBetweenCheck = 10

  def locateClearAndSendKeys(locator: By, textToInsert: String){
    val inputElement = getVisibleElementAfterWaitBy(locator)
    inputElement.clear()
    inputElement.sendKeys(textToInsert)
  }

  def waitForElementVisibleBy(locator: By) {
    val webWait = new WebDriverWait(this, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
  }

  def waitForElementInvisibleBy(locator: By) {
    val webWait = new WebDriverWait(this, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.invisibilityOfElementLocated(locator))
  }

  // Should be used in sorts only ?and in changed labels
  def waitForElementWithTextBy(locator: By, text: String) {
    val webWait = new WebDriverWait(this, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.textToBePresentInElement(locator,text))
  }

  def getVisibleElementAfterWaitBy(locator: By) = {
    waitForElementInvisibleBy(xpath("//*[text()='Processing']"))    // Needed by Chrome.
    waitForElementVisibleBy(locator)
    this.findElement(locator)
  }

  def getAlertTextAndCloseAfterWait = {
    val webWait = new WebDriverWait(this, waitForEvent, intervalBetweenCheck)
    webWait.until(ExpectedConditions.alertIsPresent)

    val alert = this.switchTo.alert
    val alertText: String = alert.getText
    alert.accept()
    alertText
  }

  def isElementPresentBy(by: By) = try {
    this.getVisibleElementAfterWaitBy(by)
    true
  } catch {
    case e: NoSuchElementException => false
  }

  def waitForNumberOfWindowsToEqual(numberOfWindows: Int) {
    new WebDriverWait(this, waitForEvent, intervalBetweenCheck).until(
      new ExpectedCondition[Boolean] {
        def apply(driver: WebDriver): Boolean = {
          driver.getWindowHandles.size() == numberOfWindows
        }
      })
  }

  def waitForNumberOfElementsWithFilterToEqual(f: (WebElement) => Boolean, locator: By, numberOfElements: Int) {
    new WebDriverWait(this, waitForEvent, intervalBetweenCheck).until(
      new ExpectedCondition[Boolean] {
        def apply(driver: WebDriver): Boolean = {
          findElements(locator).asScala.count(f) == numberOfElements
        }
      })
  }

  //TODO: merge f() into this object scope?
  def doInNewWindow(locator: By, loadURL: String)(f: (Unit)=> Unit) {
    val baseWindow = this.getWindowHandle
    if(this.isInstanceOf[ChromeDriver] || this.isInstanceOf[RemoteWebDriver]) getVisibleElementAfterWaitBy(locator).sendKeys(newWindowKeysChrome)
    if(this.isInstanceOf[FirefoxDriver]) getVisibleElementAfterWaitBy(locator).sendKeys(newWindowKeysFirefox)

    waitForNumberOfWindowsToEqual(2)

    val windows = this.getWindowHandles
    windows.remove(baseWindow)
    val helperWindow = windows.iterator().next()
    switchTo.window(helperWindow)
    this.get(loadURL)
    f()  // this.f()
    this.close()
    switchTo().window(baseWindow)
  }

  //TODO: Don't remove. Draft of idea "one portlet - one browser window". October 2013 - can't be applyed.
  //==============
//  protected val baseUrl = "http://localhost:8080"
//  protected val adminUrl = "/web/guest/admin"
//  protected val playerUrl = "/web/guest/player"
//
//  private var adminHandle = ""
//  private var playerHandle = ""

//  def init(){
//    var previousWindows = List[String]()
//    this.get(baseUrl + adminUrl)
//    adminHandle = this.getWindowHandle
//    previousWindows = adminHandle :: previousWindows
//
//    waitAndFindElementVisibleBy(xpath("//a/span[text()=' player']/..")).sendKeys(newWindowKeys)
//    waitForNumberOfWindowsToEqual(2)
//
//    val windows = this.getWindowHandles
//    windows.removeAll(previousWindows)
//    playerHandle = windows.iterator().next()
//    previousWindows = playerHandle :: previousWindows
//  }
//  def switchToAdmin(){
//    switchTo().window(adminHandle)
//  }
//
//  def switchToPlayer(){
//    switchTo().window(playerHandle)
//  }
  //==============
}
