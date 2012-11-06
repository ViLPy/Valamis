DROP TABLE IF EXISTS ActivityStateNode CASCADE;

CREATE TABLE ActivityStateNode (
  <#if dbType=="postgres">
  id serial,
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
);
ALTER TABLE ActivityStateNode ADD FOREIGN KEY (parentID) REFERENCES ActivityStateNode (id) ON DELETE CASCADE;
ALTER TABLE ActivityStateNode ADD FOREIGN KEY (treeID) REFERENCES ActivityStateTree (id) ON DELETE CASCADE;