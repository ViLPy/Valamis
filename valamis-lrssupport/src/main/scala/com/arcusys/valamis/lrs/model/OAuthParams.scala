package com.arcusys.valamis.lrs.model

case class OAuthParams(currentUrl: Option[String]     = None,
                       oauthToken: Option[String]     = None,
                       oauthVerifier: Option[String]  = None)
