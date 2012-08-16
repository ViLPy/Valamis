DROP TABLE IF EXISTS ObjectiveMapInfo CASCADE;

CREATE TABLE ObjectiveMapInfo
(
  id serial,
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
) WITH (
  OIDS=FALSE
);

ALTER TABLE ObjectiveMapInfo ADD CONSTRAINT ObjectiveMapInfo_fk1 FOREIGN KEY (objectiveID) REFERENCES Objective(id) ON DELETE CASCADE;