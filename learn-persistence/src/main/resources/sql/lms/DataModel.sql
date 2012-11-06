SELECT * FROM DataModel 
WHERE 1=1 
<#if dataKey??> 
    AND dataKey LIKE :dataKey 
</#if>
<#if attemptID??> 
    AND attemptID=:attemptID 
</#if>
<#if activityID??>
    AND activityID=:activityID
</#if>
ORDER BY id;