package com.arcusys.learn.aop

import scala.annotation.Annotation
import scala.reflect.runtime.{ universe => ru }

//import java.lang.annotation.Annotation

/**
 * Created by Iliya on 04.02.14.
 */
trait Interceptor {
  protected def matches(annotationClass: Class[T] forSome { type T <: Annotation },
    invocation: Invocation): Boolean = {

    true
    //    invocation.method.isAnnotationPresent(annotationClass) ||
    //      invocation.target.getClass.isAnnotationPresent(annotationClass) ||
    //      false
  }

  protected def matches(annotationClass: ru.Type,
    invocation: Invocation): Boolean = {

    true
  }

  def invoke(invocation: Invocation): AnyRef
}
