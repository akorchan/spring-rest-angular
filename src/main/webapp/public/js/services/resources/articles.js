'use strict';

angular.module('spring-angular.services').factory('Articles', function($resource, RESTEndPoints) {
    return $resource(RESTEndPoints.articles, { id: '@id' }, {
        update: {
            method: 'PUT'
        }
    });
});