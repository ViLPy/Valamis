import sbt._
import sbt.Keys._

object Settings {

  val common = Seq(
    organization := "com.arcusys.valamis",
    version := "2.4",
    scalaVersion := Version.scala,
    resolvers ++= Seq(
      Resolver.mavenLocal,
      ArcusysResolvers.mavenCentral,
      ArcusysResolvers.public
    ),
    libraryDependencies ++= Dependencies.common,
    publishMavenStyle             := true,
    publishArtifact in packageDoc := false,
    publishArtifact in packageSrc := false,
    publishMavenStyle             := true,
    javacOptions ++= Seq("-source", "1.6", "-target", "1.6"),
    scalacOptions        += "-target:jvm-1.6"
  )

  val liferay = Liferay620

  object Liferay620 {
    val dependencies = Dependencies.liferay620
    val supportVersion = "6.2.3"
    val version = Version.liferay620
    val lfPersistenceFolder = "learn-persistence-liferay620"
  }
}
