SELECT * FROM Activity
WHERE parentID IS NULL
<#if id??>
AND id = :id
</#if>
<#if packageID??>
AND packageID = :packageID
</#if>
<#if dbType=="mysql">
ORDER BY indexNumber ASC, id ASC
<#else>
ORDER BY indexNumber, id
</#if>;