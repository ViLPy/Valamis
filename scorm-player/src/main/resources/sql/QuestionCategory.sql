SELECT * FROM QuestionCategory
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if parentID??>
    <#if parentID == -1>
    AND parentID is null
    <#else>
    AND parentID = :parentID
    </#if>
</#if>
ORDER BY id