SELECT * FROM PackageScopeRule
WHERE 1 = 1
<#if packageID??>
AND packageID = :packageID
</#if>
