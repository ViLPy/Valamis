<#if siblingID??>

UPDATE QuestionCategory SET
    parentID = :parentID,
    "position"=(SELECT "position" FROM QuestionCategory WHERE id = :siblingID)
<#if moveAfter == true> 
+1
-- Woohoo! Template magic! Increase position by 1. Refers to "position"=...
</#if>
WHERE id = :id;

UPDATE QuestionCategory SET 
    "position" = "position" + 1
WHERE
<#if hasParentID??>
    parentID = :parentID
<#else>
    (parentID is null)
</#if>
<#if moveAfter>
    AND ("position" > (SELECT "position" FROM QuestionCategory WHERE id = :siblingID))
<#else>
    AND ("position" >= (SELECT "position" FROM QuestionCategory WHERE id = :siblingID))
</#if>
 AND (id != :id);

<#else>

UPDATE QuestionCategory SET
    parentID = :parentID,
    -- if this is empty group, then set position as 1
    "position" = COALESCE((SELECT "position" 
                            FROM QuestionCategory 
                            WHERE 
                            <#if parentID??>
                                parentID = :parentID
                            <#else>
                                (parentID is null)
                            </#if>
                            AND id != :id ORDER BY "position" DESC LIMIT 1),
                           0) + 1
WHERE id = :id;

</#if>