DELETE FROM FileStorage
<#if deleteByDirectory??>
WHERE (filename LIKE :filename)
<#else>
WHERE (filename = :filename)
</#if>