package com.arcusys.learn.storage

object DBType extends Enumeration {
  type DBType = Value
  val Postgres = Value("psql")
  val H2 = Value("h2")
}
