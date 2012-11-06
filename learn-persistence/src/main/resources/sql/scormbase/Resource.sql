SELECT * FROM Resource
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if identifierRef??>
AND identifierRef = :identifierRef
</#if>
<#if packageID??>
AND packageID = :packageID
</#if>
ORDER BY id