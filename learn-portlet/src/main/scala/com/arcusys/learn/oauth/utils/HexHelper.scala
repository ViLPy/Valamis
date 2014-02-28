package com.arcusys.learn.oauth.utils

//
// Created by iliya.tryapitsin on 12.02.14.
//
trait HexHelper {

  private final val hexCode: Array[Char] = "0123456789abcdef".toCharArray

  def toHexString(data: Array[Byte]): String = {
    if (data == null) {
      return null
    }
    val r: StringBuilder = new StringBuilder(data.length * 2)
    for (b <- data) {
      r.append(hexCode((b >> 4) & 0xF))
      r.append(hexCode((b & 0xF)))
    }
    return r.toString
  }
}
