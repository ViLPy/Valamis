DROP TABLE IF EXISTS GlobalObjective CASCADE;

CREATE TABLE GlobalObjective (
  id serial,
  satisfied boolean,
  normalizedMeasure decimal,
  attemptCompleted boolean,
  mapKey text,
  treeID integer,
  PRIMARY KEY (id)
);
ALTER TABLE GlobalObjective ADD FOREIGN KEY (treeID) REFERENCES ActivityStateTree(id) ON DELETE CASCADE;