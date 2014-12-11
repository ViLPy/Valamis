package com.arcusys.learn.liferay.services

import com.liferay.portlet.social.model.SocialActivityCounter

import scala.collection.JavaConverters._
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil
import com.liferay.portlet.social.service.SocialActivityCounterLocalServiceUtil

/**
 * Created by mminin on 29.08.14.
 */
object SocialActivityCounterLocalServiceHelper {
  def getUserValue(userId: Long, counterNames: String): Option[Int] = {

    SocialActivityCounterLocalServiceUtil.dynamicQuery(SocialActivityCounterLocalServiceUtil.dynamicQuery
      .add(RestrictionsFactoryUtil.eq("classPK", userId)) // user Id in classpk column
      .add(RestrictionsFactoryUtil.eq("name", counterNames))
    )
      .asScala
      .filter(_.isInstanceOf[SocialActivityCounter])
      .map(_.asInstanceOf[SocialActivityCounter].getTotalValue).toSeq match {
        case Nil              => None
        case values: Seq[Int] => Some(values.sum)
      }
  }
}
