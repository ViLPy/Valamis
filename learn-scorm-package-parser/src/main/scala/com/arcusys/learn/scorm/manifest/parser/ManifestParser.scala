package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import scala.xml.Elem
import XMLImplicits._

class ManifestParser(root: Elem, title: String, summary: String) {
  def parse = {
    if (!root.label.equals("manifest")) throw new SCORMParserException("Root element of manifest is not <manifest>")
    //Map<String, Namespace> namespaces = new HashMap<String, Namespace>()
    //val imscpNamespace = manifestElement.getNamespace
    //val adlcpNamespace = manifestElement.getNamespace("adlcp")

    val xmlNs = "http://www.w3.org/XML/1998/namespace"
    val imscpNs = root.namespace
    implicit val adlcpNs = root.getNamespace("adlcp")
    implicit val adlseqNs = root.getNamespace("adlseq")
    //val identifier = root attr "identifier" required()
    val manifestVersion = root attr "version" optional string
    val base = root attr(xmlNs, "base") optional string
    val metadataElem = root childElem "metadata" required element
    val metadata = parseMetadata(metadataElem)
    val schema = metadataElem childElem "schema" required string
    val scormVersion = metadataElem childElem "schemaversion" required string
    val organizationsElement = root childElem "organizations" required element
    val resourcesElem = root childElem "resources" required element
    val sequencingCollectionElement = root childElem ("imsss", "sequencingCollection") optional element
    val sequencingElements = sequencingCollectionElement children ("imsss", "sequencing") map parseSharedSequencing
    val organizationElements = organizationsElement children "organization"
    val defaultOrganizationIdentifier = organizationsElement attr "default" optional string

    if ((organizationElements.length > 0) && (defaultOrganizationIdentifier == None)) throw new SCORMParserException("<organizations> element contains <organization> elements but does not have the default attribute defined")
    if ((organizationElements.length == 0) && (defaultOrganizationIdentifier != None)) throw new SCORMParserException("<organizations> element does not contain <organization> elements but has the default attribute defined")

    val resourceElements = resourcesElem children "resource"
    val resourcesBase = resourcesElem attr(xmlNs, "base") optional string
    def parseThisResource(elem: Elem) = parseResource(elem, scormVersion, adlcpNs)
    val resources = resourceElements map parseThisResource
    val resourceMap = resources.map(r=>r.id->r).toMap
    def parseThisOrganization(elem: Elem) = parseOrganization(elem, resourceMap, adlcpNs, adlseqNs, sequencingElements)
    val organizations = organizationElements map parseThisOrganization
    if (organizations.find(o => Some(o.item.id) == defaultOrganizationIdentifier).isEmpty)
      throw new SCORMParserException("Organization referenced by the default attribute of the <organizations> element not found among the <organization> elements while searching by identifier: " + defaultOrganizationIdentifier)

    new ManifestDocument(
      new Manifest(0, manifestVersion, base, scormVersion, defaultOrganizationIdentifier, resourcesBase, title, Some(summary), visibility=true,
        metadata = if (!metadata.externalMetadataLocations.isEmpty || !metadata.inlineMetadata.isEmpty) Some(metadata) else None),
      organizations, resources, sequencingElements
    )
  }
}