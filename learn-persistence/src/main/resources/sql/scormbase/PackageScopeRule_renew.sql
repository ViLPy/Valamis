DROP TABLE IF EXISTS PackageScopeRule CASCADE;

CREATE TABLE PackageScopeRule
(
  packageID integer NOT NULL,
  scope text,
  scopeID text,
  visibility boolean
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE PackageScopeRule ADD CONSTRAINT PackageScopeRule_fk1 FOREIGN KEY (packageID) REFERENCES package(id) ON DELETE CASCADE;