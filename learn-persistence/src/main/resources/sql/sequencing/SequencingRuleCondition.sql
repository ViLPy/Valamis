SELECT * FROM SequencingRuleCondition
WHERE 1=1
<#if id??>
 AND id = :id
</#if>
<#if conditionRuleID??>
 AND conditionRuleID = :conditionRuleID
</#if>