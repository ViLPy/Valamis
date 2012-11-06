DROP TABLE IF EXISTS Question CASCADE;

CREATE TABLE Question
(
  <#if dbType=="postgres">
  id serial,
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
  "position" integer,
  CONSTRAINT Question_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE Question ADD CONSTRAINT Question_fk1 FOREIGN KEY (categoryID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;