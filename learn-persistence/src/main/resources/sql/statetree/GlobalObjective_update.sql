UPDATE GlobalObjective SET
  satisfied = :satisfied,
  normalizedMeasure = :normalizedMeasure.bigDecimal,
  attemptCompleted = :attemptCompleted
WHERE 1=1
<#if mapKey??>
AND mapKey = :mapKey
</#if>
<#if attemptID??>
AND treeID = (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID)
</#if>