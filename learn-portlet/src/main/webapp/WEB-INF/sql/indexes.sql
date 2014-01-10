create index IX_EF6F46A7 on Learn_LFActivity (packageID);
create index IX_64BC258D on Learn_LFActivity (packageID, id_);
create index IX_A1B5A429 on Learn_LFActivity (packageID, organizationID);
create index IX_AF1B4EE0 on Learn_LFActivity (packageID, parentID);

create index IX_26F2265B on Learn_LFActivityDataMap (packageID, activityID);

create index IX_47E7C56D on Learn_LFActivityState (activityID, activityStateNodeID, activityStateTreeID);
create index IX_37DEB47C on Learn_LFActivityState (activityStateNodeID);
create index IX_E1BF8EDA on Learn_LFActivityState (activityStateNodeID, activityID);

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

create index IX_936CDEE0 on Learn_LFCertificate (companyID);
create index IX_23A101E0 on Learn_LFCertificate (title);

create index IX_FE9A5473 on Learn_LFCertificateSite (certificateID);
create index IX_35A1E709 on Learn_LFCertificateSite (certificateID, siteID);

create index IX_128B606F on Learn_LFCertificateUser (certificateID);
create index IX_2471F16D on Learn_LFCertificateUser (userID);
create index IX_994D6C15 on Learn_LFCertificateUser (userID, certificateID);

create index IX_BEA402B on Learn_LFChildrenSelection (sequencingID);

create index IX_F3405A15 on Learn_LFConditionRule (sequencingID);
create index IX_B7D49D9F on Learn_LFConditionRule (sequencingID, ruleType);

create index IX_FF65B1C8 on Learn_LFConfig (dataKey);

create index IX_DCE34E3A on Learn_LFCourse (courseID, userID);
create index IX_F1E3EE51 on Learn_LFCourse (grade);

create index IX_3FD4D2B on Learn_LFFileStorage (filename);

create index IX_90049AA3 on Learn_LFGlobalObjectiveState (treeID);
create index IX_218DD1BA on Learn_LFGlobalObjectiveState (treeID, mapKey);

create index IX_B0A8C0B1 on Learn_LFObjective (sequencingID, isPrimary);
create index IX_7FF8180E on Learn_LFObjective (sequencingID, isPrimary, identifier);

create index IX_CED95AC6 on Learn_LFObjectiveMap (objectiveID);

create index IX_EC87417A on Learn_LFObjectiveState (activityStateID);
create index IX_84DECB43 on Learn_LFObjectiveState (mapKey, activityStateID);

create index IX_5C0470E9 on Learn_LFPackage (assetRefID);
create index IX_FD0817C1 on Learn_LFPackage (courseID);

create index IX_1C6A5550 on Learn_LFPackageComment (socialPackageID);

create index IX_5E072CCC on Learn_LFPackageScopeRule (packageID);
create index IX_B73E9B27 on Learn_LFPackageScopeRule (packageID, scope, scopeID);
create index IX_BED05C0 on Learn_LFPackageScopeRule (scope, scopeID);
create index IX_53EB15E7 on Learn_LFPackageScopeRule (scope, scopeID, isDefault);
create index IX_DF43FEC6 on Learn_LFPackageScopeRule (scope, scopeID, visibility);

create index IX_48AB90A3 on Learn_LFPackageVote (socialPackageID);

create index IX_7941DC50 on Learn_LFPlayerScopeRule (playerID);

create index IX_7A8116B8 on Learn_LFQuestion (courseId, categoryId);

create index IX_35F00169 on Learn_LFQuestionCategory (courseId);
create index IX_D4CB7742 on Learn_LFQuestionCategory (courseId, parentId);

create index IX_7B90DA9A on Learn_LFQuiz (courseID);

create index IX_ED2AA2FA on Learn_LFQuizQuestion (quizId);
create index IX_EB6662E7 on Learn_LFQuizQuestion (quizId, categoryId);

create index IX_B1D50698 on Learn_LFQuizQuestionCategory (quizId);
create index IX_43EB0DB1 on Learn_LFQuizQuestionCategory (quizId, parentId);

create index IX_632D4C08 on Learn_LFResource (packageID);
create index IX_C88C6DE5 on Learn_LFResource (packageID, resourceID);

create index IX_EE5B71F9 on Learn_LFRole (isDefault, permission);
create index IX_D0D22D21 on Learn_LFRole (liferayRoleID, permission);
create index IX_F1961B94 on Learn_LFRole (permission);

create index IX_61DEB730 on Learn_LFRollupContribution (sequencingID);

create index IX_E92CEF1C on Learn_LFRollupRule (sequencingID);

create index IX_27094572 on Learn_LFRuleCondition (conditionRuleID);
create index IX_C2743893 on Learn_LFRuleCondition (rollupRuleID);

create index IX_22BC4F76 on Learn_LFSequencing (packageID, activityID);

create index IX_E922EFC4 on Learn_LFSequencingPermissions (sequencingID);

create index IX_546EB23D on Learn_LFSequencingTracking (sequencingID);

create index IX_90D71444 on Learn_LFSocialPackage (authorID);

create index IX_CF234D5B on Learn_LFSocialPackageTag (name);
create index IX_C54C6408 on Learn_LFSocialPackageTag (socialPackageID);

create index IX_D904A10 on Learn_LFTincanActivity (packageID);
create index IX_961ECBC7 on Learn_LFTincanActivity (tincanID);

create index IX_38F9C274 on Learn_LFTincanActor (memberOf);
create index IX_91905B9F on Learn_LFTincanActor (objectType, name, mbox, mbox_sha1sum, openid);
create index IX_CDC60415 on Learn_LFTincanActor (tincanID);

create index IX_D2D0DBF7 on Learn_LFTincanLrsActivityProfile (activityId, profileId);

create index IX_E8096D4F on Learn_LFTincanLrsAgentProfile (agentId, profileId);
create index IX_BF3CD0C9 on Learn_LFTincanLrsAgentProfile (profileId);

create index IX_68D244E3 on Learn_LFTincanLrsAttachment (parentID);

create index IX_2A760C2C on Learn_LFTincanLrsDocument (documentId);

create index IX_538EDAB4 on Learn_LFTincanLrsState (activityId);
create index IX_98BFD988 on Learn_LFTincanLrsState (activityId, stateId);

create index IX_D28AE6C on Learn_LFTincanLrsStatement (actorID);
create index IX_FE381CB5 on Learn_LFTincanLrsStatement (objType, objID);
create index IX_2DF2F67A on Learn_LFTincanLrsStatement (tincanID);
create index IX_B9F1D082 on Learn_LFTincanLrsStatement (verbID);

create index IX_5C883B21 on Learn_LFTincanManifestActivity (packageID);
create index IX_1CCBF496 on Learn_LFTincanManifestActivity (tincanID);

create index IX_7A257452 on Learn_LFTincanPackage (assetRefID);
create index IX_F334E16A on Learn_LFTincanPackage (courseID);

create index IX_CBB67CEE on Learn_LFUser (id_);