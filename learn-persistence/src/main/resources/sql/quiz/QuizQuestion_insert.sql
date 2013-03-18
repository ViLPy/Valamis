<#if dbType=="mysql" >
    <#if questionID??>
    INSERT INTO QuizQuestion(categoryID, questionID, quizID, arrangementIndex)
    VALUES (:categoryID, :questionID, :quizID, COALESCE((select p.arrangementIndex from (SELECT arrangementIndex
                                    FROM QuizQuestion
                                    WHERE
                                      <#if categoryID??>
                                          categoryID = :categoryID
                                      <#else>
                                          (categoryID is null)
                                      </#if>
                                    ORDER BY arrangementIndex DESC LIMIT 1) as p),0) + 1)
    <#elseif url??>
    INSERT INTO QuizQuestion(categoryID, title, url, quizID, arrangementIndex)
    VALUES (:categoryID, :title, :url, :quizID, COALESCE((select p.arrangementIndex from (SELECT arrangementIndex
                                    FROM QuizQuestion
                                    WHERE
                                      <#if categoryID??>
                                          categoryID = :categoryID
                                      <#else>
                                          (categoryID is null)
                                      </#if>
                                    ORDER BY arrangementIndex DESC LIMIT 1)as p),0) + 1)
    </#if>
<#else>
    <#if questionID??>
    INSERT INTO QuizQuestion(categoryID, questionID, quizID, arrangementIndex)
    VALUES (:categoryID, :questionID, :quizID, COALESCE((SELECT arrangementIndex
                                    FROM QuizQuestion
                                    WHERE
                                    <#if categoryID??>
                                        categoryID = :categoryID
                                    <#else>
                                        (categoryID is null)
                                    </#if>
                                    ORDER BY arrangementIndex DESC LIMIT 1),
                                    0) + 1)
    <#elseif url??>
    INSERT INTO QuizQuestion(categoryID, title, url, quizID, arrangementIndex)
    VALUES (:categoryID, :title, :url, :quizID, COALESCE((SELECT arrangementIndex
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
</#if>