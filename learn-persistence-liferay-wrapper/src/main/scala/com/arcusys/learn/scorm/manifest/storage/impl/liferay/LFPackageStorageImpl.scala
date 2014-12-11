package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFPackage
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK
import com.arcusys.learn.persistence.liferay.service.{ LFLessonLimitLocalServiceUtil, LFAttemptLocalServiceUtil, LFPackageLocalServiceUtil }
import com.arcusys.learn.scorm.manifest.model.{ PeriodType, LessonType, Manifest }
import com.arcusys.learn.storage.impl.KeyedEntityStorage

import scala.collection.JavaConverters._
import scala.util.Try

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */
@deprecated
trait LFPackageStorageImpl extends KeyedEntityStorage[Manifest] {
  protected def doRenew() { LFPackageLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    val lfRule = parameters match {
      case Seq(("refID", refID: Any)) => {
        LFPackageLocalServiceUtil.findByRefID(getLong(refID))
      }
      case Seq(("packageId", packageId: Any)) => {
        LFPackageLocalServiceUtil.getLFPackage(getLong(packageId))
      }
    }
    if (lfRule == null) None
    else Option(extract(lfRule))
  }

  private def getLong(value: Any): Long = {
    value match {
      case i: Int  => i.toLong
      case l: Long => l
      case _       => 0
    }
  }

  private def getInt(value: Any): Int = {
    value match {
      case i: Int  => i
      case l: Long => l.toInt
      case _       => 0
    }
  }

  def getAll(parameters: (String, Any)*) = {
    val packages = parameters match {
      case Seq(("ids", courseIDs: List[Int])) => {
        LFPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer))
      }
      case Seq(("courseID", courseID: Int)) =>
        LFPackageLocalServiceUtil.findByCourseID(courseID)

      case _ => LFPackageLocalServiceUtil.getLFPackages(-1, -1)
    }
    packages.asScala map { extract }
  }

  private def extract(lfEntity: LFPackage) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val lessonLimit = Try({
      val limit = LFLessonLimitLocalServiceUtil.findByID(lfEntity.getId, LessonType.scormPackage.toString)
      (limit.getPassingLimit.toInt, limit.getRerunInterval.toInt, limit.getRerunIntervalType)
    }
    ).getOrElse((0, 0, ""))

    new Manifest(lfEntity.getId.toInt,
      None,
      lfEntity.getBase.toOption,
      "",
      lfEntity.getDefaultOrganizationID.toOption,
      lfEntity.getResourcesBase.toOption,
      lfEntity.getTitle,
      Option(lfEntity.getSummary),
      None,
      lfEntity.getAssetRefID.toOption,
      lfEntity.getCourseID.toOption,
      None,
      Option(lfEntity.getLogo),
      false,
      lessonLimit._1,
      lessonLimit._2,
      PeriodType(lessonLimit._3))
  }

  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException }
  def create(entity: Manifest, parameters: (String, Any)*) { throw new UnsupportedOperationException }
  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Any)) => {
        LFPackageLocalServiceUtil.deleteLFPackage(getLong(id))
        val limitEntity = LFLessonLimitLocalServiceUtil.findByID(getLong(id), LessonType.scormPackage.toString)
        LFLessonLimitLocalServiceUtil.deleteLFLessonLimit(limitEntity)

      }
    }
  }

  def modify(parameters: (String, Any)*) {
    val lfEntity = parameters match {
      case Seq(("id", id: Int), ("title", title: String), ("summary", summary: String)) => {
        val entity = LFPackageLocalServiceUtil.findByPackageID(Array(id.toLong: java.lang.Long)).asScala.headOption
        entity.foreach(e => {
          e.setTitle(title)
          e.setSummary(summary)
        })
        entity
      }
      case Seq(("id", id: Any), ("assetRefID", assetRefID: Any)) => {
        val entity = LFPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).asScala.headOption
        entity.foreach(e => {
          e.setAssetRefID(getLong(assetRefID))
        })
        entity
      }
      case Seq(("id", id: Int), ("logo", logo: Option[String])) => {
        val entity = LFPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).asScala.headOption
        logo.foreach { l =>
          entity.foreach(e => {
            e.setLogo(l)
          })
        }
        entity
      }
      case Seq(("id", id: Int), ("passingLimit", passingLimit: Int), ("rerunInterval", rerunInterval: Int), ("rerunIntervalType", rerunIntervalType: String)) => {
        val entity = LFPackageLocalServiceUtil.findByPackageID(Array(id.toLong: java.lang.Long)).asScala.headOption
        entity.foreach(e => {
          try {
            val limitEntity = LFLessonLimitLocalServiceUtil.findByID(e.getId, LessonType.scormPackage.toString)
            limitEntity.setPassingLimit(passingLimit)
            limitEntity.setRerunInterval(rerunInterval)
            limitEntity.setRerunIntervalType(rerunIntervalType)
            LFLessonLimitLocalServiceUtil.updateLFLessonLimit(limitEntity)
          } catch {
            case _ => {
              val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.scormPackage.toString))
              limitEntity.setPassingLimit(passingLimit)
              limitEntity.setRerunInterval(rerunInterval)
              limitEntity.setRerunIntervalType(rerunIntervalType)
              LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)
            }
          }
        })
        entity
      }
    }
    lfEntity.foreach(LFPackageLocalServiceUtil.updateLFPackage)
  }

  def modify(entity: Manifest, parameters: (String, Any)*) { throw new UnsupportedOperationException }
  def getByID(id: Int, parameters: (String, Any)*) = {
    Option(LFPackageLocalServiceUtil.getLFPackage(id)).map(extract)
  }

  def createAndGetID(entity: Manifest, parameters: (String, Any)*) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFPackageLocalServiceUtil.createLFPackage()

    newEntity.setDefaultOrganizationID(entity.defaultOrganizationID.getOrElse(null))
    newEntity.setTitle(entity.title)
    newEntity.setBase(entity.base.getOrElse(null))
    newEntity.setResourcesBase(entity.resourcesBase.getOrElse(null))
    newEntity.setSummary(entity.summary.getOrElse(null))
    newEntity.setAssetRefID(entity.assetRefID)
    newEntity.setCourseID(entity.courseID)
    entity.logo.foreach(newEntity.setLogo)

    val id = LFPackageLocalServiceUtil.addLFPackage(newEntity).getId.toInt

    val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.scormPackage.toString))
    limitEntity.setPassingLimit(entity.passingLimit)
    limitEntity.setRerunInterval(entity.rerunInterval)
    limitEntity.setRerunIntervalType(entity.rerunIntervalType.toString)
    LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)

    id
  }

  override def getAll(sql: String, parameters: (String, Any)*) = {
    if (sql.equalsIgnoreCase("_packages")) {
      parameters match {
        case Seq(("userID", userID: Int)) => {
          val packageIDs = LFAttemptLocalServiceUtil.findByUserID(userID).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
          LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
        }
        case _ => {
          val packageIDs = LFAttemptLocalServiceUtil.getLFAttempts(-1, -1).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
          LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
        }
      }
    } else {
      Nil
    }
  }

  def createAndGetID(parameters: (String, Any)*) = { throw new UnsupportedOperationException }

  def execute(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException }

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Manifest] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException }
}
