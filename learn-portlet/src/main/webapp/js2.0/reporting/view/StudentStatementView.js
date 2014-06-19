var StudentStatementView = Backbone.Marionette.ItemView.extend({
    template: '#latestStudentStatementViewTemplate',
    templateHelpers: {
        tincanActor: function () {
            return new TinCan.Agent(this.actor);
        },
        tincanVerb: function () {
            return new TinCan.Verb(this.verb);
        },
        tincanObject: function () {
            var obj = this.object;
            if (typeof obj.objectType === "undefined") {
                // assumed to be activity
                obj.objectType = "Activity";
            }

            if (obj.objectType === "Activity") {
                obj = new TinCan.Activity(obj);
            }
            else if (obj.objectType === "Agent") {
                obj = new TinCan.Agent(obj);
            }
            else if (obj.objectType === "SubStatement") {
                obj = new TinCan.SubStatement(obj);
            }
            else if (obj.objectType === "StatementRef") {
                obj = new TinCan.StatementRef(obj);
            }
            return obj;
        },
        json: function () {
            return JSON.stringify(this, undefined, 2);
        },
        storedTime: function () {
            return this.stored.replace('Z', '');
        }
    },
    events: {
        'click .statement': 'toggleStatementView'
    },
    toggleStatementView: function () {
        this.$('.tc_rawdata').toggle();
    },
    tagName: "tr",
    className: "statementRow"
});

var StudentStatementsListView = Backbone.Marionette.CollectionView.extend({
    itemView: StudentStatementView,
    tagName: 'tbody',
    className: 'statementList'
});