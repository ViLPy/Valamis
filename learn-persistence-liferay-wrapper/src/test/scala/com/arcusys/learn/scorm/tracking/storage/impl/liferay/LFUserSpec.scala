package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFUserLocalServiceUtil
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.scorm.tracking.impl.liferay.LFUserStorageImpl

/**
 * User: Yulia.Glushonkova
 * Date: 28.03.13
 */
class LFUserSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFUserLocalServiceUtil.createLFUser()
      there was atLeastOne(userService).createLFUser()
    }
  }
  "LFUserStorageImpl" should {

    "execute 'create' without errors" in new Context {
      userStorage.create(new User(1, "testUser")) must not(throwA[Exception])
    }

    "execute 'get' without errors" in new Context {
      userStorage.create(new User(2, "testUser2")) must not(throwA[Exception])
      var user = userStorage.getOne("id" -> 2)
      user must beSome
      user.get.name must beEqualTo("testUser2")
    }
    "execute 'delete' without errors" in new Context {
      userStorage.create(new User(3, "testUser3")) must not(throwA[Exception])
      userStorage.delete("id" -> 3)
      var user = userStorage.getOne("id" -> 3)
      user must beNone
    }
  }

  trait Context extends Scope {
    val userService = UserEntityContainer.mockLocalService
    val userStorage: EntityStorage[User] = new LFUserStorageImpl {}
  }

}
