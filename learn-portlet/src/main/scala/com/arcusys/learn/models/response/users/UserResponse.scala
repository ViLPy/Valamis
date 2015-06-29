package com.arcusys.learn.models.response.users

import com.arcusys.learn.liferay.LiferayClasses.LUser

case class UserResponse(
  id: Long,
  name: String,
  picture: String,
  pageUrl: String
)

trait UserConverter {
  def toResponse(lUser: LUser): UserResponse = {
    UserResponse(
      id = lUser.getUserId,
      name = lUser.getFullName,
      picture = UserResponseUtils.getPortraitUrl(lUser),
      pageUrl = UserResponseUtils.getPublicUrl(lUser)
    )
  }
}