package com.arcusys.learn.scorm.tracking.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.tracking.model.{PermissionType, Role}
import com.arcusys.learn.persistence.liferay.service.{LFCertificateLocalServiceUtil, LFRoleLocalServiceUtil}
import com.arcusys.learn.persistence.liferay.model.LFRole
import scala.collection.JavaConverters._


trait LFRoleStorageImpl extends KeyedEntityStorage[Role]{
  protected def doRenew() {
    LFRoleLocalServiceUtil.removeAll()
  }

  def getOne(parameters: (String, Any)*) =  { throw new UnsupportedOperationException("Not implemented") }

  def extract(lfEntity: LFRole) =
    if (lfEntity == null) null
    else new Role(lfEntity.getId.toInt, lfEntity.getLiferayRoleID, PermissionType.withName(lfEntity.getPermission), lfEntity.getIsDefault)

  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("permission", permission: String)) =>
      {
        LFRoleLocalServiceUtil.findByPermission(permission).asScala.map(extract)
      }
      case Seq(("permission", permission: String), ("isDefault", isDefault: Boolean)) =>
      {
        LFRoleLocalServiceUtil.findByDefaultAndPermission(permission, isDefault).asScala.map(extract)
      }
    }
  }
  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def create(entity: Role, parameters: (String, Any)*) {throw new UnsupportedOperationException }
  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("liferayRoleID", roleID: Int), ("permission", permission: String)) =>
      {
        LFRoleLocalServiceUtil.removeByRoleIDAndPermission(roleID, permission)
      }
  }}
  def modify(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Int), ("isDefault", isDefault: Boolean)) => {
        val role = LFRoleLocalServiceUtil.getLFRole(id)
        role.setIsDefault(isDefault)
        LFRoleLocalServiceUtil.updateLFRole(role)
      }
    }
  }
  def modify(entity: Role, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def execute(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    if (sqlKey.equalsIgnoreCase("_cleanIsDefault")) {
      parameters match {
        case Seq(("permission", permisison: String)) => {
          val roles = LFRoleLocalServiceUtil.findByPermission(permisison).asScala
          roles.foreach(role => {
            role.setIsDefault(false)
            LFRoleLocalServiceUtil.updateLFRole(role)
          })
        }
      }
    }
  }

  def getByID(id: Int, parameters: (String, Any)*)= {
    Option(LFRoleLocalServiceUtil.getLFRole(id)) map extract
  }

  def createAndGetID(entity: Role, parameters: (String, Any)*)= {
    val lfEntity = LFRoleLocalServiceUtil.createLFRole()
    lfEntity.setLiferayRoleID(entity.liferayRoleID)
    lfEntity.setPermission(entity.permission.toString)
    lfEntity.setIsDefault(entity.isDefault)
    LFRoleLocalServiceUtil.addLFRole(lfEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException

}
