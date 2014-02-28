package com.arcusys.learn.liferay.helpers

import com.liferay.portal.kernel.search.BaseIndexer
import com.liferay.portal.security.permission.PermissionChecker

trait IndexerHelper extends BaseIndexer {
  override def hasPermission(permissionChecker: PermissionChecker, entryClassName: String, entryClassPK: Long, actionId: String): Boolean = {
    true
  }
}
