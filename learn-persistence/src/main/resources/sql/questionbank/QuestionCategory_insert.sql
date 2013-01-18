INSERT INTO QuestionCategory(title, description, parentID, "position", courseID)
VALUES (:e.title, :e.description, :e.parentID, COALESCE((SELECT "position" 
                                                            FROM QuestionCategory 
                                                            WHERE 
                                                            <#if parentID??>
                                                                parentID = :parentID
                                                            <#else>
                                                                (parentID is null)
                                                            </#if>
                                                            ORDER BY "position" DESC LIMIT 1),
                                                        0) + 1, :e.courseID)