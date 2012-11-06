SELECT * FROM Package
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if refID??>
AND assetRefID = :refID
</#if>
<#if visibility??>
AND visibility = :visibility
</#if>
ORDER BY id