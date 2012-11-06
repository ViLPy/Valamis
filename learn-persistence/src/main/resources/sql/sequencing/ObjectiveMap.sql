SELECT * FROM ObjectiveMapInfo
WHERE 1=1
<#if id??>
 AND id = :id
</#if>
<#if objectiveID??>
 AND objectiveID = :objectiveID
</#if>