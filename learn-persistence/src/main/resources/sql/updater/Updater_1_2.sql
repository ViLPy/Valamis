-- 1.0 to 1.1
DO $$
    BEGIN
        BEGIN
            ALTER TABLE Activity ADD COLUMN masteryScore text;
            ALTER TABLE Activity ADD COLUMN maxTimeAllowed text;
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column masteryScore or maxTimeAllowed already exists in Activity.';
        END;
    END;
$$
;

-- 1.1 to 1.2
CREATE TABLE IF NOT EXISTS FileStorage
(
	id serial,
	filename text,
	content bytea,
	CONSTRAINT FileStorage_pk0 PRIMARY KEY (id)
) WITH (
	OIDS=FALSE
);

DO $$
    BEGIN
        BEGIN
            ALTER TABLE Package ADD COLUMN assetRefID bigint;
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column assetRefID already exists in Package.';
        END;
    END;
$$
;


-- 1.2 to 1.2.1
-- Add courseID field to Question table
DO $$
    BEGIN
        BEGIN
            ALTER TABLE Question ADD COLUMN courseID integer;
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column courseID already exists in Question.';
        END;
    END;
$$
;

DO $$
    BEGIN
        BEGIN
            ALTER TABLE Question RENAME COLUMN "position" TO arrangementIndex;
        EXCEPTION
            WHEN syntax_error_or_access_rule_violation THEN RAISE NOTICE 'column position already renamed in Question.';
        END;
    END;
$$
;

-- Add courseID field to QuestionCategory table
DO $$
    BEGIN
        BEGIN
            ALTER TABLE QuestionCategory ADD COLUMN courseID integer;
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column courseID already exists in QuestionCategory.';
        END;
    END;
$$
;

DO $$
    BEGIN
        BEGIN
            ALTER TABLE QuestionCategory RENAME COLUMN "position" TO arrangementIndex;
        EXCEPTION
            WHEN syntax_error_or_access_rule_violation THEN RAISE NOTICE 'column position already renamed in QuestionCategory.';
        END;
    END;
$$
;

-- Add courseID field to Quiz table
DO $$
    BEGIN
        BEGIN
            ALTER TABLE Quiz ADD COLUMN courseID integer;
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column courseID already exists in Quiz.';
        END;
    END;
$$
;

DO $$
    BEGIN
        BEGIN
            ALTER TABLE QuizQuestion ADD COLUMN url text;
            ALTER TABLE QuizQuestion ADD COLUMN title text;
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column url and title already exists in QuizQuestion.';
        END;
    END;
$$
;

DO $$
    BEGIN
        BEGIN
            ALTER TABLE QuizQuestion RENAME COLUMN "position" TO arrangementIndex;
        EXCEPTION
            WHEN syntax_error_or_access_rule_violation THEN RAISE NOTICE 'column position already renamed in QuizQuestion.';
        END;
    END;
$$
;

DO $$
    BEGIN
        BEGIN
            ALTER TABLE QuizCategory RENAME COLUMN "position" TO arrangementIndex;
        EXCEPTION
            WHEN syntax_error_or_access_rule_violation THEN RAISE NOTICE 'column position already renamed in QuizCategory.';
        END;
    END;
$$
;


-- Add courseID field to Package table
DO $$
    BEGIN
        BEGIN
            ALTER TABLE Package ADD COLUMN courseID integer;
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column courseID already exists in Package.';
        END;
    END;
$$
;

-- Remove visibility field from Package table
ALTER TABLE Package DROP COLUMN visibility;

-- Add PackageScopeRule table
CREATE TABLE IF NOT EXISTS PackageScopeRule
(
  packageID integer NOT NULL,
  scope text,
  scopeID text,
  visibility boolean,
  isDefault boolean
) WITH (
  OIDS=FALSE
);

DO $$
    BEGIN
        BEGIN
			ALTER TABLE PackageScopeRule ADD CONSTRAINT PackageScopeRule_fk1 FOREIGN KEY (packageID) REFERENCES package(id) ON DELETE CASCADE;
        EXCEPTION
            WHEN syntax_error_or_access_rule_violation THEN RAISE NOTICE 'column Course_fk1 already exists in Course.';
        END;
    END;
$$
;
--END


-- Add PlayerScopeRule table
CREATE TABLE IF NOT EXISTS PlayerScopeRule
(
  playerID text,
  scope text
) WITH (
  OIDS=FALSE

);

-- Add Course table
CREATE TABLE IF NOT EXISTS Course
(
  courseID integer NOT NULL,
  userID integer NOT NULL,
  grade text,
  comment text
) WITH (
  OIDS=FALSE
);

DO $$
    BEGIN
        BEGIN
            ALTER TABLE Course ADD CONSTRAINT Course_fk1 FOREIGN KEY (userID) REFERENCES LMSUser(id) ON DELETE CASCADE;
        EXCEPTION
            WHEN syntax_error_or_access_rule_violation THEN RAISE NOTICE 'column Course_fk1 already exists in Course.';
        END;
    END;
$$
;



