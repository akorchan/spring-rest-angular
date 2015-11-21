'use strict';

/** Controllers */
angular.module('spring-angular.controllers')
    .controller('MainPageController', function ($scope, $http, $timeout, $location, MainPageService) {
        MainPageService.test('test name', function (data) {
            console.log('Successfull test!');
            $scope.greeting = data;
        });
    });