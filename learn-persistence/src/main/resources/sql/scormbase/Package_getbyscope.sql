SELECT  p.*, r.visibility, r.isDefault FROM Package AS p
LEFT JOIN
(SELECT * FROM PackageScopeRule WHERE scope = :scope AND scopeID = :scopeID) AS r
ON p.id = r.packageID
WHERE
courseID = :courseID
<#if packageId??>
AND r.packageId = :packageId
</#if>
ORDER BY id