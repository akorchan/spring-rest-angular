'use strict';

angular.module('spring-angular.controllers')
    .controller('NavigationController', function ($scope, $rootScope, $http, $timeout, $location) {
        var self = this
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
        self.credentials = {};
        $scope.login = function() {
            $http.post('login', $.param($scope.credentials), {
                headers : {
                    "content-type" : "application/x-www-form-urlencoded"
                }
            }).success(function(data) {
                authenticate(function() {
                    if ($rootScope.authenticated) {
                        $location.path("/");
                        $scope.error = false;
                    } else {
                        $location.path("/#/login");
                        $scope.error = true;
                    }
                });
            }).error(function(data) {
                $location.path("/#/login");
                $scope.error = true;
                $rootScope.authenticated = false;
            })
        };

    });