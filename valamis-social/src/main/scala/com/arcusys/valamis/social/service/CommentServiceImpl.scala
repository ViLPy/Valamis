package com.arcusys.valamis.social.service

import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.social.model.{Comment, CommentFilter}
import com.arcusys.valamis.social.storage.CommentRepository
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import org.joda.time.DateTime

class CommentServiceImpl(implicit val bindingModule: BindingModule) extends CommentService with Injectable {
  val commentRepository = inject[CommentRepository]

  def create(comment: Comment): Comment = commentRepository.create(comment)

  def updateContent(id: Long, content: String): Comment = {
    val entityToUpdate =
      commentRepository
        .getById(id)
        .getOrElse(throw new EntityNotFoundException(s"Not found comment with id: $id"))

    val alteredEntity = entityToUpdate.copy(content = content, lastUpdateDate = Some(DateTime.now))
    commentRepository.update(alteredEntity)
  }

  def delete(id: Long): Unit = commentRepository.delete(id)

  def getBy(commentRequest: CommentFilter): Seq[Comment] = commentRepository.getBy(commentRequest)

  def getCountBy(commentRequest: CommentFilter): Long = commentRepository.getCountBy(commentRequest)
}