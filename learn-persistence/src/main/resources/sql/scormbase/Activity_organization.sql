SELECT * FROM Activity
WHERE parentID IS NULL
<#if id??>
AND id = :id
</#if>
<#if packageID??>
AND packageID = :packageID
</#if>
ORDER BY indexNumber, id