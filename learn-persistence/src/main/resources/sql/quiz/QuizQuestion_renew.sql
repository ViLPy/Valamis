<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS QuizQuestion CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE QuizQuestion
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  categoryID integer,
  questionID integer,
  url text,
  title text,
  quizID integer,
  arrangementIndex integer,
  CONSTRAINT QuizQuestion_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk1 FOREIGN KEY (categoryID) REFERENCES QuizCategory(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk2 FOREIGN KEY (questionID) REFERENCES Question(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk3 FOREIGN KEY (quizID) REFERENCES Quiz(id) ON DELETE CASCADE ON UPDATE CASCADE;