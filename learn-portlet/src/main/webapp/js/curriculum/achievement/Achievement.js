var Activity = Backbone.Model.extend({
	defaults: function(){
		return {
			activityClassName: "Choose activity",
			numberActivitiesRequired: 1
		};
	}
})

var ActivityView = Backbone.View.extend({	
	events:{
		"click .modifyActivity": "editActivity"
	},
	editActivity: function(){
		console.log("Fix me");
		console.log(this.model.attributes);
	},
	tagName: "li",
	template: function(){return jQuery1816Curriculum("#activity").html()},
	render: function(){			
		this.$el.html(Mustache.render(this.template(), this.model.attributes));
		return this;
	}
})

var Activities = Backbone.Collection.extend({
	model: Activity,
	initialize: function(models, options){
		this.achievement = options.achievement;
	}, 
	url: function(){
		return this.achievement.url() + '/activities';
	}
})

var ActivitiesView = Backbone.View.extend({
	initialize: function(){
		this.collection.on('sync', this.render, this);
		this.collection.on('add', this.render, this);
	},
	render: function(){
		this.$el.html("Prefix collection");					
		this.collection.forEach(this.addOne, this );
	},
	addOne: function(activity){
		var activityView = new ActivityView({model: activity});
		this.$el.append(activityView.render().el);
	}
})

/*var Achievement = Backbone.Model.extend({
    defaults: function(){
		return {
			logo: "/learn-portlet/img/certificate-default.png",
			title: "Please enter the title", 
			description: "Please eneter the description",
			isAdmin: true, //TODO: Remove. This is for demo
			editing: false //TODO: check if needed
		};
	},
    initialize: function(){
    	this.activitiesRequired = new Activities([], {achievement: this})
    },
    addActivity: function(activityName, activityQuantity){
    	activitiesRequired.create({name: activityName, quantity: activityQuantity});
    }
})*/

/*
var AchievementView = Backbone.View.extend({
	events:{
		"click .addActivity": "addActivity",
		"click .buttonRemove": "removeAchievement",
		"click .buttonEdit": "editAchievement",
		"click #addSites": "addActivity"
	},
	addActivity: function(){

	},
	tabArea: jQuery1816Curriculum(function(){return jQuery1816Curriculum("#certificateTabs");}),
	removeAchievement: function(){
            this.model.destroy();
    },
	editAchievement: function(){
		console.log("Fix me");
		console.log(this.model.attributes);
		this.model.set({editing: true})


        //TODO: rewrite this. Bad solution for demo purpose
        var num_tabs = jQuery1816Curriculum("#certificateTabs .ui-tabs-nav li").length + 1;
        jQuery1816Curriculum("#certificateTabs .ui-tabs-nav ").append("<li><a href='#tabMenuAchievement" + this.model.get("id") + "'>" + this.model.get("title") + "</a></li>");

        var t = jQuery1816Curriculum("<div id='tabMenuAchievement" + this.model.get("id") + "'>" + Mustache.render(jQuery1816Curriculum("#certificateItemEditSites").html(),this.model.attributes) + "</div>");

        jQuery1816Curriculum("#certificateTabs").append(t)

        jQuery1816Curriculum("#certificateTabs").tabs("destroy");
        jQuery1816Curriculum("#certificateTabs").tabs();

        jQuery1816Curriculum("#addSites",t)
        jQuery1816Curriculum("#editSitesCertificateTitleInput_"+this.model.get("id"),t).hide()
        jQuery1816Curriculum("#certificateTitleUpdate_"+this.model.get("id"),t).hide()

        var activitiesPlace = jQuery1816Curriculum("#certificateSitesSortable_"+this.model.get("id"),t)

        this.activitiesView = new ActivitiesView({el: activitiesPlace, collection:this.model.activitiesRequired});
        this.model.activitiesRequired.fetch()

        //end of bad solution
	},
	addActivity: function(){
		var activity = new Activity
		this.model.activitiesRequired.create(activity);
	},
	tagName: "li",
	className: "quizList",
	template: function(){return jQuery1816Curriculum("#availableCertificateListItemView").html()}, // achievement
	render: function(){
		this.$el.html(Mustache.render(this.template(), this.model.attributes));
		// this.activitiesView = new ActivitiesView({el: jQuery1816Curriculum(".activities_required",this.$el), collection:this.model.activitiesRequired}); TODO: that was rather pretty. Uncomment/rethink.
		return this;
	}
});*/
