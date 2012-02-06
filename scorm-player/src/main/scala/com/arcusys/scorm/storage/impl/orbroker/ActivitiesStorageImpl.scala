package com.arcusys.scorm.storage.impl.orbroker

import com.arcusys.scorm.model._
import com.arcusys.scorm.storage._
import org.orbroker.Row
import org.orbroker.RowExtractor

import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
import org.orbroker.Token
import org.orbroker.conv._

class ActivitiesStorageImpl extends ActivitiesStorage with GenericEntityStorageImpl[Activity]
{
  def tablePath = "Activity"
  def extractor = Extractor
  def idParam = "id"

  def getAllByParam(packageID: Int, organizationID: Int): IndexedSeq[Activity] =
  {
    val allActivities = broker.readOnly() { session => session.selectAll(Token(Symbol(tablePath), Extractor),
                                                                         "packageID"->packageID,
                                                                         "organizationID"->organizationID) }

    // collect all activities (with casting to ContainerActivity if needed) and append LeafActivity into a containers
    val allLeafActivities = allActivities.filter(_.isInstanceOf[LeafActivity])

    def getContainer(activity: ContainerActivity):Activity =
    {
      activity.asInstanceOf[ContainerActivity].childActivities ++= allLeafActivities.filter(leaf=>leaf.parentID!=None && leaf.parentID.get == activity.id).map
      {
        subActivity =>
        if (subActivity.isInstanceOf[ContainerActivity]) getContainer(subActivity.asInstanceOf[ContainerActivity])
        else subActivity
      }
      activity
    }

    allActivities.map{
      activity => {
        if (activity.isInstanceOf[ContainerActivity]) getContainer(activity.asInstanceOf[ContainerActivity])
        else activity
      }
    }.filter(activity=> (!activity.isInstanceOf[LeafActivity] || activity.parentID.isEmpty))
  }

  def getByID(packageID: Int, organizationID: Int, activityID: Int): Option[Activity] =
  {
    broker.readOnly() { session => session.selectOne(Token(Symbol(tablePath), Extractor),
                                                     "packageID"->packageID,
                                                     "organizationID"->organizationID,
                                                     "activityID"->activityID) }
  }

  def create(packageID: Int, organizationID: Int, entity: Activity, parentID: Option[Int] = None) =
  {
    defParams.clear
    defParams += "packageID"->packageID
    defParams += "organizationID"->organizationID
    defParams += "parentID"->parentID
    defParams += "identifierRef" -> (entity match {
        case l:LeafActivity => l.resourceIdentifier
        case _ => ""
      })
    defParams += "resourceParameters" -> (entity match {
        case l:LeafActivity => l.resourceParameters
        case _ => ""
      })
    create(entity)
  }

  object Extractor extends RowExtractor[Activity]
  {
    def extract(row: Row) =
    {
      val identifierRef = row.string("identifierRef").getOrElse("")
      val parentId = row.string("parentID")
      if (identifierRef.isEmpty)
        new ContainerActivity(
          row.integer("id").get.toString,
          true, //visible
          row.string("title").get,
          None, //metadata
          None, //completionThreshold
          None, //sequencing
          scala.collection.immutable.Set(), //hiddenNavigationControls
          parentId)

      else // leaf activity
        new LeafActivity(
          row.integer("id").get.toString,
          true, //visible
          row.string("title").get,
          None, //metadata
          None, //completionThreshold
          None, //sequencing
          scala.collection.immutable.Set(), //hiddenNavigationControls
          row.string("identifierRef").get,
          row.string("resourceParameters"),
          TimeLimitAction.NotDefined, //timeLimitAction
          Some("dataFromLMS"),
          parentId
        )
    }
  }
}
