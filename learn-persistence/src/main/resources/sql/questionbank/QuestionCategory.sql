SELECT * FROM QuestionCategory
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if courseID??>
  <#if courseID == -1>
    AND courseID is null
    <#else>
    AND (courseID = :courseID OR   courseID is null)
    </#if>
</#if>
<#if parentID??>
    <#if parentID == -1>
    AND parentID is null
    <#else>
    AND parentID = :parentID
    </#if>
</#if>
ORDER BY "position",id