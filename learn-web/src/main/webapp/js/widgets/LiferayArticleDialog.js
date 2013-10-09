LiferayArticleModel = Backbone.Model.extend({
    defaults:{
        groupID:"",
        articleID:"",
        version:"1",
        availableLocales:{},
        titles:{}
    }
});

LiferayLanguageModel = Backbone.Model.extend({
    defaults:{
        language:"",
        country:""
    },
    select:function () {
        this.trigger('focus', this);
    },
    dropSelection:function () {
        this.trigger('focus-lost', this);
    }
});

LiferayArticleCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': "/services/liferay/article/"
    }
});

LiferayArticleCollection = Backbone.Collection.extend({
    model:LiferayArticleModel
}).extend(LiferayArticleCollectionService);

LiferayLanguageCollection = Backbone.Collection.extend({
    model:LiferayLanguageModel
});

LiferayLanguageView = Backbone.View.extend({
    events:{
        "click #liferayArticleLanguageElement":"select"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
        this.$el.addClass('journalArticle');
        this.model.on('focus', this.doSelect, this);
        this.model.on('focus-lost', this.doLostSelection, this);
    },
    select:function () {
        this.model.select();
    },
    doSelect:function () {
        this.$el.addClass('languageSelected');
    },
    doLostSelection:function () {
        this.$el.removeClass('languageSelected');
    },
    render:function () {
        var country = this.model.get('country');
        if (!_.isEmpty(country)) country = "(" + country + ")";
        var template = Mustache.to_html(jQuery('#liferayArticleLanguageElementView').html(), {country:country, language:this.model.get("language")});
        this.$el.html(template);
        return this.$el;
    }
});

LiferayArticleListElement = Backbone.View.extend({
    events:{
        "click #selectArticleButton":"addThis"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
        var defaultLanguage = this.options.languageID || "en";
        var keysArray = _(this.model.get('availableLocales')).keys()
        var locale = _(keysArray).find(function (locale) {
            return locale.indexOf(defaultLanguage) === 0;
        });
        if (locale) {
            this.currentLocale = locale;
        } else {
            this.currentLocale = _.keys(this.model.get('availableLocales'))[0];
        }
        this.languages = new LiferayLanguageCollection();
        for (var key in this.model.get('availableLocales')) {
            var model = new LiferayLanguageModel(this.model.get('availableLocales')[key]);
            model.id = key;
            this.languages.add(model);
        }
        this.languages.on('focus', function (model) {
            this.languages.each(function (element) {
                if (element.id != model.id) {
                    element.dropSelection();
                }
            }, this);
            this.currentLocale = model.id;
            this.render();
        }, this);
    },
    render:function () {
        var template = Mustache.to_html(jQuery('#liferayArticleElementView').html(), {title:this.model.get('titles')[this.currentLocale]});
        this.$el.html(template);
        this.languages.each(function (lang) {
            var view = new LiferayLanguageView({model:lang});
            this.$("#languageSwitch").append(view.render());
            if (this.currentLocale == lang.id) view.doSelect();
        }, this);
        return this.$el;
    },
    addThis:function () {
        this.model.trigger('select', this.model, this.currentLocale);
    }
});

// Dialog

LiferayArticleDialog = Backbone.View.extend({
    events:{
        'click #refetchResource':'updateResources',
        'keyup #articleFilterInput':'filter'
    },
    callback:function (groupID, articleID, lang) {
    },
    initialize:function () {
        this.collection = new LiferayArticleCollection();
        this.language = this.options.language || {};
        this.defaultLanguage = this.options.languageID || "en";
        this.collection.on('reset', this.render, this);
        this.collection.on('select', this.pickUp, this);
        this.$el.dialog({
            autoOpen:false,
            modal:true,
            width:640,
            height:480
        });
        this.collection.fetch({reset: true});
    },
    filter: function() {
        var query = this.$('#articleFilterInput').val();
        if (!query) {
            this.renderList(this.collection);
            return;
        }

        var filtered = this.collection.filter(function(item){
            for (var language in item.get('titles')) {
                if (item.get('titles')[language].toLowerCase().indexOf(query.toLowerCase()) > -1) return true;
            }
            return false;
        });
        this.renderList(new LiferayArticleCollection(filtered));
    },
    addArticle:function (article) {
        var view = new LiferayArticleListElement({model:article});
        this.$('#articleList').append(view.render());
    },
    render:function () {
        var template = Mustache.to_html(jQuery('#liferayArticleDialogView').html(), this.language);
        this.$el.html(template);
        this.renderList(this.collection);
    },
    renderList: function(collection) {
        this.$('#articleList').empty();
        collection.each(this.addArticle, this);
    },
    choose:function (onChoose) {
        this.callback = onChoose;
        this.render();
        this.$("#externalResourceUrl").val("");
        this.$el.dialog('open');
    },
    pickUp:function(model, language){
        this.callback(model.get('groupID'), model.get('articleID'), language);
        this.$el.dialog('close');
    },
    updateResources:function () {
        this.collection.fetch({reset: true});
    },
    createURL:function (model, language) {
        return location.protocol + "//" + location.host + "/c/journal/view_article_content?groupId=" + model.get('groupID') + "&articleId=" + model.get('articleID') + "&version=" + model.get('version') + "&languageId=" + language;
    }
});
