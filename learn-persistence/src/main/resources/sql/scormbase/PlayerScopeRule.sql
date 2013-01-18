SELECT * FROM PlayerScopeRule
WHERE playerID = :playerID
<#if scope??>
AND scope = :scope
</#if>

