package com.arcusys.learn.aop

import org.scalatest.FlatSpec
import org.junit.runner.RunWith

//import java.lang.annotation.Annotation
import scala.annotation.Annotation
import scala.reflect.runtime.{ universe => ru }

/**
 * Created by Iliya Tryapitsin on 06.05.2014.
 */

class TestAnnotation extends Annotation {
  //override def annotationType(): Class[_ <: Annotation] = classOf[TestAnnotation]
}

abstract trait Foo {

  @TestAnnotation
  def testMethod()
}

class FooImpl extends Foo {
  @TestAnnotation
  def testMethod() = {

  }
}

trait TestInterceptor extends Interceptor {
  val matchingJtaAnnotation = classOf[Annotation]
  val matchingAnnotation = ru.typeOf[TestAnnotation]

  abstract override def invoke(invocation: Invocation): AnyRef = {
    if (matches(matchingAnnotation, invocation)) {
      super.invoke(invocation)
    }
    super.invoke(invocation)
  }
}

//@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class InvocationTest extends FlatSpec {
  "AopTest" should "call annotations" in {
    val foo = ManagedComponentFactory.createComponent[Foo](classOf[Foo], new ManagedComponentProxy(new FooImpl) with TestInterceptor)

    foo.testMethod()
  }
}
