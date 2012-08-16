SELECT * FROM Sequencing
WHERE 1=1
<#if packageID??>
AND packageID = :packageID
</#if>
<#if activityID??>
AND activityID = :activityID
</#if>