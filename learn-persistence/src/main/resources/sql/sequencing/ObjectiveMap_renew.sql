<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS ObjectiveMapInfo CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE ObjectiveMapInfo
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  objectiveID integer,
  readSatisfiedStatusFrom text,
  readNormalizedMeasureFrom text,
  writeSatisfiedStatusTo text,
  writeNormalizedMeasureTo text,
  readRawScoreFrom text,
  readMinScoreFrom text,
  readMaxScoreFrom text,
  readCompletionStatusFrom text,
  readProgressMeasureFrom text,
  writeRawScoreTo text,
  writeMinScoreTo text,
  writeMaxScoreTo text,
  writeCompletionStatusTo text,
  writeProgressMeasureTo text,
  CONSTRAINT ObjectiveMapInfo_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE ObjectiveMapInfo ADD CONSTRAINT ObjectiveMapInfo_fk1 FOREIGN KEY (objectiveID) REFERENCES Objective(id) ON DELETE CASCADE;