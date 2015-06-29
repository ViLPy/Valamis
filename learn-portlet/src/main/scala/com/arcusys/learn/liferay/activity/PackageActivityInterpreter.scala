package com.arcusys.learn.liferay.activity

import java.util.Date

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LBaseSocialActivityInterpreter
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.valamis.lesson.model.PackageActivityType
import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.service.PackageService
import com.arcusys.valamis.lesson.tincan.model.TincanPackage
import com.arcusys.valamis.quiz.service.QuizService
import com.escalatesoft.subcut.inject.Injectable
import com.liferay.portlet.social.model.SocialActivity
import org.ocpsoft.prettytime.PrettyTime

object PackageActivityInterpreter {
  val ScormPackageClassName = classOf[ScormPackage].getName
  val TincanPackageClassName = classOf[TincanPackage].getName
  val ClassNames = Array[String](ScormPackageClassName, TincanPackageClassName)
}

class PackageActivityInterpreterLF extends PackageActivityInterpreter

class PackageActivityInterpreterSO extends PackageActivityInterpreter {
  override def getSelector() = "SO"
}

abstract class PackageActivityInterpreter extends LBaseSocialActivityInterpreter with Injectable {
  import PackageActivityInterpreter._
  implicit val bindingModule = Configuration

  lazy val quizService = inject[QuizService]
  lazy val packageService = inject[PackageService]

  def getVerb(value: Int) = PackageActivityType.apply(value) match {
    case PackageActivityType.Published => "published"
    case PackageActivityType.Shared => "shared"
  }

  override protected def doInterpret(activity: SocialActivity , context: Context): LSocialActivityFeedEntry = {
    val title = ""
    val body = activity.getClassName match {
      case TincanPackageClassName => renderTincanPackageFeedEntryBody(activity)
      case ScormPackageClassName => renderScormPackageFeedEntryBody(activity)
    }
    new LSocialActivityFeedEntry(title, body)
  }

  val prettyTime = new PrettyTime()
  private def renderFeedEntryBodyHelper[E <: {def id: Long; def title: String; def logo: Option[String]}](f: Long => E, activity: LSocialActivity) = {
    val model = f(activity.getClassPK)

    val userName = UserLocalServiceHelper().getUser(activity.getUserId).getFullName
    val verb = getVerb(activity.getType)

    val displayLogo = """<img style="width: 180px; height: 120px;" src="""" +
      (if(model.logo.isDefined && model.logo.get != "") s"""/delegate/files/images?folderId=package_logo_${model.id}&file=${model.logo.get}"/>"""
      else """/learn-portlet/img/imgo.jpg">""")

    s"""
       |<div><b>${userName}</b> $verb a lesson</div>
       |<div style="font-size: small; color: gray"> ${prettyTime.format(new Date(activity.getCreateDate))} </div>
       |<div style="margin: 10px 5px;"> ${activity.getExtraData} </div>
       |<div style="margin-bottom: 10px;"> ${displayLogo} <b> ${model.title} </b> </div>
    """.stripMargin
  }

  private def renderTincanPackageFeedEntryBody(activity: SocialActivity) = renderFeedEntryBodyHelper({ packageId =>
    val packageId = activity.getClassPK.toInt
    packageService.getTincanPackageById(packageId).get
  }, activity)

  private def renderScormPackageFeedEntryBody(activity: SocialActivity) = renderFeedEntryBodyHelper({ packageId =>
    val packageId = activity.getClassPK.toInt
    packageService.getScormPackageById(packageId).get
  }, activity)

  def getClassNames = ClassNames
}