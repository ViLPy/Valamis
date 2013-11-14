package com.arcusys.learn.base

import org.openqa.selenium._
import java.util.concurrent.TimeUnit

trait LoginSupport extends UITestBase {
  val driver: WebDriver

  private val adminLogin = "test@liferay.com"
  private val adminPassword = "test"

  protected val studentLogin = "student@liferay.com"
  private val studentPassword = "test"

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
    val loginField = driver.findElement(By.id("_58_login"))
    val passwordField = driver.findElement(By.id("_58_password"))
    val loginForm = driver.findElement(By.id("_58_fm"))

    loginField.clear()
    loginField.sendKeys(name)
    passwordField.clear()
    passwordField.sendKeys(password)
    loginForm.submit()

    driver.manage.timeouts.implicitlyWait(10, TimeUnit.SECONDS)
  }
}
