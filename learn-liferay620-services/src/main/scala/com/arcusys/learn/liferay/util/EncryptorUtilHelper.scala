package com.arcusys.learn.liferay.util

import java.security.Key

/**
 * User: Yulia.Glushonkova
 * Date: 18.08.14
 */
object EncryptorUtilHelper {
  def encrypt(key: Key, plainText: String) = com.liferay.util.Encryptor.encrypt(key, plainText)
}
