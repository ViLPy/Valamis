DROP TABLE IF EXISTS RollupRuleCondition CASCADE;

CREATE TABLE RollupRuleCondition
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  rollupRuleID integer,
  conditionRuleID integer,
  conditionType text,
  objectiveId text,
  measureThreshold numeric,
  inverseCondition boolean,
  CONSTRAINT RollupRuleCondition_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE RollupRuleCondition ADD CONSTRAINT RollupRuleCondition_fk1 FOREIGN KEY (rollupRuleID) REFERENCES RollupRule(id) ON DELETE CASCADE;
ALTER TABLE RollupRuleCondition ADD CONSTRAINT RollupRuleCondition_fk2 FOREIGN KEY (conditionRuleID) REFERENCES ConditionRule(id) ON DELETE CASCADE;