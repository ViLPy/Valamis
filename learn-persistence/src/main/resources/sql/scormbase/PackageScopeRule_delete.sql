DELETE FROM PackageScopeRule
WHERE packageID = :packageID
<#if scope??>
AND scope = :scope
</#if>
<#if scopeID??>
   <#if scopeID == '-1'>
    AND scopeID is null
  <#else>
    AND scopeID = :scopeID
  </#if>
</#if>