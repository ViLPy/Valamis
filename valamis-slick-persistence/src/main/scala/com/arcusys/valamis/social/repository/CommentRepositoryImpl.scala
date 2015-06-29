package com.arcusys.valamis.social.repository

import com.arcusys.valamis.model.Order
import com.arcusys.valamis.social.model._
import com.arcusys.valamis.social.schema.CommentTableComponent
import com.arcusys.valamis.social.storage.CommentRepository
import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class CommentRepositoryImpl(
    db: JdbcBackend#DatabaseDef,
    val driver: JdbcProfile)
  extends CommentRepository
  with CommentTableComponent {

  import driver.simple._

  def create(comment: Comment): Comment = db.withSession { implicit session =>
    val id = comments.returning(comments.map(_.id)).insert(comment)
    comments.filter(_.id === id).first
  }

  def update(comment: Comment): Comment = db.withSession { implicit session =>
    comments.filter(_.id === comment.id).update(comment)
    comments.filter(_.id === comment.id).first
  }

  def delete(id: Long): Unit = db.withSession { implicit session =>
    comments.filter(_.id === id).delete
  }

  def getById(id: Long) = db.withSession { implicit session =>
    comments.filter(_.id === id).firstOption
  }

  def getBy(commentRequest: CommentFilter) = db.withSession { implicit session =>
    composeQuery(commentRequest).run
  }

  def getCountBy(commentRequest: CommentFilter) = db.withSession { implicit session =>
    composeQuery(commentRequest).length.run
  }

  private def composeQuery(commentReq: CommentFilter)(implicit session: JdbcBackend#Session) = {
    val companyIdFiltered = comments.filter(_.companyId === commentReq.companyId)

    val userIdFiltered =
      if(commentReq.userId.isDefined) companyIdFiltered.filter(_.userId === commentReq.userId.get)
      else companyIdFiltered

    val subjectFiltered =
      if(commentReq.activityId.isDefined)
        userIdFiltered.filter(_.activityId === commentReq.activityId)
      else userIdFiltered

    val sorted =
      if(commentReq.sortBy.isDefined){
        commentReq.sortBy.get match {
          case CommentSortBy(CommentSortByCriteria.CreationDate, Order.Asc) =>
            subjectFiltered.sortBy(_.creationDate)

          case CommentSortBy(CommentSortByCriteria.CreationDate, Order.Desc) =>
            subjectFiltered.sortBy(_.creationDate.desc)

          case unsupported =>
            val errorMessage = s"sort criterion ${unsupported.toString} is not supported"
            throw new UnsupportedOperationException(errorMessage)}}
      else subjectFiltered

    val skipped =
      if(commentReq.skipTake.isDefined)
        sorted
          .drop(commentReq.skipTake.get.skip)
          .take(commentReq.skipTake.get.take)
      else sorted

    skipped
  }
}