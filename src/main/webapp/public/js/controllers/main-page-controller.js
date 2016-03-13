'use strict';

/** Controllers */
angular.module('spring-angular.controllers')
    .controller('MainPageController', function ($scope, $http, $timeout, $location, MainPageService) {
        MainPageService.test('11', function (data) {
            console.log('Successfull test!');
            $scope.article = data;
        });
    });