var AvailableAchievementCollectionView = Backbone.View.extend({
    events:{
        "click #SCORMButtonAddAchievement":"createAchievement",
        "click #sortList":"sortList",
        "click #filterList":"searchList"
    },
    initialize: function(){
        this.views = [];
        this.sortAZ = true;

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('reset', this.addAll, this);
        this.collection.bind('remove', this.deleteCertificate, this);

        this.render();

        var that = this;
        this.collection.on("achievementCollection:updated", function (details) {
            that.updatePagination(details, that);
        });

        jQuery("#allAchievementPaginator").pagination({
            items:0,
            itemsOnPage:10,
            cssStyle:'light-theme',
            prevText:this.options.language['previous'],
            nextText:this.options.language['next'],
            onPageClick:function (pageNumber, event) {
                that.collection.fetch({reset:true});
            }
        });
    },
    updatePagination:function (details, context) {
        jQuery("#allAchievementPaginator").pagination('updateItems', details.total);

        if (details.total <= 10)
            jQuery("#allAchievementPaginator").hide();
        else
            jQuery("#allAchievementPaginator").show();
    },
    createAchievement:function () {
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        var achievement = new Achievement();
        achievement.save({}, {
            success:jQuery.proxy(function (achievement, response) {
                achievement.set(response);
                this.collection.add(achievement);
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(
                    that.options.language['overlayCreateQuizMessageLabel'],
                    that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(
                    that.options.language['overlayCreateQuizMessageLabel'],
                    that.options.language['overlayFailedMessageLabel']);
            }
        });
    },
    render: function(){
        var language = this.options.language;
        var template = Mustache.to_html(
            jQuery("#availableAchievementListView").html(),
            _.extend({
                    cid: this.cid,
                    isAdmin: this.options.isAdmin
                },
                language));

        this.$el.append(template);

        return this;
    },
    addOne: function(el){
        var view = new AvailableAchievementItemView({
            model: el,
            language:this.options.language,
            isAdmin:this.options.isAdmin
        });

        this.views[el.id] = view;
        var viewDOM = view.render();
        this.$("#achievementList").prepend(viewDOM);

        view.on('achievementSite-open', this.openCertificate, this);
        view.on('achievementUser-open', this.openCertificateUsers, this);
        view.on('achievement-remove', this.removeCertificate, this);
        view.on('membership-changed', this.membershipChanged, this);
    }
});