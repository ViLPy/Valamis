UPDATE ActivityState SET
  active=:e.active,
  suspended=:e.suspended,
  attemptCompleted=:e.attemptCompleted,
  attemptCompletionAmount=:e.attemptCompletionAmount.bigDecimal,
  attemptCount=:e.attemptCount
WHERE
(
  (activityStateNodeID is NULL AND
    activityStateTreeID = (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID))
OR
  (activityStateTreeID is NULL AND
    activityStateNodeID in (SELECT id FROM ActivityStateNode WHERE treeID = (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID)))
) AND activityID = :e.activity.id