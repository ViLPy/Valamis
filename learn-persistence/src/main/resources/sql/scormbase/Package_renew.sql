<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS Package CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE Package
(
  <#if dbType=="postgres">
    id serial,
  <#elseif dbType=="mysql" >
    id integer NOT NULL auto_increment,
  <#elseif dbType=="h2">
    id int auto_increment,
  </#if>
  defaultOrganizationID text,
  title text,
  base text,
  resourcesBase text,
  summary text,
  assetRefID bigint,
  courseID integer,
  CONSTRAINT Package_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;