package com.arcusys.learn.base

import org.openqa.selenium._

trait LoginSupport extends UITestBase {
  val driver: WebDriverArcusys

  def loginAsAdmin() {
    login(adminLogin, adminPassword)
  }

  def loginAsStudent() {
    login(studentLogin, studentPassword)
  }

  def logout() {
    driver.get(baseUrl + "/c/portal/logout")
  }

  private def login(name: String, password: String) {
    driver.get(baseUrl + "/c/portal/login")
    val loginField = driver.getVisibleElementAfterWaitBy(By.id("_58_login"))
    val passwordField = driver.getVisibleElementAfterWaitBy(By.id("_58_password"))
    val loginForm = driver.getVisibleElementAfterWaitBy(By.id("_58_fm"))

    loginField.clear()
    loginField.sendKeys(name)
    passwordField.clear()
    passwordField.sendKeys(password)
    loginForm.submit()

    driver.getVisibleElementAfterWaitBy(By.className("dockbar"))

//    driver.manage.timeouts.implicitlyWait(10,TimeUnit.SECONDS) // TODO: remove after test refactoring
  }
}
