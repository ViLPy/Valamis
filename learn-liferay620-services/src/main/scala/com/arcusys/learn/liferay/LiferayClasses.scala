package com.arcusys.learn.liferay

import com.liferay.portal.kernel.upgrade.UpgradeProcess
import com.liferay.portal.kernel.util.UnicodeProperties
import com.liferay.portal.model._
import com.liferay.portlet.social.model.{ SocialActivityFeedEntry, SocialActivity }
import com.liferay.portlet.journal.model.JournalArticle
import com.liferay.portal.theme.ThemeDisplay
import com.liferay.portal.{ NoSuchLayoutException, NoSuchGroupException, NoSuchRoleException }
import com.liferay.portlet.asset.model.{ BaseAssetRenderer, AssetEntry, BaseAssetRendererFactory }
import com.liferay.portal.security.permission.PermissionChecker
import com.liferay.portal.kernel.portlet.{ LiferayPortletResponse, LiferayPortletRequest }
import com.liferay.portal.kernel.struts.{ StrutsAction, BaseStrutsAction }
import com.liferay.portal.kernel.search._
import com.liferay.portal.kernel.dao.orm.DynamicQuery
import com.liferay.portlet.asset.NoSuchEntryException
import com.liferay.portal.service.{ BaseLocalService, ServiceContext }
import com.liferay.portal.kernel.bean.BeanLocator
import com.liferay.portlet.trash.DuplicateEntryException

object LiferayClasses {
  type LAssetEntry = AssetEntry
  type LBeanLocator = BeanLocator
  type LBaseAssetRenderer = BaseAssetRenderer
  type LBaseAssetRendererFactory = BaseAssetRendererFactory
  type LBaseIndexer = BaseIndexer
  type LBaseLocalService = BaseLocalService
  type LBaseModel[T] = BaseModel[T]
  type LBaseModelListener[T <: com.liferay.portal.model.BaseModel[T]] = BaseModelListener[T]
  type LBaseStrutsAction = BaseStrutsAction
  type LBooleanQuery = BooleanQuery
  type LDocument = Document
  type LDocumentImpl = DocumentImpl
  type LDynamicQuery = DynamicQuery
  type LGroup = Group
  type LHits = Hits
  type LHitsOpenSearchImpl = HitsOpenSearchImpl
  type LJournalArticle = JournalArticle
  type LLayout = Layout
  type LLayoutTypePortlet = LayoutTypePortlet
  type LLiferayPortletRequest = LiferayPortletRequest
  type LLiferayPortletResponse = LiferayPortletResponse
  type LPermissionChecker = PermissionChecker
  type LSearchContext = SearchContext
  type LServiceContext = ServiceContext
  type LSocialActivity = SocialActivity
  type LSocialActivityFeedEntry = SocialActivityFeedEntry
  type LStrutsAction = StrutsAction
  type LSummary = Summary
  type LThemeDisplay = ThemeDisplay
  type LUnicodeProperties = UnicodeProperties
  type LUpgradeProcess = UpgradeProcess
  type LUser = User

  // Exceptions
  type LNoSuchRoleException = NoSuchRoleException
  type LNoSuchGroupException = NoSuchGroupException
  type LNoSuchEntryException = NoSuchEntryException
  type LNoSuchLayoutException = NoSuchLayoutException
  type LDuplicateEntryException = DuplicateEntryException
}
