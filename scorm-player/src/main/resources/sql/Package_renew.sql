DROP TABLE IF EXISTS Package CASCADE;

CREATE TABLE Package
(
  id serial,
  defaultOrganizationID text,
  title text,
  base text,
  resourcesBase text,
  summary text,
  visibility boolean,
  CONSTRAINT Package_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);