<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS Activity CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE Activity
(
  <#if dbType=="postgres">
  indexNumber serial,
  id VARCHAR(512),
  <#elseif dbType=="mysql" >
  indexNumber integer not null auto_increment unique,
  id VARCHAR(255),
  <#else>
  indexNumber int auto_increment,
  id VARCHAR(512),
  </#if>
  packageID integer,
  <#if dbType=="mysql" >
  organizationID VARCHAR(255) NOT NULL,
  parentID VARCHAR(255),
  <#else>
  organizationID VARCHAR(512) NOT NULL,
  parentID VARCHAR(512),
  </#if>
  title text,
  identifierRef text,
  resourceParameters text,
  hideLMSUI text,
  visible boolean,
  objectivesGlobalToSystem boolean,
  sharedDataGlobalToSystem boolean,
  masteryScore text,
  maxTimeAllowed text,
  CONSTRAINT Activity_pk PRIMARY KEY (id, packageID)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE Activity ADD CONSTRAINT Activity_fk1 FOREIGN KEY (organizationID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk2 FOREIGN KEY (parentID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk3 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;