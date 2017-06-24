/**
 * Created by GreenNun on 12.04.17.
 */
angular.module('pump.modules.constant')
    .controller('constantCtrl', ['$rootScope', '$scope', '$http', '$state', function ($rootScope, $scope, $http, $state) {
        $scope.config = $state.current.data;

        $scope.tempItem = [];
        $scope.newItem = {
            id: null,
            version: null,
            name: $scope.config.operation,
            value: null
        };

        $scope.getConstantList = function (constantName) {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: constantName}
            })
                .then(function (success) {
                    $scope.constant_module = success.data;
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
                url: '/pump/api/constant/save',
                data: $scope.tempItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.constant_module[index] = success.data;
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.add = function () {
            $http({
                method: 'POST',
                url: '/pump/api/constant/save',
                data: $scope.newItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.constant_module.push(success.data);
                    $scope.newItem.value = null;
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', $rootScope.error);
                    $('#createModal').modal('show');
                });
        };

        $scope.delete = function (item) {
            $http({
                method: 'POST',
                url: '/pump/api/constant/delete',
                data: item
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    var index = $scope.constant_module.indexOf(item);
                    $scope.constant_module.splice(index, 1);
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstantList($scope.config.operation);
    }]);