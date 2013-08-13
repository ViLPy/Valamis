<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS Answer CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE Answer
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  description text,
  isCorrect boolean,
  questionID integer,
  rangeFrom decimal(20,2),
  rangeTo decimal(20,2),
  matchingText text,
  answerPosition integer,
  answerType integer,
  CONSTRAINT Answer_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE Answer ADD CONSTRAINT Answer_fk1 FOREIGN KEY (questionID) REFERENCES Question(id) ON DELETE CASCADE;