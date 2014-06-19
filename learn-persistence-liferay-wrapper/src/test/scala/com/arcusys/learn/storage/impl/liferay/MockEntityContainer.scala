package com.arcusys.learn.storage.impl.liferay

import org.specs2.mock.Mockito
import com.arcusys.learn.persistence.liferay.service.ClpSerializer
import collection.mutable
import java.util.concurrent.ConcurrentHashMap
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import java.util.{ List => JavaList }
import java.lang.{ Integer => JavaInteger }
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.util.PortletBeanLocatorUtilHelper

/**
 * User: dkudinov
 * Date: 12.3.2013
 */
trait MockKeyedEntityContainer[A <: LBaseLocalService, B <: LBaseModel[B]] extends MockEntityContainer[A, B] {
  getByIdFunction(mockLocalService, anyLong) answers {
    longRaw =>
      orNull(internalStorage.get(unwrapLong(longRaw)))
  }

  // keyed entity - service related mocks
  def getByIdFunction: (A, Long) => B
}

object IDGenService {
  private var nextID = 0

  def getNextID = synchronized {
    nextID += 1
    nextID
  }
}

trait MockEntityContainer[A <: LBaseLocalService, B <: LBaseModel[B]] extends Mockito {
  private val _internalStorage = new ThreadLocal[mutable.ConcurrentMap[Long, B]]
  val mockBeanLocator = Option(PortletBeanLocatorUtilHelper.getBeanLocator(ClpSerializer.getServletContextName)).getOrElse(mock[LBeanLocator])

  PortletBeanLocatorUtilHelper.setBeanLocator(ClpSerializer.getServletContextName, mockBeanLocator)

  mockBeanLocator.locate(mockServiceBeanName) answers { _ => mockLocalService }

  createFunction(mockLocalService) answers {
    mockService =>
      val mockEntity: B = createMockEntity()
      val id: Long = IDGenService.getNextID //util.Random.nextInt()

      getIdFunction(mockEntity) returns id

      // mock entity properties
      mockEntityProperties(mockEntity)

      mockEntity
  }

  addFunction(mockLocalService, any) answers {
    addToStorage(_)
  }

  deleteFunction(mockLocalService, anyInt) answers {
    deleteFromStorage(_)
  }

  getAllFunction(mockLocalService, anyInt, anyInt) answers {
    (service, params) => internalStorage.values.toList.asJava
  }

  removeAllFunction(mockLocalService) answers { service => internalStorage.clear() }

  def mockLocalService: A
  def mockServiceBeanName: String

  // service related mocks
  def createFunction: A => B
  def addFunction: (A, B) => B
  def deleteFunction: (A, Int) => B
  def updateFunction: (A, B) => B
  def orNull: Option[B] => B
  def getAllFunction: (A, Int, Int) => JavaList[B]
  def removeAllFunction: (A) => Unit

  // entity related mocks
  def createMockEntity(): B
  def mockEntityProperties(mockEntity: B)
  def getIdFunction: B => Long

  // common mocks
  private def addToStorage(entityRaw: Any) = {
    val entity = entityRaw.asInstanceOf[B]
    internalStorage += getIdFunction(entity) -> entity
    entity
  }

  private def deleteFromStorage(idRaw: Any): B = {
    orNull(internalStorage.remove(unwrapLong(idRaw)))
  }

  def internalStorage: mutable.ConcurrentMap[Long, B] = {
    if (_internalStorage.get == null) {
      _internalStorage.set(new ConcurrentHashMap[Long, B])
    }
    _internalStorage.get
  }

  def mockStringProperty(setter: String => Unit, getter: (B) => String) = {
    setter(anyString) answers {
      (stringRaw, entityRaw) =>
        getter(entityRaw.asInstanceOf[B]) returns unwrapString(stringRaw)
        ()
    }
  }

  def mockIntProperty(setter: Int => Unit, getter: (B) => Int) = {
    setter(any) answers {
      (valueRaw: Any, entityRaw: Any) =>
        getter(entityRaw.asInstanceOf[B]) returns unwrapNullableInteger(valueRaw)
        ()
    }
  }

  def mockIntegerProperty(setter: java.lang.Integer => Unit, getter: (B) => java.lang.Integer) = {
    // override default - return Null for Integer until set
    setter(any) answers {
      (valueRaw: Any, entityRaw: Any) =>
        getter(entityRaw.asInstanceOf[B]) answers {
          mock =>
            unwrapNullableInteger(valueRaw)
        }
        ()
    }
  }

  def mockDecimalProperty(setter: java.math.BigDecimal => Unit, getter: (B) => java.math.BigDecimal) = {
    setter(any) answers {
      (valueRaw: Any, entityRaw: Any) =>
        getter(entityRaw.asInstanceOf[B]) answers {
          mock => unwrapBigDecimal(valueRaw)
        }
        ()
    }
  }

  def mockDoubleProperty(setter: java.lang.Double => Unit, getter: (B) => java.lang.Double) = {
    setter(any) answers {
      (valueRaw: Any, entityRaw: Any) =>
        getter(entityRaw.asInstanceOf[B]) answers {
          mock => unwrapDouble(valueRaw)
        }
        ()
    }
  }

  def mockBooleanProperty(setter: Boolean => Unit, getter: (B) => Boolean) = {
    setter(any) answers {
      (valueRaw: Any, entityRaw: Any) =>
        getter(entityRaw.asInstanceOf[B]) returns unwrapBoolean(valueRaw)
        ()
    }
  }

  def mockLongProperty(setter: java.lang.Long => Unit, getter: (B) => java.lang.Long) = {
    setter(any) answers {
      (valueRaw: Any, entityRaw: Any) =>
        getter(entityRaw.asInstanceOf[B]) returns unwrapLong(valueRaw)
        ()
    }
  }

  // useful functions
  def unwrapString(valueRaw: Any): String = valueRaw match {
    case x: String   => x
    case Array(null) => null
    case Array(x)    => x.toString
    case _           => null
  }

  def unwrapNullableInteger(valueRaw: Any): java.lang.Integer = valueRaw match {
    case x: java.lang.Integer => x
    case Array(x)             => x.asInstanceOf[java.lang.Integer]
    case null                 => null
  }

  def unwrapArrayInteger(valueRaw: Any): Array[JavaInteger] = valueRaw match {
    case x: Array[JavaInteger] => x
    case Array(x: Array[_])    => x.asInstanceOf[Array[JavaInteger]]
    case null                  => null
  }

  def unwrapLong(valueRaw: Any): Long = valueRaw match {
    case x: Long        => x
    case Array(x: Long) => x
    case Array(null)    => null.asInstanceOf[Long]
  }

  def unwrapBoolean(valueRaw: Any) = valueRaw match {
    case x: Boolean        => x
    case Array(x: Boolean) => x
  }

  def unwrapDouble(valueRaw: Any): java.lang.Double = valueRaw match {
    case x: Double        => x
    case Array(x: Double) => x
    case _                => null
  }

  def unwrapBigDecimal(valueRaw: Any): java.math.BigDecimal = valueRaw match {
    case x: java.math.BigDecimal        => x
    case Array(x: java.math.BigDecimal) => x
    case _                              => null
  }
}
