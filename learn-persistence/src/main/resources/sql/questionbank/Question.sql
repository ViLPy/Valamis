SELECT * FROM Question
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if categoryID??>
    <#if categoryID == -1>
    AND categoryID is null
    <#else>
    AND categoryID = :categoryID
    </#if>
</#if>
<#if courseID??>
  <#if courseID == -1>
    AND courseID is null
    <#else>
    AND (courseID = :courseID OR   courseID is null)
    </#if>
</#if>
ORDER BY arrangementIndex,id