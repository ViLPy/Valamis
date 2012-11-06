DROP TABLE IF EXISTS Objective CASCADE;

CREATE TABLE Objective
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  satisfiedByMeasure boolean,
  identifier text,
  minNormalizedMeasure numeric,
  isPrimary boolean,
  CONSTRAINT Objective_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE Objective ADD CONSTRAINT Objective_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;