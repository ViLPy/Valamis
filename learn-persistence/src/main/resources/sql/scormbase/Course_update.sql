UPDATE Course SET
    grade = :e.grade,
    comment = :e.comment
WHERE courseID = :e.courseID AND userID = :e.userID