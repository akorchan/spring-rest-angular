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
                    var icon = new google.maps.MarkerImage(
                        'public/img/icons/barber-pole2.png',
                        null, /* size is determined at runtime */
                        null, /* origin is 0,0 */
                        null, /* anchor is bottom center of the scaled image */
                        new google.maps.Size(30, 60)
                    );
                    var shape = {
                        coords: [1, 1, 1, 20, 18, 20, 18, 1],
                        type: 'poly'
                    };
                    self.dynMarkers.push(new google.maps.Marker({
                        position: marker.position,
                        icon: icon,
                    }));
                });
                self.markerClusterer = new MarkerClusterer(map, self.dynMarkers, {gridSize: 60, maxZoom: 16});
            });
        });
    });