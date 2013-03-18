UPDATE PackageScopeRule
SET isDefault = TRUE
WHERE packageID = :packageID
AND scope = :scope
<#if scopeID??>
AND scopeID = :scopeID
<#else>
AND scopeID is null
</#if>