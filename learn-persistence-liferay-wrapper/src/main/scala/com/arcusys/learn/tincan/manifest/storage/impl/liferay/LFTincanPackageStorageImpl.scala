package com.arcusys.learn.tincan.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage
import com.arcusys.learn.persistence.liferay.service._
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK
import com.arcusys.learn.scorm.manifest.model.{ PeriodType, LessonType }
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.manifest.model.TincanManifest

import scala.collection.JavaConverters._
import scala.util.Try

@deprecated
trait LFTincanPackageStorageImpl extends KeyedEntityStorage[TincanManifest] {

  protected def doRenew() {
    LFTincanPackageLocalServiceUtil.removeAll()
  }

  def getOne(parameters: (String, Any)*) = {
    val lfRule = parameters match {
      case Seq(("refID", refID: Any)) =>
        LFTincanPackageLocalServiceUtil.findByRefID(getLong(refID))
      case Seq(("packageId", packageId: Any)) =>
        LFTincanPackageLocalServiceUtil.getLFTincanPackage(getLong(packageId))
      case _ => throw new UnsupportedOperationException()
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
    val packages: Seq[LFTincanPackage] = parameters match {
      case Seq(("ids", courseIDs: List[Int])) => {
        LFTincanPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer)).asScala
      }
      case Seq(("courseID", courseID: Int)) =>
        LFTincanPackageLocalServiceUtil.findByCourseID(courseID).asScala
      case Seq() => LFTincanPackageLocalServiceUtil.findAll().asScala
      case _     => Seq(LFTincanPackageLocalServiceUtil.getLFTincanPackage(-1))
    }
    packages filter (_ != null) map { extract }
  }

  private def extract(lfEntity: LFTincanPackage) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val lessonLimit = Try({
      val limit = LFLessonLimitLocalServiceUtil.findByID(lfEntity.getId, LessonType.tincanPackage.toString)
      (limit.getPassingLimit.toInt, limit.getRerunInterval.toInt, limit.getRerunIntervalType)
    }
    ).getOrElse((0, 0, ""))

    TincanManifest(
      lfEntity.getId.toInt,
      lfEntity.getTitle,
      Option(lfEntity.getSummary),
      lfEntity.getCourseID.toOption,
      lfEntity.getAssetRefID.toOption,
      None, Option(lfEntity.getLogo),
      false,
      lessonLimit._1,
      lessonLimit._2,
      PeriodType(lessonLimit._3))
  }

  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException }
  def create(entity: TincanManifest, parameters: (String, Any)*) {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFTincanPackageLocalServiceUtil.createLFTincanPackage()

    newEntity.setCourseID(entity.courseID)
    newEntity.setTitle(entity.title)
    newEntity.setSummary(entity.summary.getOrElse(null))
    newEntity.setAssetRefID(entity.assetRefID)
    entity.logo.foreach(newEntity.setLogo)

    val id = LFTincanPackageLocalServiceUtil.addLFTincanPackage(newEntity).getId.toInt
    val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.tincanPackage.toString))
    limitEntity.setPassingLimit(entity.passingLimit)
    limitEntity.setRerunInterval(entity.rerunInterval)
    limitEntity.setRerunIntervalType(entity.rerunIntervalType.toString)
    LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)
    id
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Any)) => {
        LFTincanPackageLocalServiceUtil.deleteLFTincanPackage(getLong(id))
        val passingLimitEntity = LFLessonLimitLocalServiceUtil.findByID(getLong(id), LessonType.tincanPackage.toString)
        LFLessonLimitLocalServiceUtil.deleteLFLessonLimit(passingLimitEntity)
      }
    }
  }

  def modify(parameters: (String, Any)*) {
    val lfEntity = parameters match {
      case Seq(("id", id: Int), ("title", title: String), ("summary", summary: String)) => {
        val entity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(id.toLong: java.lang.Long)).get(0)
        entity.setTitle(title)
        entity.setSummary(summary)
        entity
      }
      case Seq(("id", id: Any), ("assetRefID", assetRefID: Any)) => {
        val entity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).get(0)
        entity.setAssetRefID(getLong(assetRefID))
        entity
      }
      case Seq(("id", id: Int), ("logo", logo: Option[String])) => {
        val entity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).get(0)
        logo.foreach(entity.setLogo)
        entity
      }
      case Seq(("id", id: Int), ("passingLimit", passingLimit: Int), ("rerunInterval", rerunInterval: Int), ("rerunIntervalType", rerunIntervalType: String)) => {
        val entity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(id.toLong: java.lang.Long)).get(0)
        try {
          val limitEntity = LFLessonLimitLocalServiceUtil.findByID(entity.getId, LessonType.tincanPackage.toString)
          limitEntity.setPassingLimit(passingLimit)
          limitEntity.setRerunInterval(rerunInterval)
          limitEntity.setRerunIntervalType(rerunIntervalType)
          LFLessonLimitLocalServiceUtil.updateLFLessonLimit(limitEntity)
        } catch {
          case _ => {
            val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.tincanPackage.toString))
            limitEntity.setPassingLimit(passingLimit)
            limitEntity.setRerunInterval(rerunInterval)
            limitEntity.setRerunIntervalType(rerunIntervalType)
            LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)
          }
        }
        entity
      }
    }
    LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
  }

  def modify(entity: TincanManifest, parameters: (String, Any)*) { throw new UnsupportedOperationException }
  def getByID(id: Int, parameters: (String, Any)*) = {
    Option(LFTincanPackageLocalServiceUtil.getLFTincanPackage(id)).map(extract)
  }

  def createAndGetID(entity: TincanManifest, parameters: (String, Any)*) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFTincanPackageLocalServiceUtil.createLFTincanPackage()

    newEntity.setCourseID(entity.courseID)
    newEntity.setSummary(entity.summary.getOrElse(null))
    newEntity.setTitle(entity.title)

    val id = LFTincanPackageLocalServiceUtil.addLFTincanPackage(newEntity).getId.toInt

    val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.tincanPackage.toString))
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
          LFTincanPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
        }
        case _ => {
          val packageIDs = LFAttemptLocalServiceUtil.getLFAttempts(-1, -1).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
          LFTincanPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
        }
      }
    } else {
      Nil
    }
  }

  def createAndGetID(parameters: (String, Any)*) = { throw new UnsupportedOperationException }

  def execute(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException }

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[TincanManifest] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException }
}
