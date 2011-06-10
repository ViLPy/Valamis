package com.arcusys.scorm.storage.impl.orbroker

import com.arcusys.scorm.storage._
import com.arcusys.scorm.model._
import org.orbroker.Row
import org.orbroker.RowExtractor

class PackagesStorageImpl extends PackagesStorage with GenericEntityStorageImpl[Manifest]
{
  def tablePath = "Package"
  def extractor = Extractor
  def idParam = "id"

  object Extractor extends RowExtractor[Manifest]
  {
    def extract(row: Row) = new Manifest(
      row.integer("id").get.toString,
      None, // version
      row.string("base"),
      new ManifestMetadata("",""),
      row.string("defaultOrganizationID"),
      row.string("resourcesBase"),
      row.string("title").get,
      row.string("summary"))
  }

  def modify(id:Int, entity: Manifest):(Int,Manifest) =
  {
    defParams.clear
    defParams += "id"->id
    modify(entity)
  }
  
  def renewTotally = 
  {
    import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
    import org.orbroker.Token
    import org.orbroker.conv._
    
    broker.transactional() {session=>
      session.execute(Token(Symbol("_DBInit")))
      session.commit
    }
  }
}
