<#if siblingID??>

UPDATE QuizQuestion SET
    categoryID = :parentID,
    "position"=(SELECT "position" FROM QuizQuestion WHERE id = :siblingID)
<#if moveAfter == true> 
+1
-- Woohoo! Template magic! Increase position by 1. Refers to "position"=...
</#if>
WHERE id = :id;

UPDATE QuizQuestion SET 
    "position" = "position" + 1
WHERE
<#if parentID??>
    categoryID = :parentID
<#else>
    (categoryID is null)
</#if>
<#if moveAfter>
    AND ("position" > (SELECT "position" FROM QuizQuestion WHERE id = :siblingID))
<#else>
    AND ("position" >= (SELECT "position" FROM QuizQuestion WHERE id = :siblingID))
</#if>
 AND (id != :id);

<#else>

<#if moveAfter>

UPDATE QuizQuestion SET
    categoryID = :parentID,
    "position" = 1
WHERE id = :id;

UPDATE QuizQuestion SET
    "position" = "position" + 1
WHERE id != :id AND
<#if parentID??>
    categoryID = :parentID;
<#else>
    (categoryID is null);
</#if>

<#else>

UPDATE QuizQuestion SET
    categoryID = :parentID,
    "position" = COALESCE((SELECT "position" 
                            FROM QuizQuestion 
                            WHERE 
                            <#if parentID??>
                                categoryID = :parentID
                            <#else>
                                (categoryID is null)
                            </#if>
                            AND id != :id ORDER BY "position" DESC LIMIT 1),
                           0) + 1
WHERE id = :id

</#if>

</#if>