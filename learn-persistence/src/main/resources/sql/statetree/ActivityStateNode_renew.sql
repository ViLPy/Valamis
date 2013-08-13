<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS ActivityStateNode CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE ActivityStateNode (
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  parentID integer,
  treeID integer,
  availableChildrenIDs text,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;
ALTER TABLE ActivityStateNode ADD FOREIGN KEY (parentID) REFERENCES ActivityStateNode (id) ON DELETE CASCADE;
ALTER TABLE ActivityStateNode ADD FOREIGN KEY (treeID) REFERENCES ActivityStateTree (id) ON DELETE CASCADE;