create index IX_512B8525 on Learn_FileStorage (filename);

create index IX_EF6F46A7 on Learn_LFActivity (packageID);
create index IX_64BC258D on Learn_LFActivity (packageID, id_);
create index IX_A1B5A429 on Learn_LFActivity (packageID, organizationID);
create index IX_AF1B4EE0 on Learn_LFActivity (packageID, parentID);

create index IX_26F2265B on Learn_LFActivityDataMap (packageID, activityID);

create index IX_47E7C56D on Learn_LFActivityState (activityID, activityStateNodeID, activityStateTreeID);
create index IX_87C4F2FA on Learn_LFActivityState (activityID, activityStateTreeID);
create index IX_3BDCAFB5 on Learn_LFActivityState (activityID, activityStateTreeID, activityStateNodeID);
create index IX_37DEB47C on Learn_LFActivityState (activityStateNodeID);
create index IX_E1BF8EDA on Learn_LFActivityState (activityStateNodeID, activityID);
create index IX_F6ACEB0F on Learn_LFActivityState (activityStateNodeID, activityStateTreeID);

create index IX_679A7462 on Learn_LFActivityStateNode (treeID);
create index IX_2400CEDB on Learn_LFActivityStateNode (treeID, parentID);

create index IX_9CD3C427 on Learn_LFActivityStateTree (attemptID);

create index IX_52772CEE on Learn_LFAnswer (questionId);

create index IX_B2CCF333 on Learn_LFAttempt (packageID);
create index IX_68CEBF78 on Learn_LFAttempt (userID);
create index IX_FC24D590 on Learn_LFAttempt (userID, packageID, isComplete);

create index IX_36D2C30E on Learn_LFAttemptData (attemptID, activityID);
create index IX_86C2D8F7 on Learn_LFAttemptData (attemptID, activityID, dataKey);
create index IX_1634FB95 on Learn_LFAttemptData (attemptID, dataKey);

create index IX_637C536E on Learn_LFBigDecimal (decimal_);
create index IX_6456716F on Learn_LFBigDecimal (sum);

create index IX_BEA402B on Learn_LFChildrenSelection (sequencingID);

create index IX_F3405A15 on Learn_LFConditionRule (sequencingID);
create index IX_B7D49D9F on Learn_LFConditionRule (sequencingID, ruleType);

create index IX_DCE34E3A on Learn_LFCourse (courseID, userID);
create index IX_F1E3EE51 on Learn_LFCourse (grade);

create index IX_3FD4D2B on Learn_LFFileStorage (filename);

create index IX_90049AA3 on Learn_LFGlobalObjectiveState (treeID);
create index IX_218DD1BA on Learn_LFGlobalObjectiveState (treeID, mapKey);

create index IX_B0A8C0B1 on Learn_LFObjective (sequencingID, isPrimary);
create index IX_7FF8180E on Learn_LFObjective (sequencingID, isPrimary, identifier);

create index IX_CED95AC6 on Learn_LFObjectiveMap (objectiveID);

create index IX_891A0C11 on Learn_LFObjectiveState (activityID);
create index IX_EC87417A on Learn_LFObjectiveState (activityStateID);
create index IX_84DECB43 on Learn_LFObjectiveState (mapKey, activityStateID);

create index IX_5C0470E9 on Learn_LFPackage (assetRefID);
create index IX_FD0817C1 on Learn_LFPackage (courseID);
create index IX_75B49D9D on Learn_LFPackage (id_);
create index IX_6DFDA147 on Learn_LFPackage (id_, courseID);

create index IX_5E072CCC on Learn_LFPackageScopeRule (packageID);
create index IX_B73E9B27 on Learn_LFPackageScopeRule (packageID, scope, scopeID);
create index IX_BED05C0 on Learn_LFPackageScopeRule (scope, scopeID);
create index IX_53EB15E7 on Learn_LFPackageScopeRule (scope, scopeID, isDefault);
create index IX_DF43FEC6 on Learn_LFPackageScopeRule (scope, scopeID, visibility);

create index IX_7941DC50 on Learn_LFPlayerScopeRule (playerID);

create index IX_7A8116B8 on Learn_LFQuestion (courseId, categoryId);

create index IX_35F00169 on Learn_LFQuestionCategory (courseId);
create index IX_D4CB7742 on Learn_LFQuestionCategory (courseId, parentId);

create index IX_7B90DA9A on Learn_LFQuiz (courseID);
create index IX_52F44A58 on Learn_LFQuiz (title);

create index IX_ED2AA2FA on Learn_LFQuizQuestion (quizId);
create index IX_EB6662E7 on Learn_LFQuizQuestion (quizId, categoryId);

create index IX_B1D50698 on Learn_LFQuizQuestionCategory (quizId);
create index IX_43EB0DB1 on Learn_LFQuizQuestionCategory (quizId, parentId);

create index IX_632D4C08 on Learn_LFResource (packageID);
create index IX_C88C6DE5 on Learn_LFResource (packageID, resourceID);

create index IX_61DEB730 on Learn_LFRollupContribution (sequencingID);

create index IX_E92CEF1C on Learn_LFRollupRule (sequencingID);

create index IX_27094572 on Learn_LFRuleCondition (conditionRuleID);
create index IX_C2743893 on Learn_LFRuleCondition (rollupRuleID);

create index IX_22BC4F76 on Learn_LFSequencing (packageID, activityID);

create index IX_E922EFC4 on Learn_LFSequencingPermissions (sequencingID);

create index IX_546EB23D on Learn_LFSequencingTracking (sequencingID);

create index IX_CBB67CEE on Learn_LFUser (id_);