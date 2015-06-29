package com.arcusys.valamis.lrsEndpoint.model

import org.joda.time.DateTime

/*
Case class that contains relations between proxy and real authorization
 */
case class LrsToken(
    token: String,
    authInfo: String,
    authType: String,
    created: DateTime )
