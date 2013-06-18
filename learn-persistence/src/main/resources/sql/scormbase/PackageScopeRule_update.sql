UPDATE PackageScopeRule
SET visibility = :e.visibility,
    isDefault = :e.isDefault
WHERE packageID = :e.packageID
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