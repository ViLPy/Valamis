DROP TABLE IF EXISTS ConditionRule CASCADE;

CREATE TABLE ConditionRule
(
  id serial,
  sequencingID integer,
  combination text,
  ruleType text,
  action text,
  CONSTRAINT ConditionRule_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE ConditionRule ADD CONSTRAINT ConditionRule_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;