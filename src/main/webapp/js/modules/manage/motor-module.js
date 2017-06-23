/**
 * Created by GreenNun on 18.06.17.
 */
angular.module('pump.modules.motor')
    .controller('motorCtrl', ['$rootScope', '$scope', '$http', '$state', function ($rootScope, $scope, $http) {
        $scope.tempItem = [];
        $scope.newItem = {
            id: null,
            version: null,
            modelName: null,
            producer: null,
            price: null,
            vendor: null,
            constSpeed: null,
            constExplosionProof: null,
            constPowerHp: null,
            constMotorFrameSize: null
        };

        $scope.getMotorList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/motor/list'
            })
                .then(function (success) {
                    $scope.motors = success.data;
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

        $scope.getConstSpeedList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'motor speed'}
            })
                .then(function (success) {
                    $scope.speeds = success.data;
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
                url: '/pump/api/motor/save',
                data: $scope.tempItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.motors[index] = success.data;
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                    $('#editModal').modal('show');
                });
        };

        $scope.add = function () {
            $http({
                method: 'POST',
                url: '/pump/api/motor/save',
                data: $scope.newItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.motors.push(success.data);
                    $scope.newItem =  {
                        id: null,
                        version: null,
                        modelName: null,
                        producer: null,
                        price: null,
                        vendor: null,
                        constSpeed: null,
                        constExplosionProof: null,
                        constPowerHp: null,
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
                url: '/pump/api/motor/delete',
                data: item
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    var index = $scope.motors.indexOf(item);
                    $scope.motors.splice(index, 1);
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getMotorList();
        $scope.getProducerList();
        $scope.getConstSpeedList();
        $scope.getConstExProofList();
        $scope.getConstPowerList();
        $scope.getConstFrameSizesList();
    }]);

