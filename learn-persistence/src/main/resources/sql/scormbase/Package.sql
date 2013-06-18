SELECT  p.* FROM Package AS p
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if packageId??>
AND id = :packageId
</#if>
<#if refID??>
AND assetRefID = :refID
</#if>
<#if courseID??>
AND courseID = :courseID
</#if>
<#if ids??>
AND (courseID <@IN seq="ids"/> OR courseID is NULL)
</#if>
ORDER BY id