DROP TABLE IF EXISTS RollupRule CASCADE;

CREATE TABLE RollupRule
(
  id serial,
  sequencingID integer,
  combination text,
  childActivitySet text,
  minimumCount integer,
  minimumPercent numeric,
  action text,
  CONSTRAINT RollupRule_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE RollupRule ADD CONSTRAINT RollupRule_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;