DROP TABLE IF EXISTS QuestionCategory CASCADE;

CREATE TABLE QuestionCategory
(
  id serial,
  title text,
  description text,
  parentID integer,
  CONSTRAINT QuestionCategory_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);