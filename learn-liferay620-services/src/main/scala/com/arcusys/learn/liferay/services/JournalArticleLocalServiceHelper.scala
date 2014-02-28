package com.arcusys.learn.liferay.services

import com.liferay.portal.theme.ThemeDisplay
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil
import com.liferay.portlet.journal.model.JournalArticle
import java.io.File
import com.liferay.portal.service.ServiceContext
import java.util.Locale

object JournalArticleLocalServiceHelper {
  def getArticleContent(groupId: Long,
                        articleId: String,
                        viewMode: String,
                        languageId: String,
                        themeDisplay: ThemeDisplay): String =
    JournalArticleLocalServiceUtil.getArticleContent(groupId, articleId, viewMode, languageId, themeDisplay)


  def getArticle(groupId: Long, articleId: String): JournalArticle =
    JournalArticleLocalServiceUtil.getArticle(groupId, articleId)

  def getCompanyArticles(companyId: Long,
                         status: Int,
                         start: Int,
                         end: Int): java.util.List[JournalArticle] =
    JournalArticleLocalServiceUtil.getCompanyArticles(companyId, status, start, end)

  def addArticle(userId: Long, groupId: Long, folderId: Long, classNameId: Long,
                 classPK: Long, articleId: String, autoArticleId: Boolean, version: Double,
                 titleMap: java.util.Map[Locale, String], descriptionMap: java.util.Map[Locale, String],
                 content: String, articleType: String, ddmStructureKey: String, ddmTemplateKey: String, layoutUuid: String,
                 displayDateMonth: Int, displayDateDay: Int, displayDateYear: Int, displayDateHour: Int, displayDateMinute: Int,
                 expirationDateMonth: Int, expirationDateDay: Int, expirationDateYear: Int, expirationDateHour: Int, expirationDateMinute: Int, neverExpire: Boolean,
                 reviewDateMonth: Int, reviewDateDay: Int, reviewDateYear: Int, reviewDateHour: Int, reviewDateMinute: Int, neverReview: Boolean,
                 indexable: Boolean, smallImage: Boolean, smallImageURL: String, smallImageFile: File,
                 images: java.util.Map[String, Array[Byte]], articleURL: String, serviceContext: ServiceContext): JournalArticle =
    JournalArticleLocalServiceUtil.addArticle(userId, groupId, folderId, classNameId, classPK, articleId, autoArticleId,
      version, titleMap, descriptionMap, content, articleType, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth,
      displayDateDay, displayDateYear, displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay,
      expirationDateYear, expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay,
      reviewDateYear, reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL,
      smallImageFile, images, articleURL, serviceContext)

  def updateStatus(userId: Long,
                   groupId: Long,
                   articleId: String,
                   version: Double,
                   status: Int,
                   articleURL: String,
                   workflowContext: java.util.Map[String, java.io.Serializable],
                   serviceContext: ServiceContext): JournalArticle =
    JournalArticleLocalServiceUtil.updateStatus(userId, groupId, articleId, version, status,
      articleURL, workflowContext, serviceContext)
}
