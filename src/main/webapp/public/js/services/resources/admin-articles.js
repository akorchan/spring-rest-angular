'use strict';

angular.module('spring-angular.services').factory('AdminArticles', function($resource, RESTEndPoints) {
    return $resource(RESTEndPoints.adminArticles, { id: '@id' }, {
        update: {
            method: 'PUT'
        }
    });
});
// $resources check here:
// http://www.sitepoint.com/creating-crud-app-minutes-angulars-resource/