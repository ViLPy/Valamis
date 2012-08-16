package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

/*class OrganizationsStorageImpl extends GenericEntityStorageImpl[Organization]("Organization") with OrganizationsStorage {
  def getByPackageID(packageID: Int) = getAll("packageID" -> packageID)

  def getByID(packageID: Int, organizationID: String) = getOne("packageID" -> packageID, "organizationID" -> organizationID)

  def create(packageID: Int, entity: Organization) {
    create(entity, "packageID" -> packageID)
  }

  def extract(row: Row) = new Organization(
    row.string("id").get,
    row.string("title").get,
    completionThreshold = None,
    sequencing = Sequencing.default,
    objectivesGlobalToSystem = false,
    sharedDataGlobalToSystem = false
    )
}
                    */