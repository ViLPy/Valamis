package com.arcusys.learn.oauth

import org.apache.oltu.oauth2.as.request.OAuthRequest
import org.apache.oltu.oauth2.common.validators.OAuthValidator
import javax.servlet.http.HttpServletRequest

/**
 * Created by Iliya Tryapitsin on 21.02.14.
 */
class TincanOAuthRequest(r: HttpServletRequest) extends OAuthRequest(r) {
  def initValidator(): OAuthValidator[HttpServletRequest] = new TincanOAuthRequestValidator()
}
