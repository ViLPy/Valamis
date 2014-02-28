package com.arcusys.learn.liferay.services

import com.liferay.portal.service.{LayoutSetPrototypeLocalServiceUtil, ServiceContext}
import java.util.Locale
import com.liferay.portal.model.LayoutSetPrototype
import scala.collection.JavaConverters._

object LayoutSetPrototypeLocalServiceHelper {
  def addLayoutSetPrototype(userId: Long,
                            companyId: Long,
                            nameMap: Map[Locale, String],
                            description: String,
                            active: Boolean,
                            layoutsUpdateable: Boolean,
                            serviceContext: ServiceContext): LayoutSetPrototype =
    LayoutSetPrototypeLocalServiceUtil.addLayoutSetPrototype(userId, companyId, nameMap.asJava, description, active, layoutsUpdateable, serviceContext)
}
