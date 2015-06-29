package com.arcusys.valamis.core

import scala.slick.driver.JdbcProfile

trait SlickProfile {
  val driver: JdbcProfile
}
