DROP TABLE IF EXISTS Activity CASCADE;

CREATE TABLE Activity
(
  id serial,
  organizationID integer NOT NULL,
  parentID integer,
  title text,
  identifierRef text,
  resourceParameters text,
  CONSTRAINT Activity_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Activity ADD CONSTRAINT Activity_fk1 FOREIGN KEY (organizationID) REFERENCES Organization(id) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk2 FOREIGN KEY (parentID) REFERENCES Activity(id) ON DELETE CASCADE;