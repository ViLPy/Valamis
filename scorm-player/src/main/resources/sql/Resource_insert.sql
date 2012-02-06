INSERT INTO Resource(packageID, resourceType, href, base, scormType)
VALUES (:packageID, :e.resourceType, :e.href, :e.base, :e.scormType.toString)