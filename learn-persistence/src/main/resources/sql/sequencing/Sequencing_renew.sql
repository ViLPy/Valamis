DROP TABLE IF EXISTS Sequencing CASCADE;

CREATE TABLE Sequencing
(
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  packageID integer,
  activityID VARCHAR(512),
  sharedId text,
  sharedSequencingIdReference text,
  onlyCurrentAttemptObjectiveProgressForChildren boolean,
  onlyCurrentAttemptAttemptProgressForChildren boolean,
  attemptLimit integer,
  durationLimitInMilliseconds bigint,
  rollupContributionID integer,
  preventChildrenActivation boolean,
  constrainChoice boolean,

  CONSTRAINT Sequencing_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);

ALTER TABLE Sequencing ADD CONSTRAINT Sequencing_fk1 FOREIGN KEY (activityID,packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;