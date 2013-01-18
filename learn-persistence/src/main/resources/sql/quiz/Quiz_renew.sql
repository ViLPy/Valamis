DROP TABLE IF EXISTS Quiz CASCADE;

CREATE TABLE Quiz
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  title text,
  description text,
  welcomePageContent text,
  finalPageContent text,
  courseID integer,
  CONSTRAINT Quiz_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);