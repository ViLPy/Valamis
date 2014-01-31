package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.junit.Assert._


class CurriculumManagementTest(_driver: WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with UICurriculumBase {
  val driver = _driver

  "Curriculum management" should "be able to create more certificates" in {
    driver.get(baseUrl + curriculumUrl)
    addCertificate("certificate2")
    addCertificate("test x3")
    addCertificate("xxx yyy")

    driver.getVisibleElementAfterWaitBy(By.partialLinkText(manager)).click()
    assertAmount(6)
  }

  it should "be able to search across certificates" in {
    search("test")
    assertAmount(2)

    search("cert")
    assertAmount(4)

    search("y")
    assertAmount(2)

    search("")
    assertAmount(6)
  }

  it should "be able to sort" in {
    driver.getVisibleElementAfterWaitBy(By.id("sortList")).click()
    assertAmount(6)
    assertTitleInList("xxx yyy", 1)
    assertTitleInList("test x3", 2)
    assertTitleInList("Test cert1", 3)
    assertTitleInList(permanentCertificateName, 4)
    assertTitleInList("certificate2", 5)
    assertTitleInList(yearCertificateName, 6)

    driver.getVisibleElementAfterWaitBy(By.id("sortList")).click()
    assertTitleInList(yearCertificateName, 1)
    assertTitleInList("certificate2", 2)
    assertTitleInList(permanentCertificateName, 3)
    assertTitleInList("Test cert1", 4)
    assertTitleInList("test x3", 5)
    assertTitleInList("xxx yyy", 6)
  }

  it should "be able to delete certificate and it is not able to be found in list" in {
    deleteCertificate("certificate2")
    assertAmount(5)
    search("2")
    assertAmount(0)
    search("")
    assertAmount(5)
  }

  val name1 = "Aaa"
  val name2 = "ABa"
  val name3 = "Bbb"
  val name4 = "Ccc"
  val name5 = "Ddd"
  val name6 = "DE"
  it should "show paging if many certificates" in {
    addCertificate(name1)
    addCertificate(name2)
    addCertificate(name3)
    addCertificate(name4)
    addCertificate(name5)
    addCertificate(name6)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText(manager)).click()
    assertAmount(11)

    driver.get(baseUrl + curriculumUrl)
    assertAmount(10)
    driver.waitForElementVisibleBy(By.id("allCertificatesPaginator"))
//    assertTrue(isElementPresent())
    assertEquals("Prev", driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[1]/span")).getText)
    assertEquals("1", driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[2]/span")).getText)
    assertEquals("2", driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[3]")).getText)
    assertEquals("Next", driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[4]")).getText)

    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[3]/a")).click()
    assertAmount(1)
    assertTitleInList("xxx yyy", 1)

    driver.getVisibleElementAfterWaitBy(By.xpath("//*[@id=\"allCertificatesPaginator\"]/ul/li[1]/a")).click()
    assertAmount(10)

  }

  it should "delete unnecessary certificates" in {
    driver.get(baseUrl + curriculumUrl)
    assertTitleInList(yearCertificateName, 1)

    assertTitleInList(name1, 2)
    deleteCertificate(name1)

    assertTitleInList(name2, 2)
    deleteCertificate(name2)

    assertTitleInList(name3, 2)
    deleteCertificate(name3)

    assertTitleInList(name4, 2)
    deleteCertificate(name4)

    assertTitleInList(name5, 2)
    deleteCertificate(name5)

    assertTitleInList(name6, 2)
    deleteCertificate(name6)

    assertTitleInList(permanentCertificateName, 2)

    driver.get(baseUrl + curriculumUrl)
    assertAmount(5)
  }


  def search(value: String) {
    driver.getVisibleElementAfterWaitBy(By.id("certificateSearch")).clear()
    if (value != "") driver.getVisibleElementAfterWaitBy(By.id("certificateSearch")).sendKeys(value)

    driver.getVisibleElementAfterWaitBy(By.id("filterList")).click()
  }

  def assertAmount(expected: Int) {
    var amount = 0
    wait(1)
    driver.getVisibleElementAfterWaitBy(By.id("certificateList")).findElements(By.className("availableQuizItem"))
      .toArray.foreach(x => if (x.asInstanceOf[WebElement].isDisplayed) amount += 1)
    assertEquals(expected, amount)
  }

}
