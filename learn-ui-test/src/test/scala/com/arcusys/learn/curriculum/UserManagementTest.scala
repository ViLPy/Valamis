package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._


class UserManagementTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase with UICurriculumBase {
  val driver = _driver

  "Curriculum user management" should "be opened correctly" in {
    driver.get(baseUrl + curriculumUrl)
    wait(1)
    openUserManagement()

    assertTrue(isElementPresent(By.id("certificateMemberList")))
    assertTrue(isElementPresent(By.id("addMember")))

  }

  var firstAddedUsername = ""
  it should "be able to add user" in {
    firstAddedUsername = addMemberAndReturnName(0)

    driver.findElement(By.className("expandMember")).click()
    wait(1)
    val reviews = driver.findElements(By.className("userCourseReview"))
    assertEquals(2, reviews.size)

    setGrade(9,"comment! good work!" )
  }

  it should "be able to find student user" in{
    addStudentMember()

    val items = driver.findElement(By.id("certificateMemberList")).findElements(By.className("availableQuizItem")).size()
    assertEquals(2, items)

  }

  it should "be able to remove user" in {
    openManagement()
    assertAmount(2)

    openUserManagement()
    wait(1)

    def findUser: WebElement={
      val user = driver.findElement(By.id("certificateMemberList")).findElements(By.className("availableQuizItem")).toArray.foreach(x => {
        val title = x.asInstanceOf[WebElement].findElement(By.className("quizItemTitle")).getText
        if (firstAddedUsername.startsWith(title)) return x.asInstanceOf[WebElement]
      })
      user.asInstanceOf[WebElement]
    }

    findUser.findElement(By.id("memberDelete")).click()
    closeAlertAndGetItsText

    wait(1)
    openManagement()
    assertAmount(1)
  }

  def assertAmount(expected: Int){
    val sites = driver.findElement(By.className("certificateInfoDiv")).findElements(By.className("quizSectionTitle")).get(2).getText
    assertEquals( expected +" Members", sites)
  }
}
