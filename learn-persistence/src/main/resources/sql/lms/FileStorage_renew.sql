DROP TABLE IF EXISTS FileStorage CASCADE;

CREATE TABLE FileStorage
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  filename text,
  content bytea,
  CONSTRAINT FileStorage_pk0 PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);
