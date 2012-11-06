DROP TABLE IF EXISTS ChildrenSelection CASCADE;

CREATE TABLE ChildrenSelection
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  takeCount integer,
  takeTimingOnEachAttempt text,
  reorderOnEachAttempt text,

  CONSTRAINT ChildrenSelection_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE ChildrenSelection ADD CONSTRAINT ChildrenSelection_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;