DROP TABLE IF EXISTS DataModel CASCADE;

CREATE TABLE DataModel
( 
    id serial,
    dataKey text,
    dataValue text,
    attemptID integer,
    activityID text,
    CONSTRAINT DataModel_pk0 PRIMARY KEY (id) 
) WITH ( 
    OIDS=FALSE
);

ALTER TABLE DataModel ADD CONSTRAINT DataModel_fk1 FOREIGN KEY (attemptID) REFERENCES Attempt(id) ON DELETE CASCADE;
