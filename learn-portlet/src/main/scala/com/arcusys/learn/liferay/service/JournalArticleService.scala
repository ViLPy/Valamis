package com.arcusys.learn.liferay.service

import com.arcusys.learn.controllers.api.BaseApiController

import scala.collection.JavaConverters._
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.util.Locale
import com.arcusys.learn.liferay.services.JournalArticleLocalServiceHelper
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.{ QueryUtilHelper, WorkflowConstantsHelper }

class JournalArticleService(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[LJournalArticle](article =>
    Map("articleID" -> article.getArticleId,
      "groupID" -> article.getGroupId.toString,
      "version" -> article.getVersion.toString,
      "availableLocales" -> article.getAvailableLocales.map(localeStr => {
        val localeSplit = localeStr.split('_')
        val locale = if (localeSplit.size > 1) new Locale(localeSplit(0), localeSplit(1)) else new Locale(localeSplit.head)
        localeStr -> Map("language" -> locale.getDisplayLanguage, "country" -> locale.getDisplayCountry)
      }).toMap,
      "titles" -> article.getAvailableLocales.map(locale => locale -> article.getTitle(locale)).toMap)
  )

  get("/") {
    jsonModel(getJournalArticles)
  }

  private def getJournalArticles = {
    val companyID = parameter("companyID").longRequired
    JournalArticleLocalServiceHelper.getCompanyArticles(companyID,
      WorkflowConstantsHelper.STATUS_APPROVED, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS).asScala
      // get last approved version
      .groupBy {
        article => (article.getArticleId, article.getGroupId)
      }.values.map { _.maxBy(_.getVersion) }.toSeq

    /*
    // will get only last version of article, ignore previous edits
    val subQuery = DynamicQueryFactoryUtil.forClass(classOf[JournalArticle], "articleSub", PortalClassLoaderUtil.getClassLoader)
      .add(PropertyFactoryUtil.forName("articleId").eqProperty("articleParent.articleId"))
      .setProjection(ProjectionFactoryUtil.max("id"))

    val query = DynamicQueryFactoryUtil.forClass(classOf[JournalArticle], "articleParent", PortalClassLoaderUtil.getClassLoader)
      .add(PropertyFactoryUtil.forName("id").eq(subQuery))
      .addOrder(OrderFactoryUtil.desc("createDate"))

    JournalArticleLocalServiceUtil.dynamicQuery(query).asScala.map(_.asInstanceOf[JournalArticle])
*/
  }
}
