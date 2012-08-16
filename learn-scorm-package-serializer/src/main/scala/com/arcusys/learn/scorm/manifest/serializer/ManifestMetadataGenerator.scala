package com.arcusys.learn.scorm.manifest.serializer

import com.arcusys.learn.scorm.manifest.model.Manifest

object ManifestMetadataGenerator {
  def toXML(manifest: Manifest) =
    <metadata>
      <schema>
        "ADL SCORM"
      </schema>
      <schemaversion>
        {manifest.scormVersion}
      </schemaversion>
    </metadata>
}
