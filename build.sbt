import sbt._

def lfService = lfService620

def lfPersistence =  lfPersistence620

def hook = hookLf620


lazy val util = (project in file("valamis-util"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-util")
  .settings(libraryDependencies += Libraries.json4s)

lazy val lfService620 = (project in file("learn-liferay620-services"))
  .settings(Settings.common: _*)
  .settings(organization := "com.arcusys.learn")
  .settings(name := "learn-liferay620-services")
  .settings(libraryDependencies ++= Dependencies.liferay620)
  .dependsOn(util)

lazy val questionbank = (project in file("valamis-questionbank"))
  .settings(Settings.common: _*)
  .settings(libraryDependencies += Libraries.subcut)
  .settings(name := "valamis-questionbank")

lazy val lrssupport = (project in file("valamis-lrssupport"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-lrssupport")
  .settings(libraryDependencies ++= (Settings.liferay.dependencies
                ++ Dependencies.oauthClient
                ++ Dependencies.lrs))
  .settings(libraryDependencies += Libraries.subcut)
  .dependsOn(lfService)

lazy val core = (project in file("valamis-core"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-core")
  .settings(libraryDependencies ++= Settings.liferay.dependencies)
  .settings(libraryDependencies += Libraries.subcut)
  .dependsOn(lfService, util)

lazy val quiz = (project in file("valamis-quiz"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-quiz")
  .settings(libraryDependencies ++= Settings.liferay.dependencies)
  .dependsOn(questionbank, core)

lazy val tincanLesson = (project in file("valamis-tincan-lesson"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-tincan-lesson")
  .dependsOn(core, util)

lazy val scormLesson = (project in file("valamis-scorm-lesson"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-scorm-lesson")
  .settings(libraryDependencies ++= Seq(Libraries.scalaMock, Libraries.junit).map(_ % Test))
  .dependsOn(core, util)

lazy val lesson = (project in file("valamis-lesson"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-lesson")
  .settings(libraryDependencies ++= Settings.liferay.dependencies)
  .dependsOn(core, tincanLesson, scormLesson, lrssupport)

lazy val gradebook = (project in file("valamis-gradebook"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-gradebook")
  .settings(libraryDependencies ++= Settings.liferay.dependencies)
  .dependsOn(core, quiz, questionbank, scormLesson, lesson, lfService)

lazy val social = (project in file("valamis-social"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-social")
  .settings(libraryDependencies ++= (Settings.liferay.dependencies))
  .dependsOn(lfService, gradebook, certificate, lesson)

lazy val slickPersistence = (project in file("valamis-slick-persistence"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-slick-persistence")
  .settings(libraryDependencies ++= Dependencies.slick)
  .settings(libraryDependencies ++= Dependencies.javax)
  .settings(libraryDependencies ++= Seq(Libraries.lrsApi, Libraries.valamisCore))
  .settings(parallelExecution in test := false)
  .dependsOn(core, certificate, social)

lazy val certificate = (project in file("valamis-certificate"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-certificate")
  .settings(libraryDependencies ++= Settings.liferay.dependencies)
  .dependsOn(core, lrssupport, lesson, gradebook)

lazy val lessonGenerator = (project in file("valamis-lesson-generator"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-lesson-generator")
  .settings(libraryDependencies ++= (Settings.liferay.dependencies ++ Seq(Libraries.commonsLang, Libraries.poiOoxml)))
  .dependsOn(core, questionbank, quiz, lesson)

lazy val slide = (project in file("valamis-slide"))
  .settings(Settings.common: _*)
  .settings(name := "valamis-slide")
  .settings(libraryDependencies ++= Settings.liferay.dependencies)
  .dependsOn(core, questionbank, lesson, lessonGenerator, lrssupport)

lazy val persistenceApi = (project in file("learn-persistence-api"))
  .settings(Settings.common: _*)
  .settings(organization := "com.arcusys.learn")
  .settings(name := "learn-persistence-api")
  .settings(libraryDependencies ++= Settings.liferay.dependencies)
  .dependsOn(core, quiz, lesson, lrssupport)

lazy val lfPersistence620 = (project in file("learn-persistence-liferay620"))
  .settings(Settings.common: _*)
  .settings(organization := "com.arcusys.learn")
  .settings(name := "learn-persistence-liferay620")
  .settings(libraryDependencies ++= Settings.Liferay620.dependencies)

lazy val lfPersistenceImpl = (project in file("learn-persistence-liferay-wrapper"))
  .settings(Settings.common: _*)
  .settings(organization := "com.arcusys.learn")
  .settings(name := "learn-persistence-liferay-wrapper")
  .settings(libraryDependencies ++= Settings.liferay.dependencies :+ Libraries.antiXml)
  .settings(parallelExecution in test := false)
  .dependsOn(
    persistenceApi,
    lfPersistence,
    questionbank,
    lfService,
    lrssupport,
    core,
    quiz,
    tincanLesson,
    scormLesson,
    lesson,
    lessonGenerator,
    gradebook,
    slide
  )

lazy val hookLf620 = (project in file("valamis-hook"))
  .settings(Settings.common: _*)
  .settings(warSettings ++ webappSettings : _*)
  .settings(artifactName in packageWar := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
    "learn-liferay620-hook." + artifact.extension
  })
  .settings(libraryDependencies ++= Settings.Liferay620.dependencies)

lazy val portlet = (project in file("learn-portlet"))
  .settings(Settings.common: _*)
  .settings(organization := "com.arcusys.learn")
  .settings(warSettings ++ webappSettings : _*)
  .settings(artifactName in packageWar := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
    module.name + "." + artifact.extension
  })
  .settings(postProcess in webapp := { webappDir =>
    IO.delete(webappDir / "WEB-INF/learn-persistence-sb")
    IO.delete(webappDir / "WEB-INF/sql")
    IO.delete(webappDir / "WEB-INF/liferay-plugin-package.properties")

    IO.copyDirectory(
      webappDir / "../../../" / Settings.liferay.lfPersistenceFolder / "src/main/resources/generated",
      webappDir / "WEB-INF",
      overwrite = true)

    IO.copyDirectory(
      webappDir / "../../../learn-portlet/src/main/resources/ext-libs",
      webappDir / "WEB-INF/lib",
      overwrite = true)

    //todo: move it to prepare resource task
    val propertiesContent = IO.read(webappDir / "../../../learn-portlet/src/main/resources/liferay-plugin-package.properties")
      .replace("${supported.liferay.versions}", Settings.liferay.supportVersion)

    IO.write(webappDir / "WEB-INF/liferay-plugin-package.properties", propertiesContent)
  })
  .settings(name := "learn-portlet")
  .settings(libraryDependencies ++= (
    Settings.liferay.dependencies
      ++ Dependencies.slick
      ++ Dependencies.guice
      ++ Dependencies.json4s
      ++ Dependencies.oauthClient
      ++ Seq(
        Libraries.subcut,
        Libraries.poiOoxml,
        Libraries.httpClient,
        Libraries.slf4j,
        Libraries.slf4jSimple,
        Libraries.slf4jLclOver,
        Libraries.scalatra,
        Libraries.scalatraAuth,
        Libraries.scalatraJson,

        Libraries.apacheXml
          exclude("org.apache.avalon.framework", "avalon-framework-api")
          exclude("org.apache.avalon.framework", "avalon-framework-impl"),
        Libraries.apacheAvalonApi, Libraries.apacheAvalonImpl,

        Libraries.commonsLang,
        Libraries.commonsFileUpload,
        Libraries.commonsIO,
        Libraries.antiSamy,
        Libraries.quartz,
        Libraries.nimbusJose,
        Libraries.scalatraScalatest % Test,
        Libraries.prettyTime,
        Libraries.valamisAuth
      )
    )
  )
  .dependsOn(
    questionbank, lfService, lrssupport, core, quiz,
    tincanLesson, scormLesson, lesson, lessonGenerator,
    gradebook, certificate, slide, social,
    persistenceApi, lfPersistenceImpl, slickPersistence
  )
