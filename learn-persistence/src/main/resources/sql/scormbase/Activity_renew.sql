DROP TABLE IF EXISTS Activity CASCADE;

CREATE TABLE Activity
(
  indexNumber serial,
  id text,
  packageID integer,
  organizationID text NOT NULL,
  parentID text,
  title text,
  identifierRef text,
  resourceParameters text,
  hideLMSUI text,
  visible boolean,
  objectivesGlobalToSystem boolean,
  sharedDataGlobalToSystem boolean,
  CONSTRAINT Activity_pk PRIMARY KEY (id, packageID)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Activity ADD CONSTRAINT Activity_fk1 FOREIGN KEY (organizationID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk2 FOREIGN KEY (parentID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk3 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;