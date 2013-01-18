SELECT p.*, r.visibility FROM Package AS p
LEFT OUTER JOIN PackageScopeRule AS r
ON p.id = r.packageID
WHERE courseID <@IN seq="ids"/>
AND r.scope = 'instanceScope'
<#if onlyVisible??>
AND visibility IS TRUE
</#if>
ORDER BY id