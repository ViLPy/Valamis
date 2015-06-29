package com.arcusys.valamis.social.service

import com.arcusys.valamis.social.model.{Comment, CommentFilter}

trait CommentService {
  def create(comment: Comment): Comment
  def updateContent(id: Long, content: String): Comment
  def delete(id: Long): Unit
  def getBy(commentRequest: CommentFilter): Seq[Comment]
  def getCountBy(commentRequest: CommentFilter): Long
}