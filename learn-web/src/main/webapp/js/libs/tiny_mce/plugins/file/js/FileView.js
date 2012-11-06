function getFileIcon(src) {
    var supported = ['3gp', '7z', 'ace', 'ai', 'aif', 'aiff', 'amr', 'asf', 'asx', 'bat', 'bin', 'bmp', 'bup', 'cab', 'cbr', 'cda',
        'cdl', 'cdr', 'chm', 'dat', 'divx', 'dll', 'dmg', 'doc', 'dss', 'dvf', 'dwg', 'eml', 'eps', 'exe', 'fla', 'flv', 'gif', 'gz',
        'hqx', 'htm', 'html', 'ifo', 'indd', 'iso', 'jar', 'jpeg', 'jpg', 'lnk', 'log', 'm4a', 'm4b', 'm4p', 'm4v', 'mcd', 'mdb', 'mid',
        'mov', 'mp2', 'mp4', 'mpeg', 'mpg', 'msi', 'mswmm', 'ogg', 'pdf', 'png', 'pps', 'ps', 'psd', 'pst', 'ptb', 'pub', 'qbb', 'qbw',
        'qxd', 'ram', 'rar', 'rm', 'rmvb', 'rtf', 'sea', 'ses', 'sit', 'sitx', 'ss', 'swf', 'tgz', 'thm', 'tif', 'tmp', 'torrent', 'ttf',
        'txt', 'vcd', 'vob', 'wav', 'wma', 'wmv', 'wps', 'xls', 'xpi', 'zip'];
    var extReversed = src.split("").reverse().join("");
    var dot = extReversed.indexOf('.');
    if (dot > 0) {
        var ext = extReversed.substr(0, dot).split("").reverse().join("");
        for (var key in supported) {
            if (supported[key] == ext) return 'img/filetypes/file_extension_' + ext + '.png';
        }
    }
    return 'img/filetypes/page_white.png';
}

DirView = Backbone.View.extend({
    events:{
        "click #fileItem":"goToDir"
    },
    goToDir:function () {
        this.trigger('go-to-dir', this.model.get('name'));
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },
    render:function () {
        var template = Mustache.to_html(jQuery("#fileItemView").html(), {
            "title":this.model.get('name'),
            "iconSrc":'img/folder.png'
        });
        this.$el.empty().append(template);
        return this.$el;
    }
});

FileView = Backbone.View.extend({
    events:{
        "click #fileItem":"addItem"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },
    render:function () {
        var template = Mustache.to_html(jQuery("#fileItemView").html(), {
            "title":this.model.get('name'),
            "iconSrc":getFileIcon(this.model.get('url'))
        });
        this.$el.empty().append(template);
        return this.$el;
    },
    addItem:function () {
        this.trigger('add-file', this.model);
    }
});

FileListView = Backbone.View.extend({
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
        if (this.ignored) return;
        if (!model.get('isDirectory')) {
            var view = new FileView({model:model});
            view.bind('add-file', function (model) {
                this.trigger('add-file', model);
            }, this);
            this.$el.append(view.render());
        } else {
            var dir = new DirView({model:model});
            dir.bind('go-to-dir', function (name) {
                this.trigger('go-to-dir', name);
            }, this);
            this.$el.prepend(dir.render());
        }
    }
});