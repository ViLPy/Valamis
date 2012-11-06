DROP TABLE IF EXISTS Organization CASCADE;

CREATE TABLE Organization
(
  id VARCHAR(512),
  packageID integer NOT NULL,
  title text,
  CONSTRAINT Organization_pk PRIMARY KEY (id, packageID)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE Organization ADD CONSTRAINT Organization_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;