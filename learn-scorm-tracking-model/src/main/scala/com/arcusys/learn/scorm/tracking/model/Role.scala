package com.arcusys.learn.scorm.tracking.model


object PermissionType extends Enumeration {
  type PermissionType = Value
  val Teacher = Value("teacher")
  val Student = Value("student")
}

case class Role(
    id: Int,
		liferayRoleID: Int = 0,
    permission:PermissionType.Value,
    isDefault: Boolean)



