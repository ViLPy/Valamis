DROP TABLE IF EXISTS Activity CASCADE;

CREATE TABLE Activity
(
  id serial,
  activityID text NOT NULL,
  organizationID integer NOT NULL,
  parentID integer,
  title text,
  identifierRef text,
  resourceParameters text,
  CONSTRAINT Activity_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Activity ADD CONSTRAINT Activity_fk1 FOREIGN KEY (organizationID) REFERENCES Organization(id);
ALTER TABLE Activity ADD CONSTRAINT Activity_fk2 FOREIGN KEY (parentID) REFERENCES Activity(id);