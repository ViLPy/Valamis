UPDATE PackageScopeRule
SET isDefault = TRUE
WHERE packageID = :packageID
AND scope = :scope
<#if scopeID??>
  <#if scopeID == '-1'>
    AND scopeID is null
  <#else>
    AND scopeID = :scopeID
  </#if>
<#else>
AND scopeID is null
</#if>