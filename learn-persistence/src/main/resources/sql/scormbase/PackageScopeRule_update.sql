UPDATE PackageScopeRule
SET visibility = :e.visibility
WHERE packageID = :e.packageID
AND scope = :scope
<#if scopeID??>
AND scopeID = :scopeID
<#else>
AND scopeID is null
</#if>