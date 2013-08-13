<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS GlobalObjective CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE GlobalObjective (
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  satisfied boolean,
  normalizedMeasure decimal(20,2),
  attemptCompleted boolean,
  mapKey text,
  treeID integer,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;
ALTER TABLE GlobalObjective ADD FOREIGN KEY (treeID) REFERENCES ActivityStateTree(id) ON DELETE CASCADE;