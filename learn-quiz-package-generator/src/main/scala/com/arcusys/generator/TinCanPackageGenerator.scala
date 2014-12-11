package com.arcusys.generator

import java.net.URLDecoder
import scala.xml.Elem

trait TinCanPackageGenerator {
  protected val commonResourceURLs = Seq("jquery-1.7.2.min.js", "jquery-ui-1.8.20.custom.min.js",
    "jquery-ui-1.8.20.custom.css", "base.js", "tincan-min.js", "icheck.min.js", "player_tincan_content.css", "buttons.css")

  protected val commonRevealResourceURLs = Seq("reveal.min.js", "head.min.js", "plugin/highlight/highlight.js", "css/zenburn.css", "css/reveal.css", "css/theme/beige.css",
    "css/theme/blood.css", "css/theme/default.css", "css/theme/moon.css", "css/theme/night.css",
    "css/theme/serif.css", "css/theme/simple.css", "css/theme/sky.css", "css/theme/solarized.css",
    "skins/polaris/polaris.css", "skins/polaris/polaris.png", "skins/polaris/polaris@2x.png")

  protected def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)
  protected def decode(source: String) = URLDecoder.decode(source, "UTF-8")
  protected def generateManifest: Elem
}
