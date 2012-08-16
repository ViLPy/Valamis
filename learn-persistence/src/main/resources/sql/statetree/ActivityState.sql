SELECT * FROM ActivityState
WHERE 1=1
<#if activityStateNodeID??>
AND activityStateNodeID = :activityStateNodeID
</#if>
<#if activityStateTreeID??>
AND activityStateTreeID = :activityStateTreeID
</#if>