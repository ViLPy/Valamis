package com.arcusys.learn.liferay.interpreter

import com.arcusys.learn.tincan.storage.StatementStorage
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.ioc.Configuration
import scala.Predef._
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.StringPoolHelper
import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.tincan.model.{ Statement, Activity }
import java.util.UUID

object StatementActivityInterpreter {
  val _CLASS_NAMES = Seq[String](classOf[Statement].getName).toArray
}

class StatementActivityInterpreter extends LBaseSocialActivityInterpreter with Injectable {
  implicit val bindingModule = Configuration
  private val statementStorage = inject[StatementStorage]

  override protected def doInterpret(activity: LSocialActivity, themeDisplay: LThemeDisplay): LSocialActivityFeedEntry = {
    val forUser = themeDisplay.getUser
    val creatorUserName = getUserName(activity.getUserId, themeDisplay)
    val statement = statementStorage.getByUUID(UUID.fromString(activity.getExtraData)).getOrElse(throw new EntityNotFoundException)
    val titlePattern = "activity-passed-certificate"
    val title = themeDisplay.translate(titlePattern, null)
    val activityName = statement.obj match {
      case activity: Activity =>
        // receive activity name from lang map for user locale, or get first
        activity.name.map(name => name.get(forUser.getLanguageId).getOrElse(name.head._2))
      case _ => ""
    }
    val verbName = statement.verb.display.get(forUser.getLanguageId).getOrElse(statement.verb.display.head._2)

    val sb = new StringBuilder
    sb.append(creatorUserName + " ")
    sb.append(title + " ")
    sb.append(verbName + " ")
    sb.append(activityName + " ")
    new LSocialActivityFeedEntry(sb.toString(), StringPoolHelper.BLANK)
  }

  def getClassNames = StatementActivityInterpreter._CLASS_NAMES
}
