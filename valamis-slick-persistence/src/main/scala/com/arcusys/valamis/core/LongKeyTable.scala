package com.arcusys.valamis.core

import DbNameUtils._

trait LongKeyTableComponent { self: SlickProfile =>
  import driver.simple._
  abstract class LongKeyTable[E](tag: Tag, name: String, useAutoInc: Boolean = true) extends Table[E](tag, tblName(name)) {
    def id = if (useAutoInc) column[Long](idName, O.PrimaryKey, O.AutoInc) else column[Long](idName, O.PrimaryKey)
  }
}

