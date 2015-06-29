package com.arcusys.learn.facades

import com.arcusys.learn.ioc.Configuration
import com.arcusys.valamis.lesson.model.ValamisTag
import com.arcusys.valamis.lesson.service.TagServiceContract
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.models.TagResponse

/**
 * Created by Yuriy Gatilin on 26.01.15.
 */
class TagFacade(config: BindingModule) extends TagFacadeContract with Injectable {

  def this() = this(Configuration)

  implicit val bindingModule = config
  val tagService = inject[TagServiceContract]

  def getAll(companyId: Long): Seq[TagResponse] = {
    tagService.getAll(companyId).map(toTagResponse).toSeq
  }

  def toTagResponse(t: ValamisTag): TagResponse = {
    TagResponse(t.id, t.text)
  }
}