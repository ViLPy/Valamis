DROP TABLE IF EXISTS Attempt CASCADE;

CREATE TABLE Attempt
(
  id serial,
  userID integer,
  packageID integer,
  organizationID text,
  isComplete boolean,
  CONSTRAINT Attempt_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Attempt ADD CONSTRAINT Attempt_fk1 FOREIGN KEY (userID) REFERENCES LMSUser(id) ON DELETE CASCADE;
ALTER TABLE Attempt ADD CONSTRAINT Attempt_fk2 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;
