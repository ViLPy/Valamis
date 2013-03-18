<#if dbType=="mysql" >
  INSERT INTO QuestionCategory(title, description, parentID, courseID,arrangementIndex)
  VALUES (:e.title, :e.description, :e.parentID,:e.courseID,
        COALESCE((select p.arrangementIndex from (SELECT arrangementIndex FROM QuestionCategory
        WHERE
          <#if parentID??>
              parentID = :parentID
          <#else>
              (parentID is null)
          </#if>
          AND (courseID = :e.courseID)
        ORDER BY arrangementIndex DESC LIMIT 1) as p), 0) + 1)
<#else>
  INSERT INTO QuestionCategory(title, description, parentID, courseID, arrangementIndex)
  VALUES (:e.title, :e.description, :e.parentID,:e.courseID,
        COALESCE((SELECT arrangementIndex FROM QuestionCategory
        WHERE
          <#if parentID??>
              parentID = :parentID
          <#else>
              (parentID is null)
          </#if>
        AND (courseID = :e.courseID)
        ORDER BY arrangementIndex DESC LIMIT 1),0) + 1)
</#if>