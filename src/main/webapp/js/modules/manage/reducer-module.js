/**
 * Created by GreenNun on 19.06.17.
 */
angular.module('pump.modules.reducer')
    .controller('reducerCtrl', ['$rootScope', '$scope', '$http', '$state', function ($rootScope, $scope, $http) {
        $scope.tempItem = [];
        $scope.newItem = {
            id: null,
            version: null,
            modelName: null,
            producer: null,
            price: null,
            vendor: null,
            minRpm: null,
            maxRpm: null,
            constExplosionProof: null,
            constRequiredMotorPowerHp: null,
            constMotorFrameSize: null
        };

        $scope.getReducerList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/reducer/list'
            })
                .then(function (success) {
                    $scope.reducers = success.data;
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

        $scope.getConstExProofList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'explosion proof'}
            })
                .then(function (success) {
                    $scope.exProofs = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstPowerList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'motor power'}
            })
                .then(function (success) {
                    $scope.powers = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstFrameSizesList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'motor frame size'}
            })
                .then(function (success) {
                    $scope.frameSizes = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.edit = function (value) {
            $scope.tempItem = jQuery.extend(true, {}, value);
        };

        $scope.save = function (index) {
            $http({
                method: 'POST',
                url: '/pump/api/reducer/save',
                data: $scope.tempItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.reducers[index] = success.data;
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                    $('#editModal').modal('show');
                });
        };

        $scope.add = function () {
            $http({
                method: 'POST',
                url: '/pump/api/reducer/save',
                data: $scope.newItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.reducers.push(success.data);
                    $scope.newItem =  {
                        id: null,
                        version: null,
                        modelName: null,
                        producer: null,
                        price: null,
                        vendor: null,
                        minRpm: null,
                        maxRpm: null,
                        constExplosionProof: null,
                        constRequiredMotorPowerHp: null,
                        constMotorFrameSize: null
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
                url: '/pump/api/reducer/delete',
                data: item
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    var index = $scope.reducers.indexOf(item);
                    $scope.reducers.splice(index, 1);
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getReducerList();
        $scope.getProducerList();
        $scope.getConstExProofList();
        $scope.getConstPowerList();
        $scope.getConstFrameSizesList();
    }]);


