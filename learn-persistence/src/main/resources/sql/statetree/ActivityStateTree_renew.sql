DROP TABLE IF EXISTS ActivityStateTree CASCADE;

CREATE TABLE ActivityStateTree (
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  attemptID integer,
  currentActivityID text,
  suspendedActivityID text,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);
ALTER TABLE ActivityStateTree ADD FOREIGN KEY (attemptID) REFERENCES Attempt (id) ON DELETE CASCADE;