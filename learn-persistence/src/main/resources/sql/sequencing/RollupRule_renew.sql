DROP TABLE IF EXISTS RollupRule CASCADE;

CREATE TABLE RollupRule
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  sequencingID integer,
  combination text,
  childActivitySet text,
  minimumCount integer,
  minimumPercent numeric,
  action text,
  CONSTRAINT RollupRule_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE RollupRule ADD CONSTRAINT RollupRule_fk1 FOREIGN KEY (sequencingID) REFERENCES Sequencing(id) ON DELETE CASCADE;