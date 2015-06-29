package com.arcusys.learn.liferay.activity

import com.arcusys.learn.liferay.LBaseSocialActivityInterpreter
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrs.tincan.{AuthorizationScope, Statement, Activity}
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.StringPoolHelper
import java.util.UUID

object StatementActivityInterpreter {
  val _CLASS_NAMES = Seq[String](classOf[Statement].getName).toArray
}

class StatementActivityInterpreter extends LBaseSocialActivityInterpreter with Injectable {
  implicit val bindingModule = Configuration
  lazy val lrsReader = inject[LrsClientManager]

  override protected def doInterpret(activity: LSocialActivity, context: Context): LSocialActivityFeedEntry = {
    val lrsAuth = lrsReader.getLrsEndpointInfo(AuthorizationScope.All).auth
    val forUser = getUser(context)
    val creatorUserName = getUserName(activity.getUserId, context)

    val statement = lrsReader.statementApi(_.getStatementById(UUID.fromString(activity.getExtraData)), lrsAuth).get

    val activityName = statement.obj match {
      case activity: Activity =>
        // receive activity name from lang map for user locale, or get first
        activity.name.map(name => name.getOrElse(forUser.getLanguageId, name.head._2)).getOrElse("Unknown activity name")
      case _ => ""
    }
    val verbName = statement.verb.display.getOrElse(forUser.getLanguageId, statement.verb.display.head._2)

    val sb = new StringBuilder
    sb.append(creatorUserName + " ")
    sb.append(verbName + " ")
    sb.append(activityName + " ")
    new LSocialActivityFeedEntry(sb.toString(), StringPoolHelper.BLANK)
  }

  def getClassNames = StatementActivityInterpreter._CLASS_NAMES
}
