package com.arcusys.learn.controllers.oauth.utils

import javax.crypto._
import javax.crypto.spec.SecretKeySpec

import org.apache.oltu.oauth2.common.exception.OAuthSystemException
import java.util.UUID

//
// Created by iliya.tryapitsin on 12.02.14.
//
class HMACSHA1Generator extends SignatureGenerator with HexHelper {
  def generateValue(): String = {
    return generateValue(UUID.randomUUID.toString, UUID.randomUUID.toString)
  }

  def generateValue(param: String, key: String): String =
    try {
      val mac: Mac = Mac.getInstance("HmacSHA1")
      mac.init(new SecretKeySpec(key.getBytes("utf-8"), "HmacSHA1"))
      return toHexString(mac.doFinal(param.getBytes("utf-8")))
    } catch {
      case e: Exception => {
        throw new OAuthSystemException("OAuth Token cannot be generated.", e)
      }
    }
}
