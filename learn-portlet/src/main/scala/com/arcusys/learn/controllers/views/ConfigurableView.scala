package com.arcusys.learn.controllers.views

import com.arcusys.learn.bl.services.{ UserRoleServiceContract }
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.ioc.Configuration
import com.arcusys.scorm.lms.PackageService

/**
 * Created with IntelliJ IDEA.
 * User: dkudinov
 * Date: 27.2.2013
 * Time: 15.00
 */
trait ConfigurableView extends Injectable {

  implicit val bindingModule = Configuration

  val userRoleService = inject[UserRoleServiceContract]
  val packageService = new PackageService()

}
