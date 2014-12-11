package com.arcusys.learn.ioc

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.escalatesoft.subcut.inject.NewBindingModule

object Configuration extends NewBindingModule({
  implicit module =>

    module mergeWithReplace WebConfiguration
    module mergeWithReplace DomainConfiguration

})