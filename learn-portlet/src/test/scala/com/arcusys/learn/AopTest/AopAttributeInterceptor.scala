package com.arcusys.learn.AopTest

import com.arcusys.learn.aop.{Invocation, Interceptor}

/**
 * Created by Iliya on 04.02.14.
 */

trait AopAttributeInterceptor extends Interceptor {

  val matchingJtaAnnotation = classOf[AopAnnotation]

  abstract override def invoke(invocation: Invocation): AnyRef = {
    if (matches(matchingJtaAnnotation, invocation)) {
      println("Invoke interceptor")
      super.invoke(invocation)
    } else super.invoke(invocation)
  }
}
