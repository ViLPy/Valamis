DROP TABLE IF EXISTS SequencingTracking CASCADE;

CREATE TABLE SequencingTracking
(
  id serial,
  sequencingID integer,
  completionSetByContent boolean,
  objectiveSetByContent boolean,

  CONSTRAINT SequencingTracking_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE SequencingTracking ADD CONSTRAINT SequencingTracking_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;