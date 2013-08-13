<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS ObjectiveState CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE ObjectiveState (
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  satisfied boolean,
  normalizedMeasure decimal(20,2),
  mapKey text,
  activityStateID integer,
  objectiveID integer,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;
ALTER TABLE ObjectiveState ADD FOREIGN KEY (activityStateID) REFERENCES ActivityState(id) ON DELETE CASCADE;
ALTER TABLE ObjectiveState ADD FOREIGN KEY (objectiveID) REFERENCES Objective(id) ON DELETE CASCADE;