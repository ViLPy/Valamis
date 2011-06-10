package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import scala.xml.Elem
import XMLImplicits._

class ManifestParser(val root: Elem) {
  def parse = {
    if (!root.label.equals("manifest")) throw new SCORMParserException("Root element of manifest is not <manifest>")
    //Map<String, Namespace> namespaces = new HashMap<String, Namespace>()
    //val imscpNamespace = manifestElement.getNamespace
    //val adlcpNamespace = manifestElement.getNamespace("adlcp")
    
    val xmlNs = "http://www.w3.org/XML/1998/namespace"
    val imscpNs = root.namespace
    val adlcpNs = root.getNamespace("adlcp")
    val adlseqNs = root.getNamespace("adlseq")
    val identifier = root %! "identifier"
    val version = root %? "version"
    val base = root %? (xmlNs, "base")
    ParserUtil.checkBaseAttributeValue(base)
    val metadataElem = root \! "metadata"    
    val organizationsElement = root \! "organizations"
    val resourcesElem = root \! "resources"
    val sequencingCollectionElement = root \? ("imsss","sequencingCollection")
    val organizationElements = organizationsElement\"organization"
    val defaultOrganizationIdentifier = organizationsElement %? "default"

    if ((organizationElements.length > 0) && (defaultOrganizationIdentifier == None)) throw new SCORMParserException("<organizations> element contains <organization> elements but does not have the default attribute defined")
    if ((organizationElements.length == 0) && (defaultOrganizationIdentifier != None)) throw new SCORMParserException("<organizations> element does not contain <organization> elements but has the default attribute defined")    
    
    val resourceElements = resourcesElem \ "resource"
    val resourcesBase = resourcesElem %? (xmlNs, "base")
    ParserUtil.checkBaseAttributeValue(resourcesBase)
    val metadataParser = new MetadataParser(metadataElem)
    val manifest = new Manifest(identifier, version, base, metadataParser.parseForManifest, defaultOrganizationIdentifier, resourcesBase, "New manifest")

    for (e<-resourceElements) {
      e.foreach(resourceElement => {
          val resource = new ResourceParser(resourceElement.asInstanceOf[Elem], manifest.metadata.schemaversion, adlcpNs).parse
          if (manifest.resources.contains(resource.identifier)) throw new SCORMParserException("<resources> element contains <resource> elements with non-unique identifier attributes")
          manifest.resources(resource.identifier) = resource
        })
    }
    manifest.resources.keySet.foreach(resourceIdentifier => 
      manifest.resources(resourceIdentifier).dependencyIdentifiers.foreach(dependencyIdentifier =>
        if (!manifest.resources.contains(dependencyIdentifier)) throw new SCORMParserException("<resource> element contains <dependency> element referencing a non-existing resource: " + dependencyIdentifier)
      )
    )
    var defaultOrganizationFound = false
    organizationElements.foreach(organizationElement =>
      {        
        val organization = new OrganizationParser(organizationElement.asInstanceOf[Elem], manifest, adlcpNs, adlseqNs).parse
        if (organization.identifier == manifest.defaultOrganizationIdentifier.get) defaultOrganizationFound = true
        if (manifest.organizations.contains(organization.identifier)) throw new SCORMParserException("<organizations> element contains <organization> elements with non-unique identifier attributes")
        manifest.organizations(organization.identifier) = organization
      })

    if (!defaultOrganizationFound) throw new SCORMParserException("Organization referenced by the default attribute of the <organizations> element not found among the <organization> elements while searching by identifier: "+manifest.defaultOrganizationIdentifier)
    for (e<-sequencingCollectionElement)       
      for (sequencingElement<-e \!! ("imsss","sequencing")) {
        val sequencing = new SequencingParser(sequencingElement, true).parse
        manifest.sequencingCollection(sequencing.sharedId.get) = sequencing
      }
    
    manifest
  }
}