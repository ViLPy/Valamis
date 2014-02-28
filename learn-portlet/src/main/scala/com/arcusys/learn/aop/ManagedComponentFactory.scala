package com.arcusys.learn.aop

import java.lang.reflect.Proxy

/**
 * Created by Iliya on 04.02.14.
 */
object ManagedComponentFactory {
  def createComponent[T](intf: Class[T] forSome {type T},
                         proxy: ManagedComponentProxy): T =
    Proxy.newProxyInstance(
        proxy.target.getClass.getClassLoader,
        Array(intf),
        proxy)
      .asInstanceOf[T]
}
