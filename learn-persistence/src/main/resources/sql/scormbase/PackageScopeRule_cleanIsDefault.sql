UPDATE PackageScopeRule
SET isDefault = NULL
WHERE
scope = :scope
<#if scopeID??>
AND scopeID = :scopeID
<#else>
AND scopeID is null
</#if>