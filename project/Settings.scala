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
      ArcusysResolvers.snapshots,
      ArcusysResolvers.releases,
      ArcusysResolvers.public
    ),
    libraryDependencies ++= Dependencies.common,
    publishArtifact in packageDoc := false,
    publishArtifact in packageSrc := false,
    publishMavenStyle             := true,
    publishTo                     := {
      if(version.value.trim.contains("SNAPSHOT"))
        Some(ArcusysResolvers.snapshots)
      else
        Some(ArcusysResolvers.releases)
    }
  )

  val liferay = Liferay620

  object Liferay620 {
    val dependencies = Dependencies.liferay620
    val supportVersion = "6.2.3"
    val version = Version.liferay620
    val lfPersistenceFolder = "learn-persistence-liferay620"
  }
}
