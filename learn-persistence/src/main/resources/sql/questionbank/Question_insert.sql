<#if dbType=="mysql" >
  INSERT INTO Question(categoryID, title, description, explanationText, forceCorrectCount, isCaseSensitive, questionType, courseID, arrangementIndex)
  VALUES (:e.categoryID, :e.title, :e.text, :e.explanationText, :forceCorrectCount, :isCaseSensitive, :e.questionTypeCode, :e.courseID,
/*        COALESCE((select p.arrangementIndex from (SELECT arrangementIndex FROM Question
        WHERE
          <#if categoryID??>
              categoryID = :categoryID
          <#else>
              (categoryID is null)
          </#if>
          AND (courseID = :e.courseID)
        ORDER BY arrangementIndex DESC LIMIT 1) as p), 0) + 1 */
        :arrangementIndex
        )
<#else>
  INSERT INTO Question(categoryID, title, description, explanationText, forceCorrectCount, isCaseSensitive, questionType, courseID, arrangementIndex)
  VALUES (:e.categoryID, :e.title, :e.text, :e.explanationText, :forceCorrectCount, :isCaseSensitive, :e.questionTypeCode, :e.courseID,
/*  COALESCE((SELECT arrangementIndex FROM Question
          WHERE
          <#if categoryID??>
              categoryID = :categoryID
          <#else>
              (categoryID is null)
          </#if>
          AND (courseID = :e.courseID)
          ORDER BY arrangementIndex DESC LIMIT 1),0) + 1*/
                  :arrangementIndex
)
</#if>





