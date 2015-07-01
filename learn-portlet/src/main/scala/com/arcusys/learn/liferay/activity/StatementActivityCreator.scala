package com.arcusys.learn.liferay.activity

import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.valamis.lrs.serializer.StatementSerializer
import com.arcusys.valamis.lrs.tincan.{Activity, Statement}
import com.arcusys.valamis.settings.service.LRSToActivitySettingService
import com.arcusys.valamis.util.serialization.JsonHelper
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import scala.util.Try

trait StatementActivityCreator {
  def create(companyId: Long, statementString: String, userId: Long): Unit
}

class StatementActivityCreatorImpl(implicit val bindingModule: BindingModule)
  extends StatementActivityCreator with Injectable {
  private lazy val lrsToActivitySettingService = inject[LRSToActivitySettingService]

  def create(companyId: Long, statementString: String, userId: Long): Unit =
    Try {JsonHelper.fromJson[Statement](statementString, new StatementSerializer)}
      .map { statement =>
        val lrsToActivityMappers = lrsToActivitySettingService.getAll
        val matchedMappers =
          lrsToActivityMappers.filter { lrsToActivitySetting =>
            val isActivityMatched =
              lrsToActivitySetting.mappedActivity.isEmpty || (statement.obj match {
                case act: Activity => lrsToActivitySetting.mappedActivity.get == act.id
                case _ => false
              })

            val isVerbMatched =
              lrsToActivitySetting.mappedVerb.isEmpty ||
                (lrsToActivitySetting.mappedVerb.get == statement.verb.id)

            isActivityMatched && isVerbMatched
          }

        if(matchedMappers.nonEmpty)
          SocialActivityLocalServiceHelper.addWithSet(
            companyId,
            userId,
            classOf[Statement].getName,
            extraData = statement.id.map(_.toString))
    }
}