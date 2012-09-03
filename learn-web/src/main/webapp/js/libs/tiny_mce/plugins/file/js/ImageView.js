DirImageView = Backbone.View.extend({
    events:{
        "click #imageDir":"goToDir"
    },
    goToDir:function () {
        this.trigger('go-to-dir', this.model.get('name'));
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },
    render:function () {
        var template = Mustache.to_html(jQuery("#imageDirView").html(), {
            "title":this.model.get('name'),
            "imgSrc":'img/folder.png'
        });
        this.$el.empty().append(template);
        return this.$el;
    }
});

ImageView = Backbone.View.extend({
    events:{
        "click #imageItem":"addItem"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },
    render:function () {
        var template = Mustache.to_html(jQuery("#imageItemView").html(), {
            "imgSrc":this.model.get('thumb'),
            "title":this.model.get('name')
        });
        this.$el.empty().append(template);
        return this.$el;
    },
    addItem:function () {
        this.trigger('add-image', this.model);
    }
});

ImageListView = Backbone.View.extend({
    initialize:function () {
        this.collection.bind('add', this.addItem, this);
        this.collection.bind('reset', this.addAll, this);
        this.ignored = false;
    },
    render:function () {
        this.addAll();
    },
    addAll:function () {
        if (this.ignored) return;
        this.$el.empty();
        this.collection.each(jQuery.proxy(this.addItem, this));
    },
    setIgnore:function (flag) {
        this.ignored = flag;
    },
    addItem:function (model) {
        if (this.ignored) return;

        function isImage(src) {
            var imgFileFormats = ['.jpg', '.jpeg', '.bmp', '.gif', '.png'];
            var length = src.length;
            for (var key in imgFileFormats) {
                if (src.substring(length - imgFileFormats[key].length) == imgFileFormats[key]) return true;
            }
            return false;
        }

        if (!model.get('isDirectory') && isImage(model.get('url'))) {
            var view = new ImageView({model:model});
            view.bind('add-image', function (model) {
                this.trigger('add-image', model);
            }, this);
            this.$el.append(view.render());
        } else if (model.get('isDirectory')) {
            var dir = new DirImageView({model:model});
            dir.bind('go-to-dir', function (name) {
                this.trigger('go-to-dir', name);
            }, this);
            this.$el.prepend(dir.render());
        }
    }
});