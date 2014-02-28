package com.arcusys.learn.aop

import java.lang.reflect.Method

/**
 * Created by Iliya on 04.02.14.
 */
case class Invocation(val method: Method,
                      val args: Array[AnyRef],
                      val target: AnyRef) {
  def invoke: AnyRef = method.invoke(target, args:_*)
  override def toString: String = "Invocation [method: " + method.getName + ", args: " + args + ", target: " + target + "]"
}
