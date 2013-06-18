SELECT * FROM PackageScopeRule
WHERE
scope = :scope
<#if scopeID??>
AND (scopeID = :scopeID)
<#else>
AND scopeID is null
</#if>
--AND visibility = TRUE
AND isDefault = TRUE
