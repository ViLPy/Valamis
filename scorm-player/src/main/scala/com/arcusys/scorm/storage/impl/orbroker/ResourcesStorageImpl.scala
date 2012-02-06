package com.arcusys.scorm.storage.impl.orbroker

import com.arcusys.scorm.model._
import com.arcusys.scorm.storage._
import org.orbroker.Row
import org.orbroker.RowExtractor

import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
import org.orbroker.Token
import org.orbroker.conv._

class ResourcesStorageImpl extends ResourcesStorage with GenericEntityStorageImpl[Resource]
{
  def tablePath: String = "Resource"
  def extractor = Extractor
  def idParam = "id"

  def getByPackageID(packageID: Int) =
  {
    defParams.clear
    defParams += "packageID"->packageID
    getAll
  }

  def getByID(packageID: Int, resourceID: Int) =
  {
    broker.readOnly() { session => session.selectOne(Token(Symbol(tablePath), Extractor),
                                                     "packageID"->packageID,
                                                     "id"->resourceID) }
  }

  def create(packageID: Int, entity: Resource) =
  {
    defParams.clear
    defParams += "packageID"->packageID
    create(entity)
  }
  
  
  
  object Extractor extends RowExtractor[Resource]
  {
    def extract(row: Row) = new Resource(
      row.integer("id").get.toString,
      row.string("resourceType").get,
      row.string("href"),
      row.string("base"),
      (if (row.string("scormType").getOrElse("").toLowerCase.equals("sco")) ResourceScormType.Sco else ResourceScormType.Asset),
      None)//metadata
  } 
}
