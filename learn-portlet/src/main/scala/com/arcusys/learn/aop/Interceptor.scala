package com.arcusys.learn.aop

import java.lang.annotation.Annotation

/**
 * Created by Iliya on 04.02.14.
 */
trait Interceptor {
  protected def matches(annotationClass: Class[T] forSome { type T <: Annotation},
                        invocation: Invocation): Boolean = {
    invocation.method.isAnnotationPresent(annotationClass) ||
      invocation.target.getClass.isAnnotationPresent(annotationClass) ||
      false
  }

  def invoke(invocation: Invocation): AnyRef
}
