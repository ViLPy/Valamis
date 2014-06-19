package com.arcusys.learn.facades

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.test.mocks.MockInjectableFactory
import org.mockito.{ Mockito }
import com.liferay.portal.model.User
import com.arcusys.learn.mocks.Mocks
import org.scalamock.proxy.ProxyMockFactory
import org.scalatest.{ Ignore, FlatSpec }
import com.arcusys.learn.scorm.certificating.{ CertificateUserStorage, CertificateSiteStorage, CertificateStorage }
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.liferay.services.UserLocalServiceHelper

/**
 * Created by Iliya Tryapitsin on 14.03.14.
 */
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
@Ignore
class CertificateFacadeTest extends FlatSpec with MockFactory with ProxyMockFactory with MockInjectableFactory {

  val liferayFakeUser = Mockito.mock(classOf[User])
  val certificateStorage = Mockito.mock(classOf[CertificateStorage])
  val certificateUserStorage = Mockito.mock(classOf[CertificateUserStorage])
  val settingStorage = Mockito.mock(classOf[SettingStorage])
  val certificateSiteStorage = Mockito.mock(classOf[CertificateSiteStorage])
  val courseFacade = Mockito.mock(classOf[CourseFacadeContract])
  val userLocalServiceHelper = Mockito.mock(classOf[UserLocalServiceHelper])
  var target: CertificateFacade = null

  bindingModule.modifyBindings(module => {
    module.bind[CertificateStorage] toSingle certificateStorage
    module.bind[CertificateUserStorage] toSingle certificateUserStorage
    module.bind[SettingStorage] toSingle settingStorage
    module.bind[CertificateSiteStorage] toSingle certificateSiteStorage
    module.bind[CourseFacadeContract] toSingle courseFacade
    module.bind[UserLocalServiceHelper] toSingle userLocalServiceHelper

    target = new CertificateFacade(module)
  })

  "CertificateFacade" should "return issue badge" in {

    Mocks.CertificateStorage.getByIdStub()
    Mocks.UserLocalServiceHelper.getUserStub(liferayFakeUser)

    Mockito
      .stub(liferayFakeUser.getEmailAddress)
      .toReturn("test@example.com")

    val result = target.getIssuerBadge(1, 1, "")
  }
}
