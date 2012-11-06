INSERT INTO QuizCategory(title, description, parentID, quizID, "position")
VALUES (:e.title, :e.description, :e.parentID, :e.quizID, COALESCE((SELECT "position" 
                                                            FROM QuizCategory 
                                                            WHERE 
                                                            <#if parentID??>
                                                                parentID = :parentID
                                                            <#else>
                                                                (parentID is null)
                                                            </#if>
                                                            ORDER BY "position" DESC LIMIT 1),
							    0) + 1)
