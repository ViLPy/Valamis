SELECT * FROM Course
WHERE 1 = 1
<#if userID??>
AND userID = :userID
</#if>
<#if courseID??>
AND courseID = :courseID
</#if>
ORDER BY courseID