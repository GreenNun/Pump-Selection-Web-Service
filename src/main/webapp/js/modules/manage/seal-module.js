/**
 * Created by GreenNun on 23.06.17.
 */
angular.module('pump.modules.seal')
    .controller('sealCtrl', ['$rootScope', '$scope', '$http', function ($rootScope, $scope, $http) {
        $scope.tempItem = [];
        $scope.tempPumps = [];
        $scope.newItem = {
            id: null,
            version: null,
            modelName: null,
            producer: null,
            price: null,
            sealType: null,
            oringMaterial: null,
            suitablePumps: []
        };

        $scope.getSealList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/seal/list'
            })
                .then(function (success) {
                    $scope.seals = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
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

        $scope.getConstSealTypesList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'seal type'}
            })
                .then(function (success) {
                    $scope.sealTypes = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstORingMaterialList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'seal material'}
            })
                .then(function (success) {
                    $scope.oRingMaterials = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getPumpList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/pump/list'
            })
                .then(function (success) {
                    $scope.pumps = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.new = function () {
            $scope.tempPumps = jQuery.extend(true, [], $scope.pumps);
            $scope.initAvailablePumpList($scope.tempPumps, $scope.newItem.suitablePumps);
        };

        $scope.edit = function (value) {
            $scope.tempItem = jQuery.extend(true, {}, value);
            $scope.tempPumps = jQuery.extend(true, [], $scope.pumps);
            $scope.initAvailablePumpList($scope.tempPumps, $scope.tempItem.suitablePumps);
        };

        $scope.save = function (index) {
            $http({
                method: 'POST',
                url: '/pump/api/seal/save',
                data: $scope.tempItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.seals[index] = success.data;
                    $scope.tempPumps = [];
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.add = function () {
            $http({
                method: 'POST',
                url: '/pump/api/seal/save',
                data: $scope.newItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.seals.push(success.data);
                    $scope.newItem =  {
                        id: null,
                        version: null,
                        modelName: null,
                        producer: null,
                        price: null,
                        sealType: null,
                        oringMaterial: null,
                        suitablePumps: null
                    };
                    $scope.tempPumps = [];
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', $rootScope.error);
                    $('#createModal').modal('show');
                });
        };

        $scope.delete = function (item) {
            $http({
                method: 'POST',
                url: '/pump/api/seal/delete',
                data: item
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    var index = $scope.seals.indexOf(item);
                    $scope.seals.splice(index, 1);
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        // DIRECTIVE
        $scope.selectedFrom = [];
        $scope.perSelectedFrom = [];
        $scope.selectedTo = [];

        $scope.move = function (from, selected, to) {
            angular.forEach(selected, function (item) {
                to.push(item);
                var index = from.indexOf(item);
                from.splice(index, 1);
            });
        };

        $scope.moveAll = function (from, to) {
            angular.forEach(from, function (item) {
                to.push(item);
            });
            from.length = 0;
        };

        $scope.initAvailablePumpList = function (available, current){
            for (var i = 0; i < current.length; i++) {
                for (var j = 0; j < available.length; j++) {
                    if(angular.toJson(current[i]) === angular.toJson(available[j])){
                        available.splice(j, 1);
                    }
                }
            }
        };

        $scope.getSealList();
        $scope.getProducerList();
        $scope.getConstSealTypesList();
        $scope.getConstORingMaterialList();
        $scope.getPumpList();
    }]);
