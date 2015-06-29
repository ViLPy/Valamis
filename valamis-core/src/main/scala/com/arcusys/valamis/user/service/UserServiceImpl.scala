package com.arcusys.valamis.user.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.{OrganizationLocalServiceHelper, UserLocalServiceHelper}
import com.arcusys.valamis.model.{RangeResult, SkipTake}
import com.arcusys.valamis.user.model.User
import com.arcusys.valamis.user.storage.UserStorage
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import com.liferay.portal.model.Organization
import scala.collection.JavaConversions._

import scala.collection.JavaConverters._

// TODO: refactor (get by id)
class UserServiceImpl(
    implicit val bindingModule: BindingModule)
  extends UserService
  with UserConverter
  with Injectable {

  val userStorage = inject[UserStorage]

  def all(courseId: Long, skip: Int, take: Int, filter: String, sortAZ: Boolean): Seq[LUser] = {
    var users = UserLocalServiceHelper()
      .getGroupUsers(courseId)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .sortBy(x => x.getFullName)

    users = users.filter(x => if (filter != "") x.getFullName.toLowerCase.contains(filter.toLowerCase) else true)

    if (!sortAZ) users = users.reverse

    if (skip < 0)
      users
    else
      users.drop(skip).take(take)
  }

  def all(companyId: Long,
          orgId: Option[Long],
          skipTake: Option[SkipTake],
          filter: String,
          sortAZ: Boolean): RangeResult[LUser] = {

    var users = UserLocalServiceHelper()
      .getCompanyUsers(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .sortBy(x => x.getFullName)

    users = users.filter(x => x.getFullName.toLowerCase.contains(filter.toLowerCase))

    for (id <- orgId)
      users = users.filter(u =>
        u.getOrganizations.asScala.map(_.getOrganizationId).contains(id)
      )

    if (!sortAZ)
      users = users.reverse

    val count = users.length

    for (
      SkipTake(skip, take) <- skipTake
      if skip >= 0
    ) {
      users = users.drop(skip).take(take)
    }

    RangeResult(count, users)
  }

  def byId(id: Long): LUser = UserLocalServiceHelper().getUser(id)

  def byIds(companyId: Long, ids: Set[Long]): Set[LUser] =
    UserLocalServiceHelper()
      .getCompanyUsers(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .filter(user => ids.contains(user.getUserId))
      .toSet

  def getByName(name: String, companyId: Long) =
    all(companyId.toInt)
      .filter(_.getFullName.toLowerCase.contains(name.toLowerCase))
      .map(toModel)

  def getByIds(companyId: Long, ids: Set[Long]): Seq[User] =
    UserLocalServiceHelper()
      .getCompanyUsers(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .filter(user => ids.contains(user.getUserId))
      .map(toModel)

  def orgs(): Seq[Organization] = {
    OrganizationLocalServiceHelper
      .getOrganizations(QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
  }

  override def all(companyId: Int): Seq[LUser] = UserLocalServiceHelper()
    .getCompanyUsers(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
    .asScala
    .filter(u => u.isActive && u.getFullName != "")

  def getUserOption(userId: Int): Option[User] = {
    userStorage.getByID(userId)
  }

  // TODO rename
  def createAndGetId(userId: Int, name: String): Unit = {
    userStorage.createAndGetID(new User(userId, name))
  }

  override def getUsersWithAttemptsByCourseID(courseID: Long) = {
    def getAllRawUsers = {
      val users = UserLocalServiceHelper().getGroupUsers(courseID)
      for (i <- 0 to users.size - 1) yield users.get(i)
    }

    def getUsersByRole: IndexedSeq[User] = {
      val scormUsers = userStorage.getUsersWithAttempts.filter(_ != null)
      for {
        user: LUser <- getAllRawUsers
        if scormUsers.count(scUser => scUser.id == user.getUserId) > 0
      } yield scormUsers.filter(scUser => scUser.id == user.getUserId).head
    }
  }
}

trait UserConverter {
  def toModel(lUser: LUser) = User(lUser.getUserId.toInt, lUser.getFullName)
}