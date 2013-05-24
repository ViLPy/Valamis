UPDATE Package SET
id = :id
<#if title??>
, title = :title
</#if>
<#if summary??>
, summary = :summary
</#if>
<#if assetRefID??>
, assetRefID = :assetRefID
</#if>
WHERE id = :id