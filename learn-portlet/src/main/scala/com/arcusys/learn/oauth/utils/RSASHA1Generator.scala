package com.arcusys.learn.oauth.utils

import org.apache.oltu.oauth2.common.exception.OAuthSystemException
import java.security.{KeyPairGenerator, Signature}
import java.util.UUID
import com.arcusys.learn.oauth.utils.SignatureGenerator

//
// Created by iliya.tryapitsin on 12.02.14.
//
class RSASHA1Generator extends SignatureGenerator with HexHelper {
  def generateValue(): String = {
    return generateValue(UUID.randomUUID.toString, UUID.randomUUID.toString)
  }

  def generateValue(param: String, key: String): String =
    try {
      val keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair()
      val privateKey = keyPair.getPrivate()
      val signer = Signature.getInstance("SHA1withRSA")
      signer.initSign(privateKey)
      val arr = param.getBytes("utf-8")
      val messageDigest: Array[Byte] = signer.sign()

      return toHexString(messageDigest)
    }
    catch {
      case e: Exception => {
        throw new OAuthSystemException("OAuth Token cannot be generated.", e)
      }
    }
}
