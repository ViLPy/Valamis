/**
 * Created by Iliya Tryapitsin on 18.08.2014.
 */

var path = {};
path.root = '/';
path.portlet = {
    prefix: 'learn-portlet/'
};

path.api = {
    prefix: 'delegate/'
};
path.api.certificates = path.api.prefix + 'certificates/';
path.api.quiz = path.api.prefix + 'quiz/';
path.api.category = path.api.prefix + 'categories/';
path.api.packages = path.api.prefix + 'packages/';
path.api.files = path.api.prefix + 'files/';
path.api.gradebooks = path.api.prefix + 'gradebooks/';
path.api.courses = path.api.prefix + 'courses/';
path.api.users = path.api.prefix + 'users/';
path.api.roles = path.api.prefix + 'roles/';
path.api.administrering = path.api.prefix + 'administering/';
path.api.questions = path.api.prefix + 'questions/';
path.api.print = path.api.prefix + 'print/';

path.api.settingsApi = path.api.prefix + 'settings-api-controller/';
path.api.activities =  path.api.prefix + 'activities/';
path.api.manifestactivities =  path.api.prefix + 'manifestactivities/';
path.api.report =  path.api.prefix + 'report/';
path.api.liferay = path.api.prefix  + 'liferay/';
path.api.lrs2activity = path.api.prefix  + 'lrs2activity-filter-api-controller/';
path.api.uri = path.api.prefix  + 'uri/';

path.sequencing = path.api.prefix + 'sequencing/';
path.rte = path.api.prefix + 'rte/';
path.api.tincanApi = path.api.prefix + ''; // do not remove!

path.api.packageExport = function(id) {

};
