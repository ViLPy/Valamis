<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS DataModel CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE DataModel
( 
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  dataKey text,
  dataValue text,
  attemptID integer,
  activityID text,
  CONSTRAINT DataModel_pk0 PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE DataModel ADD CONSTRAINT DataModel_fk1 FOREIGN KEY (attemptID) REFERENCES Attempt(id) ON DELETE CASCADE;
