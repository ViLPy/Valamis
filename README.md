# Valamis - eLearning for Liferay

**http://valamis.arcusys.com/**

[![build status](https://api.travis-ci.org/arcusys/JSCORM.png)](http://travis-ci.org/arcusys/JSCORM)

###This is Valamis CE version - No support - No warranty
###To get supported Valamis Enterprise Edition contact us in http://valamis.arcusys.com/get-valamis
###Or buy straight from Liferay Marketplace http://www.liferay.com/marketplace/-/mp/application/35268197
####The following features are not supported in the CE version
#####-Competences
#####-Phenomenizer
#####-Mobile application

Valamis is a social learning environment for sharing and receiving knowledge. We want to help people to share knowledge and learn. You can use Valamis as your organization's social learning environment.

Supported Liferay version is currently 6.2.
The targeted version of SCORM is 2004 4th edition with support of SCORM 1.2.
All server-side code is written using the Scala programming language for the JVM.

The current implementation is able to display SCORM and Tin Can content with respect towards the different content organizations and the activity structure in each organization.
Application includes a question editor for creating quizes with different types of questions (single-/multi-choice, matching, short answer, etc.)

Administrative features let you manage SCORM packages, uploading the them in standard zipped format.
The user interface is available as a JSR-compliant portlets, which may be deployed into Liferay portal. The portlet version has been tested on Liferay 6.1.1 and 6.1.2, and depend on its specific features.

The solution uses Liferay database, so no need to install additional database.

If deployed against a portlet container, the end-user features are available via the portlet's standard View mode, while administrative features are available via the Edit mode. Also there is another portlet for question editor, quiz editor and gradebook.

### LRS
TinCan LRS endpoint is set by default to use our internal LRS, so no need to configure something.
Internal LRS endpoint is: `<your-domain>/learn-portlet/TincanApi`

If you need to customize it, settings can be found in admin portlet on settings tab.

TinCan LRS OAuth endpoint is: `<your-domain>/learn-portlet/oauth`

### Download 
Download Valamis CE source code from this repository and compile the application yourself

###Post-deployment process
Since version 1.2.1 it's required to manually add 2 roles in Liferay: Student and Teacher. Admin should manually set membership relations for user/roles

###Known issues
**PermGen issue**: Valamis requires 512Mb of PermGen size. This is default size in Liferay bundled with glassfish, but permgen in Tomcat and jBoss bundles should be increased.

Liferay 6.1 EE bundled with Tomcat 7 can throw errors while accessing uploaded content. To avoid this problems just turn off GZip conmpression:
`com.liferay.portal.servlet.filters.gzip.GZipFilter=false`

## Version 2.4 Update 26.6.2015
 - New Valamis login page with new design
 - Valamis site automatically created with Dashboard page when application is deployed
 - Content management portlet has a new design with added functionality: You can now create subcategories, duplicate questions and add custom correct and incorrect answer texts
 - New Lesson Studio portlet added with a wysiwyg slide editor for lessons: Add text, images, videos, PDF files, embedded content, pptx files, questions or math functions to slides
 - Lesson Designer lessons can be exported to new Lesson Studio portlet
 - New dashboard landing page for students: Displays statistical information concerning your learning courses, certificates, learning paths and activities
 - Removed file size limit of 15mb for uploaded lesson packages
 - Padding lessons created in Lesson Studio on mobile device fixed
 - Needed fixes for reports done

## Version 2.2 Update 11.12.2014
 - Uploading pptx presentation as TinCan package
 - Uploading pptx presentation as list of questions in Lesson Designer
 - Moving questions between courses, displaying all questions from Liferay instance
 - Logo change will affect only after Save action
 - Scandic letters problem fix
 - Time limit for passing package
 - Time limit between package retakes
 - Check mark for package which user already started, displaying remain attemps
 - PDF viewer
 - Theme selector for tincan
 - Randomization questions in tincan packages
 - Foreground video
 - Printing Learning transcript
 - Fluid card layout
 - Tincan signed statements support
 - Removed instructional sentences (such as "choose correct answers" ) from questions
 - UI improvements

## Version 2.0 Update 19.6.2014
 - New UI with RWD
 - Gradebook for LRS
 - New reports
 - Updated curriculum functionality
 - Fullscreen mode for Lesson Viewer 

## Version 1.7 Update 28.2.2014
 - OAuth identity provider for TinCan LRS
 - TinCan statements viewer and reporting
 - Separate Package manager and Administering portlets 
 - Personal scope for packages
 - Impoved user searching for certificates and achievements
 - Oracle DB support
 - Improvements and fixes

## Version 1.6.6 Update 31.1.2014
**Liferay 6.2 support. Liferay 6.1 is not supported since this version**
 - Liferay 6.2 support
 - Achievements portlets

## Version 1.6.1 Update 10.1.2014
 - Tin Can API LRS - Learning Record Store implementation
 - Small improvements and fixes

## Version 1.5.6 Update: 14.11.2013
 - Support for Liferay 6.1.2 GA3
 - Support for Liferay 6.1.30 EE
 - Special characters issue in LIFERAY_HOME path
 - Question management - Numberic question issue
 - Search hook fix for Liferay 6.1.2 GA3
 - Relative URL conversion fix in TinyMCE
 - Fix for Liferay web content scopes
 - Fix for Gradebook instance-wide visibility in multi-instance installation
 - Curriculum - Fix for user visibility issue in multi-instance installation
 - Curriculum - Fix for course site link issue
 - Fix for database update issue with Service Builder
 - Fix for Openbadges.me integration
 - Name refactoring - Removing SCORM references

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