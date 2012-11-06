DROP TABLE IF EXISTS Attempt CASCADE;

CREATE TABLE Attempt
(
  <#if dbType=="postgres">
  id serial,
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
);

ALTER TABLE Attempt ADD CONSTRAINT Attempt_fk1 FOREIGN KEY (userID) REFERENCES LMSUser(id) ON DELETE CASCADE;
ALTER TABLE Attempt ADD CONSTRAINT Attempt_fk2 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;
