<#if moveToCategory>

UPDATE Question SET
    categoryID = :categoryID,
    "position" = COALESCE((SELECT "position" 
                            FROM Question 
                            WHERE 
                            <#if categoryID??>
                                categoryID = :categoryID
                            <#else>
                                (categoryID is null)
                            </#if>
                            AND id != :e.id ORDER BY "position" DESC LIMIT 1),
                           0) + 1
WHERE id = :e.id

<#else>

UPDATE Question SET
    categoryID = :categoryID,
    "position"=(SELECT "position" FROM Question WHERE id = :targetId)
<#if moveAfter == true> 
+1
-- Woohoo! Template magic! Increase position by 1. Refers to "position"=...
</#if>
WHERE id = :e.id;

UPDATE Question SET 
    "position" = "position" + 1
WHERE
<#if categoryID??>
    categoryID = :categoryID
<#else>
    (categoryID is null)
</#if>
<#if moveAfter>
    AND ("position" > (SELECT "position" FROM Question WHERE id = :targetId))
<#else>
    AND ("position" >= (SELECT "position" FROM Question WHERE id = :targetId))
</#if>
 AND (id != :e.id);

</#if>