<#if dbType=="mysql" >
    <#if siblingID??>
        UPDATE QuestionCategory SET
            parentID = :parentID,
            arrangementIndex=(select p.arrangementIndex from (SELECT arrangementIndex FROM QuestionCategory WHERE id = :siblingID)as p)
        <#if moveAfter == true>
            +1
            -- Woohoo! Template magic! Increase arrangementIndex by 1. Refers to "arrangementIndex"=...
        </#if>
        WHERE id = :id;

        UPDATE QuestionCategory SET
            arrangementIndex = arrangementIndex + 1
        WHERE
        <#if hasParentID??>
            parentID = :parentID
        <#else>
            (parentID is null)
        </#if>
        <#if moveAfter>
            AND (arrangementIndex > (select p.arrangementIndex from (SELECT arrangementIndex FROM QuestionCategory WHERE id = :siblingID) as p))
        <#else>
            AND (arrangementIndex >= (select p.arrangementIndex from (SELECT arrangementIndex FROM QuestionCategory WHERE id = :siblingID) as p))
        </#if>
         AND (id != :id);
    <#else>
        UPDATE QuestionCategory SET
            parentID = :parentID,
            -- if this is empty group, then set arrangementIndex as 1
            arrangementIndex = COALESCE((select p.arrangementIndex from (SELECT arrangementIndex FROM QuestionCategory
                                    WHERE
                                      <#if parentID??>
                                          parentID = :parentID
                                      <#else>
                                          (parentID is null)
                                      </#if>
                                    AND id != :id
                                    ORDER BY arrangementIndex DESC LIMIT 1) as p), 0) + 1
        WHERE id = :id;
    </#if>
<#else>
    <#if siblingID??>
        UPDATE QuestionCategory SET
            parentID = :parentID,
            arrangementIndex=(SELECT arrangementIndex FROM QuestionCategory WHERE id = :siblingID)
        <#if moveAfter == true>
            +1
            -- Woohoo! Template magic! Increase arrangementIndex by 1. Refers to "arrangementIndex"=...
        </#if>
        WHERE id = :id;

        UPDATE QuestionCategory SET
            arrangementIndex = arrangementIndex + 1
        WHERE
            <#if hasParentID??>
                parentID = :parentID
            <#else>
                (parentID is null)
            </#if>
            <#if moveAfter>
                AND (arrangementIndex > (SELECT arrangementIndex FROM QuestionCategory WHERE id = :siblingID))
            <#else>
                AND (arrangementIndex >= (SELECT arrangementIndex FROM QuestionCategory WHERE id = :siblingID))
            </#if>
        AND (id != :id);
    <#else>
        UPDATE QuestionCategory SET
            parentID = :parentID,
            -- if this is empty group, then set arrangementIndex as 1
            arrangementIndex = COALESCE((SELECT arrangementIndex
                                    FROM QuestionCategory
                                    WHERE
                                    <#if parentID??>
                                        parentID = :parentID
                                    <#else>
                                        (parentID is null)
                                    </#if>
                                    AND id != :id ORDER BY arrangementIndex DESC LIMIT 1),
                                   0) + 1
        WHERE id = :id;
    </#if>
</#if>;