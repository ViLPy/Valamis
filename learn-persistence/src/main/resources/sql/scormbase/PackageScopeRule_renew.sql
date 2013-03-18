<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS PackageScopeRule CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE PackageScopeRule
(
  packageID integer NOT NULL,
  scope text,
  scopeID text,
  visibility boolean,
  isDefault boolean
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;
ALTER TABLE PackageScopeRule ADD CONSTRAINT PackageScopeRule_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;