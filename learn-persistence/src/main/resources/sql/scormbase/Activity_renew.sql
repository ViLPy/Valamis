DROP TABLE IF EXISTS Activity CASCADE;

CREATE TABLE Activity
(
  <#if dbType=="postgres">
  indexNumber  serial,
  <#else>
  indexNumber  int auto_increment,
  </#if>
  id VARCHAR(512),
  packageID integer,
  organizationID VARCHAR(512) NOT NULL,
  parentID VARCHAR(512),
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
);

ALTER TABLE Activity ADD CONSTRAINT Activity_fk1 FOREIGN KEY (organizationID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk2 FOREIGN KEY (parentID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk3 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;