DROP TABLE IF EXISTS Resource CASCADE;

CREATE TABLE Resource
(
  id serial,
  identifierRef text,
  packageID integer NOT NULL,
  resourceType text,
  scormType text,
  href text,
  base text,
  CONSTRAINT ResourcePK PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Resource ADD CONSTRAINT Resource_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;