DROP TABLE IF EXISTS SequencingTracking CASCADE;

CREATE TABLE SequencingTracking
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  completionSetByContent boolean,
  objectiveSetByContent boolean,

  CONSTRAINT SequencingTracking_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE SequencingTracking ADD CONSTRAINT SequencingTracking_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;