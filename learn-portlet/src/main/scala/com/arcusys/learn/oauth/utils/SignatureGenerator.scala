package com.arcusys.learn.oauth.utils

//
// Created by iliya.tryapitsin on 13.02.14.
//
abstract class SignatureGenerator {
  def generateValue(): String

  def generateValue(param: String, key: String): String
}
