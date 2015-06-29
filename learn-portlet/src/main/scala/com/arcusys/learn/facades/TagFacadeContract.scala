package com.arcusys.learn.facades

import com.arcusys.learn.models.TagResponse
import com.liferay.portlet.asset.model.AssetCategory

/**
 * Created by Yuriy Gatilin on 26.01.15.
 */
trait TagFacadeContract {
  def getAll(companyId: Long): Seq[TagResponse]
}
