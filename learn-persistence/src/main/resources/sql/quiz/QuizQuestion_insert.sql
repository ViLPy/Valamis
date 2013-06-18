<#if questionID??>
  INSERT INTO QuizQuestion(categoryID, questionID, quizID, questionType, arrangementIndex)
  VALUES (:categoryID, :questionID, :quizID, :questionType,
<#elseif url??>
  INSERT INTO QuizQuestion(categoryID, title, url, quizID, questionType, arrangementIndex)
  VALUES (:categoryID, :title, :url, :quizID, :questionType,
<#elseif text??>
  INSERT INTO QuizQuestion(categoryID, title, plainText, quizID, questionType, arrangementIndex)
  VALUES (:categoryID, :title, :text, :quizID, :questionType,
</#if>
<#if dbType=="mysql" >
COALESCE((select p.arrangementIndex from (SELECT arrangementIndex
          FROM QuizQuestion
          WHERE
            <#if categoryID??>
                categoryID = :categoryID
            <#else>
                (categoryID is null)
            </#if>
          ORDER BY arrangementIndex DESC LIMIT 1)as p),0) + 1)
<#else>
COALESCE((SELECT arrangementIndex
          FROM QuizQuestion
          WHERE
          <#if categoryID??>
              categoryID = :categoryID
          <#else>
              (categoryID is null)
          </#if>
          ORDER BY arrangementIndex DESC LIMIT 1),
          0) + 1)
</#if>
