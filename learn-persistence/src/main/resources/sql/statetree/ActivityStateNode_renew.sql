DROP TABLE IF EXISTS ActivityStateNode CASCADE;

CREATE TABLE ActivityStateNode (
  id serial,
  parentID integer,
  treeID integer,
  availableChildrenIDs text,
  PRIMARY KEY (id)
);
ALTER TABLE ActivityStateNode ADD FOREIGN KEY (parentID) REFERENCES ActivityStateNode (id) ON DELETE CASCADE;
ALTER TABLE ActivityStateNode ADD FOREIGN KEY (treeID) REFERENCES ActivityStateTree (id) ON DELETE CASCADE;