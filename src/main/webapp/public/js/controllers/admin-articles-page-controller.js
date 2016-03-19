'use strict';

angular.module('spring-angular.controllers')
    .controller('AdminArticlesPageController', function ($scope, $http, $timeout, $location, AdminArticles) {
        $scope.articles = AdminArticles.query();
    });