DROP TABLE IF EXISTS ObjectiveState CASCADE;

CREATE TABLE ObjectiveState (
  id serial,
  satisfied boolean,
  normalizedMeasure decimal,
  mapKey text,
  activityStateID integer,
  objectiveID integer,
  PRIMARY KEY (id)
);
ALTER TABLE ObjectiveState ADD FOREIGN KEY (activityStateID) REFERENCES ActivityState(id) ON DELETE CASCADE;
ALTER TABLE ObjectiveState ADD FOREIGN KEY (objectiveID) REFERENCES Objective(id) ON DELETE CASCADE;