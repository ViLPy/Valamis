DROP TABLE IF EXISTS QuizCategory CASCADE;

CREATE TABLE QuizCategory
(
  id serial,
  title text,
  description text,
  parentID integer,
  quizID integer,
  "position" integer,
  CONSTRAINT QuizCategory_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE QuizCategory ADD CONSTRAINT QuizCategory_fk1 FOREIGN KEY (parentID) REFERENCES QuizCategory(id) ON DELETE CASCADE;
ALTER TABLE QuizCategory ADD CONSTRAINT QuizCategory_fk2 FOREIGN KEY (quizID) REFERENCES Quiz(id) ON DELETE CASCADE;