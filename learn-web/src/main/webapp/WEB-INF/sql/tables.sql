create table Learn_LFActivity (
	indexNumber LONG not null primary key,
	id_ VARCHAR(512) null,
	packageID INTEGER,
	organizationID VARCHAR(512) null,
	parentID VARCHAR(512) null,
	title TEXT null,
	identifierRef TEXT null,
	resourceParameters TEXT null,
	hideLMSUI TEXT null,
	visible BOOLEAN,
	objectivesGlobalToSystem BOOLEAN,
	sharedDataGlobalToSystem BOOLEAN,
	masteryScore TEXT null,
	maxTimeAllowed TEXT null
);

create table Learn_LFActivityDataMap (
	id_ LONG not null primary key,
	packageID INTEGER,
	activityID VARCHAR(512) null,
	targetId TEXT null,
	readSharedData BOOLEAN,
	writeSharedData BOOLEAN
);

create table Learn_LFActivityState (
	id_ LONG not null primary key,
	packageID INTEGER,
	activityID TEXT null,
	active_ BOOLEAN,
	suspended BOOLEAN,
	attemptCompleted BOOLEAN null,
	attemptCompletionAmount NUMERIC(20,2),
	attemptAbsoluteDuration NUMERIC(20,2),
	attemptExperiencedDuration NUMERIC(20,2),
	activityAbsoluteDuration NUMERIC(20,2),
	activityExperiencedDuration NUMERIC(20,2),
	attemptCount INTEGER,
	activityStateNodeID INTEGER null,
	activityStateTreeID INTEGER null
);

create table Learn_LFActivityStateNode (
	id_ LONG not null primary key,
	parentID INTEGER null,
	treeID INTEGER,
	availableChildrenIDs TEXT null
);

create table Learn_LFActivityStateTree (
	id_ LONG not null primary key,
	currentActivityID TEXT null,
	suspendedActivityID TEXT null,
	attemptID INTEGER
);

create table Learn_LFAnswer (
	id_ LONG not null primary key,
	description TEXT null,
	correct BOOLEAN,
	questionId INTEGER,
	rangeFrom NUMERIC(20,2),
	rangeTo NUMERIC(20,2),
	matchingText TEXT null,
	answerPosition INTEGER,
	answerType INTEGER
);

create table Learn_LFAttempt (
	id_ LONG not null primary key,
	userID INTEGER,
	packageID INTEGER,
	organizationID TEXT null,
	isComplete BOOLEAN
);

create table Learn_LFAttemptData (
	id_ LONG not null primary key,
	dataKey TEXT null,
	dataValue TEXT null,
	attemptID INTEGER,
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
	description TEXT null
);

create table Learn_LFCertificateSite (
	id_ LONG not null primary key,
	certificateID INTEGER,
	siteID INTEGER,
	arrangementIndex INTEGER
);

create table Learn_LFCertificateUser (
	id_ LONG not null primary key,
	certificateID INTEGER,
	userID INTEGER
);

create table Learn_LFChildrenSelection (
	id_ LONG not null primary key,
	sequencingID INTEGER,
	takeCount INTEGER,
	takeTimingOnEachAttempt TEXT null,
	reorderOnEachAttempt TEXT null
);

create table Learn_LFConditionRule (
	id_ LONG not null primary key,
	sequencingID INTEGER,
	combination TEXT null,
	ruleType TEXT null,
	action TEXT null
);

create table Learn_LFCourse (
	id_ LONG not null primary key,
	courseID INTEGER,
	userID INTEGER,
	grade TEXT null,
	comment_ TEXT null
);

create table Learn_LFFileStorage (
	id_ LONG not null primary key,
	filename TEXT null,
	content TEXT null
);

create table Learn_LFGlobalObjectiveState (
	id_ LONG not null primary key,
	satisfied BOOLEAN,
	normalizedMeasure NUMERIC(20,2),
	attemptCompleted BOOLEAN,
	mapKey TEXT null,
	treeID INTEGER
);

create table Learn_LFObjective (
	lfId LONG not null primary key,
	sequencingID INTEGER,
	satisfiedByMeasure BOOLEAN,
	identifier TEXT null,
	minNormalizedMeasure NUMERIC(20,2),
	isPrimary BOOLEAN
);

create table Learn_LFObjectiveMap (
	id_ LONG not null primary key,
	objectiveID INTEGER,
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
	satisfied BOOLEAN,
	normalizedMeasure NUMERIC(20,2),
	mapKey TEXT null,
	activityStateID INTEGER,
	objectiveID INTEGER
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
	socialPackageID INTEGER,
	authorID INTEGER,
	comment_ VARCHAR(75) null,
	publishDate DATE null
);

create table Learn_LFPackageScopeRule (
	id_ LONG not null primary key,
	packageID INTEGER,
	scope TEXT null,
	scopeID TEXT null,
	visibility BOOLEAN,
	isDefault BOOLEAN null
);

create table Learn_LFPackageVote (
	id_ LONG not null primary key,
	userID INTEGER,
	socialPackageID INTEGER,
	value INTEGER
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
	forceCorrectCount BOOLEAN,
	caseSensitive BOOLEAN,
	questionType INTEGER,
	courseId INTEGER null,
	arrangementIndex INTEGER
);

create table Learn_LFQuestionCategory (
	id_ LONG not null primary key,
	title TEXT null,
	description TEXT null,
	parentId INTEGER null,
	courseId INTEGER null,
	arrangementIndex INTEGER
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
	quizId INTEGER,
	categoryId INTEGER null,
	questionId INTEGER,
	questionType TEXT null,
	title TEXT null,
	url TEXT null,
	plainText TEXT null,
	arrangementIndex INTEGER
);

create table Learn_LFQuizQuestionCategory (
	id_ LONG not null primary key,
	title TEXT null,
	description TEXT null,
	quizId INTEGER,
	parentId INTEGER null,
	arrangementIndex INTEGER
);

create table Learn_LFRollupContribution (
	id_ LONG not null primary key,
	sequencingID INTEGER,
	contributeToSatisfied TEXT null,
	contributeToNotSatisfied TEXT null,
	contributeToCompleted TEXT null,
	contributeToIncomplete TEXT null,
	objectiveMeasureWeight NUMERIC(20,2),
	measureSatisfactionIfActive BOOLEAN
);

create table Learn_LFRollupRule (
	id_ LONG not null primary key,
	sequencingID INTEGER,
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
	inverse BOOLEAN,
	rollupRuleID INTEGER,
	conditionRuleID INTEGER
);

create table Learn_LFResource (
	id_ LONG not null primary key,
	packageID INTEGER,
	scormType TEXT null,
	resourceID TEXT null,
	href TEXT null,
	base TEXT null
);

create table Learn_LFSequencing (
	id_ LONG not null primary key,
	packageID INTEGER,
	activityID VARCHAR(512) null,
	sharedId TEXT null,
	sharedSequencingIdReference TEXT null,
	onlyCurrentAttemptObjectiveProgressForChildren BOOLEAN,
	onlyCurrentAttemptAttemptProgressForChildren BOOLEAN,
	attemptLimit INTEGER null,
	durationLimitInMilliseconds LONG null,
	rollupContributionID INTEGER,
	preventChildrenActivation BOOLEAN,
	constrainChoice BOOLEAN
);

create table Learn_LFSequencingPermissions (
	id_ LONG not null primary key,
	sequencingID INTEGER,
	choiceForChildren BOOLEAN,
	choiceForNonDescendants BOOLEAN,
	flowForChildren BOOLEAN,
	forwardOnlyForChildren BOOLEAN
);

create table Learn_LFSequencingTracking (
	id_ LONG not null primary key,
	sequencingID INTEGER,
	completionSetByContent BOOLEAN,
	objectiveSetByContent BOOLEAN
);

create table Learn_LFSocialPackage (
	id_ LONG not null primary key,
	packageID INTEGER,
	aboutPackage TEXT null,
	publishDate DATE null,
	authorID INTEGER
);

create table Learn_LFSocialPackageTag (
	id_ LONG not null primary key,
	socialPackageID INTEGER,
	name VARCHAR(75) null
);

create table Learn_LFUser (
	lfid LONG not null primary key,
	id_ INTEGER,
	name TEXT null,
	preferredAudioLevel DOUBLE,
	preferredLanguage TEXT null,
	preferredDeliverySpeed DOUBLE,
	preferredAudioCaptioning INTEGER
);