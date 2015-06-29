package com.arcusys.valamis.gradebook.service

import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.tincan.Statement

/**
 * Created by igorborisov on 15.10.14.
 */
trait GradeBookService {

  def getStatementGrades(statementApi: StatementApi, packageId: Long, valamisUserId: Int, sortAsc: Boolean = false, shortMode: Boolean = false): Seq[Statement]
}
