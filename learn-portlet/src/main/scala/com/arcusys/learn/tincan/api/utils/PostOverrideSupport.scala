//package com.arcusys.learn.tincan.api.utils
//
//import java.net.URLDecoder
//import org.scalatra.util.MultiMapHeadView
//
//object PostOverrideSupport {
//  def parseBody(raw:String, encoding:String) : MultiMapHeadView[String,String] = {
//    def decode(s:String) = URLDecoder.decode(s, encoding)
//
//    val parameters = raw.split("&").map(_.split("=")).filter(_.size>1).map(p=>(decode(p(0)),Seq(decode(p(1))))).toMap
//    new MultiMapHeadView[String, String]{
//      val multiMap = parameters
//    }
//  }
//}
