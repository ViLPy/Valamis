package com.arcusys.learn.achievements

import org.scalatest.FlatSpec
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory
import org.junit.runner.RunWith
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.models.Lms2PortletConverters._
import com.arcusys.learn.models.UserModel

//
// Created by iliya.tryapitsin on 04.02.14.
//
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class Lms2PortletConvertersTest extends FlatSpec with MockFactory with ProxyMockFactory {
  it should "should convert Liferay user entity to achievement portlet user model" in {
    val liferayUser = mock[LUser]

    val userId: Long = 1000
    val userFullname: String = "Test"
    val userEmail: String = "Test email"
    liferayUser.expects('getUserId).returning(userId)
    liferayUser.expects('getFullName).returning(userFullname)
    liferayUser.expects('getEmailAddress).returning(userEmail)

    val user: UserModel = liferayUser
    assert(user.id == userId)
    assert(user.email == userEmail)
    assert(user.name == userFullname)
  }

  it should "should convert Liferay users entity to achievement portlet users model" in {
    val liferayUser = mock[LUser]

    val userId: Long = 1000
    val userFullname: String = "Test"
    val userEmail: String = "Test email"
    liferayUser.expects('getUserId).returning(userId)
    liferayUser.expects('getFullName).returning(userFullname)
    liferayUser.expects('getEmailAddress).returning(userEmail)

    val liferayUsers = List(liferayUser)

    val users: List[UserModel] = liferayUsers
    assert(users.size == liferayUsers.size)
  }
}
