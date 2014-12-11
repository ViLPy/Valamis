package com.arcusys.learn.ioc

import com.escalatesoft.subcut.inject.Injectable

trait InjectableFactory extends Injectable {
  implicit val bindingModule = Configuration
}
