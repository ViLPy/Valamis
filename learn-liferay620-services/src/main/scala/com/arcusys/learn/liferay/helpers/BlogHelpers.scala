package com.arcusys.learn.liferay.helpers

import com.liferay.portal.kernel.util._
import com.liferay.portal.service.ServiceContext
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil
import scala.Array

trait BlogHelpers {
  def addBlogsEntry(userId: Long, title: String, fileName: String,
    serviceContext: ServiceContext, replacement: Map[String, String] = Map()) = {
    val content = if (replacement.isEmpty) {
      HookHelpers.getString(fileName)
    } else {
      replacement.foldLeft(HookHelpers.getString(fileName)) {
        (src, param) => src.replaceAll(param._1, param._2)
      }
    }

    BlogsEntryLocalServiceUtil.addEntry(
      userId, title, StringPool.BLANK, content, 1, 1, 2013, 0, 0, false, false,
      Array[String](), false, StringPool.BLANK, StringPool.BLANK, null, serviceContext)
  }
}