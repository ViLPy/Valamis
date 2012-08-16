DROP TABLE IF EXISTS Sequencing CASCADE;

CREATE TABLE Sequencing
(
  id serial,
  packageID integer,
  activityID text,
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
) WITH (
  OIDS=FALSE
);

ALTER TABLE Sequencing ADD CONSTRAINT Sequencing_fk1 FOREIGN KEY (activityID,packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;