//SCORM 1.2
var CMIDataModel12 = (function () {
    // Children lists
    var CMICoreChildren = 'student_id,student_name,lesson_location,credit,lesson_status,entry,score,total_time,lesson_mode,exit,session_time';
    var CMIInteractionsChildren = 'id,objectives,time,type,correct_responses,weighting,student_response,result,latency';
    var CMIObjectivesChildren = 'id,score,status';
    var CMIStudentPreferences = 'audio,language,speed,text';
    var CMIStudentDataChildren = 'mastery_score,max_time_allowed,time_limit_action';
    var CMICoreScoreChildren = 'max,raw,min';

    var modelFields = {};

    function CMIDataModel12() {
        modelFields = {
            'cmi.core._children':{
                'defaultValue':CMICoreChildren,
                'mod':'r'
            },
            'cmi.core.student_id':{
                'mod':'r'
            },
            'cmi.core.student_name':{
                'mod':'r'
            },
            'cmi.core.lesson_location':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.core.credit':{
                'defaultValue':'credit',
                'mod':'r'
            },
            'cmi.core.lesson_status':{
                'defaultValue':'not attempted',
                'mod':'rw'
            },
            'cmi.core.entry':{
                'defaultValue':'',
                'mod':'r'
            },
            // Score
            'cmi.core.score._children':{
                'defaultValue':CMICoreScoreChildren,
                'mod':'r'
            },
            'cmi.core.score.raw':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.core.score.min':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.core.score.max':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.core.total_time':{
                'defaultValue':'0000:00:00.00',
                'mod':'r'
            },
            'cmi.core.session_time':{
                'mod':'w'
            },
            'cmi.core.lesson_mode':{
                'defaultValue':'normal',
                'mod':'r'
            },
            // Exit
            'cmi.core.exit':{
                'validator':CMIValidator.Exit,
                'mod':'w'
            },
            // Suspend Data
            'cmi.suspend_data':{
                'defaultValue':'',
                'mod':'rw'
            },
            // Launch Data
            'cmi.launch_data':{
                'defaultValue':'',
                'mod':'r'
            },
            'cmi.comments':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.comments_from_lms':{
                'defaultValue':'',
                'mod':'r'
            },
            // Objectives
            'cmi.objectives._children':{
                'defaultValue':CMIObjectivesChildren,
                'mod':'r'
            },
            'cmi.objectives._count':{
                'defaultValue':'0',
                'mod':'r'
            },
            'cmi.objectives.n.id':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.objectives.n.score._children':{
                'defaultValue':CMICoreScoreChildren,
                'mod':'r'
            },
            'cmi.objectives.n.score.raw':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.objectives.n.score.min':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.objectives.n.score.max':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.objectives.n.status':{
                'mod':'rw'
            },
            'cmi.student_data._children':{
                'defaultValue':CMIStudentDataChildren,
                'mod':'r'
            },
            'cmi.student_data.mastery_score':{
                'mod':'r'
            },
            'cmi.student_data.max_time_allowed':{
                'mod':'r'
            },
            'cmi.student_data.time_limit_action':{
                'mod':'r'
            },
            'cmi.student_preferences._children':{
                'defaultValue':CMIStudentPreferences,
                'mod':'r'
            },
            'cmi.student_preferences.audio':{
                'defaultValue':'0',
                'mod':'rw'
            },
            'cmi.student_preferences.language':{
                'defaultValue':'',
                'mod':'rw'
            },
            'cmi.student_preferences.speed':{
                'defaultValue':'0',
                'mod':'rw'
            },
            'cmi.student_preferences.text':{
                'defaultValue':'0',
                'mod':'rw'
            },
            'cmi.interactions._children':{
                'defaultValue':CMIInteractionsChildren,
                'mod':'r'
            },
            'cmi.interactions._count':{
                'defaultValue':'0',
                'mod':'r'
            },
            'cmi.interactions.n.id':{
                'mod':'w'
            },
            'cmi.interactions.n.objectives._count':{
                'mod':'r'
            },
            'cmi.interactions.n.objectives.n.id':{
                'mod':'w'
            },
            'cmi.interactions.n.time':{
                'mod':'w'
            },
            'cmi.interactions.n.type':{
                'mod':'w'
            },
            'cmi.interactions.n.correct_responses._count':{
                'mod':'r'
            },
            'cmi.interactions.n.correct_responses.n.pattern':{
                'mod':'w'
            },
            'cmi.interactions.n.weighting':{
                'mod':'w'
            },
            'cmi.interactions.n.student_response':{
                'mod':'w'
            },
            'cmi.interactions.n.result':{
                'mod':'w'
            },
            'cmi.interactions.n.latency':{
                'mod':'w'
            }
        };
    }

    CMIDataModel12.prototype.getField = function (key) {
        return modelFields[key];
    };

    CMIDataModel12.prototype.setFieldValue = function (key, value) {
        modelFields[key].value = value;
    };

    CMIDataModel12.prototype.initValues = function (data) {
        for (var key in data) {
            if (modelFields[key]) {
                modelFields[key].value = data[key];
            }
        }
    };

    CMIDataModel12.prototype.getAllFieldsData = function () {
        var data = [];
        for (var key in modelFields) {
            if (modelFields[key].value) {
                data[key] = modelFields[key].value;
            }
        }
        return data;
    };

    return CMIDataModel12;
})();