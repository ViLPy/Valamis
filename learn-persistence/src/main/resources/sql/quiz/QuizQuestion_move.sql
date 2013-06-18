<#if dbType=="mysql" >
    <#if siblingID??>
        UPDATE QuizQuestion SET
            categoryID = :parentID,
            arrangementIndex=(select p.arrangementIndex from (SELECT arrangementIndex FROM QuizQuestion WHERE id = :siblingID)as p)
        <#if moveAfter == true>
            +1
            -- Woohoo! Template magic! Increase arrangementIndex by 1. Refers to "arrangementIndex"=...
        </#if>
        WHERE id = :id;

        UPDATE QuizQuestion SET
            arrangementIndex = arrangementIndex + 1
        WHERE
          <#if parentID??>
              categoryID = :parentID
          <#else>
              (categoryID is null)
          </#if>
          <#if moveAfter>
              AND (arrangementIndex > (select p.arrangementIndex from (SELECT arrangementIndex FROM QuizQuestion WHERE id = :siblingID)as p))
          <#else>
              AND (arrangementIndex >= (select p.arrangementIndex from (SELECT arrangementIndex FROM QuizQuestion WHERE id = :siblingID)as p))
          </#if>
         AND (id != :id);
    <#else>
        <#if moveAfter>
            UPDATE QuizQuestion SET
                categoryID = :parentID,
                arrangementIndex = 1
            WHERE id = :id;
            UPDATE QuizQuestion SET
                arrangementIndex = arrangementIndex + 1
            WHERE id != :id AND
                <#if parentID??>
                    categoryID = :parentID;
                <#else>
                    (categoryID is null);
                </#if>
        <#else>
            UPDATE QuizQuestion SET
                categoryID = :parentID,
                arrangementIndex = COALESCE((select p.arrangementIndex from (SELECT arrangementIndex FROM QuizQuestion
                                        WHERE
                                            <#if parentID??>
                                                categoryID = :parentID
                                            <#else>
                                                (categoryID is null)
                                            </#if>
                                        AND id != :id ORDER BY arrangementIndex DESC LIMIT 1) as p),0) + 1
            WHERE id = :id
        </#if>
    </#if>
<#else>
    <#if siblingID??>
        UPDATE QuizQuestion SET
            categoryID = :parentID,
            arrangementIndex=(SELECT arrangementIndex FROM QuizQuestion WHERE id = :siblingID)
        <#if moveAfter == true>
            +1
            -- Woohoo! Template magic! Increase arrangementIndex by 1. Refers to "arrangementIndex"=...
        </#if>
        WHERE id = :id;
        UPDATE QuizQuestion SET
            arrangementIndex = arrangementIndex + 1
        WHERE
            <#if parentID??>
                categoryID = :parentID
            <#else>
                (categoryID is null)
            </#if>
            <#if moveAfter>
                AND (arrangementIndex > (SELECT arrangementIndex FROM QuizQuestion WHERE id = :siblingID))
            <#else>
                AND (arrangementIndex >= (SELECT arrangementIndex FROM QuizQuestion WHERE id = :siblingID))
            </#if>
        AND (id != :id);
    <#else>
        <#if moveAfter>
            UPDATE QuizQuestion SET
                categoryID = :parentID,
                arrangementIndex = 1
            WHERE id = :id;
            UPDATE QuizQuestion SET
                arrangementIndex = arrangementIndex + 1
            WHERE id != :id AND
                <#if parentID??>
                    categoryID = :parentID;
                <#else>
                    (categoryID is null);
                </#if>
        <#else>
            UPDATE QuizQuestion SET
                categoryID = :parentID,
                arrangementIndex = COALESCE((SELECT arrangementIndex
                                        FROM QuizQuestion
                                        WHERE
                                        <#if parentID??>
                                            categoryID = :parentID
                                        <#else>
                                            (categoryID is null)
                                        </#if>
                                        AND id != :id ORDER BY arrangementIndex DESC LIMIT 1),
                                       0) + 1
            WHERE id = :id
        </#if>
    </#if>
</#if>;