INSERT INTO Sequencing(packageID, activityID, sharedId, sharedSequencingIdReference, onlyCurrentAttemptObjectiveProgressForChildren,
  onlyCurrentAttemptAttemptProgressForChildren, attemptLimit, durationLimitInMilliseconds, preventChildrenActivation, constrainChoice)
VALUES (:packageID, :activityID, :e.sharedId, :e.sharedSequencingIdReference, :e.onlyCurrentAttemptObjectiveProgressForChildren,
  :e.onlyCurrentAttemptAttemptProgressForChildren, :e.attemptLimit, :e.durationLimitInMilliseconds, :e.preventChildrenActivation, :e.constrainChoice)