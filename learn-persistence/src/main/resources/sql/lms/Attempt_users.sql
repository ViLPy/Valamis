SELECT DISTINCT u.* FROM LMSUser AS u INNER JOIN Attempt as a ON u.id = a.userID
WHERE 1 = 1
<#if packageID??>
AND a.packageID = :packageID
</#if>
ORDER BY u.id