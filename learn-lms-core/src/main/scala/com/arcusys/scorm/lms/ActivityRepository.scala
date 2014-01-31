package com.arcusys.scorm.lms

import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil._
import scala.collection.JavaConverters._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

/**
 * Created with IntelliJ IDEA.
 * User: iliya.tryapitsin
 * Date: 10.01.14
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
class ActivityRepository(implicit val bindingModule: BindingModule) extends ActivityRepositoryContract
  with Injectable {

    def get(): scala.collection.mutable.Buffer[String] = {
      var set = Set[String]()
      SocialActivityLocalServiceUtil.getSocialActivities(ALL_POS,ALL_POS)
        .asScala
        .map(_.getClassName)
        .filterNot({ (obj: String) =>
          val b = set(obj);
          set += obj;
          b })
    }
}
