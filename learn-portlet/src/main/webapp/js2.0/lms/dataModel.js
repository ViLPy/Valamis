var CMIDataModel = (function () {
    // Children lists
    var CMIChildren = '_version,comments_from_learner,comments_from_lms,completion_status,credit,entry,exit,interactions,launch_data,learner_id,learner_name,learner_preference,location,max_time_allowed,mode,objectives,progress_measure,scaled_passing_score,score,session_time,success_status,suspend_data,time_limit_action,total_time';
    var CMICommentsChildren = 'comment,location,timestamp';
    var CMIIteractionsChildren = 'id,type,objectives,timestamp,correct_responses,weighting,learner_response,result,latency,description';
    var CMIStudentPreferenceChildren = 'audio_level,audio_captioning,delivery_speed,language';
    var CMIObjectivesChildren = 'progress_measure,completion_status,success_status,description,score,id';
    var ADLDataChildren = 'id,store';
    var CMIScoreChildren = 'max,raw,scaled,min';
    // Data ranges
    var CMIAudioRange = '0|*';
    var CMISpeedRange = '0|*';
    var CMITextRange = '-1|1';
    var CMIScaledRange = '-1|1';
    var CMIProgressRange = '0|1';

    var modelFields = {};

    function CMIDataModel() {
        modelFields = {
            'cmi._children':{
                'defaultValue':CMIChildren,
                'mod':'r'
            },
            'cmi._version':{
                'defaultValue':'1.0',
                'mod':'r'
            },
            // Comments From Learner
            'cmi.comments_from_learner._children':{
                'defaultValue':CMICommentsChildren,
                'mod':'r'
            },
            'cmi.comments_from_learner._count':{
                'defaultValue':'0',
                'mod':'r'
            },
            'cmi.comments_from_learner.n.comment':{
                'validator':CMIValidator.LocalizedString4000,
                'mod':'rw'
            },
            'cmi.comments_from_learner.n.location':{
                'validator':CMIValidator.String250,
                'mod':'rw'
            },
            'cmi.comments_from_learner.n.timestamp':{
                'validator':CMIValidator.Time,
                'mod':'rw'
            },
            // Comments From LMS
            'cmi.comments_from_lms._children':{
                'defaultValue':CMICommentsChildren,
                'mod':'r'
            },
            'cmi.comments_from_lms._count':{
                'defaultValue':'0',
                'mod':'r'
            },
            'cmi.comments_from_lms.n.comment':{
                'mod':'r'
            },
            'cmi.comments_from_lms.n.location':{
                'mod':'r'
            },
            'cmi.comments_from_lms.n.timestamp':{
                'mod':'r'
            },
            // Completion Status
            'cmi.completion_status':{
                'defaultValue':'unknown',
                'validator':CMIValidator.State,
                'mod':'rw'
            },
            // Completion Threshold
            'cmi.completion_threshold':{
                'mod':'r'
            },
            // Credit
            'cmi.credit':{
                'defaultValue':'credit',
                'mod':'r'
            },
            // Entry
            'cmi.entry':{
                'mod':'r'
            },
            // Exit
            'cmi.exit':{
                'validator':CMIValidator.Exit,
                'mod':'w'
            },
            // Interactions
            'cmi.interactions._children':{
                'defaultValue':CMIIteractionsChildren,
                'mod':'r'
            },
            'cmi.interactions._count':{
                'defaultValue':'0',
                'mod':'r'
            },
            'cmi.interactions.n.id':{
                'validator':CMIValidator.LongIdentifier,
                'mod':'rw'
            },
            'cmi.interactions.n.type':{
                'validator':CMIValidator.Type,
                'mod':'rw'
            },
            'cmi.interactions.n.objectives._count':{
                'defaultValue':'0',
                'mod':'r'
            },
            'cmi.interactions.n.objectives.n.id':{
                'validator':CMIValidator.LongIdentifier,
                'mod':'rw'
            },
            'cmi.interactions.n.timestamp':{
                'validator':CMIValidator.Time,
                'mod':'rw'
            },
            'cmi.interactions.n.correct_responses._count':{
                'defaultValue':'0',
                'mod':'r'
            },
            'cmi.interactions.n.correct_responses.n.pattern':{
                'validator':'CMIFeedback',
                'mod':'rw'
            },
            'cmi.interactions.n.weighting':{
                'validator':CMIValidator.Decimal,
                'mod':'rw'
            },
            'cmi.interactions.n.learner_response':{
                'validator':'CMIFeedback',
                'mod':'rw'
            },
            'cmi.interactions.n.result':{
                'validator':CMIValidator.Result,
                'mod':'rw'
            },
            'cmi.interactions.n.latency':{
                'validator':CMIValidator.Timespan,
                'mod':'rw'
            },
            'cmi.interactions.n.description':{
                'validator':CMIValidator.LocalizedString250,
                'mod':'rw'
            },
            // Launch Data
            'cmi.launch_data':{
                'mod':'r'
            },
            // Learner Id
            'cmi.learner_id':{
                'mod':'r'
            },
            // Learner Name
            'cmi.learner_name':{
                'mod':'r'
            },
            // Learner Preference
            'cmi.learner_preference._children':{
                'defaultValue':CMIStudentPreferenceChildren,
                'mod':'r'
            },
            'cmi.learner_preference.audio_level':{
                'defaultValue':'1',
                'validator':CMIValidator.Decimal,
                'range':CMIAudioRange,
                'mod':'rw'
            },
            'cmi.learner_preference.language':{
                'validator':CMIValidator.Lang,
                'mod':'rw'
            },
            'cmi.learner_preference.delivery_speed':{
                'validator':CMIValidator.Decimal,
                'range':CMISpeedRange,
                'mod':'rw'
            },
            'cmi.learner_preference.audio_captioning':{
                'validator':CMIValidator.Integer,
                'range':CMITextRange,
                'mod':'rw'
            },
            // Location
            'cmi.location':{
                'validator':CMIValidator.String1000,
                'mod':'rw'
            },
            // Maximum Time Allowed
            'cmi.max_time_allowed':{
                'mod':'r'
            },
            // Mode
            'cmi.mode':{
                'defaultValue':'normal,',
                'mod':'r'
            },
            // Objectives
            'cmi.objectives._children':{
                'defaultValue':CMIObjectivesChildren,
                'mod':'r'
            },
            'cmi.objectives._count':{
                'mod':'r',
                'defaultValue':'0'
            },
            'cmi.objectives.n.id':{
                'validator':CMIValidator.LongIdentifier,
                'mod':'rw'
            },
            'cmi.objectives.n.score._children':{
                'defaultValue':CMIScoreChildren,
                'mod':'r'
            },
            'cmi.objectives.n.score.scaled':{
                'validator':CMIValidator.Decimal,
                'range':CMIScaledRange,
                'mod':'rw'
            },
            'cmi.objectives.n.score.raw':{
                'validator':CMIValidator.Decimal,
                'mod':'rw'
            },
            'cmi.objectives.n.score.min':{
                'validator':CMIValidator.Decimal,
                'mod':'rw'
            },
            'cmi.objectives.n.score.max':{
                'validator':CMIValidator.Decimal,
                'mod':'rw'
            },
            'cmi.objectives.n.success_status':{
                'defaultValue':'unknown',
                'validator':CMIValidator.SStatus,
                'mod':'rw'
            },
            'cmi.objectives.n.completion_status':{
                'defaultValue':'unknown',
                'validator':CMIValidator.CStatus,
                'mod':'rw'
            },
            'cmi.objectives.n.progress_measure':{
                'validator':CMIValidator.Decimal,
                'range':CMIProgressRange,
                'mod':'rw'
            },
            'cmi.objectives.n.description':{
                'validator':CMIValidator.LocalizedString250,
                'mod':'rw'
            },
            // Progress Measure
            'cmi.progress_measure':{
                'validator':CMIValidator.Decimal,
                'range':CMIProgressRange,
                'mod':'rw'
            },
            // Scaled Passing Score
            'cmi.scaled_passing_score':{
                'range':CMIProgressRange,
                'mod':'r'
            },
            // Score
            'cmi.score._children':{
                'defaultValue':CMIScoreChildren,
                'mod':'r'
            },
            'cmi.score.scaled':{
                'validator':CMIValidator.Decimal,
                'range':CMIScaledRange,
                'mod':'rw'
            },
            'cmi.score.raw':{
                'validator':CMIValidator.Decimal,
                'mod':'rw'
            },
            'cmi.score.min':{
                'validator':CMIValidator.Decimal,
                'mod':'rw'
            },
            'cmi.score.max':{
                'validator':CMIValidator.Decimal,
                'mod':'rw'
            },
            // Session Time
            'cmi.session_time':{
                'validator':CMIValidator.Timespan,
                'mod':'w'
            },
            // Success Status
            'cmi.success_status':{
                'defaultValue':'unknown',
                'validator':CMIValidator.SStatus,
                'mod':'rw'
            },
            // Suspend Data
            'cmi.suspend_data':{
                'validator':CMIValidator.String64000,
                'mod':'rw'
            },
            // Time Limit Action
            'cmi.time_limit_action':{
                'mod':'r'
            },
            // Total Time
            'cmi.total_time':{
                'mod':'r'
            },
            // Score
            'adl.data._children':{
                'defaultValue':ADLDataChildren,
                'mod':'r'
            },
            'adl.data._count':{
                'mod':'r',
                'defaultValue':'0'
            },
            'adl.data.n.id':{
                'mod':'r'
            },
            'adl.data.n.store':{
                'defaultValue':ADLDataChildren,
                'mod':'rw'
            }
        };
    }

    CMIDataModel.prototype.getField = function (key) {
        if (modelFields[key] !== null && modelFields[key] !== undefined)
            modelFields[key].value = SCORMtoTinCanHandler("GetValue",key,modelFields[key].value);
        return modelFields[key];
    };

    CMIDataModel.prototype.setFieldValue = function (key, value) {
        modelFields[key].value = value;
        SCORMtoTinCanHandler("SetValue",key,value);
    };

    CMIDataModel.prototype.initValues = function (data) {
        for (var key in data) {
            if (modelFields[key]) {
                modelFields[key].value = data[key];
                SCORMtoTinCanHandler("SetValue",key,data[key]);
            }
        }
    };

    CMIDataModel.prototype.getAllFieldsData = function () {
        var data = [];
        for (var key in modelFields) {
            if (modelFields[key].value) {
                //data[key] = modelFields[key].value;
                data[key] = SCORMtoTinCanHandler("GetValue",key, modelFields[key].value);
            }
        }
        return data;
    };

    return CMIDataModel;
})();