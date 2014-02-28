package com.arcusys.learn.oauth

import org.apache.oltu.oauth2.common.validators.OAuthValidator
import javax.servlet.http.HttpServletRequest

/**
 * Created by Iliya Tryapitsin on 21.02.14.
 */
class TincanOAuthRequestValidator extends OAuthValidator[HttpServletRequest] {
  def validateMethod(p1: HttpServletRequest): Unit = ()

  def validateContentType(p1: HttpServletRequest): Unit = ()

  def validateRequiredParameters(p1: HttpServletRequest): Unit = ()

  def validateOptionalParameters(p1: HttpServletRequest): Unit = ()

  def validateNotAllowedParameters(p1: HttpServletRequest): Unit = ()

  def validateClientAuthenticationCredentials(p1: HttpServletRequest): Unit = ()

  def performAllValidations(p1: HttpServletRequest): Unit = ()
}
