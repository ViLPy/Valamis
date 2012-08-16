DROP TABLE IF EXISTS ChildrenSelection CASCADE;

CREATE TABLE ChildrenSelection
(
  id serial,
  sequencingID integer,
  takeCount integer,
  takeTimingOnEachAttempt text,
  reorderOnEachAttempt text,

  CONSTRAINT ChildrenSelection_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE ChildrenSelection ADD CONSTRAINT ChildrenSelection_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;