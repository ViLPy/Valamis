SELECT * FROM Quiz
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if courseID??>
  <#if courseID == -1>
    AND courseID is null
    <#else>
    AND (courseID = :courseID OR  courseID is null)
    </#if>
</#if>
ORDER BY id