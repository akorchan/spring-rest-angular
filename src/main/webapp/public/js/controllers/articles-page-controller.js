'use strict';

/** Controllers */
angular.module('spring-angular.controllers')
    .controller('ArticlesPageController', function ($scope, $http, $timeout, $location, ArticlesPageService) {
        ArticlesPageService.getAllArticles(function (data) {
            $scope.articles = data;
        });
    });