UPDATE ActivityStateTree SET
  currentActivityID = :currentActivityID,
  suspendedActivityID = :suspendedActivityID
WHERE attemptID = :attemptID