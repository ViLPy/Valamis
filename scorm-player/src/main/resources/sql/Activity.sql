SELECT * FROM Activity
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if organizationID??>
AND organizationID = (select id from organization where packageID = :packageID AND organizationID = :organizationID)
</#if>
<#if activityID??>
AND activityID = :activityID
</#if>
ORDER BY id