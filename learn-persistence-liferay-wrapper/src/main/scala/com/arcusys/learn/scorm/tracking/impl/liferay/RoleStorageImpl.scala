package com.arcusys.learn.scorm.tracking.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFRole
import com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.{ Role, PermissionType }
import com.arcusys.learn.scorm.tracking.storage.RoleStorage
import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.10.14.
 */
class RoleStorageImpl extends RoleStorage {

  override def renew(): Unit = {
    LFRoleLocalServiceUtil.removeAll()
  }

  override def getAll: Seq[Role] = {
    LFRoleLocalServiceUtil.getLFRoles(-1, -1).asScala.map(extract)
  }

  override def getByID(id: Int): Option[Role] = {
    Option(LFRoleLocalServiceUtil.getLFRole(id)) map extract
  }

  override def createAndGetID(role: Role): Int = {
    val lfEntity = LFRoleLocalServiceUtil.createLFRole()
    lfEntity.setLiferayRoleID(role.liferayRoleID)
    lfEntity.setPermission(role.permission.toString)
    lfEntity.setIsDefault(role.isDefault)
    LFRoleLocalServiceUtil.addLFRole(lfEntity).getId.toInt
  }

  override def delete(liferayRoleID: Int, permission: PermissionType.Value) {
    LFRoleLocalServiceUtil.removeByRoleIDAndPermission(liferayRoleID, permission.toString)
  }

  override def getForPermission(permission: PermissionType.Value): Seq[Role] = {
    LFRoleLocalServiceUtil.findByPermission(permission.toString).asScala.map(extract)
  }

  override def getDefault(permission: PermissionType.Value): Option[Role] = {
    LFRoleLocalServiceUtil.findByDefaultAndPermission(permission.toString, true).asScala.headOption.map(extract)
  }

  override def getDefault(liferayRoleID: Int, permission: PermissionType.Value): Option[Role] = {
    LFRoleLocalServiceUtil.findByRoleIDAndPermission(liferayRoleID, permission.toString).asScala.headOption.map(extract)
  }

  override def update(id: Int, permission: PermissionType.Value, isDefault: Boolean) {
    if (isDefault) {
      val roles = LFRoleLocalServiceUtil.findByPermission(permission.toString).asScala
      roles.foreach(role => {
        role.setIsDefault(false)
        LFRoleLocalServiceUtil.updateLFRole(role)
      })
    }

    val role = LFRoleLocalServiceUtil.getLFRole(id)
    role.setIsDefault(isDefault)
    LFRoleLocalServiceUtil.updateLFRole(role)
  }

  def extract(lfEntity: LFRole) =
    if (lfEntity == null) null
    else new Role(lfEntity.getId.toInt, lfEntity.getLiferayRoleID, PermissionType.withName(lfEntity.getPermission), lfEntity.getIsDefault)

}
