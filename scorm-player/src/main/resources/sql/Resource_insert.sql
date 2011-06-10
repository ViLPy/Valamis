INSERT INTO Resource(packageID, resourceID, resourceType, href, base, scormType)
VALUES (:packageID, :e.identifier, :e.resourceType, :e.href, :e.base, :e.scormType.toString)