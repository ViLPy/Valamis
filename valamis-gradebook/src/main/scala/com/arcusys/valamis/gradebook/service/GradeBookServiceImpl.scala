package com.arcusys.valamis.gradebook.service

import com.arcusys.valamis.lesson.service.ValamisPackageService
import com.arcusys.valamis.uri.service.URIServiceContract
import com.arcusys.valamis.util.Joda
import Joda._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.model.StatementFilter
import com.arcusys.valamis.lrs.tincan.Statement
import com.arcusys.valamis.lrs.util.{ StatementApiHelpers, TinCanVerbs, TincanHelper }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import StatementApiHelpers._

class GradeBookServiceImpl(implicit val bindingModule: BindingModule) extends Injectable with GradeBookService {

  private val packageService = inject[ValamisPackageService]
  private val uriService = inject[URIServiceContract]

  def getStatementGrades(statementApi: StatementApi, packageId: Long, valamisUserId: Int, sortAsc: Boolean = false, shortMode: Boolean = false): Seq[Statement] = {

    val agent = TincanHelper.getAgentByEmail(UserLocalServiceHelper().getUser(valamisUserId).getEmailAddress)
    val activityIds = packageService.getRootActivityIds(packageId)
    val statements =
      activityIds.flatMap(actId => {
        val filter = StatementFilter(
          agent = Option(agent),
          activity = Option(actId),
          relatedActivities = Option(true),
          limit = Option(25)
        )

        statementApi.getByFilter(filter)
          .filter(st => !shortMode || TincanHelper.isVerbType(st.verb, TinCanVerbs.Answered) || TincanHelper.isAcivityWithId(st, actId))
      })
        .sortBy(_.timestamp)

    if (!sortAsc)
      statements.reverse
    else
      statements
  }

}
