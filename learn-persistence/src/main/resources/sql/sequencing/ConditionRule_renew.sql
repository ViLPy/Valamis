DROP TABLE IF EXISTS ConditionRule CASCADE;

CREATE TABLE ConditionRule
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  combination text,
  ruleType text,
  action text,
  CONSTRAINT ConditionRule_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE ConditionRule ADD CONSTRAINT ConditionRule_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;