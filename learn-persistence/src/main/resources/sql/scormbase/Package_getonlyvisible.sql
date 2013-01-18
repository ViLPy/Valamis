SELECT * FROM Package AS p
JOIN PackageScopeRule AS r
ON p.id = r.packageid
WHERE r.scope = :scope
AND r.scopeid = :scopeID
AND r.visibility IS TRUE
ORDER BY p.id