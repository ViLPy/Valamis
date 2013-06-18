<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS QuestionCategory CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE QuestionCategory
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  title text,
  description text,
  parentID integer,
  arrangementIndex integer,
   courseID integer,
  CONSTRAINT QuestionCategory_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE QuestionCategory ADD CONSTRAINT QuestionCategory_fk1 FOREIGN KEY (parentID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;