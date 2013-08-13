package com.arcusys.learn.curriculum

import org.openqa.selenium.{Keys, WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 16.07.13
 */
class CurriculumManagementTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Curriculum management" should "be able to create more certificates" in {
    driver.get(baseUrl + curriculumUrl)
    addCertificate("certificate2")
    addCertificate("test 3")
    addCertificate("xxx yyy")

    driver.findElement(By.partialLinkText("Management")).click()
    wait(1)
    assertAmount(4)
  }

  it should "be able to search across certificates" in {
    //search("test")
    //assertAmount(2)

    //search("cert")
    //assertAmount(2)

   // search("y")
    //assertAmount(1)

    search("")
    assertAmount(4)
  }

 /* it should "be able to sort" in{
    driver.findElement(By.id("sortList")).click()
    assertAmount(4)
    assertName("Test cert1", 1)
    assertName("certificate2", 2)
    assertName("test 3", 3)
    assertName("xxx yyy", 4)

    driver.findElement(By.id("sortList")).click()
    assertName("xxx yyy", 1)
    assertName("test 3", 2)
    assertName("certificate2", 3)
    assertName("Test cert1", 4)
  }*/

  it should "be able to delete site and it is not able to be found in list" in {
    driver.findElement(By.id("certificateDelete")).click()
    wait(1)
    assertTrue(closeAlertAndGetItsText.matches("^This will delete certificate from the system\\. Are you sure[\\s\\S]$"));
    wait(1)
    assertAmount(3)
    search("y")
    assertAmount(0)
    search("")
    assertAmount(3)
  }

  def assertName(name: String, index: Int){
    assertEquals(name, driver.findElement(By.xpath("//*[@id=\"certificateList\"]/li["+ index +"]/div/div[1]/div[1]")).getText)
  }

  def search(value: String){
    driver.findElement(By.id("certificateSearch")).clear()
    if (value != "" ) driver.findElement(By.id("certificateSearch")).sendKeys(value)


    driver.findElement(By.id("certificateSearch")).sendKeys(Keys.ENTER)
    wait(2)
  }

  def assertAmount(expected: Int){
    var amount = 0;
    driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
      .toArray.foreach(x => if (x.asInstanceOf[WebElement].isDisplayed) amount += 1)
    assertEquals(expected, amount)
  }

  def addCertificate(name: String){
    driver.findElement(By.partialLinkText("Management")).click()
    wait(1)

    driver.findElement(By.id("SCORMButtonAddCertificate")).click()
    wait(1)

    driver.findElement(By.id("certificateEdit")).click()

    getElement("certificateEditTitle").click()
    val input = getElement("quizItemTitle")
    input.clear()
    input.sendKeys(name)
    getElement("certificateTitleUpdate").click()
    wait(1)
  }

  def getElement(name: String): WebElement = {
    val element = driver.findElements(By.className(name)).toArray
      .foreach(x => if (x.asInstanceOf[WebElement].isDisplayed) return  x.asInstanceOf[WebElement])
    return element.asInstanceOf[WebElement]
  }

}
