package com.arcusys.learn.aop

import java.lang.reflect.Method
import scala.reflect.runtime.{ universe => ru }

/**
 * Created by Iliya on 04.02.14.
 */
case class Invocation(val method: ru.MethodType,
    val args: Array[AnyRef],
    val target: AnyRef) {
  def invoke: AnyRef = {
    //    method.invoke(target, args: _*)
    method
  }
  override def toString: String = "Invocation [method: " + method + ", args: " + args + ", target: " + target + "]"
}
