<#if dbType=="mysql" >
    INSERT INTO QuizCategory(title, description, parentID, quizID, arrangementIndex)
    VALUES (:e.title, :e.description, :e.parentID, :e.quizID, COALESCE((select p.arrangementIndex from (SELECT arrangementIndex FROM QuizCategory
                                                            WHERE 
                                                            <#if parentID??>
                                                                parentID = :parentID
                                                            <#else>
                                                                (parentID is null)
                                                            </#if>
                                                            ORDER BY arrangementIndex DESC LIMIT 1)as p),0) + 1)
<#else>
    INSERT INTO QuizCategory(title, description, parentID, quizID, arrangementIndex)
    VALUES (:e.title, :e.description, :e.parentID, :e.quizID, COALESCE((SELECT arrangementIndex FROM QuizCategory
                                                            WHERE
                                                            <#if parentID??>
                                                                parentID = :parentID
                                                            <#else>
                                                                (parentID is null)
                                                            </#if>
                                                            ORDER BY arrangementIndex DESC LIMIT 1), 0) + 1)
</#if>
