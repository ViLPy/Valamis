DROP TABLE IF EXISTS Resource CASCADE;

CREATE TABLE Resource
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  identifierRef text,
  packageID integer NOT NULL,
  resourceType text,
  scormType text,
  href text,
  base text,
  CONSTRAINT ResourcePK PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE Resource ADD CONSTRAINT Resource_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;