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
path.api.lesson = path.api.packages = path.api.prefix + 'packages/';
path.api.files = path.api.prefix + 'files/';
path.api.gradebooks = path.api.prefix + 'gradebooks/';
path.api.courses = path.api.prefix + 'courses/';
path.api.users = path.api.prefix + 'users/';
path.api.administrering = path.api.prefix + 'administering/';
path.api.questions = path.api.prefix + 'questions/';
path.api.print = path.api.prefix + 'print/';

path.api.settingsApi = path.api.prefix + 'settings-api-controller/';
path.api.manifestactivities =  path.api.prefix + 'manifestactivities/';
path.api.report =  path.api.prefix + 'report/';
path.api.liferay = path.api.prefix  + 'liferay/';
path.api.lrs2activity = path.api.prefix  + 'lrs2activity-filter-api-controller/';
path.api.uri = path.api.prefix  + 'uri/';

path.api.tags = path.api.prefix + 'tags/';

path.api.slideSets = path.api.prefix + 'slidesets/';
path.api.slides = path.api.prefix + 'slides/';
path.api.slideEntities = path.api.prefix + 'slideentities/';

path.sequencing = path.api.prefix + 'sequencing/';
path.rte = path.api.prefix + 'rte/';

path.api.tincanApi = path.portlet.prefix + 'xapi/'; // do not remove!
path.api.activities =  path.api.certificates + 'activities/';

path.api.competences = {};
path.api.competences.category = path.api.prefix + 'competencecategory';
path.api.competences.level = path.api.prefix + 'competencelevel';
path.api.competences.skill = path.api.prefix + 'competenceskill';
path.api.competences.competence = path.api.prefix + 'competence';
path.api.competences.experience = path.api.prefix + 'competencecertificate';

path.api.stories = path.api.prefix + 'storyTrees/';

path.api.valamisActivity = path.api.prefix + 'activity/';
path.api.valamisActivityLike = path.api.prefix + 'activity-like/';
path.api.valamisActivityComment = path.api.prefix + 'activity-comment/';

path.api.packageExport = function(id) {

};

path.api.dashboard = path.api.prefix + 'dashboard/';
