'use strict';

angular.module('spring-angular', ['spring-angular.controllers', 'spring-angular.services']).
    config(function ($routeProvider) {
        $routeProvider.
            when('/main', {templateUrl: 'public/partials/test.html', controller: 'MainPageController'}).
            //when('/store', {templateUrl: 'public/partials/store.html', controller: 'StoreController', pageKey: 'STORE'}).
            //when('/store/:itemId', {templateUrl: 'public/partials/item-view.html', controller: 'ItemController', pageKey: 'STORE'}).
            //when('/cook', {templateUrl: 'public/partials/cook.html', controller: 'CookController', pageKey: 'COOK'}).
            //when('/howto', {templateUrl: 'public/partials/howto.html', controller: 'HowToController', pageKey: 'HOWTO'}).
            //when('/admin', {templateUrl: 'public/partials/admin.html', controller: 'AdminController', pageKey: 'ADMIN'}).
            //when('/admin', {templateUrl: 'public/partials/admin.html', controller: 'AdminController', pageKey: 'ADMIN'}).
            //when('/shopping-cart', {templateUrl: 'public/partials/shopping-cart.html', controller: 'ShoppingCartController', pageKey: 'SHOPCART'}).
            otherwise({redirectTo: '/main'});
    });
//.run(function ($rootScope) {
//        $rootScope.$on("$routeChangeSuccess",
//            function (angularEvent, currentRoute, previousRoute) {
//                $("li[class*='pagekey']").toggleClass("active", false);
//                $(".pagekey_" + currentRoute.pageKey).toggleClass("active", true);
//            });
//
//    });

/** services module initialization, allows adding services to module in multiple files */
angular.module('spring-angular.services', []);

/** controllers module initialization, allows adding controllers to module in multiple files */
angular.module('spring-angular.controllers', ['spring-angular.services', 'spring-angular.directives']);

/** directives module initialization, allows adding directives to module in multiple files */
angular.module('spring-angular.directives', []);