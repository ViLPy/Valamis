package com.arcusys.learn.exceptions

//
// Created by iliya.tryapitsin on 04.02.14.
//
trait AccessDeniedException extends Exception

object AccessDeniedException {
  def apply(): AccessDeniedException = new Exception() with AccessDeniedException

  def apply(message: String): AccessDeniedException = new Exception(message) with AccessDeniedException
}
