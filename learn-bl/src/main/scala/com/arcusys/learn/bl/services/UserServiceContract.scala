package com.arcusys.learn.bl.services

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.liferay.portal.model.Organization
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.scorm.tracking.model.User

/**
 * User: Yulia.Glushonkova
 * Date: 14.10.2014
 */
trait UserServiceContract {
  private[services] def all(companyId: Int): Seq[LUser]

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
    sortAZ: Boolean): Seq[LUser]

  def byPermission(permissionType: PermissionType): Seq[LUser]

  def count(companyId: Long,
    orgID: Long,
    filter: String): Int

  def orgs(): Seq[Organization]

  def getUserCertificates(id: Int, lUser: LUser, withOpenBadges: Boolean): Seq[Certificate]

  def getUserOption(userId: Int): Option[User]

  def createAndGetId(userId: Int, name: String)
}
