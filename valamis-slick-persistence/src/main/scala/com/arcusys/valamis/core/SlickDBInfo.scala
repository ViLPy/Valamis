package com.arcusys.valamis.core

import javax.sql.DataSource

import scala.slick.driver.{JdbcDriver, JdbcProfile}
import scala.slick.jdbc.JdbcBackend

trait SlickDBInfo {
  def dataSource: DataSource

  def slickDriver: JdbcDriver
  def slickProfile: JdbcProfile

  def databaseDef: JdbcBackend#DatabaseDef
}