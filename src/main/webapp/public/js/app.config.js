'use strict';

angular.module('spring-angular.constants').constant('RESTEndPoints', {
    articles: '/api/articles/:id',
    barbershops: '/api/barbershops/:id',
    adminArticles: '/admin/api/articles/:id'
});