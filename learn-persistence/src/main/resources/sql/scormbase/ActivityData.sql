SELECT * FROM ActivityData
WHERE 1 = 1
<#if id??>
AND id = :id
</#if>
<#if packageID??>
AND packageID = :packageID
</#if>
<#if activityID??>
AND activityID = :activityID
</#if>
ORDER BY id