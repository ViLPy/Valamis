UPDATE ObjectiveState SET
    satisfied = :satisfied,
    normalizedMeasure = :normalizedMeasure.bigDecimal
WHERE
<#if mapKey??>
  mapKey = :mapKey
<#else>
  mapKey is null
</#if> AND activityStateID = (SELECT id FROM ActivityState WHERE (
  (activityStateNodeID is NULL AND
    activityStateTreeID = (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID))
OR
  (activityStateTreeID is NULL AND
    activityStateNodeID in (SELECT id FROM ActivityStateNode WHERE treeID = (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID)))
) AND activityID = :activityID)