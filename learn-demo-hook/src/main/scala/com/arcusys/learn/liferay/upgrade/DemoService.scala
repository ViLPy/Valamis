package com.arcusys.learn.liferay.upgrade

import com.arcusys.learn.bl.services.FileServiceContract
import com.arcusys.learn.bl.services.lesson.PackageUploadManager
import com.arcusys.learn.bl.utils.{ TemplateUpgradeProcess, UpgradeProcess }
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class DemoService(configuration: BindingModule) extends Injectable { // extends ServletBase(configuration) {
  // extends Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration
  val fileService = inject[FileServiceContract]
  val packageUploadManager = inject[PackageUploadManager]

  /*get("/DemoHook1.4") {
    update()
  }*/

  def update() {
    val upgradeProcess = new UpgradeProcess(fileService, packageUploadManager, configuration)
    upgradeProcess.doUpgrade()

    val templateUpgradeProcess = new TemplateUpgradeProcess
    templateUpgradeProcess.doUpgrade()
  }

}
