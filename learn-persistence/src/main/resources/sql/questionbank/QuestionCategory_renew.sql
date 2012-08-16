DROP TABLE IF EXISTS QuestionCategory CASCADE;

CREATE TABLE QuestionCategory
(
  id serial,
  title text,
  description text,
  parentID integer,
  "position" integer,
  CONSTRAINT QuestionCategory_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE QuestionCategory ADD CONSTRAINT QuestionCategory_fk1 FOREIGN KEY (parentID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;