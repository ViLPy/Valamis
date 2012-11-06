INSERT INTO ObjectiveState(mapKey, activityStateID, satisfied, normalizedMeasure, objectiveID)
VALUES (:mapKey, :activityStateID, :satisfied, :normalizedMeasure.bigDecimal,
  (SELECT id FROM Objective WHERE
   <#if mapKey??>
    isPrimary = false AND identifier = :mapKey
   <#else>
    isPrimary = true
   </#if>
   AND sequencingID = (SELECT id FROM Sequencing
                        WHERE packageID = (SELECT packageID FROM ActivityState WHERE id = :activityStateID)
                              AND activityID = (SELECT activityID FROM ActivityState WHERE id = :activityStateID)))
)