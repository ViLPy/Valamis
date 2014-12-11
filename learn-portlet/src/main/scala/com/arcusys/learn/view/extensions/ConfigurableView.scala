package com.arcusys.learn.view.extensions

import com.arcusys.learn.bl.services.settings.SiteDependentSettingManager
import com.arcusys.learn.bl.services.{ UserServiceContract, UserRoleServiceContract }
import com.arcusys.learn.facades.PackageFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.scorm.lms.PackageService
import com.escalatesoft.subcut.inject.Injectable

/**
 * Created with IntelliJ IDEA.
 * User: dkudinov
 * Date: 27.2.2013
 * Time: 15.00
 */
trait ConfigurableView extends Injectable {

  implicit val bindingModule = Configuration

  val siteSettingsManager = inject[SiteDependentSettingManager]
  val userService = inject[UserServiceContract]
  val userRoleService = inject[UserRoleServiceContract]
  val packageService = inject[PackageService]
  val packageFacade = inject[PackageFacadeContract]
  // TODO to solve services and facades needed
}
