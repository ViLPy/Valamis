# Valamis - eLearning for Liferay

**http://www.valamislearning.com**

[![build status](https://api.travis-ci.org/arcusys/JSCORM.png)](http://travis-ci.org/arcusys/JSCORM)

Valamis is a social learning environment for sharing and receiving knowledge. We want to help people to share knowledge and learn using Liferay platform. You can use it as your organizations social learning environment.

Supported Liferay version is currently 6.1.1+
The targeted version of SCORM is 2004 4th edition with support of SCORM 1.2.
All server-side code is written using the Scala programming language for the JVM.

The current implementation is able to display SCORM and Tin Can content with respect towards the different content organizations and the activity structure in each organization.
Application includes a question editor for creating quizes with different types of questions (single-/multi-choice, matching, short answer, etc.)

Administrative features let you manage SCORM packages, uploading the them in standard zipped format.
The user interface is available as a JSR-compliant portlets, which may be deployed into Liferay portal. The portlet version has been tested on Liferay 6.1.1, and depend on its specific features.

The solution uses Liferay database, so no need to install additional database.

If deployed against a portlet container, the end-user features are available via the portlet's standard View mode, while administrative features are available via the Edit mode. Also there is another portlet for question editor, quiz editor and gradebook.

### Download 
Github has deprecated the Download section. You can download the latest distributable from here: **http://opensource.arcusys.com/learn/learn-web/1.4.5/**

###Post-deployment process
Since version 1.2.1 it's required to manually add 2 roles in Liferay: Student and Teacher. Admin should manually set membership relations for user/roles

###Known issues
Liferay 6.1 EE bundled with Tomcat 7 can throw errors while accessing uploaded content. To avoid this problems just turn off GZip conmpression:
`com.liferay.portal.servlet.filters.gzip.GZipFilter=false`

## Version 1.5.1 Update: 16.10.2013

Fixed problems:
 - JavaScript Minifier failed for SCORM Gradebook viewer
 - Quiz portlet shows only main instance LF Articles
 - Gradebook matrix view shows all quizes even from another courses
 - Reordering questions and categories is not working properly

## Version 1.5 Update: 9.10.2013
 - Tin Can API support
 - Integration connecting 3rd party Tin Can LRS with Basic Auth
 - Open Badges integration for issuing and earning badges
 - My Certificates -portlet
 - Badges functionality to Curriculum
 - Integration to Open Badges to show your earned Open Badges in My Certificates portlet
 - Badge Designer integration to Curriculum
 - Badge uploading
 - Curriculum improvements
 - Gradebook matrix view, to see all students for a course
 - Small improvements and bug fixes

## Version 1.4.5 Update: 13.08.2013
 - new Curriculum portlet for managing certifications, awards and learning paths
 - demo hook updated and now create private site and site pages

## Version 1.4 Update: 24.05.2013
 - Persistence reimplemented using Liferay Service Builder, so there is no database settings in Admin portlet.
 - Demo Hook updated and now it add additional demo content into separate site
 - Refactoring, Bugs fixing
 

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
