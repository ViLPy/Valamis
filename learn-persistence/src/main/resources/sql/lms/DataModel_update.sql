UPDATE DataModel 
SET dataValue=:dataValue 
WHERE attemptID=:attemptID AND dataKey=:dataKey AND activityID=:activityID;