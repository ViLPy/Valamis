package com.arcusys.learn.view

import com.arcusys.learn.facades.PackageFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.scorm.lms.{ PackageService, UserManagement }
import com.escalatesoft.subcut.inject.Injectable

/**
 * Created with IntelliJ IDEA.
 * User: dkudinov
 * Date: 27.2.2013
 * Time: 15.00
 */
trait ConfigurableView extends Injectable {

  implicit val bindingModule = Configuration

  val storageFactory = inject[StorageFactoryContract]
  val userStorage = storageFactory.userStorage
  val userManagement = new UserManagement()
  val packageService = new PackageService()
  val packageFacade = inject[PackageFacadeContract]
  // TODO to solve services and facades needed
}
