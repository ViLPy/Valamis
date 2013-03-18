<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS Course CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

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
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;
ALTER TABLE Course ADD CONSTRAINT Course_fk1 FOREIGN KEY (userID) REFERENCES LMSUser(id) ON DELETE CASCADE ON UPDATE CASCADE;