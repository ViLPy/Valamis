<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS Organization CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE Organization
(
  <#if dbType=="mysql" >
  id VARCHAR(255),
  <#else>
  id VARCHAR(512),
  </#if>
  packageID integer NOT NULL,
  title text,
  CONSTRAINT Organization_pk PRIMARY KEY (id, packageID)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE Organization ADD CONSTRAINT Organization_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;