DROP TABLE IF EXISTS ObjectiveState CASCADE;

CREATE TABLE ObjectiveState (
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  satisfied boolean,
  normalizedMeasure decimal,
  mapKey text,
  activityStateID integer,
  objectiveID integer,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);
ALTER TABLE ObjectiveState ADD FOREIGN KEY (activityStateID) REFERENCES ActivityState(id) ON DELETE CASCADE;
ALTER TABLE ObjectiveState ADD FOREIGN KEY (objectiveID) REFERENCES Objective(id) ON DELETE CASCADE;