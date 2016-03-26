'use strict';

angular.module('spring-angular.controllers')
    .controller('MainPageController', function ($scope, $http, $timeout, $location, NgMap, Barbershops) {
        var self = this;
        $scope.barbershops = Barbershops.query();
        $scope.barbershops.$promise.then(function (result) {
           var markers = result.map(function (barbershop) {
                return {
                    position: new google.maps.LatLng(barbershop.lat, barbershop.lon)
                };
            });
            self.dynMarkers = [];
            NgMap.getMap().then(function (map) {
                markers.forEach(function (marker) {
                    self.dynMarkers.push(new google.maps.Marker({position: marker.position}));
                });
                self.markerClusterer = new MarkerClusterer(map, self.dynMarkers, {});
            });
        });
    });