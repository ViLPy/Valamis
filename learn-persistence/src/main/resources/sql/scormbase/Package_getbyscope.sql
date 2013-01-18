SELECT  p.*, r.visibility FROM Package AS p
LEFT JOIN
(SELECT * FROM PackageScopeRule WHERE scope = :scope AND scopeID = :scopeID) AS r
ON p.id = r.packageID
WHERE
courseID = :courseID
ORDER BY id