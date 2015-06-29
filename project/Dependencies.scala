import sbt._

object Version {
  val scala             = "2.10.4"
  val json4s            = "3.2.11"
  val sprayJson         = "1.3.2"
  val scalatest         = "2.2.3"
  val slf4j             = "1.6.4"
  val commonLang        = "2.2"
  val commonFileUpload  = "1.3.1"
  val commonIO          = "2.4"

  val jodaConvert       = "1.7"
  val jodaTime          = "2.3"
  val prettyTime        = "3.2.7.Final"
  val commonsValidator  = "1.4.1"
  val subcut            = "2.0"
  val lrs               = "2.4"

  val portletApi        = "2.0"
  val servletApi        = "2.5"
  val javaxMail         = "1.4"
  val liferay620        = "6.2.0-GA1"
  val junit             = "4.10"
  val scalaMock         = "3.1.RC1"
  val mockito           = "1.9.5"
  val slick             = "2.1.0"
  val slickJodaMapper   = "1.2.0"
  val scalaMustache     = "1.0.0"
  val guiceScala        = "4.0.0"
  val guice             = "4.0"
  val scalatra          = "2.2.2"
  val h2                = "1.3.170"
  val oauth             = "20100527"
  val oauthHttpClient   = "20090913"

  val poiOoxml          = "3.10.1-arcusys1"
  val httpClient        = "4.3"
  val antiSamy          = "1.5.1"
  val quartz            = "2.2.1"
  val nimbusJose        = "3.2"
  val antiXml           = "0.5.2"
}

object Libraries {
  // general
  val json4s            = "org.json4s"                 %% "json4s-jackson"     % Version.json4s
  val scalatest         = "org.scalatest"              %% "scalatest"          % Version.scalatest
  val subcut            = "com.escalatesoft.subcut"    %% "subcut"             % Version.subcut
  val slf4j             = "org.slf4j"                  %  "slf4j-api"          % Version.slf4j
  val slf4jSimple       = "org.slf4j"                  %  "slf4j-simple"       % Version.slf4j
  val slf4jLclOver      = "org.slf4j"                  %  "jcl-over-slf4j"     % Version.slf4j
  val jodaTime          = "joda-time"                  %  "joda-time"          % Version.jodaTime
  val prettyTime        = "org.ocpsoft.prettytime"     % "prettytime"          % Version.prettyTime
  val jodaConvert       = "org.joda"                   %  "joda-convert"       % Version.jodaConvert
  val commonsValidator  = "commons-validator"          %  "commons-validator"  % Version.commonsValidator
  val commonsLang       = "commons-lang"               %  "commons-lang"       % Version.commonLang
  val commonsFileUpload = "commons-fileupload"         %  "commons-fileupload" % Version.commonFileUpload
  val commonsIO         = "commons-io"                 %  "commons-io"         % Version.commonIO
  val mustache          = "com.arcusys.scala-mustache" %  "scala-mustache"     % Version.scalaMustache

  // scalatra
  val scalatra     = "org.scalatra" %% "scalatra"      % Version.scalatra
  val scalatraAuth = "org.scalatra" %% "scalatra-auth" % Version.scalatra
  val scalatraJson = "org.scalatra" %% "scalatra-json" % Version.scalatra

  // json4s
  val json4sJakson = "org.json4s" %% "json4s-jackson" % Version.json4s
  val json4sCore   = "org.json4s" %% "json4s-core"    % Version.json4s
  val json4sAst    = "org.json4s" %% "json4s-ast"     % Version.json4s
  val json4sExt    = "org.json4s" %% "json4s-ext"     % Version.json4s
  val sprayJson    = "io.spray"   %% "spray-json"     % Version.sprayJson

  // liferay
  val lfPortalService620 = "com.liferay.portal" % "portal-service" % Version.liferay620
  val lfPortalImpl620    = "com.liferay.portal" % "portal-impl"    % Version.liferay620
  val lfUtilJava620      = "com.liferay.portal" % "util-java"      % Version.liferay620

  // javax
  val portletApi = "javax.portlet" % "portlet-api" % Version.portletApi
  val servletApi = "javax.servlet" % "servlet-api" % Version.servletApi
  val jspApi     = "javax.servlet" % "jsp-api"     % Version.portletApi
  val mail       = "javax.mail"    % "mail"        % Version.javaxMail

  // valamis core / LRS
  val auth   = "com.arcusys.valamis" %% "valamis-lrs-auth"    % Version.lrs
  val lrsApi = "com.arcusys.valamis" %% "valamis-lrs-api"     % Version.lrs
  val lrsWeb = "com.arcusys.valamis" %% "valamis-lrs-liferay" % Version.lrs

  // slick
  val slick          = "com.typesafe.slick" %% "slick"           % Version.slick
  val slickDrivers   = "com.arcusys.slick"  %% "slick-drivers"   % "1.0" //Version.slick
  val slickMigration = "com.arcusys.slick"  %% "slick-migration" % Version.slick
  val slickJodaMapper = "com.github.tototoshi" %% "slick-joda-mapper" % Version.slickJodaMapper

  // guice
  val guiceScala        = "net.codingwell"               %% "scala-guice"        % Version.guiceScala
  val guiceMultibinding = "com.google.inject.extensions" % "guice-multibindings" % Version.guice
  val guiceServlet      = "com.google.inject.extensions" % "guice-servlet"       % Version.guice

  // test
  val specs             = "org.specs2"      %% "specs2"                      % "2.3.10"
  val scalaMock         = "org.scalamock"   %% "scalamock-scalatest-support" % Version.scalaMock
  val scalatraScalatest = "org.scalatra"    %% "scalatra-scalatest"          % Version.scalatra
  val scalatestMock     = "org.scalamock"   %% "scalamock-scalatest-support" % Version.scalaMock
  val mockito           = "org.mockito"     % "mockito-all"                  % Version.mockito
  val portletTester     = "com.portletguru" % "portlettester"                % "0.1"
  val junit             = "junit"           % "junit"                        % Version.junit
  val h2DB              = "com.h2database"  % "h2"                           % Version.h2

  //OAuth 1.0 Provider & Consumer Library
  val oauthCore       = "net.oauth.core" % "oauth"             % Version.oauth
  val oauthConsumer   = "net.oauth.core" % "oauth-consumer"    % Version.oauth
  val oauthHttpClient = "net.oauth.core" % "oauth-httpclient4" % Version.oauthHttpClient

  //apache xml graphics
  val apacheXml        = "org.apache.xmlgraphics"      % "fop"                   % "1.1"
  val apacheAvalonApi  = "org.apache.avalon.framework" % "avalon-framework-api"  % "4.3.1"
  val apacheAvalonImpl = "org.apache.avalon.framework" % "avalon-framework-impl" % "4.3.1"

  // other
  val poiOoxml   = "org.apache.poi"            % "poi-ooxml"       % Version.poiOoxml
  val httpClient = "org.apache.httpcomponents" % "httpclient"      % Version.httpClient
  val antiSamy   = "org.owasp.antisamy"        % "antisamy"        % Version.antiSamy
  val quartz     = "org.quartz-scheduler"      % "quartz"          % Version.quartz
  val nimbusJose = "com.nimbusds"              % "nimbus-jose-jwt" % Version.nimbusJose
  val antiXml    = "no.arktekk"                %% "anti-xml"       % Version.antiXml
}

object Dependencies {
  import Libraries._

  val common = Seq(
    jodaTime,
    jodaConvert,
    scalatest % Test,
    specs     % Test,
    mockito   % Test,
    scalaMock % Test,
    scalatestMock % Test,
    junit     % Test
  )

  val guice = Seq(
    guiceScala
//    guiceMultibinding,
//    guiceServlet
  )

  val json4s = Seq(
    json4sJakson,
    json4sCore,
    json4sAst,
    json4sExt
  )

  val javax = Seq(portletApi, servletApi, jspApi, mail).map( _ % Provided)

  val oauthClient = Seq(
    oauthCore,
    oauthConsumer,
    oauthHttpClient
  )

  val slick = Seq(
    Libraries.slick,
    slickDrivers,
    slickMigration,
    h2DB % Test
  )

  val internalPortlets = slick ++ Seq(sprayJson) ++ javax

  val liferay620 = javax ++ Seq(Libraries.lfUtilJava620, lfPortalService620, lfPortalImpl620).map( _ % Provided)
}
