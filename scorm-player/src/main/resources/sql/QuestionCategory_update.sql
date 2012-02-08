UPDATE QuestionCategory SET
    title = :e.title,
    description = :e.description,
    parentID = :e.parentID
WHERE id = :e.id