'use strict';

angular.module('spring-angular', ['ngRoute', 'spring-angular.controllers', 'spring-angular.services'])
    .config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/main', {templateUrl: 'public/partials/main.html', controller: 'MainPageController'})
            .when('/contact', {templateUrl: 'public/partials/contact.html', controller: 'MainPageController'})
            .when('/about', {templateUrl: 'public/partials/about.html', controller: 'MainPageController'})
            .when('/post', {templateUrl: 'public/partials/post.html', controller: 'MainPageController'})
            .otherwise({redirectTo: '/main'});
    }]);

/** constants */
angular.module('spring-angular.constants', []);

/** services module initialization, allows adding services to module in multiple files */
angular.module('spring-angular.services', ['spring-angular.constants']);

/** controllers module initialization, allows adding controllers to module in multiple files */
angular.module('spring-angular.controllers', ['spring-angular.services', 'spring-angular.directives']);

/** directives module initialization, allows adding directives to module in multiple files */
angular.module('spring-angular.directives', []);