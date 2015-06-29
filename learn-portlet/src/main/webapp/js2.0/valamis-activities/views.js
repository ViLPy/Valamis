valamisActivities.module('Views', function (Views, valamisActivities, Backbone, Marionette, $, _) {

  var OBJECT_TYPE = {
    LESSON: 'Lesson',
    CERTIFICATE: 'Certificate',
    COURSE: 'Course',
    USER_STATUS: 'UserStatus'
  };

  Views.UserStatusView = Marionette.ItemView.extend({
    template: '#userStatusViewTemplate',
    className: 'activity-item user-status',
    events: {
      'click .js-post-status': 'postStatus'
    },
    postStatus: function() {
      var that = this;
      this.model.postStatus({},{content: this.$('.js-user-status').val()}).then(function (result) {
        that.triggerMethod('activities:addactivity', result);
        that.render();
      }, function (err, res) {
        toastr.error(Valamis.language['failedLabel']);
      });
    }
  });

  Views.UsersLikedItemView = Marionette.ItemView.extend({
    template: '#valamisActivityUsersLikedItemViewTemplate',
    tagName: 'tr'
  });

  Views.UsersLikedCollectionView = Marionette.CollectionView.extend({
    childView: Views.UsersLikedItemView,
    tagName: 'table',
    className: 'val-table medium list'
  });

  Views.ValamisCommentItemView = Marionette.ItemView.extend({
    template: '#valamisCommentItemViewTemplate',
    className: 'comment-item'
  });

  Views.ValamisCommentCollectionView = Marionette.CollectionView.extend({
    childView: Views.ValamisCommentItemView,
    className: 'comments-block'
  });

  Views.ValamisActivityItemView = Marionette.LayoutView.extend({
    template: '#valamisActivityItemViewTemplate',
    className: 'activity-item',
    regions: {
      'commentsRegion' : '.js-activity-comments'
    },
    events: {
      'focus .js-my-comment-field': function() {this.$('.js-post-my-comment').show();},
      'blur .js-my-comment-field': function() {this.$('.js-post-my-comment').hide();},
      'click .js-action-like': 'toggleLike',
      'click .js-action-comment': function() {this.$('.js-activity-comments').toggle();},
      'click .js-action-share': 'shareActivity',
      'click .js-show-liked-users': 'showUsersModal'
    },
    initialize: function(options) {
      this.currentUserModel = options.currentUserModel;
    },
    templateHelpers: function() {
      var commentAmount = this.model.get('comments').length;
      var commentAmountLabel = (commentAmount > 1) ? Valamis.language['commentsLabel'] : Valamis.language['commentLabel'];

      var folderId = '';
      switch(this.model.get('obj')['tpe']) {
        case OBJECT_TYPE.LESSON:
          folderId = 'package_logo_' + this.model.get('obj')['id'];
          break;
        case OBJECT_TYPE.CERTIFICATE:
          folderId = this.model.get('obj')['id'];
          break;
      }

      var activityStmnt = (this.model.get('obj')['tpe'] !== OBJECT_TYPE.USER_STATUS) ?
        (Valamis.language[this.model.get('verb') + 'VerbLabel']) + ' ' + Valamis.language[this.model.get('obj')['tpe'].toLowerCase() + 'ActivityLabel'] : '';

      var userLikedList = this.model.get('userLiked');
      var likesAmount = userLikedList.length;
      var iLikeThis = this.model.get('currentUserLike');

      var actLike = {};
      actLike.verb = (likesAmount === 1 && !iLikeThis) ? Valamis.language['likesThisLabel'] : Valamis.language['likeThisLabel'];
      actLike.isLink = false;
      var likeItems = ['',''];

      if (likesAmount > 2) {
        actLike.isLink = true;
        if (iLikeThis) {
          likeItems[1] = Valamis.language['youLabel'];
          likeItems[0] = (likesAmount - 1) + ' ' + Valamis.language['peopleLabel'];
        } else {
          likeItems[0] = likesAmount + ' ' + Valamis.language['peopleLabel'];
        }
      }
      else {
        likeItems = userLikedList.filter(function(item) {
          return item['id'] !== Valamis.currentUserId
        }).map(function(item) {
          return item['name'];
        });
        if (iLikeThis)
          likeItems.push(Valamis.language['youLabel']);
      }

      actLike.firstItem = likeItems[1];
      actLike.secondItem = likeItems[0];

      var objectType = this.model.get('obj')['tpe'];

      return {
        currentUser: this.options.currentUserModel.toJSON(),
        activityStmnt: activityStmnt,
        objectClassName: (objectType === OBJECT_TYPE.CERTIFICATE) ? 'certificate' : '',
        folderId: folderId,
        withImage: objectType !== OBJECT_TYPE.COURSE && objectType !== OBJECT_TYPE.USER_STATUS,
        commentText: (commentAmount || '') + ' ' + commentAmountLabel,
        canShare: objectType === OBJECT_TYPE.LESSON,
        actLike: actLike
      }
    },
    onRender: function() {
      this.commentsCollection = new valamisActivities.Entities.ActivitiesCollection(this.model.get('comments'));
      var commentsView = new Views.ValamisCommentCollectionView({collection: this.commentsCollection});
      this.commentsRegion.show(commentsView);

      var that = this;
      this.$('.js-post-my-comment').on('mousedown', function(event) {
        event.preventDefault();
      }).on('click', function() {
        that.model.commentActivity({}, {content: that.$('.js-my-comment-field').val()}).then(function (result) {
          (that.model.get('comments')).push(result);
          that.render();
        }, function (err, res) {
          toastr.error(Valamis.language['failedLabel']);
        });
      });
    },
    toggleLike: function() {
      var iLikeThis = this.model.get('currentUserLike');
      var userLikedList = this.model.get('userLiked');
      var that = this;
      if (iLikeThis)
        this.model.unlikeActivity().then(function (result) {
          that.model.set('userLiked', userLikedList.filter(function(i) {return i['id'] !== Valamis.currentUserId}));
          that.model.set('currentUserLike', false);
          that.render();
        }, function (err, res) {
          toastr.error(Valamis.language['failedLabel']);
        });
      else
        this.model.likeActivity().then(function (result) {
          userLikedList.push(that.currentUserModel.toJSON());
          that.model.set('userLiked', userLikedList);
          that.model.set('currentUserLike', true);
          that.render();
        }, function (err, res) {
          toastr.error(Valamis.language['failedLabel']);
        });
    },
    showUsersModal: function() {
      var usersLikedView = new Views.UsersLikedCollectionView({
        collection: new valamisActivities.Entities.LiferayUserCollection(this.model.get('userLiked'))
      });

      var usersLikedModalView = new valamisApp.Views.ModalView({
        contentView: usersLikedView,
        header: Valamis.language['usersLikedLabel'],
        customClassName: 'valamis-activities-users-liked'
      });

      valamisApp.execute('modal:show', usersLikedModalView);
    },
    shareActivity: function() {
      var that = this;
      this.model.shareActivity().then(function (result) {
        that.triggerMethod('activities:addactivity', result);
      }, function (err, res) {
        toastr.error(Valamis.language['failedLabel']);
      });
    }
  });

  Views.ValamisActivitiesCollectionView = Marionette.CompositeView.extend({
    template: '#valamisActivityCollectionViewTemplate',
    childView: Views.ValamisActivityItemView,
    childViewContainer: '.js-list-view',
    childViewOptions: function() {
      return {
        currentUserModel: this.options.currentUserModel
      }
    },
    onRender: function() {
      if(this.collection.length === 0)
        this.$('.js-no-activities').removeClass('hidden');
    }
  });

  Views.AppLayoutView = Marionette.LayoutView.extend({
    template: '#activitiesLayoutTemplate',
    className: 'val-activities',
    regions: {
      'statusRegion' : '#statusRegion',
      'activitiesRegion' : '#activitiesRegion'
    },
    childEvents: {
      'activities:addactivity':function(childView, activity){
        delete activity['id'];
        this.activitiesCollection.unshift(activity);
      }
    },
    initialize: function(options) {
      this.currentUserModel = options.currentUserModel;
    },
    onRender: function () {
      var statusView = new Views.UserStatusView({model: this.currentUserModel});
      this.statusRegion.show(statusView);

      this.activitiesCollection = new valamisActivities.Entities.ActivitiesCollection();
      this.activitiesCollection.on('sync', function() {
        var valamisActivitiesView = new Views.ValamisActivitiesCollectionView({
          collection: this.activitiesCollection,
          currentUserModel: this.currentUserModel
        });
        this.activitiesRegion.show(valamisActivitiesView);
      }, this);
      this.activitiesCollection.fetch();
    }
  });

});