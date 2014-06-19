(function (factory) {
    if (typeof exports === 'object') {
        module.exports = factory(require('underscore'), require('backbone'));
    } else if (typeof define === 'function' && define.amd) {
        define(['underscore', 'backbone'], factory);
    } else {
        factory(_, Backbone);
    }
})(function (_, Backbone) {

    'use strict';

    function Service(options) {
        var syncImpl = 'sync_';
        this[syncImpl] = {};

        this.options = options || {};
        var syncImplementations = parseTargets(this.options.sync || {});
        _(syncImplementations).each(_.partial(this.createMethod, this[syncImpl]), this);

        this.targets = parseTargets(this.options.targets || {});
        _(this.targets).each(_.partial(this.createMethod, this), this);
        this.sync = function (method, model, options) {
            var mappedSync = this[syncImpl][method];
            if (_.isFunction(mappedSync)) return mappedSync.call(this, {}, options);
            else return Backbone.sync(method, model, options);
        }
    }

    Service.sendModels = true;
    Service.url = '';

    Service.prototype.createMethod = function (parent, target) {
        var promise, method, self = this;

        parent[target.name] = function (data, options) {
            promise = new Promise(self);
            if (_.isFunction(target.data)) {
                // data map function should process data entirely
                data = _.extend(target.data(this, options), data);
            } else if (Service.sendModels && methodMap[target.method.toUpperCase()] != 'read') {
                // if data is not a function, but we want to send model with each request
                data = _.extend(this.toJSON(), data, target.data);
            } else {
                // otherwise just concat all data together; if no data exists, then model will be sent from Backbone.sync
                data = _.extend({}, data, target.data);
            }
            options = self.createOptions(promise, target, options, this);
            if (data && !_.isEmpty(data)) {
                if (!Backbone.emulateJSON && methodMap[target.method.toUpperCase()] != 'read') {
                    data = JSON.stringify(data);
                    options.contentType = 'application/json';
                }
                options.data = data;
            }
            options.type = target.method.toUpperCase();

            if (_.find(_.values(methodMap), function (method) {
                return method === target.name;
            })) {
                method = target.name;
            } else {
                method = methodMap[options.type];
            }
            Backbone.sync(method, this, options);

            return promise;
        }
    };

    Service.prototype.createOptions = function (promise, target, options, model) {
        var self = this;

        options || (options = {});

        var path;
        if (_.isFunction(target.path)) path = target.path(model, options);
        else path = target.path;

        var url = _.result(this.options, 'url') || Service.url;

        return {
            url: url + path,
            success: function (resp, status, xhr) {
                options.success && options.success.call(self, resp);
                promise.resolve(resp);
            },
            error: function (xhr, status, error) {
                options.error && options.error.apply(self, [error, xhr]);
                promise.reject(error, xhr);
            }
        };
    };

    var methodMap = {
        'POST': 'create',
        'PUT': 'update',
        'DELETE': 'delete',
        'GET': 'read'
    };

    function parseTargets(targets) {
        var target, defaultMethod = "GET";

        return _(targets).map(function (props, name) {
            target = { name: name, path: props, method: defaultMethod };

            if (_.isObject(props) && !_.isFunction(props)) {
                _.extend(target, { path: props.path, method: props.method || defaultMethod, data: props.data });
            }

            return target;
        });
    }

    _.extend(Service.prototype, Backbone.Events);
    Backbone.Service = Service;

    // simple promise implementation
    function Promise(context) {
        this.context = context || this;
        this.success = [];
        this.error = [];
    }

    Promise.prototype = {
        constructor: Promise,

        then: function (success, error) {
            if (success) {
                if (this.resolved) {
                    success.apply(this.context, this.resolved);
                }
                else {
                    this.success.push(success);
                }
            }

            if (error) {
                if (this.rejected) {
                    error.apply(this.context, this.rejected);
                }
                else {
                    this.error.push(error);
                }
            }

            return this;
        },

        resolve: function () {
            var callback;

            this.resolved = arguments;
            this.error = [];

            while (callback = this.success.shift()) {
                callback.apply(this.context, this.resolved);
            }
        },

        reject: function () {
            var callback;

            this.rejected = arguments;
            this.success = [];

            while (callback = this.error.shift()) {
                callback.apply(this.context, this.rejected);
            }
        }
    };
});
//(Backbone);