SELECT * FROM RollupRuleCondition
WHERE 1=1
<#if id??>
 AND id = :id
</#if>
<#if rollupRuleID??>
 AND rollupRuleID = :rollupRuleID
</#if>
<#if conditionRuleID??>
 AND conditionRuleID = :conditionRuleID
</#if>