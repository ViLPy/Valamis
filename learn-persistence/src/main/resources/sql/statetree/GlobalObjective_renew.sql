DROP TABLE IF EXISTS GlobalObjective CASCADE;

CREATE TABLE GlobalObjective (
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  satisfied boolean,
  normalizedMeasure decimal,
  attemptCompleted boolean,
  mapKey text,
  treeID integer,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);
ALTER TABLE GlobalObjective ADD FOREIGN KEY (treeID) REFERENCES ActivityStateTree(id) ON DELETE CASCADE;