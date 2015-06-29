var ParticipantModelService = new Backbone.Service({ url: '/',
    sync: {
        'read':{
            path: path.api.report,
            'data': function (model, params) {
                return {
                    action: 'PARTICIPANTS',
                    groupBy: params.groupBy,
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'get'

        }
    }
});

var ParticipantModel = Backbone.Model.extend({
    defaults: {
        amount: 0,
        groupName: ''
    }
})

var ParticipantModelCollection = Backbone.Collection.extend({
    model: ParticipantModel
}).extend(ParticipantModelService);