var ParticipantModelService = new Backbone.Service({ url: '/',
    sync: {
        'read': function(model, params){

            return path.api.report + "?action=PARTICIPANTS"+
                "&groupBy=" + params.groupBy;
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
//    parse: function (data) {
//        if (_.isObject(data.records)) {
//            this.trigger('update:statementCollection', {totalStatements: data.total, currentPage: data.page});
//            return data.records;
//        } else {
//            return data;
//        }
//    }
}).extend(ParticipantModelService);