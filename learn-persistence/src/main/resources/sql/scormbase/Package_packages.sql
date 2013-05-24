SELECT DISTINCT p.* FROM Package AS p INNER JOIN Attempt as a ON p.id = a.packageID
WHERE 1 = 1
<#if userID??>
AND a.userID = :userID
</#if>
ORDER BY p.id