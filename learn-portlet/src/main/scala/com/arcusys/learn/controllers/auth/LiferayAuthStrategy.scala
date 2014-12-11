package com.arcusys.learn.controllers.auth

import org.scalatra.auth.{ ScentryStrategy }

/**
 * Created by Iliya Tryapitsin on 04.04.2014.
 */
trait LiferayAuthStrategy extends ScentryStrategy[LiferayAuthUser]