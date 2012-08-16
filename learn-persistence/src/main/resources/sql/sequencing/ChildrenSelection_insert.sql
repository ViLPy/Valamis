INSERT INTO ChildrenSelection(sequencingID, takeCount, takeTimingOnEachAttempt, reorderOnEachAttempt)
VALUES (:sequencingID, :e.take.count, :e.take.timing.toString, :e.reorder.toString)