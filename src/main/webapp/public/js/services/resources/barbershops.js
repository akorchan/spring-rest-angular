'use strict';

angular.module('spring-angular.services').factory('Barbershops', function($resource, RESTEndPoints) {
    return $resource(RESTEndPoints.barbershops, { id: '@id' }, {
        update: {
            method: 'PUT'
        }
    });
});
// $resources check here:
// http://www.sitepoint.com/creating-crud-app-minutes-angulars-resource/