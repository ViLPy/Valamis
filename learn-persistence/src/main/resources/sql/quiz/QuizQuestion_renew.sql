DROP TABLE IF EXISTS QuizQuestion CASCADE;

CREATE TABLE QuizQuestion
(
  id serial,
  categoryID integer,
  questionID integer,
  quizID integer,
  "position" integer,
  CONSTRAINT QuizQuestion_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk1 FOREIGN KEY (categoryID) REFERENCES QuizCategory(id) ON DELETE CASCADE;
ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk2 FOREIGN KEY (questionID) REFERENCES Question(id) ON DELETE CASCADE;
ALTER TABLE QuizQuestion ADD CONSTRAINT QuizQuestion_fk3 FOREIGN KEY (quizID) REFERENCES Quiz(id) ON DELETE CASCADE;