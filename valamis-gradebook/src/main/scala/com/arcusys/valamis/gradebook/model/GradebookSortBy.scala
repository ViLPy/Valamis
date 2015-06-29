package com.arcusys.valamis.gradebook.model

object GradebookUserSortBy extends Enumeration {
  type GradebookUserSortBy = Value
  val name, org, last_modified = Value

  def apply(v: String): GradebookUserSortBy = GradebookUserSortBy.withName(v.toLowerCase)
}

