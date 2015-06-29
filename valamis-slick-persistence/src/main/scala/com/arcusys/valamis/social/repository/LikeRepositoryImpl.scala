package com.arcusys.valamis.social.repository

import com.arcusys.valamis.model.Order
import com.arcusys.valamis.social.model._
import com.arcusys.valamis.social.schema.LikeTableComponent
import com.arcusys.valamis.social.storage.LikeRepository
import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class LikeRepositoryImpl(
    db: JdbcBackend#DatabaseDef,
    val driver: JdbcProfile)
  extends LikeRepository
  with LikeTableComponent {

  import driver.simple._

  override def create(like: Like): Like = db.withSession { implicit session =>
    val id = likes.returning(likes.map(_.id)).insert(like)
    likes.filter(_.id === id).first
  }

  override def delete(userId: Long, activityId: Long) =
    db.withSession{ implicit session =>
      likes
        .filter(like => like.userId === userId && like.activityId === activityId)
        .delete
    }

  override def getBy(likeRequest: LikeFilter) = db.withSession { implicit session =>
    composeQuery(likeRequest).run
  }

  override def getCountBy(likeRequest: LikeFilter) = db.withSession { implicit session =>
    composeQuery(likeRequest).length.run
  }

  private def composeQuery(likeReq: LikeFilter)(implicit session: JdbcBackend#Session) = {
    val companyIdFiltered = likes.filter(_.companyId === likeReq.companyId)
    val userIdFiltered =
      if(likeReq.userId.isDefined) companyIdFiltered.filter(_.userId === likeReq.userId.get)
      else companyIdFiltered
    val subjectFiltered =
      if(likeReq.activityId.isDefined) userIdFiltered.filter(like => like.activityId === likeReq.activityId)
      else userIdFiltered
    val sorted =
      if(likeReq.sortBy.isDefined){
        likeReq.sortBy.get match {
          case LikeSortBy(LikeSortByCriteria.CreationDate, Order.Asc) => subjectFiltered.sortBy(_.creationDate)
          case LikeSortBy(LikeSortByCriteria.CreationDate, Order.Desc) => subjectFiltered.sortBy(_.creationDate.desc)
          case unsupported =>
            val errorMessage = s"sort criterion ${unsupported.toString} is not supported"
            throw new UnsupportedOperationException(errorMessage)}}
      else subjectFiltered
    sorted
  }
}
