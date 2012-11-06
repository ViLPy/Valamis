<#if ruleType="exit">
INSERT INTO ConditionRule(sequencingID, combination, ruleType)
VALUES (:sequencingID, :combination.toString, :ruleType)
<#else>
INSERT INTO ConditionRule(sequencingID, combination, ruleType, action)
VALUES (:sequencingID, :combination.toString, :ruleType, :e.action.toString)
</#if>