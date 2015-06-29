package com.arcusys.valamis.lesson.scorm.service.serializer

import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest

object ManifestMetadataGenerator {
  def toXML(manifest: Manifest) =
    <metadata>
      <schema>
        ADL SCORM
      </schema>
      <schemaversion>
        { manifest.scormVersion }
      </schemaversion>
    </metadata>
}
