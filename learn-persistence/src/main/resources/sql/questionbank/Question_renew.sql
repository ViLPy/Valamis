<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS Question CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE Question
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  categoryID integer,
  title text,
  description text,
  explanationText text,
  forceCorrectCount boolean,
  isCaseSensitive boolean,
  questionType integer,
  arrangementIndex integer,
  courseID integer,
  CONSTRAINT Question_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE Question ADD CONSTRAINT Question_fk1 FOREIGN KEY (categoryID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;
