<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS SequencingRuleCondition CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE SequencingRuleCondition
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  conditionRuleID integer,
  conditionType smallint,
  inverseCondition boolean,
  objectiveID text,
  measureThreshold numeric(20,2),
  CONSTRAINT SequencingRuleCondition_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE SequencingRuleCondition ADD CONSTRAINT SequencingRuleCondition_fk1 FOREIGN KEY (conditionRuleID) REFERENCES SequencingRule(id) ON DELETE CASCADE;