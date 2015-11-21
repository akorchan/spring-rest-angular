'use strict';

/** store items service */
angular.module('spring-angular.services').service('MainPageService', function ($http) {

    var test = function (name, callback) {
        $http({method: "GET", url: "/greeting?name=" + name}).
            success(function (data) {
                //isAuthenticated = (data == "login");
                callback(data);
            }).error(function (data) {
                console.log(data);
                //isAuthenticated = false;
            });
    };

    return {
        test: test,
    };

});