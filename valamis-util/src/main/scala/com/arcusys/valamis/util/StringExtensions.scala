package com.arcusys.valamis.util

import java.net.URLDecoder

object StringExtensions {
  implicit class StringDecode(val s: String) extends AnyVal {
    def urlDecode = {
      try {
        URLDecoder.decode(s, "UTF-8")
      } catch {
        case _: Throwable => s
      }
    }
  }
}