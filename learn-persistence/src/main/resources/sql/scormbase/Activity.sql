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
    <#if parentID == "-1">
    AND parentID is null
    <#else>
    AND parentID = :parentID
    </#if>
</#if>
<#if dbType=="mysql">
ORDER BY indexNumber ASC, id ASC
<#else>
ORDER BY indexNumber, id
</#if>;