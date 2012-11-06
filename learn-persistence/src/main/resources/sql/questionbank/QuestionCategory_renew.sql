DROP TABLE IF EXISTS QuestionCategory CASCADE;

CREATE TABLE QuestionCategory
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  title text,
  description text,
  parentID integer,
  "position" integer,
  CONSTRAINT QuestionCategory_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE QuestionCategory ADD CONSTRAINT QuestionCategory_fk1 FOREIGN KEY (parentID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;