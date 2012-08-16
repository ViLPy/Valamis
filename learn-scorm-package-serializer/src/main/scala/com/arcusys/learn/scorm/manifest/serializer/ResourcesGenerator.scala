package com.arcusys.learn.scorm.manifest.serializer

import com.arcusys.learn.scorm.manifest.model.{AssetResource, ScoResource, Resource, ResourceFile}


object ResourcesGenerator {

  import AttributeImplicits._

  def toXML(resources: Seq[Resource], base: Option[String]) = (
    <resources>
      {for (resource <- resources) yield serializeSingleResource(resource)}
    </resources>
    ) % ("xml:base" -> base)

  private def serializeSingleResource(resource: Resource) = (
    <resource identifier={resource.id} type="webcontent">
      {for (file <- resource.files) yield serializeResourceFile(file)}{for (dependency <- resource.dependencyIds) yield serializeDependency(dependency)}
    </resource>) %
    ("href" -> resource.href) %
    ("adlcp:scormType" -> Some(resource match {
      case _: ScoResource => "sco"
      case _: AssetResource => "asset"
    }))

  private def serializeResourceFile(file: ResourceFile) = <file href={file.href}></file>

  private def serializeDependency(id: String) = <dependency identifierref={id}/>
}
