DROP TABLE IF EXISTS QuizQuestion CASCADE;

CREATE TABLE QuizQuestion
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  categoryID integer,
  questionID integer,
  url text,
  title text,
  quizID integer,
  "position" integer,
  CONSTRAINT QuizQuestion_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk1 FOREIGN KEY (categoryID) REFERENCES QuizCategory(id) ON DELETE CASCADE;
ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk2 FOREIGN KEY (questionID) REFERENCES Question(id) ON DELETE CASCADE;
ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk3 FOREIGN KEY (quizID) REFERENCES Quiz(id) ON DELETE CASCADE;