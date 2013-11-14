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
	activityID TEXT null,
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
	dataKey TEXT null,
	dataValue TEXT null,
	attemptID INTEGER null,
	activityID TEXT null
);

create table Learn_LFBigDecimal (
	id_ LONG not null primary key,
	decimal_ NUMERIC(20,2),
	text_ VARCHAR(75) null
);

create table Learn_LFCertificate (
	id_ LONG not null primary key,
	title TEXT null,
	description TEXT null,
	logo VARCHAR(75) null,
	isPermanent BOOLEAN null,
	publishBadge BOOLEAN null,
	shortDescription VARCHAR(75) null,
	companyID INTEGER null
);

create table Learn_LFCertificateSite (
	id_ LONG not null primary key,
	certificateID INTEGER null,
	siteID INTEGER null,
	arrangementIndex INTEGER null
);

create table Learn_LFCertificateUser (
	id_ LONG not null primary key,
	certificateID INTEGER null,
	userID INTEGER null
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
	ruleType TEXT null,
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
	grade TEXT null,
	comment_ TEXT null,
	date_ DATE null
);

create table Learn_LFFileStorage (
	id_ LONG not null primary key,
	filename TEXT null,
	content TEXT null
);

create table Learn_LFGlobalObjectiveState (
	id_ LONG not null primary key,
	satisfied BOOLEAN null,
	normalizedMeasure NUMERIC(20,2),
	attemptCompleted BOOLEAN null,
	mapKey TEXT null,
	treeID INTEGER null
);

create table Learn_LFObjective (
	lfId LONG not null primary key,
	sequencingID INTEGER null,
	satisfiedByMeasure BOOLEAN null,
	identifier TEXT null,
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
	mapKey TEXT null,
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
	courseID INTEGER null
);

create table Learn_LFPackageComment (
	id_ LONG not null primary key,
	socialPackageID INTEGER null,
	authorID INTEGER null,
	comment_ VARCHAR(75) null,
	publishDate DATE null
);

create table Learn_LFPackageScopeRule (
	id_ LONG not null primary key,
	packageID INTEGER null,
	scope TEXT null,
	scopeID TEXT null,
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
	playerID TEXT null,
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
	welcomePageContent TEXT null,
	finalPageContent TEXT null,
	courseID INTEGER null
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
	arrangementIndex INTEGER null
);

create table Learn_LFQuizQuestionCategory (
	id_ LONG not null primary key,
	title TEXT null,
	description TEXT null,
	quizId INTEGER null,
	parentId INTEGER null,
	arrangementIndex INTEGER null
);

create table Learn_LFResource (
	id_ LONG not null primary key,
	packageID INTEGER null,
	scormType TEXT null,
	resourceID TEXT null,
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
	onlyCurrentAttemptObjectiveProgressForChildren BOOLEAN null,
	onlyCurrentAttemptAttemptProgressForChildren BOOLEAN null,
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

create table Learn_LFTincanActivity (
	id_ LONG not null primary key,
	tincanID VARCHAR(75) null,
	packageID LONG null,
	activityType VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	launch VARCHAR(75) null,
	resource VARCHAR(75) null
);

create table Learn_LFTincanLrsEndpoint (
	id_ LONG not null primary key,
	endpoint VARCHAR(75) null,
	authType VARCHAR(75) null,
	key_ VARCHAR(75) null,
	secret VARCHAR(75) null
);

create table Learn_LFTincanPackage (
	id_ LONG not null primary key,
	title VARCHAR(75) null,
	summary VARCHAR(75) null,
	assetRefID LONG null,
	courseID INTEGER null
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