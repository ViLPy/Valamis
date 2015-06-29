package com.arcusys.valamis.lesson.scorm.model.manifest

/**
 * Custom metadata for some element in the manifest
 * @param externalMetadataLocations List of URLs pointing to separate XML files with metadata. Relative to package base (for resource metadata also to resources common base and resource base)
 * @param inlineMetadata            List of XML elements with metadata in string representation
 */
class Metadata(val externalMetadataLocations: Seq[String], val inlineMetadata: Seq[String])
//TODO: review this. Might be that in domain model this will be replaced with a single String field in every object with metadata or something like that