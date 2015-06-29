package com.arcusys.learn.controllers.auth

import org.scalatra.auth.{ ScentryStrategy }

/**
 * Created by Alexander Klimov on 17.12.2014.
 */
trait MobileAuthStrategy extends ScentryStrategy[AuthUser]