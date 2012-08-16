DROP TABLE IF EXISTS SequencingRuleCondition CASCADE;

CREATE TABLE SequencingRuleCondition
(
  id serial,
  conditionRuleID integer,
  conditionType smallint,
  inverseCondition boolean,
  objectiveID text,
  measureThreshold numeric,
  CONSTRAINT SequencingRuleCondition_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE SequencingRuleCondition ADD CONSTRAINT SequencingRuleCondition_fk1 FOREIGN KEY (conditionRuleID) REFERENCES SequencingRule(id) ON DELETE CASCADE;