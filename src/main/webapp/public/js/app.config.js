'use strict';

angular.module('spring-angular.constants').constant('EndPointUrls', {
    findWord: '/words/:word/:lang',
    findWords: '/words/search/:word/:lang',
    postWord: '/words/:word/:meaning'
});