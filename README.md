# SCORM

The project is an implementation of the SCORM set of standards for e-learning for the Liferay portal. Supported Liferay version is currently 6.0.5+ CE. Also checked with 6.1.
The targeted version of SCORM is 2004 4th edition.
All server-side code is written using the Scala programming language for the JVM.

The current implementation is only able do display static SCORM content with respect towards the different content organizations and the activity structure in each organization.
Also added simple question editor for creating quizes with different types of questions (single-/multi-choice, matching, short answer, etc.). At that moment only quiz editor is available. 
Quiz player will be available later.

Administrative features let you manage SCORM packages, uploading the them in standard zipped format.
The user interface is available in two forms - a standalone web application, which may be deployed against any servlet container, and a JSR-compliant portlet, which may be deployed against a standards-based portlet container. The portlet version has been tested on Liferay, but does not depend on its specific features.

The solution uses its own PostgreSQL database. You only need it created and accessible, there's an admin feature that lets you initialize the database structure before use.

If deployed against a servlet container, the end-user features are available at the relative url '/', and the admin features are available at the relative url '/ScormAdmin'. Quiz editor is available at '/QuestionBank'. **But** you should have portlet-api jar inside of your app.server.

If deployed against a portlet container, the end-user features are available via the portlet's standard View mode, while administrative features are available via the Edit mode. Also there is another portlet for quiz editor.

The solution will be further developed to support the full set of requirements from the SCORM set of standards.

**After deploying** please login as portal administrator, go to SCORM View portlet preferences and re-initalize database from admin. dialog.

###Known issues
Liferay 6.1 EE bundled with Tomcat 7 can throw errors while accessing uploaded content. To avoid this problems just turn off GZip conmpression:
`com.liferay.portal.servlet.filters.gzip.GZipFilter=false`

## Version 3 - Question base portlet stabilized. Update: 06.02.2012
 - Added functionality to upload and add image and file attachements in Questionbank.
 - Added drag-n-dropfor question and category in TreeView
 - A lot of small improvements regarding to UI
 
### Building

This is Maven2 project, so you can use IDE that you like.
Tested on Netbeans 6.8+ up to current Netbeans 7.1 release.

#### Tests
For running tests on local machine for scorm-player you should change db.properties file inside resources directory and setup you current PostgreSQL instance.