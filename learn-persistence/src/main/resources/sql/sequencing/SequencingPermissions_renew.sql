DROP TABLE IF EXISTS SequencingPermissions CASCADE;

CREATE TABLE SequencingPermissions
(
  <#if dbType=="postgres">
  id serial,
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
);

ALTER TABLE SequencingPermissions ADD CONSTRAINT SequencingPermissions_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;