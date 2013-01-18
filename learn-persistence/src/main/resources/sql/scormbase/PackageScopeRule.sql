SELECT * FROM PackageScopeRule
WHERE 1 = 1
<#if packageID??>
AND packageID = :packageID
</#if>
<#if scope??>
AND scope = :scope
</#if>
<#if scopeID??>
AND (scopeID = :scopeID)
<#else>
AND scopeID is null
</#if>
