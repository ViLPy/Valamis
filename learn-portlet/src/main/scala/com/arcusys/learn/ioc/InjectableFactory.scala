package com.arcusys.learn.ioc

import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.storage.StorageFactoryContract

trait InjectableFactory extends Injectable {
  implicit val bindingModule = Configuration
  protected val storageFactory = inject[StorageFactoryContract]
}
