SELECT * FROM FileStorage
WHERE 1 = 1
<#if filename??>
AND filename = :filename
</#if>
<#if directory??>
AND filename LIKE :directory
</#if>
