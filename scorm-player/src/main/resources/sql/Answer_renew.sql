DROP TABLE IF EXISTS Answer CASCADE;

CREATE TABLE Answer
(
  id serial,
  description text,
  isCorrect boolean,
  questionID integer,
  rangeFrom decimal,
  rangeTo decimal,
  subquestionText text,
  answerPosition integer,
  answerType integer,
  CONSTRAINT Answer_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);