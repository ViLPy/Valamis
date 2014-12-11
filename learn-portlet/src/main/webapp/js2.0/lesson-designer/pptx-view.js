/*
* DRY Disclaimer
* Almost all stuff is copied from pdf-view.js
* */
var PPTXModel = LessonContentModel.extend({
    defaults: {
        contentType: 'questionPPTX',
        title: '',
        text: ''
    }
});

var PPTXView = Backbone.View.extend({
    template: $('#pptxViewTemplate').html(),
    render: function () {
        this.isNew = this.model.isNew();
        var mustacheAccumulator = {};
        _.extend(mustacheAccumulator, this.model.toJSON(), GLOBAL_translations);

        this.$el.html(Mustache.render(this.template, mustacheAccumulator));

        if (this.isNew) {
            var uploaderPath = path.root + path.api.files + '?action=ADD&contentType=pptx&quizID=' + this.model.get('lessonId');
            if (this.model.get('categoryId')) uploaderPath += '&categoryID=' + this.model.get('categoryId');

            var uploader = new FileUploader({
                endpoint:  uploaderPath
            });
            uploader.on('itemDone', function(response) {
                this.model.set({
                    id: response.id,
                    title: this.$('.title-edit').val(),
                    slides: response.slides
                });
                this.displaySlides();
                this.submit();
                this.trigger('pptx-modal-cancel', this.model);
            }.bind(this));

            this.$('.file-uploader').append(uploader.render().$el);
        }

        return this;
    },
    displaySlides: function(){
        var slides = this.model.get("slides");
        var slideArea = this.$("tbody");
        var template = "<tr><td></td><td>{{title}}</td></tr>";

        _.forEach(_.drop(this.$("tbody tr"),1),function(elem){elem.remove()}); //remove trs except fileUploader
        _.forEach(slides, function(slide){
            slideArea.append(Mustache.render(template, slide));
        })
    },
    submit: function () {
        _.forEach(this.model.get("slides"), function(slide){
            var slideModel = new PPTXModel(slide);
            contentManagerEvent.trigger('question:added', slideModel);
        });
    },
    cancel: function() {
        this.cancelled = true;
        if (this.isNew) {
            this.model.destroy();
        }
    }
});

var PPTXModal = Backbone.Modal.extend({
    template: _.template(Mustache.render($('#modal-template-pptx').html(), _.extend({header: GLOBAL_translations['addPresentationLabel']}, GLOBAL_translations))),
    submitEl: '.modal-submit',
    cancelEl: '.close-button',
    className: 'add-presentation-modal',
    onRender: function () {
        this.view = new PPTXView({
            model: this.model,
            el: this.$('.content')
        });
        this.view.render();
        var that = this;
        this.view.on('pptx-modal-cancel', function() {
            that.trigger('modal:close');
        });
    },
    submit: function () {
        if (this.view)
            this.view.submit();
    },
    cancel: function() {
        if (this.view)
            this.view.cancel();
    }
});