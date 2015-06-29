CertificateService = new Backbone.Service({ url: '/',
  sync: {
    'create': {
      'path': path.api.certificates,
      'data':  {
            action: 'ADD',
            courseId:  Utils.getCourseId(),
            companyID: jQuery('#curriculumCompanyID').val()
      },
      'method': 'post'
    },
    'update': {
      'path':function (model) {
        return path.api.certificates + model.id
      },
      'data': function (model) {
        parameters = {
            action: 'UPDATE',
            courseId:  Utils.getCourseId()
        }
        _.extend(parameters, model.toJSON())
        return parameters
      },
      'method': 'post'
    },
    'read': {
      'path': function (model) {
        return path.api.certificates + model.id;
      },
      'data': function (model) {
        return {
          action: 'GETBYID',
          courseId: Utils.getCourseId()
        }
      },
      'method': 'get'
    },
    'delete': {
      'path': function (model) {
        return path.api.certificates + model.id
      },
      'data': function (model) {
        return {
            action:'DELETE',
            courseId: Utils.getCourseId()
        }
      },
          'method': 'post'
    }
  },

  targets: {
    'clone': {
      'path': function (model) {
        return path.api.certificates + model.id
      },
      'data': function (model) {
        return {
            action: 'CLONE',
            courseId: Utils.getCourseId()

        }
      },
      method: 'post'
    },
    'publish': {
      'path': function (model) {
        return path.api.certificates + model.id
      },
      'data': function (model) {
        return {
            action:'PUBLISH',
            courseId: Utils.getCourseId()
        }
      },
      method: 'post'
    },
    'unpublish': {
      'path': function (model) {
        return path.api.certificates + model.id
      },
      'data': function (model) {
        return {
            action: 'UNPUBLISH',
            courseId: Utils.getCourseId()
        }
      },
      method: 'post'
    },
    'join' : {
      'path': function (model) {
        return path.api.certificates + model.id
      },
      'data': function (model) {
        return {
            action: 'ADDUSER',
            userID: jQuery('#curriculumStudentID').val(),
            courseId: Utils.getCourseId()
        }
      },
      method: 'post'
    },
    'leave' : {
      'path': function (model) {
        return path.api.certificates + model.id
      },
      'data': function (model) {
        return {
            action: 'DELETEUSER',
            userID: jQuery('#curriculumStudentID').val(),
            courseId: Utils.getCourseId()
        }
      },
      method: 'post'
    }
  }
});

var CertificateModel = Backbone.Model.extend({
  defaults: {
    title: '',
    description: '',
    sitesCount: 0,
    usersCount: 0,
    isPublished: false,
    isPermanent: true,
    validPeriod: {value: 0, valueType: 'UNLIMITED'},
    isOpenBadgesIntegration: false
  }
}).extend(CertificateService);


CertificateCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': {
      'path': path.api.certificates,
      'data': function (e, options) {
        var order = options.order;
        var sortBy = order.split(':')[0];
        var asc = order.split(':')[1];
        return {
          action: 'GETALL',
          companyID: jQuery('#curriculumCompanyID').val(),
          page: options.currentPage,
          count: options.itemsOnPage,
          filter: options.filter,
          scope: options.scope,
          sortBy: sortBy,
          sortAscDirection: asc,
          resultAs: "short",
          courseId: Utils.getCourseId()
        }
      },
      method: 'get'
    }
  }
});

var CertificateCollection = Backbone.Collection.extend({
  model: CertificateModel,
  parse: function (response) {
    this.trigger('certificateCollection:updated', { total: response.total, currentPage: response.currentPage });
    return response.records;
  }
}).extend(CertificateCollectionService);

// my collection
MyCertificateCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': {
      'path': function (e, options) {
        return path.api.users + jQuery('#curriculumStudentID').val() + '/certificates'
      },
      'data': function (e, options) {
        var order = options.order;
        var sortBy = order.split(':')[0];
        var asc = order.split(':')[1];

        return {
          companyID: jQuery('#curriculumUserCompanyID').val(),
          page: options.currentPage,
          count: options.itemsOnPage,
          filter: options.filter,
          scope: options.scope,
          sortBy: sortBy,
          sortAscDirection: asc,
          resultAs: "short",
          isOnlyPublished: true,
          courseId: Utils.getCourseId()
        }
      },
      method: 'get'
    }
}});

var MyCertificateCollection = Backbone.Collection.extend({
  model: CertificateModel,
  parse: function (response) {
    this.trigger('certificateCollection:updated', { total: response.total, currentPage: response.currentPage });
    return response.records;
  }
}).extend(MyCertificateCollectionService);

// available certificates

AvailableCertificateCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': {
      'path': function (e, options) {
        return path.api.users + jQuery('#curriculumStudentID').val() + '/certificates' +
            ''
      },
      'data': function (e, options) {
        var order = options.order;
        var sortBy = order.split(':')[0];
        var asc = order.split(':')[1];
        return {
          companyID: jQuery('#curriculumUserCompanyID').val(),
          page: options.currentPage,
          count: options.itemsOnPage,
          filter: options.filter,
          sortBy: sortBy,
          sortAscDirection: asc,
          resultAs: "short",
          available:true,
          isOnlyPublished: true,
          scope: options.scope,
          courseId: Utils.getCourseId()
      }
    },
      method: 'get'
  }}
});

var AvailableCertificateCollection = Backbone.Collection.extend({
  model: CertificateModel,
  parse: function (response) {
    this.trigger('certificateCollection:updated', { total: response.total, currentPage: response.currentPage });
    return response.records;
  }
}).extend(AvailableCertificateCollectionService);