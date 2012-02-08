<#if moveToEnd>

UPDATE QuestionCategory SET
    parentID = :e.parentID,
    -- if this is empty group, then set position as 1
    "position" = COALESCE((SELECT "position" 
                            FROM QuestionCategory 
                            WHERE 
                            <#if hasParentID??>
                                parentID = :e.parentID
                            <#else>
                                (parentID is null)
                            </#if>
                            AND id != :e.id ORDER BY "position" DESC LIMIT 1),
                           0) + 1
WHERE id = :e.id;

<#else>

UPDATE QuestionCategory SET
    parentID = :e.parentID,
    "position"=(SELECT "position" FROM QuestionCategory WHERE id = :targetId)
<#if moveAfter == true> 
+1
-- Woohoo! Template magic! Increase position by 1. Refers to "position"=...
</#if>
WHERE id = :e.id;

UPDATE QuestionCategory SET 
    "position" = "position" + 1
WHERE
<#if hasParentID??>
    parentID = :e.parentID
<#else>
    (parentID is null)
</#if>
<#if moveAfter>
    AND ("position" > (SELECT "position" FROM QuestionCategory WHERE id = :targetId))
<#else>
    AND ("position" >= (SELECT "position" FROM QuestionCategory WHERE id = :targetId))
</#if>
 AND (id != :e.id);

</#if>