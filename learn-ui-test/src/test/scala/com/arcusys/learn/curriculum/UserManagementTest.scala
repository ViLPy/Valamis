package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.junit.Assert._


class UserManagementTest(_driver: WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase with UICurriculumBase {
  val driver = _driver

  "Curriculum user management" should "be opened correctly" in {
    driver.get(baseUrl + curriculumUrl)
    openUserManagement(permanentCertificateName)

    driver.waitForElementVisibleBy(By.id("certificateMemberList"))
    driver.waitForElementVisibleBy(By.id("addMember"))

  }

  var firstAddedUsername = ""
  it should "be able to add user" in {
    firstAddedUsername = addNotStudentMemberAndReturnName(0)

    driver.getVisibleElementAfterWaitBy(By.className("expandMember")).click()
    driver.getVisibleElementAfterWaitBy(By.className("userCourseReview"))
    val reviews = driver.findElements(By.className("userCourseReview"))
    assertEquals(3, reviews.size)

  }

  it should "be able to open user public page" in {
    // ignored for IE
    driver.getVisibleElementAfterWaitBy(By.id("addMember")).click()
    driver.getVisibleElementAfterWaitBy(By.id("userSearch")).sendKeys(studentUserName)

    val baseWindow = driver.getWindowHandle

    driver.getVisibleElementAfterWaitBy(By.xpath("id('userList')//div[contains(text(), '" + studentUserName + "')]/../div[1]/a")).click()
    driver.waitForNumberOfWindowsToEqual(2)

    val windows = driver.getWindowHandles
    windows.remove(baseWindow)
    val helperWindow = windows.iterator().next()
    driver.switchTo.window(helperWindow)

    assertEquals(baseUrl + "/web/student", driver.getCurrentUrl)

    driver.close()
    driver.switchTo().window(baseWindow)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("close")).click()
  }

  it should "be able to find student user" in {
    addStudentMember()

    val items = driver.getVisibleElementAfterWaitBy(By.id("certificateMemberList")).findElements(By.className("availableQuizItem")).size()
    assertEquals(2, items)

  }

  it should "not add user twice" in {
    addStudentMember()

    val items = driver.getVisibleElementAfterWaitBy(By.id("certificateMemberList")).findElements(By.className("availableQuizItem")).size()
    assertEquals(2, items)
  }

  it should "show links correctly" in {
    def getLink(index: Int) = {
      driver.getVisibleElementAfterWaitBy(By.xpath("//*[@class='myCertificateGrid']/tbody/tr[" + index + "]/td/div/a"))
    }

    val link1 = getLink(1)
    assertEquals(testSite1, link1.getText)
    assertTrue(link1.getAttribute("href").contains(baseUrl + "/group/" + testSite1)) // it should redirect to private pages if there are no public

    val link2 = getLink(2)
    assertEquals(site2name, link2.getText)
    assertTrue(link2.getAttribute("href").contains(baseUrl + "/web/" + site2name))

    val link3 = getLink(3)
    assertEquals(testSite2, link3.getText)
    assertTrue(link3.getAttribute("href").contains(baseUrl + "/web/" + testSite2))
  }

  it should "be able to set mark for student user" in {
    driver.getVisibleElementAfterWaitBy(By.xpath("id('certificateMemberList')//*[ text()='" + studentUserName + "']/..")).
      findElement(By.className("expandMember")).click()

    val gradeId = driver.findElements(By.className("userCourseReview")).get(0).getAttribute("id").replace("reviewButton_", "")
    assertEquals("-", driver.getVisibleElementAfterWaitBy(By.id("reviewGrade_" + gradeId)).getText)

    setGrade(9, "comment! good work!")
    assertEquals("90%", driver.getVisibleElementAfterWaitBy(By.id("reviewGrade_" + gradeId)).getText)
  }

  it should "be able to remove user" in {
    openManagement()
    driver.waitForElementWithTextBy(By.xpath("//div[text()='" + permanentCertificateName + "']/../../div[2]/div/div/div[2]/div[3]/div[2]"), "2")
    assertMembersAmountInManagement(permanentCertificateName, 2)

    openUserManagement(permanentCertificateName)

    def findUser: WebElement = {
      val user = driver.getVisibleElementAfterWaitBy(By.id("certificateMemberList")).findElements(By.className("availableQuizItem")).toArray.foreach(x => {
        val title = x.asInstanceOf[WebElement].findElement(By.className("quizItemTitle")).getText
        if (firstAddedUsername.startsWith(title)) return x.asInstanceOf[WebElement]
      })
      user.asInstanceOf[WebElement]
    }

    findUser.findElement(By.id("memberDelete")).click()
    driver.getAlertTextAndCloseAfterWait // TODO: bug: alert is about certificate (!)

    openManagement()
    driver.waitForElementWithTextBy(By.xpath("//div[text()='" + permanentCertificateName + "']/../../div[2]/div/div/div[2]/div[3]/div[2]"), "1")
    assertMembersAmountInManagement(permanentCertificateName, 1)
  }
}
