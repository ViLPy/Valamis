package com.arcusys.learn.models

/**
 * Created by iliya.tryapitsin on 14.01.14.
 */
case class GeneralResponse(
  isSuccess: Boolean = true,
  message: String = "",
  data: Any = Nil) {
    def isFail: Boolean = !isSuccess
}
