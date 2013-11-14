package com.arcusys.learn.curriculum

import org.openqa.selenium.{Keys, WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._


class CurriculumManagementTest(_driver: WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with UICurriculumBase {
  val driver = _driver

  "Curriculum management" should "be able to create more certificates" in {
    driver.get(baseUrl + curriculumUrl)
    addCertificate("certificate2")
    addCertificate("test x3")
    addCertificate("xxx yyy")

    driver.findElement(By.partialLinkText(manager)).click()
    wait(1)
    assertAmount(4)
  }

  it should "be able to search across certificates" in {
    search("test")
    assertAmount(2)

    search("cert")
    assertAmount(2)

    search("y")
    assertAmount(1)

    search("")
    assertAmount(4)
  }

  it should "be able to sort" in {
    driver.findElement(By.id("sortList")).click()
    assertAmount(4)
    assertTitleInList("xxx yyy", 1)
    assertTitleInList("test x3", 2)
    assertTitleInList("Test cert1", 3)
    assertTitleInList("certificate2", 4)


    driver.findElement(By.id("sortList")).click()
    assertTitleInList("certificate2", 1)
    assertTitleInList("Test cert1", 2)
    assertTitleInList("test x3", 3)
    assertTitleInList("xxx yyy", 4)
  }

  it should "be able to delete site and it is not able to be found in list" in {
    deleteCertificate()
    assertAmount(3)
    search("2")
    assertAmount(0)
    search("")
    assertAmount(3)
  }

  val name1 = "Aaa"
  val name2 = "ABa"
  val name3 = "Bbb"
  val name4 = "Ccc"
  val name5 = "Ddd"
  val name6 = "DE"
  val name7 = "Eee"
  val name8 = "Fff"
  it should "show paging if many certificates" in {
    addCertificate(name1)
    addCertificate(name2)
    addCertificate(name3)
    addCertificate(name4)
    addCertificate(name5)
    addCertificate(name6)
    addCertificate(name7)
    addCertificate(name8)
    driver.findElement(By.partialLinkText(manager)).click()
    wait(1)
    assertAmount(11)

    driver.get(baseUrl + curriculumUrl)
    assertAmount(10)
    assertTrue(isElementPresent(By.id("allCertificatesPaginator")))
    assertEquals("Prev", driver.findElement(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[1]/span")).getText)
    assertEquals("1", driver.findElement(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[2]/span")).getText)
    assertEquals("2", driver.findElement(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[3]")).getText)
    assertEquals("Next", driver.findElement(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[4]")).getText)

    driver.findElement(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[3]/a")).click()
    wait(1)
    assertAmount(1)
    assertTitleInList("xxx yyy", 1)

    driver.findElement(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[1]/a")).click()
    wait(1)
    assertAmount(10)

  }

  it should "delete unnecessary certificates" in {
    driver.get(baseUrl + curriculumUrl)
    assertTitleInList(name1, 1)
    deleteCertificate()

    assertTitleInList(name2, 1)
    deleteCertificate()

    assertTitleInList(name3, 1)
    deleteCertificate()

    assertTitleInList(name4, 1)
    deleteCertificate()

    assertTitleInList(name5, 1)
    deleteCertificate()

    assertTitleInList(name6, 1)
    deleteCertificate()

    assertTitleInList(name7, 1)
    deleteCertificate()

    assertTitleInList(name8, 1)
    deleteCertificate()

    driver.get(baseUrl + curriculumUrl)
    assertAmount(3)
  }


  def search(value: String) {
    driver.findElement(By.id("certificateSearch")).clear()
    if (value != "") driver.findElement(By.id("certificateSearch")).sendKeys(value)

    driver.findElement(By.id("filterList")).click()
    wait(2)
  }

  def assertAmount(expected: Int) {
    var amount = 0;
    driver.findElement(By.id("certificateList")).findElements(By.className("availableQuizItem"))
      .toArray.foreach(x => if (x.asInstanceOf[WebElement].isDisplayed) amount += 1)
    assertEquals(expected, amount)
  }

}
