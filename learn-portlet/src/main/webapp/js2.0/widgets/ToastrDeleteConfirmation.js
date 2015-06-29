var ToastrDeleteConfirmation = function(args){
    if(typeof toastr == 'undefined') throw new Error('toastr should be provided');
    if(typeof Backbone == 'undefined') throw new Error('DeleteConfirmationView should be provided');
    if(typeof DeleteConfirmationView == 'undefined') throw new Error('DeleteConfirmationView should be provided');

    if(typeof args.language == 'undefined' || typeof args.title == 'undefined') throw new Error('arguments should contain language and title variables');
    this.title = args.title;

    this.confirmView = new DeleteConfirmationView({language: args.language});

    _(this).extend(Backbone.Events);

    this.listenTo(this.confirmView, 'deleteConfirmed', function(){ this.trigger('deleteConfirmed') });
};

ToastrDeleteConfirmation.prototype.show = function(){
    toastr.info(this.confirmView.render().$el, this.title,
        {
            'positionClass': 'toast-center',
            'timeOut': '0',
            'showDuration': '0',
            'hideDuration': '0',
            'extendedTimeOut': '0'
        });
};