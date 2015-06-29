package com.arcusys.valamis.lesson.generator.tincan

import com.arcusys.valamis.lesson.generator.GenericPackageGenerator

trait TinCanPackageGenerator extends GenericPackageGenerator {
  protected val commonResourceURLs = Seq("jquery-1.7.2.min.js", "jquery-ui-1.8.20.custom.min.js", "lodash.min.js", "jquery.ui.touch-punch.min.js",
    "jquery-ui-1.8.20.custom.css", "base.js", "tincan-min.js", "player_tincan_content.css", "buttons.css")

  protected val commonRevealResourceURLs = Seq("reveal.min.js",
    "head.min.js",
    "plugin/highlight/highlight.js",
    "css/zenburn.css",
    "css/reveal.css",
    "css/theme/beige.css",
    "css/theme/blood.css",
    "css/theme/default.css",
    "css/theme/moon.css",
    "css/theme/night.css",
    "css/theme/serif.css",
    "css/theme/simple.css",
    "css/theme/sky.css",
    "css/theme/solarized.css",
    "css/theme/slides.css",
    "skins/polaris/polaris.css",
    "skins/polaris/polaris.png",
    "skins/polaris/polaris@2x.png",
    "lib/font/league-gothic/league-gothic.css",
    "lib/font/league-gothic/league-gothic.eot",
    "lib/font/league-gothic/league-gothic.woff",
    "lib/font/league-gothic/league-gothic.ttf")

  protected def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  def getDefaultManifest(rootActivityId: String, title: String, description: String) = {
    <tincan xmlns="http://projecttincan.com/tincan.xsd">
      <activities>
        <activity id={ rootActivityId } type="http://adlnet.gov/expapi/activities/course">
          <name>
            { title }
          </name>
          <description lang="en-US">
            { description }
          </description>
          <launch lang="en-us">data/index.html</launch>
        </activity>
      </activities>
    </tincan>
  }
}
