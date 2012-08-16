DROP TABLE IF EXISTS Question CASCADE;

CREATE TABLE Question
(
  id serial,
  categoryID integer,
  title text,
  description text,
  explanationText text,
  forceCorrectCount boolean,
  isCaseSensitive boolean,
  questionType integer,
  "position" integer,
  CONSTRAINT Question_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Question ADD CONSTRAINT Question_fk1 FOREIGN KEY (categoryID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;