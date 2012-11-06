UPDATE Answer SET
    description = :description, 
    isCorrect = :isCorrect,
    questionID = :questionID,
    rangeFrom = :rangeFrom,
    rangeTo = :rangeTo,
    matchingText = :matchingText,
    answerPosition = :answerPosition
WHERE id = :e.id