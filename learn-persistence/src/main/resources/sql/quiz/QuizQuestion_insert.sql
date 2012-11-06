<#if questionID??>
INSERT INTO QuizQuestion(categoryID, questionID, quizID, "position")
VALUES (:categoryID, :questionID, :quizID, COALESCE((SELECT "position"
							    FROM QuizQuestion 
							    WHERE 
							    <#if categoryID??>
								    categoryID = :categoryID
							    <#else>
								    (categoryID is null)
							    </#if>
							    ORDER BY "position" DESC LIMIT 1),
							    0) + 1)
<#elseif url??>
INSERT INTO QuizQuestion(categoryID, title, url, quizID, "position")
VALUES (:categoryID, :title, :url, :quizID, COALESCE((SELECT "position"
							    FROM QuizQuestion
							    WHERE
							    <#if categoryID??>
								    categoryID = :categoryID
							    <#else>
								    (categoryID is null)
							    </#if>
							    ORDER BY "position" DESC LIMIT 1),
							    0) + 1)
</#if>