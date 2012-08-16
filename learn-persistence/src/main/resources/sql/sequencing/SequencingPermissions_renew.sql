DROP TABLE IF EXISTS SequencingPermissions CASCADE;

CREATE TABLE SequencingPermissions
(
  id serial,
  sequencingID integer,
  choiceForChildren boolean,
  choiceForNonDescendants boolean,
  flowForChildren boolean,
  forwardOnlyForChildren boolean,

  CONSTRAINT SequencingPermissions_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE SequencingPermissions ADD CONSTRAINT SequencingPermissions_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;