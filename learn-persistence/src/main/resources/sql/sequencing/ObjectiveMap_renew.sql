DROP TABLE IF EXISTS ObjectiveMapInfo CASCADE;

CREATE TABLE ObjectiveMapInfo
(
  <#if dbType=="postgres">
  id serial,
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
);

ALTER TABLE ObjectiveMapInfo ADD CONSTRAINT ObjectiveMapInfo_fk1 FOREIGN KEY (objectiveID) REFERENCES Objective(id) ON DELETE CASCADE;