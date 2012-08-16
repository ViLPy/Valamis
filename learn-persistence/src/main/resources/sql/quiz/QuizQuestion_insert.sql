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
