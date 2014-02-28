package com.arcusys.learn.test.mocks

import com.escalatesoft.subcut.inject.Injectable

trait MockInjectableFactory extends Injectable {
  implicit val bindingModule = MockConfiguration
}
