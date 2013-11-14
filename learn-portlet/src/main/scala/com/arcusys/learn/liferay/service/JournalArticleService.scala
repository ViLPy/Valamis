package com.arcusys.learn.liferay.service

import com.liferay.portal.kernel.dao.orm._
import com.liferay.portlet.journal.model.JournalArticle
import com.liferay.portal.kernel.util.PortalClassLoaderUtil
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil
import scala.collection.JavaConverters._
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.util.Locale
import com.liferay.portal.util.PortalUtil
import com.liferay.portal.kernel.workflow.WorkflowConstants

class JournalArticleService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[JournalArticle](article =>
    Map("articleID" -> article.getArticleId,
      "groupID" -> article.getGroupId.toString,
      "version"->article.getVersion.toString,
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
    JournalArticleLocalServiceUtil.getCompanyArticles(companyID,
      WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS, QueryUtil.ALL_POS).asScala
      // get last approved version
      .groupBy{
      article => (article.getArticleId, article.getGroupId)
      }.values.map {_.maxBy(_.getVersion)}.toSeq

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
