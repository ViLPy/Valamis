/*
 *  Category View
 */
var CategoryView = Backbone.View.extend({
  events: {
    'click .saveCategory': 'saveModel'
  },

  initialize: function (options) {
    this.language = options.language;
    this.$el = jQuery('<div>');
    this.resetTemporaryModel();
    this.renderView();
  },


  updateModel: function () {
    if (this.$('#SCORMCategoryNameEdit').val().length === 0) {
      toastr.warning(this.language['overlayWarningMessageLabel']);
      return false;
    }
    this.temporaryModel.set({
      title: this.$('#SCORMCategoryNameEdit').val(),
      description: encodeURIComponent(CKEDITOR.instances.SCORMCategoryDescription.getData()),
      newModel: false
    });
    return true;
  },

  saveModel: function () {
    if (!this.updateModel()) return false;
    this.model.save(this.temporaryModel.toJSON(), {
      success: jQuery.proxy(function (question) {
        toastr.success(this.language['overlayCompleteMessageLabel']);
        this.trigger('qb-entity-updated', this);
      }, this),
      error: function () {
        toastr.error(this.language['overlayFailedMessageLabel']);
        this.trigger('qb-entity-updated', this);
      }
    });

  },

  resetTemporaryModel: function () {
    this.temporaryModel = this.model.clone();
  },

  render: function () {
    return this;
  },

  renderView: function () {

    var template = Mustache.to_html(jQuery('#categoryView').html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      description: decodeURIComponent(this.model.get('description'))
    }, this.language)));

    this.$el.empty().append(template);
  },

  renderEdit: function () {
    var template = Mustache.to_html(jQuery('#categoryEditView').html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      description: decodeURIComponent(this.model.get('description'))
    }, this.language)));

    this.$el.empty().append(template);
  },
  renderEditor: function () {
    CKEDITOR.replace('SCORMCategoryDescription');
  }
});
