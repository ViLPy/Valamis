DROP TABLE IF EXISTS Answer CASCADE;

CREATE TABLE Answer
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  description text,
  isCorrect boolean,
  questionID integer,
  rangeFrom decimal,
  rangeTo decimal,
  matchingText text,
  answerPosition integer,
  answerType integer,
  CONSTRAINT Answer_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE Answer ADD CONSTRAINT Answer_fk1 FOREIGN KEY (questionID) REFERENCES Question(id) ON DELETE CASCADE;