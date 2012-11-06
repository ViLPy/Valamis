SELECT * FROM GlobalObjective
WHERE 1=1
<#if mapKey??>
AND mapKey = :mapKey
</#if>
<#if treeID??>
AND treeID = :treeID
<#elseif attemptID??>
AND treeID = (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID)
</#if>