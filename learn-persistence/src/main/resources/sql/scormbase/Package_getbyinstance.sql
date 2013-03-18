SELECT p.*, r.visibility, r.isDefault FROM Package AS p
LEFT JOIN
(SELECT * FROM PackageScopeRule WHERE scope = 'instanceScope') AS r
ON p.id = r.packageID
--LEFT OUTER JOIN PackageScopeRule AS r
--ON p.id = r.packageID
WHERE 1 = 1
<#if ids??>
AND (courseID <@IN seq="ids"/> OR courseID is NULL)
</#if>
--AND r.scope = 'instanceScope'
<#if onlyVisible??>
AND visibility IS TRUE
</#if>
<#if packageId??>
AND r.packageId  = :packageId
</#if>
ORDER BY id