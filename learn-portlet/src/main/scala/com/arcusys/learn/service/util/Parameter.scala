package com.arcusys.learn.service.util

import javax.servlet.http.HttpServletRequest

/**
  * Created by Iliya Tryapitsin on 24.02.14.
  */
object Parameter {
   def apply(name: String)(implicit request: HttpServletRequest) = new ParameterBase(name, request)
 }
