package com.arcusys.valamis.lesson.scorm.service.serializer

import com.arcusys.valamis.lesson.scorm.model.manifest.ManifestDocument

object ManifestGenerator {

  import AttributeImplicits._

  def toXML(doc: ManifestDocument) =
    <manifest identifier={ "manifest" + doc.manifest.id.toString }>
      { ManifestMetadataGenerator.toXML(doc.manifest) }{ OrganizationsGenerator.toXML(doc.organizations, doc.manifest.defaultOrganizationID) }{ ResourcesGenerator.toXML(doc.resources, doc.manifest.resourcesBase) }
    </manifest> % Map(
      "version" -> doc.manifest.version,
      "xml:base" -> doc.manifest.base,
      "xmlns" -> Some("http://www.imsglobal.org/xsd/imscp_v1p1"),
      "xmlns:adlcp" -> Some("http://www.adlnet.org/xsd/adlcp_v1p3")
    )
}