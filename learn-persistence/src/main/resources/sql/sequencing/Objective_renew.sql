DROP TABLE IF EXISTS Objective CASCADE;

CREATE TABLE Objective
(
  id serial,
  sequencingID integer,
  satisfiedByMeasure boolean,
  identifier text,
  minNormalizedMeasure numeric,
  isPrimary boolean,
  CONSTRAINT Objective_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Objective ADD CONSTRAINT Objective_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;