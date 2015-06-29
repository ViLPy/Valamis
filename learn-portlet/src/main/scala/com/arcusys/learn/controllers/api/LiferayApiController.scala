package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.LiferayFacade
import com.arcusys.learn.liferay.permission.PermissionUtil
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.LiferayRequest
import com.arcusys.learn.exceptions.BadRequestException

/**
 * User: Yulia.Glushonkova
 * Date: 11.07.14
 */
class LiferayApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)
  val liferayFacade = new LiferayFacade(configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/liferay(/)") {
    val lfRequest = LiferayRequest(this)

    lfRequest.action match {
      case "GETIMAGES" => {
        jsonAction {
          liferayFacade.getImages(
            PermissionUtil.getLiferayUser,
            lfRequest.courseId,
            lfRequest.filter,
            lfRequest.page,
            lfRequest.skip,
            lfRequest.count,
            lfRequest.isSortDirectionAsc)
        }
      }
      case "GETVIDEO" => {
        jsonAction {
          liferayFacade.getVideo(
            PermissionUtil.getLiferayUser,
            lfRequest.courseId,
            lfRequest.page,
            lfRequest.skip,
            lfRequest.count
          )
        }
      }
      case _ => throw new BadRequestException
    }
  }
}
