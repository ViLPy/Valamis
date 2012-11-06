SELECT * FROM Answer
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if questionID??>
AND questionID = :questionID
</#if>
ORDER BY id