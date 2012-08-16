DROP TABLE IF EXISTS Organization CASCADE;

CREATE TABLE Organization
(
  id text,
  packageID integer NOT NULL,
  title text,
  CONSTRAINT Organization_pk PRIMARY KEY (id, packageID)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Organization ADD CONSTRAINT Organization_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;