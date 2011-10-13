UPDATE Answer SET
    description = :description, 
    isCorrect = :isCorrect,
    questionID = :questionID,
    rangeFrom = :rangeFrom,
    rangeTo = :rangeTo,
    subquestionText = :subquestionText,
    answerPosition = :answerPosition
WHERE id = :e.id