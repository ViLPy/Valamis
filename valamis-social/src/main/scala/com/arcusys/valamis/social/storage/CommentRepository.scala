package com.arcusys.valamis.social.storage

import com.arcusys.valamis.social.model.{Comment, CommentFilter}

trait CommentRepository {
  def create(comment: Comment): Comment
  def update(comment: Comment): Comment
  def delete(id: Long): Unit
  def getById(id: Long): Option[Comment]
  def getBy(commentRequest: CommentFilter): Seq[Comment]
  def getCountBy(CommentRequest: CommentFilter): Long
}
