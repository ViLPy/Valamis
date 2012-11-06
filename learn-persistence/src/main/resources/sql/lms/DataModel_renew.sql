DROP TABLE IF EXISTS DataModel CASCADE;

CREATE TABLE DataModel
( 
  <#if dbType=="postgres">
  id serial,
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
);

ALTER TABLE DataModel ADD CONSTRAINT DataModel_fk1 FOREIGN KEY (attemptID) REFERENCES Attempt(id) ON DELETE CASCADE;
