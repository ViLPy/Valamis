package com.arcusys.learn.base

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.openqa.selenium.firefox.FirefoxDriver
import com.arcusys.learn.admin.{PermissionTest, CleanUpTest, AdminTest}
import com.arcusys.learn.questionbank._
import com.arcusys.learn.quiz._
import com.arcusys.learn.player._
import com.arcusys.learn.scope.{GradeScopeTest, PlayerScopeTest, AdminScopeTest, QuizScopeTest}
import com.arcusys.learn.gradebook._
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities}
import com.arcusys.learn.curriculum._

@RunWith(classOf[JUnitRunner])
class UISuitTest extends Suites with LoginSupport with BeforeAndAfterAll {
//  //=======REMOTE IE=======
//      val capabilities = DesiredCapabilities.internetExplorer()
//      capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true) //TODO: check if needed
//      capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //TODO: check if needed
//      val driver = new RemoteWebDriver(new URL("http://10.93.97.20:4444/wd/hub"), capabilities) with WebDriverArcusys
//  //=======REMOTE IE=======

////  =======REMOTE CHROME=======
//      val dc = DesiredCapabilities.chrome()
//      dc.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true)
//      val driver = new RemoteWebDriver(new URL("http://10.93.97.20:4444/wd/hub"), dc) with WebDriverArcusys
////  =======REMOTE CHROME=======

////  =======REMOTE FIREFOX=======
//      val driver = new RemoteWebDriver(new URL("http://10.93.97.20:4444/wd/hub"), DesiredCapabilities.firefox()) with WebDriverArcusys
////  =======REMOTE FIREFOX=======

//  //  =======WINDOWS CHROME=======
//      System.setProperty("webdriver.chrome.driver", "learn-ui-test/src/test/resources/chromedriver_win")
//      val dc = new DesiredCapabilities()
//      dc.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true)
//      val driver = new ChromeDriver(dc) with WebDriverArcusys
//  //  =======WINDOWS CHROME=======
//
  //  =======WINDOWS IE=======
/*  System.setProperty("webdriver.ie.driver", "learn-ui-test/src/test/resources/IEDriverServer_32")
  val dc = new DesiredCapabilities()
  dc.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true)
  val driver = new InternetExplorerDriver(dc) with WebDriverArcusys*/
  //  =======WINDOWS IE=======

//  //  =======CHROME=======
//      System.setProperty("webdriver.chrome.driver", "learn-ui-test/src/test/resources/chromedriver")
//      val dc = new DesiredCapabilities()
//      dc.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true)
//      val driver = new ChromeDriver(dc) with WebDriverArcusys
//  //  =======CHROME=======

//  //=======FIREFOX=======
  val dc = new DesiredCapabilities()
  dc.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true)
  val driver = new FirefoxDriver(dc) with WebDriverArcusys
//  //=======FIREFOX=======

  override def beforeAll(configMap: Map[String, Any]) {
    loginAsAdmin()
    //    driver.init()
  }

  override val nestedSuites = collection.immutable.IndexedSeq(
    new AdminTest(driver),
    new BasicViewTest(driver),
    //new SearchTest(driver),

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

    new ViewedStateTest(driver),

    new CleanUpTest(driver),

    new PermissionTest(driver),
    new QuizScopeTest(driver),
    new AdminScopeTest(driver),
    new PlayerScopeTest(driver),
    new GradeScopeTest(driver),

    new BasicCurriculumAdminTest(driver),
    new UserManagementTest(driver),
    new CurriculumManagementTest(driver),
    new StudentCurriculumTest(driver),

    new ActivityCurriculumTest(driver),
    new CurriculumMetadataTest(driver),
    new MyAccountTest(driver)
  )

  override def afterAll(configMap: Map[String, Any]) {
    driver.quit()
  }
}
