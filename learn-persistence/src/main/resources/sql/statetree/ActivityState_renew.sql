<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 0;
</#if>
DROP TABLE IF EXISTS ActivityState CASCADE;
<#if dbType=="mysql">
SET FOREIGN_KEY_CHECKS = 1;
</#if>

CREATE TABLE ActivityState (
  <#if dbType=="postgres">
  id serial,
  <#elseif dbType=="mysql" >
  id integer not null auto_increment unique,
  <#else>
  id int auto_increment,
  </#if>
  packageID integer,
  activityID text,
  active boolean,
  suspended boolean,
  attemptCompleted boolean,
  attemptCompletionAmount decimal(20,2),
  attemptAbsoluteDuration decimal(20,2),
  attemptExperiencedDuration decimal(20,2),
  activityAbsoluteDuration decimal(20,2),
  activityExperiencedDuration decimal(20,2),
  attemptCount integer,
  activityStateNodeID integer,
  activityStateTreeID integer,
  PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
)<#if dbType=="mysql" >
   ENGINE=InnoDB
</#if>;
ALTER TABLE ActivityState ADD FOREIGN KEY (activityStateNodeID) REFERENCES ActivityStateNode (id) ON DELETE CASCADE;
ALTER TABLE ActivityState ADD FOREIGN KEY (activityStateTreeID) REFERENCES ActivityStateTree (id) ON DELETE CASCADE;