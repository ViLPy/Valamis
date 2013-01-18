DROP TABLE IF EXISTS Course CASCADE;

CREATE TABLE Course
(
  courseID integer NOT NULL,
  userID integer NOT NULL,
  grade text,
  comment text
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE Course ADD CONSTRAINT Course_fk1 FOREIGN KEY (userID) REFERENCES LMSUser(id) ON DELETE CASCADE;