INSERT INTO ActivityState(packageID, activityID, active, suspended, attemptCompleted, attemptCompletionAmount, attemptAbsoluteDuration,
  attemptExperiencedDuration, activityAbsoluteDuration, activityExperiencedDuration,
  attemptCount, activityStateNodeID, activityStateTreeID)
VALUES (
  <#if activityStateNodeID??>
    (SELECT packageID FROM Attempt WHERE id = (SELECT attemptID FROM ActivityStateTree WHERE id = (SELECT treeID FROM ActivityStateNode WHERE id = :activityStateNodeID))),
  <#else>
    (SELECT packageID FROM Attempt WHERE id = (SELECT attemptID FROM ActivityStateTree WHERE id = :activityStateTreeID)),
  </#if>
  :e.activity.id, :e.active, :e.suspended, :e.attemptCompleted, :e.attemptCompletionAmount.bigDecimal, :e.attemptAbsoluteDuration.bigDecimal,
  :e.attemptExperiencedDuration.bigDecimal, :e.activityAbsoluteDuration.bigDecimal, :e.activityExperiencedDuration.bigDecimal,
  :e.attemptCount, :activityStateNodeID, :activityStateTreeID)