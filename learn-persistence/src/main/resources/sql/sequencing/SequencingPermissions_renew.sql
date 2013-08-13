<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS SequencingPermissions CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE SequencingPermissions
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  choiceForChildren boolean,
  choiceForNonDescendants boolean,
  flowForChildren boolean,
  forwardOnlyForChildren boolean,

  CONSTRAINT SequencingPermissions_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE SequencingPermissions ADD CONSTRAINT SequencingPermissions_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;