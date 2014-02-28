package com.arcusys.learn.AopTest

import org.junit.runner.RunWith
import com.arcusys.learn.aop.{ManagedComponentProxy, ManagedComponentFactory}
import org.scalatest.FlatSpec

//
// Created by iliya.tryapitsin on 05.02.14.
//
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AopTest extends FlatSpec {
  "Achievement service" should "get all achievement as JSON for admin" in {
    val foo = ManagedComponentFactory.createComponent[Foo](
      classOf[Foo],
      new ManagedComponentProxy(new FooImpl) with AopAttributeInterceptor)

    foo.test()
    foo.test2()
  }
}
