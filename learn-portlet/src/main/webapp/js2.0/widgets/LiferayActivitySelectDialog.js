LiferayActivityModel = Backbone.Model.extend({
  defaults: {
    activityID: '',
    selected: false
  }
});

LiferayActivityCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  targets: {
    'saveToCertificate': {
      'path': function (model, options) {
        return 'api/certificates/' + jQuery('#selectedCertificateID').val() + '?action=ADDACTIVITIES&' + options.activities;
      },
      method: 'post'
    }
  }
});

LiferayActivityCollection = Backbone.Collection.extend({
  model: LiferayActivityModel
}).extend(LiferayActivityCollectionService);


LiferayActivityListElement = Backbone.View.extend({
  events: {
    'click .toggleButton': 'toggleThis'
  },
  initialize: function (options) {
    this.language = options.language;
    this.$el = jQuery('<tr>');
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayActivityElementView').html(),
      {title: this.language[this.model.get('activityID')] });
    this.$el.html(template);
    return this;
  },
  toggleThis: function () {
    var alreadySelected = this.model.get('selected');
    if (alreadySelected) {
      this.model.set({selected: false });
      this.$('.toggleButton').removeClass('green');
      this.$('.toggleButton').addClass('grey');
    }
    else {
      this.model.set({selected: true });
      this.$('.toggleButton').removeClass('grey');
      this.$('.toggleButton').addClass('green');
    }
  },
  isSelected: function () {
    return this.model.get('selected');
  }
});

LiferayActivityContainer = Backbone.View.extend({
  events: {
    'click .addCourses': 'addActivities'
  },
  initialize: function (options) {
    this.language = options.language;
    this.collection = new LiferayActivityCollection();

    this.collection.add({activityID: 'com.liferay.portlet.blogs.model.BlogsEntry'});
    this.collection.add({activityID: 'com.liferay.portlet.documentlibrary.model.DLFileEntry'});
    this.collection.add({activityID: 'com.liferay.portlet.wiki.model.WikiPage'});
    this.collection.add({activityID: 'com.liferay.portlet.messageboards.model.MBMessage'});
    this.collection.add({activityID: 'com.liferay.calendar.model.CalendarBooking'});
    this.collection.add({activityID: 'com.liferay.portlet.bookmarks.model.BookmarksEntry'});

  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayActivityDialogView').html(), this.language);
    this.$el.html(template);
    this.addAll();
    return this;
  },
  addAll: function () {
    this.collection.each(this.addActivity, this);
  },
  addActivity: function (act) {
    var view = new LiferayActivityListElement({model: act, language: this.language });
    this.$('#activityList').append(view.render().$el);
  },
  addActivities: function () {
    var selectedActivities = this.collection.filter(function (item) {
      return item.get('selected');
    }).map(function (item) {
        return item.get('activityID');
      });

    var activities = jQuery.param({'activityIds': selectedActivities}, true);
    var that = this;

    this.collection.saveToCertificate({}, {activities: activities}).then(function (res) {
      that.trigCloseModal();
      toastr.success(that.language['overlayCompleteMessageLabel']);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },
  trigCloseModal: function () {
    this.trigger('closeModal', this)
  }
});


