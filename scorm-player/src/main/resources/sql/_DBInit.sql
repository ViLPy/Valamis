DROP TABLE IF EXISTS Package CASCADE;

CREATE TABLE Package
(
  id serial,
  defaultOrganizationID text,
  title text,
  base text,
  resourcesBase text,
  summary text,
  visibility boolean,
  CONSTRAINT Package_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

DROP TABLE IF EXISTS Organization CASCADE;

CREATE TABLE Organization
(
  id serial,
  packageID integer NOT NULL,
  title text,
  CONSTRAINT Organization_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Organization ADD CONSTRAINT Organization_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS Activity CASCADE;

CREATE TABLE Activity
(
  id serial,
  organizationID integer NOT NULL,
  parentID integer,
  title text,
  identifierRef text,
  resourceParameters text,
  CONSTRAINT Activity_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Activity ADD CONSTRAINT Activity_fk1 FOREIGN KEY (organizationID) REFERENCES Organization(id) ON DELETE CASCADE;
ALTER TABLE Activity ADD CONSTRAINT Activity_fk2 FOREIGN KEY (parentID) REFERENCES Activity(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS Resource CASCADE;

CREATE TABLE Resource
(
  id serial,
  packageID integer NOT NULL,
  resourceType text,
  scormType text,
  href text,
  base text,
  CONSTRAINT ResourcePK PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Resource ADD CONSTRAINT Resource_fk1 FOREIGN KEY (packageID) REFERENCES Package(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS QuestionCategory CASCADE;

CREATE TABLE QuestionCategory
(
  id serial,
  title text,
  description text,
  parentID integer,
  "position" integer,
  CONSTRAINT QuestionCategory_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE QuestionCategory ADD CONSTRAINT QuestionCategory_fk1 FOREIGN KEY (parentID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS Question CASCADE;

CREATE TABLE Question
(
  id serial,
  categoryID integer,
  title text,
  description text,
  explanationText text,
  forceCorrectCount boolean,
  isCaseSensitive boolean,
  questionType integer,
  "position" integer,
  CONSTRAINT Question_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Question ADD CONSTRAINT Question_fk1 FOREIGN KEY (categoryID) REFERENCES QuestionCategory(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS Answer CASCADE;

CREATE TABLE Answer
(
  id serial,
  description text,
  isCorrect boolean,
  questionID integer,
  rangeFrom decimal,
  rangeTo decimal,
  matchingText text,
  answerPosition integer,
  answerType integer,
  CONSTRAINT Answer_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Answer ADD CONSTRAINT Answer_fk1 FOREIGN KEY (questionID) REFERENCES Question(id) ON DELETE CASCADE;