package com.arcusys.learn.tincan.model

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification
import com.arcusys.learn.tincan.model.lrsClient.{UserBasicAuthorization, LrsEndpointSettings}


@RunWith(classOf[JUnitRunner])
class LrsEndpointSettingsSpec extends Specification  {

  "Constructor " should {
//    "throw 'IllegalArgumentException' if endpoint is null" in {
//      LrsEndpointSettings(null, UserBasicAuthorization) must throwA[IllegalArgumentException]
//    }

    "create object with same endpoint" in {
      val settings = LrsEndpointSettings("http:\\test.te", UserBasicAuthorization)
      settings.endpoint.mustEqual("http:\\test.te")
    }
  }
}
