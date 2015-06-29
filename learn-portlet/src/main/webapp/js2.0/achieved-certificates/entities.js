achievedCertificates.module('Entities', function(Entities, achievedCertificates, Backbone, Marionette, $, _) {

  var CertificateCollectionService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': function (model, options) {
          return path.api.certificates;
        },
        'data': function (collection) {
          var params = {
            courseId: Utils.getCourseId(),
            action: 'GETCERTIFICATESTATES',
            statuses: 'success'
          };
          return params;
        },
        'method': 'get'
      }
    }
  });

  Entities.CertificateCollection = Backbone.Collection.extend({
    model: Backbone.Model.extend({})
  }).extend(CertificateCollectionService);

});