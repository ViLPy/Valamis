DELETE FROM Answer
<#if siblingID??>
WHERE (id = :id)
</#if>
<#if questionID??>
WHERE (questionID = :questionID)
</#if>