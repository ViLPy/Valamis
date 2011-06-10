DROP TABLE IF EXISTS Resource CASCADE;

CREATE TABLE Resource
(
  id serial,
  packageID integer NOT NULL,
  resourceID text NOT NULL,
  resourceType text,
  scormType text,
  href text,
  base text,
  CONSTRAINT ResourcePK PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);