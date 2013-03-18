# Project Learn

The project is an implementation of the SCORM set of standards for e-learning for the Liferay portal. Supported Liferay version is currently 6.0.5+ CE. Also checked with 6.1.
The targeted version of SCORM is 2004 4th edition with support of SCORM 1.2.
All server-side code is written using the Scala programming language for the JVM.

The current implementation is able to display SCORM content with respect towards the different content organizations and the activity structure in each organization.
Application includes a question editor for creating quizes with different types of questions (single-/multi-choice, matching, short answer, etc.)

Administrative features let you manage SCORM packages, uploading the them in standard zipped format.
The user interface is available in two forms - a standalone web application, which may be deployed against any servlet container, and a JSR-compliant portlet, which may be deployed against a standards-based portlet container. The portlet version has been tested on Liferay, but does not depend on its specific features.

The solution uses its own PostgreSQL database. You only need it created and accessible, there's an admin feature that lets you initialize the database structure before use.

If deployed against a servlet container, the end-user features are available at the relative url '/', and the admin features are available at the relative url '/ScormAdmin'. Question editor is available at '/QuestionBank'. Quiz editor at '/Quiz'. Gradebook at '/Gradebook' But you should have portlet-api jar inside of your app.server.

If deployed against a portlet container, the end-user features are available via the portlet's standard View mode, while administrative features are available via the Edit mode. Also there is another portlet for question editor, quiz editor and gradebook.

The solution will be further developed to support the full set of requirements from the SCORM set of standards.

**After deploying** please login as portal administrator, go to SCORM View portlet preferences and re-initalize database from admin. dialog.

### Download 
Github has deprecated the Download section. You can download the latest distributable from here: **http://opensource.arcusys.com/learn/learn-web/1.2.1/learn-web-1.2.1.war**

###Post-deployment process
After deployment you just need to configure DB. This can be done from SCORMPlayer portlet preferences or if working as servlets by opening '/ScormAdmin'.
In Learn 1.2 there will be additional default H2 database so application will work out of the box without DB configuring.
In Learn 1.2.1 it's required to manually add 2 roles in Liferay: Student and Teacher. Admin should manually set membership relations for user/roles

###Known issues
Liferay 6.1 EE bundled with Tomcat 7 can throw errors while accessing uploaded content. To avoid this problems just turn off GZip conmpression:
`com.liferay.portal.servlet.filters.gzip.GZipFilter=false`

## Version 1.3 Update: 18.03.2013
 - MySQL support
 - Demo hook
 - IsDefault property
 - Updater portlet
 - Bugs fixes

## Version 1.2.1 Update: 22.01.2013
 - Implemented Scope to all portlets
 - Added possibility to add manual comment and grade for essay and for whole course
 - Player continue playing course at the same location when user reload page
 - Static user roles for permissions: Student and Teacher
 

## Version 1.2. Update: 07.11.2012
 - Out of the box H2 database
 - Support of external resources (now you can add page by full URL, like http://www.example.com)
 - Support of Liferay's articles with article pickup dialog
 - Question preview from Quiz management
 - Packages now can be found and accessed from AssetPublisher and Search portlets from Liferay
 - L18N support based on Liferay's locale
 - Small fixes for UI
 - Fix for Liferay bundle with JBoss

## Version 1.1. Update: 07.09.2012
 - Support for SCORM 1.2
 - Small fixes for UI

## Version 1.0.1. Update: 29.08.2012
 - 'Redactor' replaced with TinyMCE
 - bugfixing

## Version 1.0 - Release. Update: 16.08.2012
 - SCORM 2004 4th Ed. support improved in part of Sequencing and RTE
 - Added quiz generation support
 - Added gradebook portlet
 - UI refactored
 - Source code refactoring and unit testing

## Version 0.3 - Question base portlet stabilized. Update: 06.02.2012
 - Added functionality to upload and add image and file attachements in Questionbank.
 - Added drag-n-dropfor question and category in TreeView
 - A lot of small improvements regarding to UI
 
### Building

This is Maven2 project, so you can use IDE that you like.

### Data base updating
To update DB structure from 1.0 to the latest 1.1 run next SQL script

    CREATE TABLE ActivityData
     (
     id serial,
     packageID integer,
     activityID text,
     targetId text,
     readSharedData boolean,
     writeSharedData boolean,
     CONSTRAINT ActivityData_pk PRIMARY KEY (id)
     ) WITH (
     OIDS=FALSE
     );
    
    ALTER TABLE ActivityData ADD CONSTRAINT ActivityData_fk1 FOREIGN KEY (activityID, packageID) REFERENCES Activity(id, packageID) ON DELETE CASCADE;
    
    ALTER TABLE Activity ADD masteryScore text;
    ALTER TABLE Activity ADD maxTimeAllowed text;

#### Tests
For running tests on local machine for scorm-player you should change db.properties file inside resources directory and setup you current PostgreSQL instance.
