DROP TABLE IF EXISTS SequencingRule CASCADE;

CREATE TABLE SequencingRule
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  conditionCombination text,
  conditionAction text,
  CONSTRAINT SequencingRule_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE SequencingRule ADD CONSTRAINT ConditionRule_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;