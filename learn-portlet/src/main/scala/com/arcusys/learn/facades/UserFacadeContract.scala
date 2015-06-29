package com.arcusys.learn.facades

import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.learn.models.OrgResponse
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.{RangeResult, SkipTake}

trait UserFacadeContract {

  def all(courseId: Long, skip: Int, take: Int, filter: String, sortAZ: Boolean): Seq[LUser]

  def byId(id: Long): LUser

  def all(companyId: Long, orgId: Option[Long], skipTake: Option[SkipTake], filter: String, sortAZ: Boolean): RangeResult[UserShortResponse]

  def byId(statementApi: StatementApi, id: Long, isShortResult: Boolean, withOpenBadges: Boolean): AnyRef

  // def byPermission(permissionType: PermissionType): Seq[UserShortResponse]
  def allCanView(viewAll: Boolean): Seq[UserShortResponse]

  def canView(user: LUser, viewAll: Boolean): Boolean

  def canView(userId: Long, viewAll: Boolean): Boolean

  def orgs(): Seq[OrgResponse]

  def getUserShortInfo(id:Long): UserShortResponse

}
