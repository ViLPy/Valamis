<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS Attempt CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE Attempt
(
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  userID integer,
  packageID integer,
  organizationID text,
  isComplete boolean,
  CONSTRAINT Attempt_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;

ALTER TABLE Attempt ADD CONSTRAINT Attempt_fk1 FOREIGN KEY (userID) REFERENCES LMSUser(id) ON DELETE CASCADE;
ALTER TABLE Attempt ADD CONSTRAINT Attempt_fk2 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;
