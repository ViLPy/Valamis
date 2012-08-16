DROP TABLE IF EXISTS Quiz CASCADE;

CREATE TABLE Quiz
(
  id serial,
  title text,
  description text,
  welcomePageContent text,
  finalPageContent text,
  CONSTRAINT Quiz_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);