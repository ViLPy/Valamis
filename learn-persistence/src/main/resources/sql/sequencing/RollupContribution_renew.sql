DROP TABLE IF EXISTS RollupContribution CASCADE;

CREATE TABLE RollupContribution
(
  id serial,
  sequencingID integer,
  contributeToSatisfied text,
  contributeToNotSatisfied text,
  contributeToCompleted text,
  contributeToIncomplete text,
  objectiveMeasureWeight numeric,
  measureSatisfactionIfActive boolean,

  CONSTRAINT RollupContribution_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE RollupContribution ADD CONSTRAINT RollupContribution_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;