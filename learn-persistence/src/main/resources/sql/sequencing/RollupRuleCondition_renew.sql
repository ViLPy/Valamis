<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS RollupRuleCondition CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE RollupRuleCondition
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  rollupRuleID integer,
  conditionRuleID integer,
  conditionType text,
  objectiveId text,
  measureThreshold numeric(20,2),
  inverseCondition boolean,
  CONSTRAINT RollupRuleCondition_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE RollupRuleCondition ADD CONSTRAINT RollupRuleCondition_fk1 FOREIGN KEY (rollupRuleID) REFERENCES RollupRule(id) ON DELETE CASCADE;
ALTER TABLE RollupRuleCondition ADD CONSTRAINT RollupRuleCondition_fk2 FOREIGN KEY (conditionRuleID) REFERENCES ConditionRule(id) ON DELETE CASCADE;