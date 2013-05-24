SELECT * FROM PackageScopeRule
WHERE 1 = 1
<#if packageID??>
AND packageID = :packageID
</#if>
<#if scope??>
AND scope = :scope
</#if>
<#if visibility??>
AND visibility = :visibility
</#if>
<#if scopeID??>
  <#if scopeID == '-1'>
    AND scopeID is null
    <#else>
    AND (scopeID = :scopeID)
  </#if>
</#if>