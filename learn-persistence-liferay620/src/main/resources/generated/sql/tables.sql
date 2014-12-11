create table Learn_LFAchievement (
	id_ LONG not null primary key,
	title VARCHAR(75) null,
	description TEXT null,
	logo TEXT null,
	creationDate DATE null
);

create table Learn_LFAchievementActivity (
	id_ LONG not null primary key,
	userId INTEGER null,
	achievementId INTEGER null
);

create table Learn_LFAchievementUser (
	id_ LONG not null primary key,
	userId INTEGER null,
	achievementId INTEGER null
);

create table Learn_LFActivity (
	indexNumber LONG not null primary key,
	id_ VARCHAR(512) null,
	packageID INTEGER null,
	organizationID VARCHAR(512) null,
	parentID VARCHAR(512) null,
	title TEXT null,
	identifierRef TEXT null,
	resourceParameters TEXT null,
	hideLMSUI TEXT null,
	visible BOOLEAN null,
	objectivesGlobalToSystem BOOLEAN null,
	sharedDataGlobalToSystem BOOLEAN null,
	masteryScore TEXT null,
	maxTimeAllowed TEXT null
);

create table Learn_LFActivityDataMap (
	id_ LONG not null primary key,
	packageID INTEGER null,
	activityID VARCHAR(512) null,
	targetId TEXT null,
	readSharedData BOOLEAN null,
	writeSharedData BOOLEAN null
);

create table Learn_LFActivityState (
	id_ LONG not null primary key,
	packageID INTEGER null,
	activityID VARCHAR(3000) null,
	active_ BOOLEAN null,
	suspended BOOLEAN null,
	attemptCompleted BOOLEAN null,
	attemptCompletionAmount NUMERIC(20,2),
	attemptAbsoluteDuration NUMERIC(20,2),
	attemptExperiencedDuration NUMERIC(20,2),
	activityAbsoluteDuration NUMERIC(20,2),
	activityExperiencedDuration NUMERIC(20,2),
	attemptCount INTEGER null,
	activityStateNodeID INTEGER null,
	activityStateTreeID INTEGER null
);

create table Learn_LFActivityStateNode (
	id_ LONG not null primary key,
	parentID INTEGER null,
	treeID INTEGER null,
	availableChildrenIDs TEXT null
);

create table Learn_LFActivityStateTree (
	id_ LONG not null primary key,
	currentActivityID TEXT null,
	suspendedActivityID TEXT null,
	attemptID INTEGER null
);

create table Learn_LFAnswer (
	id_ LONG not null primary key,
	description TEXT null,
	correct BOOLEAN null,
	questionId INTEGER null,
	rangeFrom NUMERIC(20,2),
	rangeTo NUMERIC(20,2),
	matchingText TEXT null,
	answerPosition INTEGER null,
	answerType INTEGER null
);

create table Learn_LFAttempt (
	id_ LONG not null primary key,
	userID INTEGER null,
	packageID INTEGER null,
	organizationID TEXT null,
	isComplete BOOLEAN null
);

create table Learn_LFAttemptData (
	id_ LONG not null primary key,
	dataKey VARCHAR(3000) null,
	dataValue TEXT null,
	attemptID INTEGER null,
	activityID VARCHAR(3000) null
);

create table Learn_LFBigDecimal (
	id_ LONG not null primary key,
	decimal_ NUMERIC(20,2),
	text_ VARCHAR(75) null
);

create table Learn_LFCertificate (
	id_ LONG not null primary key,
	title VARCHAR(3000) null,
	description TEXT null,
	logo VARCHAR(75) null,
	isPermanent BOOLEAN null,
	publishBadge BOOLEAN null,
	shortDescription VARCHAR(75) null,
	companyID INTEGER null,
	state_ VARCHAR(75) null,
	emails VARCHAR(75) null,
	validPeriodType VARCHAR(75) null,
	validPeriod INTEGER null,
	createdDate DATE null,
	isPublished BOOLEAN null,
	scope LONG null
);

create table Learn_LFCertificateActivity (
	certificateID LONG not null,
	activityName VARCHAR(75) not null,
	datacount INTEGER null,
	periodType VARCHAR(75) null,
	period INTEGER null,
	primary key (certificateID, activityName)
);

create table Learn_LFCertificateCourse (
	certificateID LONG not null,
	courseID LONG not null,
	arrangementIndex INTEGER null,
	periodType VARCHAR(75) null,
	period INTEGER null,
	primary key (certificateID, courseID)
);

create table Learn_LFCertificateTincanStatement (
	certificateID LONG not null,
	verb VARCHAR(75) not null,
	object VARCHAR(75) not null,
	periodType VARCHAR(75) null,
	period INTEGER null,
	primary key (certificateID, verb, object)
);

create table Learn_LFCertificateUser (
	certificateID LONG not null,
	userID LONG not null,
	attachedDate DATE null,
	primary key (certificateID, userID)
);

create table Learn_LFChildrenSelection (
	id_ LONG not null primary key,
	sequencingID INTEGER null,
	takeCount INTEGER null,
	takeTimingOnEachAttempt TEXT null,
	reorderOnEachAttempt TEXT null
);

create table Learn_LFConditionRule (
	id_ LONG not null primary key,
	sequencingID INTEGER null,
	combination TEXT null,
	ruleType VARCHAR(3000) null,
	action TEXT null
);

create table Learn_LFConfig (
	id_ LONG not null primary key,
	dataKey VARCHAR(75) null,
	dataValue VARCHAR(75) null
);

create table Learn_LFCourse (
	id_ LONG not null primary key,
	courseID INTEGER null,
	userID INTEGER null,
	grade VARCHAR(3000) null,
	comment_ TEXT null,
	date_ DATE null
);

create table Learn_LFFileStorage (
	id_ LONG not null primary key,
	filename VARCHAR(3000) null,
	content TEXT null
);

create table Learn_LFGlobalObjectiveState (
	id_ LONG not null primary key,
	satisfied BOOLEAN null,
	normalizedMeasure NUMERIC(20,2),
	attemptCompleted BOOLEAN null,
	mapKey VARCHAR(3000) null,
	treeID INTEGER null
);

create table Learn_LFLRSToActivitySetting (
	id_ LONG not null primary key,
	courseID INTEGER null,
	title VARCHAR(75) null,
	activityFilter VARCHAR(1000) null,
	verbFilter VARCHAR(1000) null
);

create table Learn_LFLessonLimit (
	itemID LONG not null,
	itemType VARCHAR(75) not null,
	passingLimit INTEGER null,
	rerunInterval INTEGER null,
	rerunIntervalType VARCHAR(75) null,
	primary key (itemID, itemType)
);

create table Learn_LFObjective (
	lfId LONG not null primary key,
	sequencingID INTEGER null,
	satisfiedByMeasure BOOLEAN null,
	identifier VARCHAR(3000) null,
	minNormalizedMeasure NUMERIC(20,2),
	isPrimary BOOLEAN null
);

create table Learn_LFObjectiveMap (
	id_ LONG not null primary key,
	objectiveID INTEGER null,
	readSatisfiedStatusFrom TEXT null,
	readNormalizedMeasureFrom TEXT null,
	writeSatisfiedStatusTo TEXT null,
	writeNormalizedMeasureTo TEXT null,
	readRawScoreFrom TEXT null,
	readMinScoreFrom TEXT null,
	readMaxScoreFrom TEXT null,
	readCompletionStatusFrom TEXT null,
	readProgressMeasureFrom TEXT null,
	writeRawScoreTo TEXT null,
	writeMinScoreTo TEXT null,
	writeMaxScoreTo TEXT null,
	writeCompletionStatusTo TEXT null,
	writeProgressMeasureTo TEXT null
);

create table Learn_LFObjectiveState (
	id_ LONG not null primary key,
	satisfied BOOLEAN null,
	normalizedMeasure NUMERIC(20,2),
	mapKey VARCHAR(3000) null,
	activityStateID INTEGER null,
	objectiveID INTEGER null
);

create table Learn_LFPackage (
	id_ LONG not null primary key,
	defaultOrganizationID TEXT null,
	title TEXT null,
	base TEXT null,
	resourcesBase TEXT null,
	summary TEXT null,
	assetRefID LONG null,
	courseID INTEGER null,
	logo TEXT null
);

create table Learn_LFPackageComment (
	id_ LONG not null primary key,
	socialPackageID INTEGER null,
	authorID INTEGER null,
	comment_ VARCHAR(75) null,
	publishDate DATE null
);

create table Learn_LFPackageGradeStorage (
	userId LONG not null,
	packageId LONG not null,
	grade VARCHAR(75) null,
	comment_ VARCHAR(75) null,
	date_ DATE null,
	primary key (userId, packageId)
);

create table Learn_LFPackageScopeRule (
	id_ LONG not null primary key,
	packageID INTEGER null,
	scope VARCHAR(3000) null,
	scopeID VARCHAR(3000) null,
	visibility BOOLEAN null,
	isDefault BOOLEAN null
);

create table Learn_LFPackageVote (
	id_ LONG not null primary key,
	userID INTEGER null,
	socialPackageID INTEGER null,
	voteValue INTEGER null
);

create table Learn_LFPlayerScopeRule (
	id_ LONG not null primary key,
	playerID VARCHAR(3000) null,
	scope TEXT null
);

create table Learn_LFQuestion (
	id_ LONG not null primary key,
	categoryId INTEGER null,
	title TEXT null,
	description TEXT null,
	explanationText TEXT null,
	forceCorrectCount BOOLEAN null,
	caseSensitive BOOLEAN null,
	questionType INTEGER null,
	courseId INTEGER null,
	arrangementIndex INTEGER null
);

create table Learn_LFQuestionCategory (
	id_ LONG not null primary key,
	title TEXT null,
	description TEXT null,
	parentId INTEGER null,
	courseId INTEGER null,
	arrangementIndex INTEGER null
);

create table Learn_LFQuiz (
	id_ LONG not null primary key,
	title TEXT null,
	description TEXT null,
	logo VARCHAR(75) null,
	welcomePageContent TEXT null,
	finalPageContent TEXT null,
	courseID INTEGER null,
	maxDuration INTEGER null
);

create table Learn_LFQuizAnswerScore (
	answerId LONG not null primary key,
	score DOUBLE null
);

create table Learn_LFQuizQuestion (
	id_ LONG not null primary key,
	quizId INTEGER null,
	categoryId INTEGER null,
	questionId INTEGER null,
	questionType TEXT null,
	title TEXT null,
	url TEXT null,
	plainText TEXT null,
	arrangementIndex INTEGER null,
	autoShowAnswer BOOLEAN null,
	groupId INTEGER null
);

create table Learn_LFQuizQuestionCategory (
	id_ LONG not null primary key,
	title TEXT null,
	description TEXT null,
	quizId INTEGER null,
	parentId INTEGER null,
	arrangementIndex INTEGER null
);

create table Learn_LFQuizTreeElement (
	id_ LONG not null primary key,
	quizID INTEGER null,
	elementID VARCHAR(75) null,
	isCategory BOOLEAN null,
	parentID VARCHAR(75) null,
	arrangementIndex INTEGER null
);

create table Learn_LFRequiredActivity (
	id_ LONG not null primary key,
	achievementId INTEGER null,
	activityClassName VARCHAR(75) null,
	numberActivitiesRequired INTEGER null
);

create table Learn_LFResource (
	id_ LONG not null primary key,
	packageID INTEGER null,
	scormType TEXT null,
	resourceID VARCHAR(3000) null,
	href TEXT null,
	base TEXT null
);

create table Learn_LFRole (
	id_ LONG not null primary key,
	liferayRoleID INTEGER null,
	permission VARCHAR(75) null,
	isDefault BOOLEAN null
);

create table Learn_LFRollupContribution (
	id_ LONG not null primary key,
	sequencingID INTEGER null,
	contributeToSatisfied TEXT null,
	contributeToNotSatisfied TEXT null,
	contributeToCompleted TEXT null,
	contributeToIncomplete TEXT null,
	objectiveMeasureWeight NUMERIC(20,2),
	measureSatisfactionIfActive BOOLEAN null
);

create table Learn_LFRollupRule (
	id_ LONG not null primary key,
	sequencingID INTEGER null,
	combination TEXT null,
	childActivitySet TEXT null,
	minimumCount INTEGER null,
	minimumPercent NUMERIC(20,2),
	action TEXT null
);

create table Learn_LFRuleCondition (
	id_ LONG not null primary key,
	conditionType TEXT null,
	objectiveId TEXT null,
	measureThreshold NUMERIC(20,2),
	inverse BOOLEAN null,
	rollupRuleID INTEGER null,
	conditionRuleID INTEGER null
);

create table Learn_LFSequencing (
	id_ LONG not null primary key,
	packageID INTEGER null,
	activityID VARCHAR(512) null,
	sharedId TEXT null,
	sharedSequencingIdReference TEXT null,
	cAttemptObjectiveProgressChild BOOLEAN null,
	cAttemptAttemptProgressChild BOOLEAN null,
	attemptLimit INTEGER null,
	durationLimitInMilliseconds LONG null,
	rollupContributionID INTEGER null,
	preventChildrenActivation BOOLEAN null,
	constrainChoice BOOLEAN null
);

create table Learn_LFSequencingPermissions (
	id_ LONG not null primary key,
	sequencingID INTEGER null,
	choiceForChildren BOOLEAN null,
	choiceForNonDescendants BOOLEAN null,
	flowForChildren BOOLEAN null,
	forwardOnlyForChildren BOOLEAN null
);

create table Learn_LFSequencingTracking (
	id_ LONG not null primary key,
	sequencingID INTEGER null,
	completionSetByContent BOOLEAN null,
	objectiveSetByContent BOOLEAN null
);

create table Learn_LFSiteDependentConfig (
	id_ LONG not null primary key,
	siteID INTEGER null,
	dataKey VARCHAR(75) null,
	dataValue VARCHAR(75) null
);

create table Learn_LFSocialPackage (
	id_ LONG not null primary key,
	packageID INTEGER null,
	aboutPackage TEXT null,
	publishDate DATE null,
	authorID INTEGER null
);

create table Learn_LFSocialPackageTag (
	id_ LONG not null primary key,
	socialPackageID INTEGER null,
	name VARCHAR(75) null
);

create table Learn_LFTincanActProfile (
	id_ LONG not null primary key,
	documentId INTEGER null,
	activityId VARCHAR(75) null,
	profileId VARCHAR(75) null
);

create table Learn_LFTincanActivity (
	id_ LONG not null primary key,
	tincanID VARCHAR(2000) null,
	packageID LONG null,
	objectType VARCHAR(75) null,
	name TEXT null,
	description TEXT null,
	theType TEXT null,
	moreInfo TEXT null,
	interactionType TEXT null,
	correctResponsesPattern TEXT null,
	choices TEXT null,
	scale TEXT null,
	source TEXT null,
	target TEXT null,
	steps TEXT null,
	extensions TEXT null
);

create table Learn_LFTincanActor (
	id_ LONG not null primary key,
	tincanID VARCHAR(75) null,
	objectType VARCHAR(75) null,
	name VARCHAR(3000) null,
	mbox VARCHAR(3000) null,
	mbox_sha1sum VARCHAR(3000) null,
	openid VARCHAR(3000) null,
	account TEXT null,
	memberOf VARCHAR(3000) null
);

create table Learn_LFTincanClientApiStorage (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	secret VARCHAR(75) null,
	url VARCHAR(75) null,
	redirectUrl VARCHAR(75) null,
	scope VARCHAR(75) null,
	iconUrl VARCHAR(75) null,
	token VARCHAR(75) null,
	code_ VARCHAR(75) null,
	issuedAt DATE null,
	expiredIn LONG
);

create table Learn_LFTincanCtxActivities (
	id_ LONG not null primary key,
	parent VARCHAR(3000) null,
	grouping VARCHAR(3000) null,
	category VARCHAR(3000) null,
	other VARCHAR(3000) null
);

create table Learn_LFTincanLrsAgentProfile (
	id_ LONG not null primary key,
	documentId INTEGER null,
	agentId INTEGER null,
	profileId VARCHAR(75) null
);

create table Learn_LFTincanLrsAttachment (
	id_ LONG not null primary key,
	parentID INTEGER null,
	usageType TEXT null,
	display TEXT null,
	description TEXT null,
	contentType TEXT null,
	length INTEGER null,
	sha2 TEXT null,
	fileUrl TEXT null
);

create table Learn_LFTincanLrsContext (
	id_ LONG not null primary key,
	registration VARCHAR(75) null,
	instructorID INTEGER null,
	teamID INTEGER null,
	contextActivitiesID INTEGER null,
	revision TEXT null,
	platform TEXT null,
	language TEXT null,
	statement TEXT null,
	extensions TEXT null
);

create table Learn_LFTincanLrsDocument (
	id_ LONG not null primary key,
	documentId VARCHAR(75) null,
	update_ DATE null,
	content TEXT null,
	contentType VARCHAR(2000) null
);

create table Learn_LFTincanLrsEndpoint (
	id_ LONG not null primary key,
	endpoint VARCHAR(2000) null,
	authType VARCHAR(2000) null,
	key_ VARCHAR(2000) null,
	secret VARCHAR(2000) null
);

create table Learn_LFTincanLrsResult (
	id_ LONG not null primary key,
	score TEXT null,
	success BOOLEAN null,
	completion BOOLEAN null,
	response TEXT null,
	duration VARCHAR(75) null,
	extension TEXT null
);

create table Learn_LFTincanLrsState (
	id_ LONG not null primary key,
	stateId VARCHAR(75) null,
	documentId VARCHAR(75) null,
	activityId VARCHAR(75) null,
	registration TEXT null,
	agentId INTEGER null
);

create table Learn_LFTincanLrsStatement (
	id_ LONG not null primary key,
	tincanID VARCHAR(75) null,
	actorID INTEGER null,
	verbID VARCHAR(2000) null,
	verbDisplay TEXT null,
	objType VARCHAR(2000) null,
	objID INTEGER null,
	resultID INTEGER null,
	contextID INTEGER null,
	timestamp DATE null,
	stored DATE null,
	authorityID INTEGER null,
	version VARCHAR(2000) null
);

create table Learn_LFTincanLrsStatementRef (
	id_ LONG not null primary key,
	uuid_ VARCHAR(75) null
);

create table Learn_LFTincanLrsSubStatement (
	id_ LONG not null primary key,
	actorID INTEGER null,
	verbID VARCHAR(2000) null,
	verbDisplay TEXT null,
	objType VARCHAR(2000) null,
	objID INTEGER null
);

create table Learn_LFTincanManifestAct (
	id_ LONG not null primary key,
	tincanID VARCHAR(2000) null,
	packageID LONG null,
	activityType VARCHAR(2000) null,
	name VARCHAR(2000) null,
	description VARCHAR(2000) null,
	launch VARCHAR(2000) null,
	resourceID VARCHAR(2000) null
);

create table Learn_LFTincanPackage (
	id_ LONG not null primary key,
	title VARCHAR(2000) null,
	summary VARCHAR(2000) null,
	assetRefID LONG null,
	courseID INTEGER null,
	logo TEXT null
);

create table Learn_LFTincanURI (
	uri VARCHAR(200) not null primary key,
	objID VARCHAR(75) null,
	objType VARCHAR(75) null,
	content VARCHAR(2000) null
);

create table Learn_LFUser (
	lfid LONG not null primary key,
	id_ INTEGER null,
	name TEXT null,
	preferredAudioLevel DOUBLE null,
	preferredLanguage TEXT null,
	preferredDeliverySpeed DOUBLE null,
	preferredAudioCaptioning INTEGER null
);