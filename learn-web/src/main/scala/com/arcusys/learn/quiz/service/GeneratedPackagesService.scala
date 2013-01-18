package com.arcusys.learn.quiz.service

import com.arcusys.scorm.util.FileSystemUtil
import java.io.FileInputStream
import com.arcusys.scorm.generator.file.QuizPackageGenerator
import com.arcusys.scorm.deployer.PackageProcessor

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.service.asset.AssetHelper

class GeneratedPackagesService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)
  import storageFactory._

  get("/Zip/:quizID") {
    contentType = "application/zip"
    
    val quizID = parameter("quizID").intRequired
    val courseID = parameter("courseID").intOption(-1)
    val quiz = quizStorage.getByID(quizID).get
    val generator = new QuizPackageGenerator(quiz)
    val filename = generator.generateZip(courseID)
    
    val is = new FileInputStream(FileSystemUtil.getRealTmpDir + filename)
    org.scalatra.util.io.copy(is, response.getOutputStream)
    is.close()
  }
  
  post("/ZipInstall/:quizID") {
    val quizID = parameter("quizID").intRequired
    val userIDHeader = request.getHeader("scormUserID")
    val userID = if (userIDHeader.isEmpty) 0 else userIDHeader.toLong
    val groupIDHeader = request.getHeader("liferayGroupID")
    val groupID = if (groupIDHeader.isEmpty) -1 else groupIDHeader.toLong
    val quiz = quizStorage.getByID(quizID).get
    val generator = new QuizPackageGenerator(quiz)
    val courseID = parameter("courseID").intOption(-1)
    val filename = generator.generateZip(courseID)

    val packageID = PackageProcessor.processPackageAndGetID(quiz.title, "", filename.substring(0,filename.length - 4),courseID)
    if (groupID != -1) AssetHelper.addPackage(userID, groupID, storageFactory.packageStorage.getByID(packageID).getOrElse(throw new Exception("Can't find newly created pakage")))

    packageID
  }
}
