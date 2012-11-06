SELECT * FROM ActivityStateNode
WHERE 1=1
<#if parentID??>
  AND parentID = :parentID
<#else>
  AND parentID is null
</#if>
<#if treeID??>
  AND treeID = :treeID
</#if>