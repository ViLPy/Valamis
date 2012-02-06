UPDATE QuestionCategory SET
    title = :e.title,
    description = :e.description,
    parentID = :e.parentID,
    "position"=:e.position
WHERE id = :e.id