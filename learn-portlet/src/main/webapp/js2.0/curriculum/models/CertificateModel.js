CertificateService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'create': {
      'path': function () {
        return 'api/certificates/?action=ADD&companyID=' + jQuery('#curriculumCompanyID').val();
      },
      'method': 'post'
    },
    'update': {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=UPDATE&companyID=' + jQuery('#curriculumCompanyID').val();
      },
      'method': 'post'
    },
    'read': {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=GETBYID';
      }
    },
    'delete': {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=DELETE';
      },
      'method': 'post'
    }
  },

  targets: {
    'clone': {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=CLONE';
      },
      method: 'post'
    },
    'publish': {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=PUBLISH';
      },
      method: 'post'
    },
    'unpublish': {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=UNPUBLISH';
      },
      method: 'post'
    },
    'join' : {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=ADDUSER&userID=' + jQuery('#curriculumStudentID').val();
      },
      method: 'post'
    },
    'leave' : {
      'path': function (model) {
        return 'api/certificates/' + model.id + '?action=DELETEUSER&userID=' + jQuery('#curriculumStudentID').val();
      },
      method: 'post'
    }
  }
});

var CertificateModel = Backbone.Model.extend({
  defaults: {
    title: 'New certificate',
    description: 'Certificate info',
    sitesCount: 0,
    usersCount: 0,
    isPublished: false,
    isPermanent: true,
    validPeriod: 'UNLIMITED',
    isOpenBadgesIntegration: false
  }
}).extend(CertificateService);


CertificateCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function (e, options) {
      var order = jQuery('#certificateOrder').val();
      var sortBy = order.split(':')[0]
      var asc = order.split(':')[1]
      return 'api/certificates?action=GETALL&companyID=' + jQuery('#curriculumCompanyID').val() +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage +
        '&filter=' + jQuery('#certificateFilter').val() +
        '&sortBy=' + sortBy +
        '&sortAscDirection=' + asc +
        '&resultAs=short';
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
MyCertificateCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function (e, options) {
      var order = jQuery('#certificateOrder').val();
      var sortBy = order.split(':')[0]
      var asc = order.split(':')[1]

      return 'api/users/'+ jQuery('#curriculumStudentID').val() +
        '/certificates?' +
        'companyID=' + jQuery('#curriculumUserCompanyID').val() +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage +
        '&filter=' + jQuery('#certificateFilter').val() +
        '&sortBy=' + sortBy +
        '&sortAscDirection=' + asc +
        '&resultAs=short' +
        '&isOnlyPublished=true';
    }
  }
});

var MyCertificateCollection = Backbone.Collection.extend({
  model: CertificateModel,
  parse: function (response) {
    this.trigger('certificateCollection:updated', { total: response.total, currentPage: response.currentPage });
    return response.records;
  }
}).extend(MyCertificateCollectionService);

// available certificates

AvailableCertificateCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function (e, options) {
      var order = jQuery('#certificateOrder').val();
      var sortBy = order.split(':')[0]
      var asc = order.split(':')[1]

      return 'api/users/'+ jQuery('#curriculumStudentID').val() +
        '/certificates?' +
        'companyID=' + jQuery('#curriculumUserCompanyID').val() +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage +
        '&filter=' + jQuery('#certificateFilter').val() +
        '&sortBy=' + sortBy +
        '&sortAscDirection=' + asc +
        '&resultAs=short' +
        '&available=true' +
        '&isOnlyPublished=true' +
        '&scope=' + jQuery('#certificateScopeFilter').val();
    }
  }
});

var AvailableCertificateCollection = Backbone.Collection.extend({
  model: CertificateModel,
  parse: function (response) {
    this.trigger('certificateCollection:updated', { total: response.total, currentPage: response.currentPage });
    return response.records;
  }
}).extend(AvailableCertificateCollectionService);