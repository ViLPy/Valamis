SELECT * FROM Activity
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if packageID??>
AND packageID = :packageID
</#if>
<#if organizationID??>
AND organizationID = :organizationID
</#if>
<#if parentID??>
AND parentID = :parentID
</#if>
<#if dbType=="mysql">
ORDER BY indexNumber ASC, id ASC
<#else>
ORDER BY indexNumber, id
</#if>;