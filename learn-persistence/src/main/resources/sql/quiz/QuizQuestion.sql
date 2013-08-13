SELECT * FROM QuizQuestion
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if quizID??>
AND quizID = :quizID
</#if>
<#if categoryID??>
    <#if categoryID == -1>
    AND categoryID is null
    <#else>
    AND categoryID = :categoryID
    </#if>
</#if>
ORDER BY arrangementIndex,id