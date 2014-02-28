package com.arcusys.learn.models

import org.apache.oltu.oauth2.common.message.OAuthResponse


/**
 * Created by Iliya Tryapitsin on 25.02.14.
 */
class TincanOAuthResponse(uri: String,  responseStatus: Int) extends OAuthResponse(uri, responseStatus) {

}
