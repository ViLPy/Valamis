var jQuery1816AchievementUser = jQuery.noConflict();

var count = 10
/* Prerequisites:
    subscribedAchievementList
    localizedResources
    userId
*/


/*Global Function */
var addLanguageSupport = function(obj){
            var newObj = {}
            for(var attrname in obj) { newObj[attrname] = obj[attrname]; }
            for(var attrname in localizedResources) { newObj[attrname] = localizedResources[attrname]; }
            return newObj
},


AchievementService = new Backbone.Service({
    url: "/learn-portlet",
    sync: {
        read: {
            'path': function (model) {
                return "/services/achievement/?action=all&page={0}&sortAZ={1}&filter={2}&count={3}"
                .replace('{0}', model.page)
                .replace('{1}', model.sortAZ)
                .replace('{2}', model.filterString)
                .replace('{3}', count);  //TODO: change passing arguments?
            },
            method: "get"
        }
    },
    targets:{
        joinAchievement: {
            'path': function (model) {
                return "/services/achievementUser/?userId={0}&achievementId={1}"
                .replace('{0}', userId)
                .replace('{1}', model.id); //TODO: change passing arguments?
            },
            method: "post"
        },
        leaveAchievement: {
            'path': function (model) {
                return "/services/achievementUser/delete/?userId={0}&achievementId={1}"
                .replace('{0}', userId)
                .replace('{1}', model.id); //TODO: change passing arguments?
            },
            method: "post"
        }
    }
})

var Achievement = Backbone.Model.extend({}).extend(AchievementService);

var AvailableAchievementList = Backbone.Collection.extend({
    comparator: function(first, second){
        var order
        if (this.sortAZ == true) order = 1;
        else order = -1;

        if( first.get("title").toLowerCase() < second.get("title").toLowerCase()) return -order;
        if( first.get("title").toLowerCase() > second.get("title").toLowerCase()) return order;
        return 0;
    },
    model: Achievement,
    initialize: function(){
        this.filterString = ""
        this.sortAZ = true;
        this.page = 1; //Start with the first page
        this.on('sync', this.onFetch,this);
        this.fetch();
    },
    nextPage: function(){
        if(this.page < this.maximalPage){
            this.page += 1;
            jQuery1816AchievementUser(".buttonPageNum",this.$el).html(this.page)
            this.fetch();
        }
    },
    previousPage: function(){
        if(this.page > 1){
            this.page -= 1;
            jQuery1816AchievementUser(".buttonPageNum",this.$el).html(this.page)
            this.fetch();
        }
    },
    invertOrder: function(){
        this.sortAZ = !this.sortAZ
        this.fetch()
    },
    filter: function(filterString){
        this.filterString = filterString
        this.fetch()
    },
    onFetch: function(){
        this.sort()
    },
    parse: function(response){
        this.page = response.page;
        this.maximalPage = Math.ceil(response.total/count);
        return response.records;
    }
}).extend(AchievementService);

var AvailableAchievementView = Backbone.View.extend({
    events: {
        "click .joinAchievement": "joinAchievement",
        "click .leaveAchievement": "leaveAchievement"
    },
    joinAchievement: function(){
        this.model.joinAchievement().then(_.bind(function(){this.listView.participationStatusChanged();},this));
        this.model.set({usersCount: parseInt(this.model.get("usersCount")) + 1})
        this.userSubscribed();
    },
    leaveAchievement: function(){
        this.model.leaveAchievement().then(_.bind(function(){this.listView.participationStatusChanged();},this));
        this.model.set({usersCount: parseInt(this.model.get("usersCount")) - 1})
        this.userUnSubscribed();
    },
    userSubscribed: function(){
        jQuery1816AchievementUser(".joinCertificate",this.$el).hide();
        jQuery1816AchievementUser(".leaveCertificate",this.$el).show();
    },
    userUnSubscribed: function(){
        jQuery1816AchievementUser(".joinCertificate",this.$el).show();
        jQuery1816AchievementUser(".leaveCertificate",this.$el).hide();
    },
    initialize: function(options){
        this.model.on("change", this.render, this)
        this.listView = options.listView;

        this.model.set({usersCount: _.size(this.model.get("users"))})
        this.model.set({numberActivities: _.size(this.model.get("activities"))})

        this.render();

        userIds = _.map(this.model.get("users"),function(user){return user.id})
        if(_.contains(userIds, userId)){
            this.userSubscribed();
        } else{
            this.userUnSubscribed();
        }
    },
    template: jQuery1816AchievementUser("#availableAchievementListItemView").html(),
    render: function(){
        this.$el.html(Mustache.render(this.template, addLanguageSupport(this.model.attributes)));
    }
})


var AvailableAchievementListView = Backbone.View.extend({
    events: {
        "click .sortAchievement": "invertOrder",
        "click .filterButton": "filter",
        "click .prevPageButton": "previousPage",
        "click .nextPageButton": "nextPage"
    },
    previousPage: function(){
        this.collection.previousPage();
    },
    nextPage: function(){
        this.collection.nextPage();
    },
    filter: function(){
        this.collection.filter(jQuery1816AchievementUser(".achievementSearch",this.$el).val())
    },
    invertOrder: function(){
        this.collection.invertOrder()
    },
    template: jQuery1816AchievementUser("#availableAchievementListView").html(),
    initialize: function(options){
        this.$el.html(Mustache.render(this.template, localizedResources))
        this.achievementList = jQuery1816AchievementUser(".quizList", this.$el)
        this.collection.on("sync", this.render, this)
        this.chosenAchievementList = options.chosenAchievementList
    },
    render: function(){
        this.achievementList.html("")
        this.collection.each(this.addOne, this)
    },
    addOne: function(achievement){
        this.achievementList.append(new AvailableAchievementView({model: achievement, listView: this}).el)
    },
    participationStatusChanged: function(){
            this.chosenAchievementList.fetch()
    }
})

/*  Chosen Achievement(My achievement tab) TODO: Separate in files  */

ChosenAchievementService = new Backbone.Service({
    url: "/learn-portlet",
    sync: {
        read: {
            'path': function (model) {
                return "/services/achievement/?action=user&userId={0}"
                .replace('{0}', userId);
            },
            method: "get"
        }
    }
})

var ChosenAchievement = Backbone.Model.extend({
    addActivityList: function(options){
        this.ActivityList = options.ActivityList
    }
}).extend(ChosenAchievementService);

var ChosenAchievementList = Backbone.Collection.extend({
    model: ChosenAchievement,
	initialize: function(properties){
		this.on('sync', this.onFetch,this);
		// If fetch from available&ChosenAchievements occurs at the same time, as allAchievements => ServiceBuilder collision on delete user
        setTimeout(
            _.bind(
                function(){this.fetch();},
                this),
            100)
	},
	onFetch: function(){
	    this.each(function(achievement){
	        achievement.addActivityList({ActivityList: new ActivityList({achievement: achievement})})
	    })
	},
	parse: function(response){
	    return response.data;
	}
}).extend(ChosenAchievementService);


var ChosenAchievementView = Backbone.View.extend({
    events:{
        "click .expandAchievement": "expandAchievement",
        "click .collapseAchievement": "collapseAchievement"
    },
    addLanguageSupport: function(obj){
            var newObj = {}
            for(var attrname in obj) { newObj[attrname] = obj[attrname]; }
            for(var attrname in localizedResources) { newObj[attrname] = localizedResources[attrname]; }
            return newObj
    },
	template: jQuery1816AchievementUser("#myAchievementListItemView").html(),
	initialize: function(){
	    this.render()
        var activityListContainer = jQuery1816AchievementUser(".MyAchievementsGrid",this.$el)
        new ActivityListView({el: activityListContainer, collection: this.model.ActivityList})
        this.collapseAchievement()
	},
	collapseAchievement: function(){
        jQuery1816AchievementUser(".expandAchievement",this.$el).show()
	    jQuery1816AchievementUser(".collapseAchievement",this.$el).hide()
        jQuery1816AchievementUser(".achievementItemBody",this.$el).hide()
	},
    expandAchievement: function(){
        jQuery1816AchievementUser(".expandAchievement",this.$el).hide()
        jQuery1816AchievementUser(".collapseAchievement",this.$el).show()
        jQuery1816AchievementUser(".achievementItemBody",this.$el).show()
    },
	render: function(){
		this.$el.html(Mustache.render(this.template, addLanguageSupport(this.model.attributes)));
	}
})

var ChosenAchievementListView = Backbone.View.extend({
	template: jQuery1816AchievementUser("#availableAchievementListView").html(),
    initialize: function(){
        this.collection.on("sync", this.render, this)
    },
    render: function(){
        this.$el.html("")
        this.collection.each(this.addOne, this)
    },
    addOne: function(achievement){
        this.$el.append(new ChosenAchievementView({model: achievement}).el)
    }
})



/*
    Activities TODO: separate to another file
*/

var ActivityService = new Backbone.Service({
    url: "/learn-portlet/services/requiredActivity/",
    sync: {
        read: {
            'path': function(model) {
                return "achievement/" + model.achievement.id;
            },
            method: "get"
        }
    },
    targets:{}
})

var Activity = Backbone.Model.extend({}).extend(ActivityService );;

var ActivityList = Backbone.Collection.extend({
    model: Activity,
    initialize: function(properties){
        this.achievement = properties.achievement;
        this.fetch();
    }
}).extend(ActivityService);

var ActivityView = Backbone.View.extend({
    tagName: "tr",
    template: jQuery1816AchievementUser("#myAchievementActivityRow").html(),
    initialize: function(){
        this.render()
    },
    render: function(){
        this.$el.html(Mustache.render(this.template, addLanguageSupport(this.model.attributes)))
    }
})

var ActivityListView = Backbone.View.extend({
    initialize: function(options){
        this.collection.on("sync", this.render, this)
    },
    render: function(){
        this.$el.html("")
        this.collection.each(this.addActivity,this)
    },
    addActivity: function(activity){
        this.$el.append(new ActivityView({model: activity}).el)
    }
})

// open/close  #myCertificateListItemView
// join/leave  #availableCertificateListItemView