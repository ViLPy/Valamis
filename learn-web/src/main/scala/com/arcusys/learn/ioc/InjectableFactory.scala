package com.arcusys.learn.ioc

import org.scala_tools.subcut.inject.Injectable
import com.arcusys.learn.storage.StorageFactoryContract

trait InjectableFactory extends Injectable {
  implicit val bindingModule = Configuration
  protected val storageFactory = inject[StorageFactoryContract]
}
