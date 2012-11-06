var filePluginDisplayMode = {
    File:1,
    Image:2
};

PluginView = Backbone.View.extend({
    events:{
        "click #showAsFilesButton":"showFiles",
        "click #showImagesButton":"showImages",
        "click .currentDirLink":"setDir"
    },
    addDirElement:function (url) {
        var link = jQuery('<span>');
        var title = (url === "")?"Root":url;
        link.data('url', url);
        var children = this.$("#filePath").children();
        if (children.length === 0) {
            link.data('path', ['']);
            this.currentDir = "";
        } else {
            var path = jQuery(children[children.length-1]).data('path');
            this.currentDir += "/" + url;
            title = " / " + title;
            var currentPath = path.slice();
            currentPath.push(url);
            link.data('path', currentPath);
        }
        link.append(jQuery('<span>').html(title).addClass('currentDirLink'));
        this.$("#filePath").append(link);
    },
    initialize:function () {
        this.currentDir = "";
        this.render();
        this.addDirElement('');

        this.imageView = new ImageListView({el:this.$("#fileContent"), collection:this.collection});
        this.fileView = new FileListView({el:this.$("#fileContent"), collection:this.collection});
        this.imageView.on('add-image', this.addImage, this);
        this.imageView.on('go-to-dir', this.enterDir, this);
        this.fileView.on('add-file', this.addFile, this);
        this.fileView.on('go-to-dir', this.enterDir, this);
        this.showFiles();
    },
    showFiles:function () {
        this.setDisplayMode(filePluginDisplayMode.File);
        this.$("#showAsFilesButton").addClass("menuBarButtonActive");
        this.$("#showImagesButton").removeClass("menuBarButtonActive");
        this.$("#infoBar").html('Selected file will be added as link to attachment');
    },
    showImages:function () {
        this.setDisplayMode(filePluginDisplayMode.Image);
        this.$("#showImagesButton").addClass("menuBarButtonActive");
        this.$("#showAsFilesButton").removeClass("menuBarButtonActive");
        this.$("#infoBar").html('Selected picture will be added');
    },
    setDir:function (event) {
        var data = jQuery(event.target).parent().data('path');
        this.$("#filePath").empty();
        for (var i =0; i<data.length; i++){
            this.addDirElement(data[i]);
        }
        this.collection.fetch(this.currentDir);
    },
    enterDir:function (dir) {
        this.addDirElement(dir);
        this.collection.fetch(this.currentDir);
    },
    setDisplayMode:function (mode) {
        this.displayMode = mode;
        switch (this.displayMode) {
            case filePluginDisplayMode.File:
                this.imageView.setIgnore(true);
                this.fileView.setIgnore(false);
                this.fileView.render();
                break;
            case filePluginDisplayMode.Image:
                this.imageView.setIgnore(false);
                this.fileView.setIgnore(true);
                this.imageView.render();
                break;
        }
    },
    render:function () {
        this.$el.empty().append(jQuery("#pluginView").html());
    },
    addImage:function (model) {
        var content = Mustache.to_html(jQuery("#tinyMCEImageContent").html(), {imgSrc:model.get('url')});
        tinyMCEPopup.editor.execCommand('mceInsertContent', false, content);
        tinyMCEPopup.close();
    },
    addFile:function (model) {
        var content = Mustache.to_html(jQuery("#tinyMCEFileContent").html(), model.toJSON());
        tinyMCEPopup.editor.execCommand('mceInsertContent', false, content);
        tinyMCEPopup.close();
    },
    getCurrentDirectory:function () {
        return this.currentDir;
    }
});