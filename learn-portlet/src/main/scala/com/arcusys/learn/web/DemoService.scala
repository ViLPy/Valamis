package com.arcusys.learn.web

import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.UpgradeProcess
import com.arcusys.learn.storage.StorageFactoryContract

class DemoService(configuration: BindingModule) extends Injectable { // extends ServletBase(configuration) {
  // extends Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration
  //val log = LoggerFactory.getLogger(this.getClass)
  val storageFactory = inject[StorageFactoryContract]

  /*get("/DemoHook1.4") {
    update()
  }*/

  def update() {
    val upgradeProcess = new UpgradeProcess(storageFactory)
    upgradeProcess.doUpgrade()

    /*val templateUpgradeProcess = new TemplateUpgradeProcess(storageFactory)
    templateUpgradeProcess.doUpgrade()*/
  }

}
