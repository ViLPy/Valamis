DROP TABLE IF EXISTS SequencingRuleCondition CASCADE;

CREATE TABLE SequencingRuleCondition
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  conditionRuleID integer,
  conditionType smallint,
  inverseCondition boolean,
  objectiveID text,
  measureThreshold numeric,
  CONSTRAINT SequencingRuleCondition_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE SequencingRuleCondition ADD CONSTRAINT SequencingRuleCondition_fk1 FOREIGN KEY (conditionRuleID) REFERENCES SequencingRule(id) ON DELETE CASCADE;