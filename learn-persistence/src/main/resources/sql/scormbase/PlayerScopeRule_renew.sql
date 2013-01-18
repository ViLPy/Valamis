DROP TABLE IF EXISTS PlayerScopeRule CASCADE;

CREATE TABLE PlayerScopeRule
(
  playerID text,
  scope text
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);
