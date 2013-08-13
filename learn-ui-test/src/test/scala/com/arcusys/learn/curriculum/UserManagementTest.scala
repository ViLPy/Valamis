package com.arcusys.learn.curriculum

import org.openqa.selenium.{WebElement, By, WebDriver}
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.base.UITestBase
import org.junit.Assert._

/**
 * User: Yulia.Glushonkova
 * Date: 15.07.13
 */
class UserManagementTest  (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Curriculum user management" should "be opened correctly" in {
    driver.findElement(By.id("certificateEditUsers")).click()

    assertTrue(isElementPresent(By.id("certificateUserContent")))
    assertTrue(isElementPresent(By.partialLinkText("Users")))

  }

  var firstAddedUsername = ""
  it should "be able to add user" in {
    driver.findElement(By.id("certificateAddUser")).click()
    wait(1)
    assertTrue(isElementPresent(By.id("CurriculumLiferayUserDialog")))
    val user = driver.findElement(By.id("userList")).findElements(By.id("liferayUserElement")).get(0)
    firstAddedUsername = user.getText

    user.findElement(By.id("selectUserButton")).click()
    driver.findElement(By.xpath("//div[10]/div[1]/a")).click()
    wait(1)

    driver.findElement(By.partialLinkText(firstAddedUsername)).click()
    wait(1)

    val reviews = driver.findElement(By.id("certificateUserContent")).findElements(By.className("userCourseReview"))
    assertEquals(2, reviews.size)

    reviews.get(0).click()

    assertTrue(isElementPresent(By.id("CurriculumUserCourseGradeDialog")))

    driver.findElement(By.id("certificateCourseComment")).sendKeys("comment! good work!")
    driver.findElement(By.xpath("(//input[@name='grade'])[9]")).click()
    driver.findElement(By.id("saveCourseGradeButton")).click()

    wait(1)
  }

  it should "be able to find student user" in{
    driver.findElement(By.id("certificateAddUser")).click()
    wait(1)

    driver.findElement(By.id("userSearch")).sendKeys(studentUserName)
    wait(1)


    val users = driver.findElements(By.id("liferayUserElement"))

    def userHelper: WebElement={
      val user = users.toArray.foreach(x => {
        if (x.asInstanceOf[WebElement].findElement(By.id("selectUserButton")).isDisplayed) return x.asInstanceOf[WebElement]
      })
      user.asInstanceOf[WebElement]
    }

    val user =  userHelper
    val username = user.getText

    user.findElement(By.id("selectUserButton")).click()
    driver.findElement(By.xpath("//div[10]/div[1]/a")).click()
    wait(1)

    driver.findElement(By.partialLinkText(username)).click()

  }

  it should "be able to remove user" in {
    driver.findElement(By.partialLinkText("Management")).click()
    val sites = driver.findElements(By.className("quizQuestionAmount")).get(1).getText
    assertEquals("2 Users are members", sites)

    driver.findElement(By.partialLinkText("Test cert1")).click()
    wait(1)
    driver.findElement(By.partialLinkText(firstAddedUsername)).click()
    driver.findElement(By.id("certificateRemoveUser")).click()
    assertTrue(closeAlertAndGetItsText.matches("^Are you sure want to delete user[\\s\\S]$"))

    wait(1)
    driver.findElement(By.partialLinkText("Management")).click()
    val updatedSites = driver.findElements(By.className("quizQuestionAmount")).get(1).getText
    assertEquals("1 Users are members", updatedSites)
  }
}
