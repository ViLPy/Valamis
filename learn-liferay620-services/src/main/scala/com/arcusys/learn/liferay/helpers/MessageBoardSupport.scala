package com.arcusys.learn.liferay.helpers

import com.liferay.portal.kernel.util._
import com.liferay.portal.service.ServiceContext
import com.liferay.portlet.messageboards.service.{ MBThreadLocalServiceUtil, MBDiscussionLocalServiceUtil, MBMessageLocalServiceUtil, MBCategoryLocalServiceUtil }
import java.util
import java.io.InputStream

trait MessageBoardSupport {
  def addMBCategory(userId: Long, name: String, description: String, serviceContext: ServiceContext) = {
    MBCategoryLocalServiceUtil.addCategory(
      userId, 0, name, description, StringPool.BLANK, StringPool.BLANK,
      StringPool.BLANK, StringPool.BLANK, 0, false, StringPool.BLANK,
      StringPool.BLANK, 1, StringPool.BLANK, false, StringPool.BLANK, 0, false,
      StringPool.BLANK, StringPool.BLANK, false, false, serviceContext)
  }

  def addMBMessage(userId: Long, userName: String, groupId: Long, categoryId: Long,
    threadId: Long, parentMessageId: Long, subject: String, fileName: String, serviceContext: ServiceContext) = {

    val body = HookHelpers.getString(fileName)

    MBMessageLocalServiceUtil.addMessage(
      userId, userName, groupId, categoryId, threadId, parentMessageId,
      subject, body, "bbcode", new util.ArrayList[ObjectValuePair[String, InputStream]](),
      false, -1.0, false, serviceContext)
  }

  def addMBDiscussionMessage(userId: Long, userName: String, groupId: Long, className: String, classPK: Long,
    threadId: Long, parentMessageId: Long, subject: String, fileName: String,
    serviceContext: ServiceContext) = {

    val body = HookHelpers.getString(fileName)
    val threadID = MBDiscussionLocalServiceUtil.getDiscussion(className, classPK).getThreadId
    MBMessageLocalServiceUtil.addDiscussionMessage(userId, userName, groupId, className, classPK, threadID,
      MBThreadLocalServiceUtil.getMBThread(threadID).getRootMessageId, subject, body, serviceContext)
  }
}