SELECT * FROM Attempt
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if userID??>
AND userID = :userID
</#if>
<#if packageID??>
AND packageID = :packageID
</#if>
<#if organizationID??>
AND organizationID = :organizationID
</#if>
<#if isComplete??>
AND isComplete = :isComplete
</#if>
<#if getLast??>
ORDER BY id DESC
LIMIT 1
<#else>
ORDER BY id
</#if>
