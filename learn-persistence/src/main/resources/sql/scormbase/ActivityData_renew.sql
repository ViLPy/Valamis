DROP TABLE IF EXISTS ActivityData CASCADE;

CREATE TABLE ActivityData
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  packageID integer,
  activityID VARCHAR(512),
  targetId text,
  readSharedData boolean,
  writeSharedData boolean,
  CONSTRAINT ActivityData_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE ActivityData ADD CONSTRAINT ActivityData_fk1 FOREIGN KEY (activityID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
