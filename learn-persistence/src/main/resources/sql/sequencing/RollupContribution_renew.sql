DROP TABLE IF EXISTS RollupContribution CASCADE;

CREATE TABLE RollupContribution
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  contributeToSatisfied text,
  contributeToNotSatisfied text,
  contributeToCompleted text,
  contributeToIncomplete text,
  objectiveMeasureWeight numeric,
  measureSatisfactionIfActive boolean,

  CONSTRAINT RollupContribution_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE RollupContribution ADD CONSTRAINT RollupContribution_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;