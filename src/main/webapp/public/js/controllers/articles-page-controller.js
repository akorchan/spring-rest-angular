'use strict';

angular.module('spring-angular.controllers')
    .controller('ArticlesPageController', function ($scope, $http, $timeout, $location, Articles) {
        $scope.articles = Articles.query();
    });