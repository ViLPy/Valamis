INSERT INTO Question(categoryID, title, description, explanationText, forceCorrectCount, isCaseSensitive, questionType, "position")
VALUES (:e.categoryID, :e.title, :e.text, :e.explanationText, :forceCorrectCount, :isCaseSensitive, :e.questionTypeCode, COALESCE((SELECT "position"
                                                                                                                                FROM Question 
                                                                                                                                WHERE 
                                                                                                                                <#if categoryID??>
                                                                                                                                    categoryID = :categoryID
                                                                                                                                <#else>
                                                                                                                                    (categoryID is null)
                                                                                                                                </#if>
                                                                                                                                ORDER BY "position" DESC LIMIT 1),
                                                                                                                            0) + 1)