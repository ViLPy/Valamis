DROP TABLE IF EXISTS Answer CASCADE;

CREATE TABLE Answer
(
  id serial,
  description text,
  isCorrect boolean,
  questionID integer,
  rangeFrom decimal,
  rangeTo decimal,
  matchingText text,
  answerPosition integer,
  answerType integer,
  CONSTRAINT Answer_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Answer ADD CONSTRAINT Answer_fk1 FOREIGN KEY (questionID) REFERENCES Question(id) ON DELETE CASCADE;