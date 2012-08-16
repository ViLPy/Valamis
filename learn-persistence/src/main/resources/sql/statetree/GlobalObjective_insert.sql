INSERT INTO GlobalObjective(satisfied, normalizedMeasure, attemptCompleted, mapKey, treeID)
VALUES (:satisfied, :normalizedMeasure.bigDecimal, :attemptCompleted, :mapKey,
<#if treeID??>
  :treeID
<#else>
  (SELECT id FROM ActivityStateTree WHERE attemptID = :attemptID)
</#if>
  )