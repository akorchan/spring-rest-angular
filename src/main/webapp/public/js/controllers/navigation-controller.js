'use strict';

angular.module('spring-angular.controllers')
    .controller('NavigationController', function ($scope, $rootScope, $http, $timeout, $location) {
        var scope = $scope;
        var authenticate = function(credentials, callback) {
            var headers = credentials ? {authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('user', {headers : headers}).success(function(data) {
                if (data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }).error(function() {
                $rootScope.authenticated = false;
                callback && callback();
            });

        }
        authenticate();
        scope.credentials = {};
        scope.login = function() {
            $http.post('login', $.param(scope.credentials), {
                headers : {
                    "content-type" : "application/x-www-form-urlencoded"
                }
            }).success(function(data) {
                authenticate(scope.credentials, function() {
                    if ($rootScope.authenticated) {
                        $location.path("/main");
                        scope.error = false;
                    } else {
                        $location.path("/login");
                        scope.error = true;
                    }
                });
            }).error(function(data) {
                $location.path("/login");
                scope.error = true;
                $rootScope.authenticated = false;
            })
        };

        scope.logout = function() {
            $http.post('logout', {}).finally(function () {
                $rootScope.authenticated = false;
                $location.path("/login");
            });
        };

    });