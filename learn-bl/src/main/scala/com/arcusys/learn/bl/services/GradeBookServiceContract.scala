package com.arcusys.learn.bl.services

import com.arcusys.learn.tincan.model.Statement

/**
 * Created by igorborisov on 15.10.14.
 */
trait GradeBookServiceContract {

  def getStatementGrades(packageId: Int, valamisUserId: Int, sortAsc: Boolean = false): Seq[Statement]
}
