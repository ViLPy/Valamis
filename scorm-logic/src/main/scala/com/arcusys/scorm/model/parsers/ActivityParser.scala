package com.arcusys.scorm.model.parsers
import com.arcusys.scorm.model._
import scala.xml.Elem
import XMLImplicits._

class ActivityParser(val activityElement: Elem, val manifest: Manifest) {
  def parse: Activity = {
    val identifier = activityElement %! "identifier"
    val resourceIdentifier = activityElement %? "identifierref"
    val visible = (activityElement %? "isvisible").getOrElse("true")
    val resourceParameters = activityElement %? "parameters"
    val titleElement = activityElement \! "title"
    
    val timeLimitActionElement = activityElement \? ("adlcp","timeLimitAction")
    val dataElement = activityElement \? ("adlcp", "data")

    val metadata = (activityElement \? "metadata").map(e=>new MetadataParser(e.asInstanceOf[Elem]).parse)
    val sequencing = (activityElement \? ("imsss", "sequencing")).map(e=>new SequencingParser(e, false).parse)
    val completionThreshold = (activityElement \? ("adlcp", "completionThreshold")).map(e=>new CompletionThresholdParser(e).parse)
    val hiddenNavigationControls = activityElement \? ("adlnav", "presentation") match {
      case None => Set[NavigationControlType.Value]()
      case Some(e) => {
          e \? ("adlnav", "navigationInterface") match {
            case None =>Set[NavigationControlType.Value]()
            case Some(e) => Set[NavigationControlType.Value]()++ (for(c<-e\("adlnav","hideLMSUI")) yield TokenParser.parseNavigationControlType(c.text))
          }
        }
    }
    
    var activity: Activity = null
    val dataFromLMS = (activityElement \? ("adlcp","dataFromLMS")).map(_.text)
    if (resourceIdentifier != None) {      
      val timeLimitAction = timeLimitActionElement.map(_.text) match {
        case None => TimeLimitAction.NotDefined
        case Some("exit,message") => TimeLimitAction.ExitMessage
        case Some("exit,no message") => TimeLimitAction.ExitNoMessage
        case Some("continue,message") => TimeLimitAction.ContinueMessage
        case Some("continue,no message") => TimeLimitAction.ContinueNoMessage
        case _ => throw new SCORMParserException("Unknown value of `timeLimitAction` attribute")
      }
      activity = new LeafActivity(identifier, visible.toBoolean, titleElement.text, metadata, completionThreshold, sequencing, hiddenNavigationControls, resourceIdentifier.get, resourceParameters, timeLimitAction, dataFromLMS, None)
      for (e<-dataElement) {
        val mapElements = e\("adlcp","map")
        mapElements.foreach(mapElement => {
            val targetId = mapElement.asInstanceOf[Elem] %! "targetID"
            val readSharedData = (mapElement.asInstanceOf[Elem] %? "readSharedData").getOrElse("true")
            val writeSharedData = (mapElement.asInstanceOf[Elem] %? "writeSharedData").getOrElse("true")
            val map = new ActivityDataMap(targetId, readSharedData.toBoolean, writeSharedData.toBoolean)
            activity.asInstanceOf[LeafActivity].data += map
          })
      }
      if (!manifest.resources.contains(resourceIdentifier.get)) throw new SCORMParserException("<item> element's `identifierref` points to a non-existing resource: " + resourceIdentifier.get)      
      val resource = manifest.resources(resourceIdentifier.get)
      if (!resource.resourceType.equals("webcontent")) throw new SCORMParserException("<resource> element referenced by an <item> element does not have the `webcontent` value for the `type` attribute: " + resourceIdentifier.get)
      if (resource.href == None) throw new SCORMParserException("<resource> element referenced by an <item> element does not have the `href` attribute specified: " + resourceIdentifier.get)      
    } else {
      activity = new ContainerActivity(identifier, visible.toBoolean, titleElement.text, metadata, completionThreshold, sequencing, hiddenNavigationControls, None)
      if (resourceParameters != None) throw new SCORMParserException("Container <item> element contains a `parameters` attribute")
      if (timeLimitActionElement != None) throw new SCORMParserException("Container <item> element contains a <timeLimitAction> element")
      if (dataFromLMS != None) throw new SCORMParserException("Container <item> element contains a <dataFromLMS> element")
      if (dataElement != None) throw new SCORMParserException("Container <item> element contains a <data> element")
      val childActivityElements = activityElement \ "item"
      if (childActivityElements.length > 0) {
        childActivityElements.foreach(childActivityElement =>
          {
            val childActivity = new ActivityParser(childActivityElement.asInstanceOf[Elem], manifest).parse
            if (manifest.allActivities.contains(childActivity.id)) throw new SCORMParserException("<item> elements with non-unique `identifier` attributes found")
            manifest.allActivities(childActivity.id) = childActivity
            activity.asInstanceOf[ContainerActivity].childActivities += childActivity
          });
      } else throw new SCORMParserException("Container <item> element does not contain child <item> elements")
    }    
    activity
  }
}