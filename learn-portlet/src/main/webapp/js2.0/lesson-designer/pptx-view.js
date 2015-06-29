/*
* DRY Disclaimer
* Almost all stuff is copied from pdf-view.js
* */
var PPTXModel = LessonContentModel.extend({
    defaults: {
        contentType: 'questionPPTX',
        title: '',
        text: '',
        icon: 'pptx'
    }
});

var PPTXView = Backbone.View.extend({
    render: function () {
        this.isNew = this.model.isNew();

        if (this.isNew) {
            var uploaderPath = path.root + path.api.files +
                '?action=ADD&contentType=pptx&quizID=' + (this.model.get('lessonId') || this.model.get('tempId')) +
                '&courseId=' + Utils.getCourseId();
            if (this.model.get('categoryId')) uploaderPath += '&categoryID=' + this.model.get('categoryId')

            var uploader = new FileUploader({
                endpoint:  uploaderPath,
                message: GLOBAL_translations['uploadPptxMessage']
            });
            uploader.on('itemDone', function(response) {
                this.model.set({
                    id: response.id,
                    title: this.$('.title-edit').val() || response.title || response.name.replace('.pptx', ''),
                    slides: response.slides
                });
                if(this.model.get('lessonId')) {
                    this.displaySlides();
                    this.submit();
                }
                else {
                    this.trigger('pptx:added', this.model);
                }
                this.trigger('pptx-modal-cancel', this.model);
            }.bind(this));

            this.$el.append(uploader.render().$el);
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
            if(this.model.get('lessonId'))
                this.model.destroy();
        }
    }
});

var PPTXModal = Backbone.Modal.extend({
    template: function (data) {
      return Mustache.to_html(jQueryValamis('#valamisEmptyModalTemplate').html(),
        _.extend({header: GLOBAL_translations['AddPPTXFileLabel']}, GLOBAL_translations))
    },
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    className: 'val-modal',
    onRender: function () {
        this.view = new PPTXView({
            model: this.model,
            el: this.$('.js-modal-content')
        });
        this.view.render();
        var that = this;
        this.view.on('pptx-modal-cancel', function() {
            that.trigger('pptx-modal-cancel');
        });
        this.view.on('pptx:added', function(model) {
            that.trigger('pptx:added', model)
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