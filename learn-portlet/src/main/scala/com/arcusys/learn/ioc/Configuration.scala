package com.arcusys.learn.ioc

import com.escalatesoft.subcut.inject.NewBindingModule

object Configuration extends NewBindingModule({
  implicit module => module <~ WebConfiguration
})