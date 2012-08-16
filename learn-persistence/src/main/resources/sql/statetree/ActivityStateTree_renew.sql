DROP TABLE IF EXISTS ActivityStateTree CASCADE;

CREATE TABLE ActivityStateTree (
  id serial,
  attemptID integer,
  currentActivityID text,
  suspendedActivityID text,
  PRIMARY KEY (id)
);
ALTER TABLE ActivityStateTree ADD FOREIGN KEY (attemptID) REFERENCES Attempt (id) ON DELETE CASCADE;