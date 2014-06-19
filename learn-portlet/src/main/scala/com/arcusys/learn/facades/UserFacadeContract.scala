package com.arcusys.learn.facades

import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.models.OrgResponse

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
trait UserFacadeContract {
  private[facades] def all(companyId: Int): Seq[LUser]

  def all(courseId: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[LUser]

  def byId(id: Int): LUser

  def all(companyID: Long,
    orgID: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[UserShortResponse]

  def byId(id: Int, isShortResult: Boolean, withOpenBadges: Boolean): AnyRef

  def byPermission(permissionType: PermissionType): Seq[UserShortResponse]

  def count(companyId: Long,
    orgID: Long,
    filter: String): Int

  def orgs(): Seq[OrgResponse]
}
