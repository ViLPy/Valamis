DROP TABLE IF EXISTS Question CASCADE;

CREATE TABLE Question
(
  id serial,
  categoryID integer,
  title text,
  description text,
  isBounded boolean,
  isCaseSensitive boolean,
  questionType integer,
  CONSTRAINT Question_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);