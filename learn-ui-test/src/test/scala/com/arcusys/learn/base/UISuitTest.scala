package com.arcusys.learn.base

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.openqa.selenium.firefox.FirefoxDriver
import com.arcusys.learn.admin.{PermissionTest, CleanUpTest, AdminTest}
import com.arcusys.learn.questionbank._
import com.arcusys.learn.quiz._
import com.arcusys.learn.liferay.SearchTest
import com.arcusys.learn.player._
import com.arcusys.learn.scope.{PlayerScopeTest, AdminScopeTest, QuizScopeTest}
import com.arcusys.learn.gradebook._
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities}
import com.arcusys.learn.curriculum.{StudentCurriculumTest, UserManagementTest, CurriculumManagementTest, BasicCurriculumAdminTest}

@RunWith(classOf[JUnitRunner])
class UISuitTest extends Suites with LoginSupport with BeforeAndAfterAll {
  val dc = new DesiredCapabilities()
  dc.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true)
  val driver = new FirefoxDriver(dc)

  override def beforeAll(configMap: Map[String, Any]) {
    loginAsAdmin()
  }

  override val nestedSuites = collection.immutable.IndexedSeq(
    /* new AdminTest(driver),
   new BasicViewTest(driver),
   new SearchTest(driver),

   new CategoryTest(driver),
   new QuestionTest(driver),
   new BasicQuizTest(driver),
   new QuizCategoryTest(driver),
   new QuizQuestionTest(driver),
   new MainQuizTest(driver),

   new GeneratedQuizCorrectPass(driver),
   new CorrectResultsTest(driver),
   new StudentNotPassedTest(driver),

   new GeneratedQuizIncorrectPass(driver),

   new StudentPassedTest(driver),
   new TeacherTest(driver),
   new StudentViewMarkTest(driver),

   new ViewedStateTest(driver)
   new CleanUpTest(driver),
   new PermissionTest(driver),
   new QuizScopeTest(driver),
   new AdminScopeTest(driver),
   new PlayerScopeTest(driver)*/

    new BasicCurriculumAdminTest(driver),
    new UserManagementTest(driver),
    new CurriculumManagementTest(driver),
    new StudentCurriculumTest(driver)
  )

  override def afterAll(configMap: Map[String, Any]) {
    driver.quit()
  }
}
