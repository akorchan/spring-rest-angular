'use strict';

/** store items service */
angular.module('spring-angular.services').service('ArticlesPageService', function ($http) {

    var getAllArticles = function (callback) {
        $http({method: "GET", url: "api/articles/"}).
            success(function (data) {
                callback(data);
            }).error(function (data) {
                console.log(data);
            });
    };

    return {
        getAllArticles: getAllArticles,
    };

});