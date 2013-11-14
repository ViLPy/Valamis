package com.arcusys.learn.view

import org.scala_tools.subcut.inject.Injectable
import com.arcusys.learn.ioc.Configuration
import com.arcusys.scorm.lms.{PackageService, UserManagement}
import com.arcusys.learn.storage.StorageFactoryContract

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

}
