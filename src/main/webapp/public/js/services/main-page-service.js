'use strict';

angular.module('spring-angular.services').service('MainPageService', function ($http) {

    var test = function (id, callback) {
        $http({method: "GET", url: "api/articles/" + id}).
            success(function (data) {
                callback(data);
            }).error(function (data) {
                console.log(data);
            });
    };

    return {
        test: test,
    };

});