<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS ActivityData CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE ActivityData
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  packageID integer,
  <#if dbType=="mysql" >
  activityID VARCHAR(255),
  <#else>
  activityID VARCHAR(512),
  </#if>
  targetId text,
  readSharedData boolean,
  writeSharedData boolean,
  CONSTRAINT ActivityData_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE ActivityData ADD CONSTRAINT ActivityData_fk1 FOREIGN KEY (activityID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
