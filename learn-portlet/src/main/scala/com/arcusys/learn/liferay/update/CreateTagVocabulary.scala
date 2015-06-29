package com.arcusys.learn.liferay.update

/**
 * Created by aklimov on 05.02.15.
 */

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.services.{ AssetCategoryLocalServiceHelper, AssetVocabularyLocalServiceHelper, GroupLocalServiceHelper, UserLocalServiceHelper }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.kernel.events.SimpleAction
import com.liferay.portal.kernel.log.{ Log, LogFactoryUtil }
import com.liferay.portlet.asset.NoSuchVocabularyException

class CreateTagVocabulary(configuration: BindingModule) extends SimpleAction with Injectable {
  implicit val bindingModule = configuration

  def this() = this(Configuration)
  private val _log: Log = LogFactoryUtil.getLog(classOf[CreateTagVocabulary])

  override def run(companyIds: Array[String]): Unit = {
    companyIds.foreach(companyId => {
      val defaultUserId = UserLocalServiceHelper().getDefaultUserId(companyId.toLong)

      createTagVocabulary(companyId.toLong, defaultUserId)
    })
  }

  private def createTagVocabulary(companyId: Long, userId: Long) {
    val vocabularyName = "ValamisPackageTags"
    val globalGroupId = GroupLocalServiceHelper.getCompanyGroup(companyId).getGroupId

    try {
      GroupLocalServiceHelper.getGroupVocabulary(globalGroupId, vocabularyName)
    } catch {
      case e: NoSuchVocabularyException =>
        AssetVocabularyLocalServiceHelper.addAssetVocabulary(companyId, vocabularyName)
    }
  }
}
