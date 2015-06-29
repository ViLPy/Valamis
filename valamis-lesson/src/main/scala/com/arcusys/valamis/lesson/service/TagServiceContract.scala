package com.arcusys.valamis.lesson.service

import com.arcusys.valamis.lesson.model.ValamisTag

/**
 * Created by ygatilin on 29.01.15.
 */
trait TagServiceContract {

  def getAll(companyId: Long): Iterable[ValamisTag]

  def getEntryTags(entryId: Long): Seq[ValamisTag]

  def assignTags(entryId: Long, tagsId: Seq[Long])

  def unassignTags(entryId: Long, tagsId: Seq[Long])

  def getTagIds(rawIds: Seq[String], companyId: Long): Seq[Long]
}
