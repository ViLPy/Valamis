DROP TABLE IF EXISTS SequencingRule CASCADE;

CREATE TABLE SequencingRule
(
  id serial,
  sequencingID integer,
  conditionCombination text,
  conditionAction text,
  CONSTRAINT SequencingRule_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE SequencingRule ADD CONSTRAINT ConditionRule_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;