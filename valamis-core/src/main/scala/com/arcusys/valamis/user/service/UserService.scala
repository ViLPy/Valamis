package com.arcusys.valamis.user.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.valamis.model.{RangeResult, SkipTake}
import com.arcusys.valamis.user.model.User
import com.liferay.portal.model.Organization

/**
 * User: Yulia.Glushonkova
 * Date: 14.10.2014
 */
trait UserService {
  def all(companyId: Int): Seq[LUser]

  def all(courseId: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[LUser]

  def byId(id: Long): LUser

  def byIds(companyId: Long, ids: Set[Long]): Set[LUser]

  def all(companyId: Long,
    orgId: Option[Long],
    skipTake: Option[SkipTake],
    filter: String,
    sortAZ: Boolean): RangeResult[LUser]

  def getByName(name: String, companyId: Long): Seq[User]

  def getByIds(companyId: Long, ids: Set[Long]): Seq[User]

  def orgs(): Seq[Organization]

  def getUserOption(userId: Int): Option[User]

  def createAndGetId(userId: Int, name: String)

  def getUsersWithAttemptsByCourseID(courseID: Long)
}
