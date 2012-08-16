DROP TABLE IF EXISTS ActivityData CASCADE;

CREATE TABLE ActivityData
(
  id serial,
  packageID integer,
  activityID text,
  targetId text,
  readSharedData boolean,
  writeSharedData boolean,
  CONSTRAINT ActivityData_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE ActivityData ADD CONSTRAINT ActivityData_fk1 FOREIGN KEY (activityID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
