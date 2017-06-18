/**
 * Created by GreenNun on 17.06.17.
 */
angular.module('pump.modules.producer')
    .controller('producerCtrl', ['$rootScope', '$scope', '$http', '$state', function ($rootScope, $scope, $http) {
        $scope.tempItem = [];
        $scope.newItem = {
            id: null,
            version: null,
            producerName: null,
            producerCountry: null
        };

        $scope.getProducerList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/producer/list'
            })
                .then(function (success) {
                    $scope.producers = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getCountryList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'country'}
            })
                .then(function (success) {
                    $scope.countries = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.edit = function (value) {
            $scope.tempItem = jQuery.extend({}, value);
        };

        $scope.save = function (index) {
            $http({
                method: 'POST',
                url: '/pump/api/producer/save',
                data: $scope.tempItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.producers[index] = success.data;
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                    $('#editModal').modal('show');
                });
        };

        $scope.add = function () {
            $http({
                method: 'POST',
                url: '/pump/api/producer/save',
                data: $scope.newItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.producers.push(success.data);
                    $scope.newItem =  {
                        id: null,
                        version: null,
                        producerName: null,
                        producerCountry: null
                    };
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', $rootScope.error);
                    $('#createModal').modal('show');
                });
        };

        $scope.delete = function (item) {
            $http({
                method: 'POST',
                url: '/pump/api/producer/delete',
                data: item
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    var index = $scope.countries.indexOf(item);
                    $scope.producers.splice(index, 1);
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getProducerList();
        $scope.getCountryList();
    }]);
