DROP TABLE IF EXISTS QuizCategory CASCADE;

CREATE TABLE QuizCategory
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  title text,
  description text,
  parentID integer,
  quizID integer,
  "position" integer,
  CONSTRAINT QuizCategory_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE QuizCategory ADD CONSTRAINT QuizCategory_fk1 FOREIGN KEY (parentID) REFERENCES QuizCategory(id) ON DELETE CASCADE;
ALTER TABLE QuizCategory ADD CONSTRAINT QuizCategory_fk2 FOREIGN KEY (quizID) REFERENCES Quiz(id) ON DELETE CASCADE;