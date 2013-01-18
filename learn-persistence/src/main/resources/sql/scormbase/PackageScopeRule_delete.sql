DELETE FROM PackageScopeRule
WHERE packageID = :packageID
<#if scope??>
AND scope = :scope
</#if>
<#if scopeID??>
AND scopeID = :scopeID
</#if>