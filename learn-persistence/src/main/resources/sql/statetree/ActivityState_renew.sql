DROP TABLE IF EXISTS ActivityState CASCADE;

CREATE TABLE ActivityState (
  <#if dbType=="postgres">
  id serial,
  <#else>
  id int auto_increment,
  </#if>
  packageID integer,
  activityID text,
  active boolean,
  suspended boolean,
  attemptCompleted boolean,
  attemptCompletionAmount decimal,
  attemptAbsoluteDuration decimal,
  attemptExperiencedDuration decimal,
  activityAbsoluteDuration decimal,
  activityExperiencedDuration decimal,
  attemptCount integer,
  activityStateNodeID integer,
  activityStateTreeID integer,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);
ALTER TABLE ActivityState ADD FOREIGN KEY (activityStateNodeID) REFERENCES ActivityStateNode (id) ON DELETE CASCADE;
ALTER TABLE ActivityState ADD FOREIGN KEY (activityStateTreeID) REFERENCES ActivityStateTree (id) ON DELETE CASCADE;