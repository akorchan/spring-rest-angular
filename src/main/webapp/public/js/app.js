'use strict';

angular.module('spring-angular', ['ngRoute', 'ngMap', 'spring-angular.controllers', 'spring-angular.services'])
    .config(['$routeProvider', '$httpProvider', '$resourceProvider', function ($routeProvider, $httpProvider, $resourceProvider) {
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        // Don't strip trailing slashes from calculated URLs
        $resourceProvider.defaults.stripTrailingSlashes = false;

        $routeProvider
            .when('/login', {templateUrl: 'public/partials/login.html', controller: 'NavigationController'})
            .when('/main', {templateUrl: 'public/partials/main.html', controller: 'MainPageController'})
            .when('/contact', {templateUrl: 'public/partials/contact.html', controller: 'MainPageController'})
            .when('/about', {templateUrl: 'public/partials/about.html', controller: 'MainPageController'})
            .when('/articles', {templateUrl: 'public/partials/articles.html', controller: 'ArticlesPageController'})
            .when('/article', {templateUrl: 'public/partials/article.html', controller: 'MainPageController'})

            .when('/admin-articles', {templateUrl: 'public/partials/admin/admin-articles.html', controller: 'AdminArticlesPageController'})
            .otherwise({redirectTo: '/main'});
    }]);

/** constants */
angular.module('spring-angular.constants', []);

/** services module initialization, allows adding services to module in multiple files */
angular.module('spring-angular.services', ['ngResource', 'spring-angular.constants']);

/** controllers module initialization, allows adding controllers to module in multiple files */
angular.module('spring-angular.controllers', ['spring-angular.services', 'spring-angular.directives']);

/** directives module initialization, allows adding directives to module in multiple files */
angular.module('spring-angular.directives', []);