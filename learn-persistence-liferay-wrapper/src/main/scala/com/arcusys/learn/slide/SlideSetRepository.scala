package com.arcusys.learn.slide

import SlideEntityConverters._
import com.arcusys.learn.persistence.liferay.service.{ LFSlideSetLocalServiceUtil => SLideSetUtil }
import com.arcusys.valamis.slide.model.{SlideSetEntity, SlideSetModel}
import com.arcusys.valamis.slide.storage.SlideSetRepositoryContract
import scala.collection.JavaConversions._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

class SlideSetRepository extends SlideSetRepositoryContract {
  override def getCount = SLideSetUtil.getLFSlideSetsCount

  private def getAll: List[SlideSetEntity] = SLideSetUtil.getLFSlideSets(0, getCount).toList

  override def getById(id: Long) = Option(SLideSetUtil.fetchLFSlideSet(id))

  override def getSlideSets(titleFilter: String, sortTitleAsc: Boolean, page: Int, itemsOnPage: Int, courseId: Option[Long]) = {
    val slideSets = getByCourseId(courseId)
      .filter(x => x.title.toLowerCase.contains(titleFilter.toLowerCase))
      .sortBy(_.title)

    val sortedWithDirection = if (sortTitleAsc) slideSets else slideSets.reverse
    sortedWithDirection.drop((page - 1) * itemsOnPage).take(itemsOnPage)
  }

  override def getSlideSetsCount(titleFilter: String, courseId: Option[Long]) = {
    getByCourseId(courseId).count(x => x.title.toLowerCase.contains(titleFilter.toLowerCase))
  }

  private def getByCourseId(courseId: Option[Long]) : List[SlideSetEntity] = {
    courseId match {
      case Some(id) => SLideSetUtil.findByCourseId(courseId).toList ++ SLideSetUtil.findByCourseId(None).toList
      case _ => getAll
    }
  }

  override def delete(id: Long) = SLideSetUtil.deleteLFSlideSet(id)

  override def update(slideSetModel: SlideSetModel) = {
    val slideSet = SLideSetUtil.getLFSlideSet(slideSetModel.id.get)
    slideSet.setTitle(slideSetModel.title)
    slideSet.setDescription(slideSetModel.description)
    slideSet.setLogo(slideSetModel.logo)
    SLideSetUtil.updateLFSlideSet(slideSet)
  }

  override def create(slideSetModel: SlideSetModel) = {
    val slideSet = SLideSetUtil.createLFSlideSet()
    slideSet.setTitle(slideSetModel.title)
    slideSet.setDescription(slideSetModel.description)
    slideSet.setCourseId(slideSetModel.courseId)
    slideSet.setLogo(slideSetModel.logo)
    SLideSetUtil.updateLFSlideSet(slideSet)
  }
}