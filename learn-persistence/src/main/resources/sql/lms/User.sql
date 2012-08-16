SELECT * FROM LMSUser
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
ORDER BY id