SELECT * FROM Activity
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if organizationID??>
AND organizationID = :organizationID
</#if>
ORDER BY id