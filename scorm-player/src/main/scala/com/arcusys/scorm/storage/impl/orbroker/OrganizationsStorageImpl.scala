package com.arcusys.scorm.storage.impl.orbroker

import com.arcusys.scorm.model._
import com.arcusys.scorm.storage._
import org.orbroker.Row
import org.orbroker.RowExtractor

import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
import org.orbroker.Token
import org.orbroker.conv._

class OrganizationsStorageImpl extends OrganizationsStorage with GenericEntityStorageImpl[Organization]
{
  def tablePath = "Organization"
  def extractor = Extractor
  def idParam = "id"

  def getByPackageID(packageID: Int) =
  {
    defParams.clear
    defParams += "packageID"->packageID
    getAll
  }

  def getByID(packageID: Int, organizationID: Int) =
  {
    broker.readOnly() { session => session.selectOne(Token(Symbol(tablePath), Extractor), 
                                                     "packageID"->packageID,
                                                     "organizationID"->organizationID) }
  }

  def create(packageID: Int, entity: Organization) =
  {
    defParams.clear
    defParams += "packageID"->packageID
    create(entity)
  }

  object Extractor extends RowExtractor[Organization]
  {
    def extract(row: Row) = new Organization(
      row.integer("id").get.toString,
      "hierarchical", // structure
      false, //objectivesGlobalToSystem
      false, //sharedDataGlobalToSystem
      row.string("title").get,
      None, //metadata
      None, //completionThreshold
      None) //sequencing
  }
}
