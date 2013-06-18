package com.arcusys.learn.web

import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.UpgradeProcess
import com.arcusys.learn.storage.StorageFactoryContract

class DemoService(configuration: BindingModule) extends Injectable { //extends ServletBase(configuration) {
  def this() = this(Configuration)

  implicit val bindingModule = configuration
  //val log = LoggerFactory.getLogger(this.getClass)
  val storageFactory = inject[StorageFactoryContract]

  /*post("/DemoHook1.4") {
    if (request.getRemoteAddr == "127.0.0.1") {
      // allow only from localhost
      update()
    }
  }*/

  def update() {
    val upgradeProcess = new UpgradeProcess(storageFactory)
    upgradeProcess.doUpgrade()
  }

}
