package com.arcusys.valamis.lrs.model

case class EndpointInfo(endpoint: String,
                        auth: String = "",
                        authType: String = AuthConstants.Basic,
                        internal: Boolean = false,
                        version: String = "1.0.1")
