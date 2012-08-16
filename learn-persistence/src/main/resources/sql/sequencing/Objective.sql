SELECT * FROM Objective
WHERE 1=1
<#if id??>
AND id = :id
</#if>
<#if isPrimary??>
AND isPrimary = :isPrimary
</#if>
<#if sequencingID??>
AND sequencingID = :sequencingID
</#if>