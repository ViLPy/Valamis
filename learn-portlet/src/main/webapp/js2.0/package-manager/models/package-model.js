PackageService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'update': {
            'path': function (model, param2) {
             // console.log("PackageService path ");
               // console.log(param2);
//                if (model.get("type") == "tincan") {
//                    return "services/tincan-packages/update/" + model.id + "?courseID=" + Utils.getCourseID() + "&scopeType=" + jQuery("#adminScopeSelect").val();
//                } else {
//                    return "services/packages/update/" + model.id + "?courseID=" + Utils.getCourseID() + "&scopeType=" + jQuery("#adminScopeSelect").val();
//                }
            },
            'method': "post"
        },
        'delete': {
            'path': function (model) {
                if (model.get("type") == "tincan") {
                    return "/services/tincan-packages/delete"
                } else {
                    return "/services/packages/delete"
                }
            },
            'method': "post"
        }
    }
});


var PackageManagerPackageModel = Backbone.Model.extend({
  defaults: {
    title: '',
    description: '',
    packageType: '',
    isVisible: true,
    isDefault: false,
    logoURLBig: 'http://placehold.it/260x180',
    logoURLSmall: 'http://placehold.it/130x90'
  },
  initialize: function(param){
     this.on('change', function(){
         // console.log('changed')
     });
  }

}).extend(PackageService);

var packageManagerTargets = {

    'update': {
        'path': function (model) {
           // console.log("update");
//            if (model.get("type") == "tincan") {
//                return "services/tincan-packages/update/" + model.id + "?courseID=" + Utils.getCourseID() + "&scopeType=" + jQuery("#adminScopeSelect").val();
//            } else {
//                return "services/packages/update/" + model.id + "?courseID=" + Utils.getCourseID() + "&scopeType=" + jQuery("#adminScopeSelect").val();
//            }
        },
        'method': "post"
    }
};

PackageCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
    'read': function (params, params2) {
        var filterData = params2.data;
      //  console.log(filterData);
        if(filterData && filterData.scope && filterData.scope == 'site') {
            return 'services/packages/allInSite?courseID=' + Utils.getCourseID();
        }
        else
            return 'services/packages/all';
    },
    'save' : function(){
        //console.log('sync save ');
    }

},
    targets: packageManagerTargets

});



var PackageManagerPackageCollection = Backbone.Collection.extend({
  model: PackageManagerPackageModel
}).extend(PackageCollectionService);