package com.arcusys.learn.web

import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.{ TemplateUpgradeProcess, UpgradeProcess }
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.facades.FileFacadeContract

class DemoService(configuration: BindingModule) extends Injectable { // extends ServletBase(configuration) {
  // extends Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration
  //val log = LoggerFactory.getLogger(this.getClass)
  val storageFactory = inject[StorageFactoryContract]
  val fileFacade = inject[FileFacadeContract]

  /*get("/DemoHook1.4") {
    update()
  }*/

  def update() {
    val upgradeProcess = new UpgradeProcess(storageFactory, fileFacade)
    upgradeProcess.doUpgrade()

    val templateUpgradeProcess = new TemplateUpgradeProcess
    templateUpgradeProcess.doUpgrade()
  }

}
