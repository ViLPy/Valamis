SELECT * FROM ActivityState
WHERE 1=1
<#if activityStateNodeID??>
AND activityStateNodeID = :activityStateNodeID
</#if>
<#if activityStateTreeID??>
AND activityStateTreeID = :activityStateTreeID
</#if>
<#if attemptID??>
AND activityStateNodeID IN (SELECT id FROM ActivityStateNode WHERE treeID = (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID))
AND activityID = (SELECT currentActivityID FROM ActivityStateTree WHERE attemptID = :attemptID)
</#if>