/**
 * Created by GreenNun on 12.04.17.
 */
angular.module('pump.modules.constant')
    .controller('constantCtrl', ['$rootScope', '$scope', '$http', '$state', function ($rootScope, $scope, $http, $state) {
        $scope.config = {};

        var countries = {
            operation: 'country',
            constant: 'Country',
            title: 'Countries Dictionary'
        };
        var pumpTypes = {
            operation: 'pump type',
            constant: 'Pump Types',
            title: 'Pump Types Dictionary'
        };
        var sealTypes = {
            operation: 'seal type',
            constant: 'Seal Type',
            title: 'Seal Types Dictionary'
        };
        var materials = {
            operation: 'material',
            constant: 'Material',
            title: 'Pump Casting Materials Dictionary'
        };
        var sealMaterials = {
            operation: 'seal material',
            constant: 'Seal O-Ring Material',
            title: 'Seal Materials Dictionary'
        };
        var bushingMaterials = {
            operation: 'bushing material',
            constant: 'Bushing Material',
            title: 'Bushing Materials Dictionary'
        };
        var connectionTypes = {
            operation: 'connection type',
            constant: 'Connection Type',
            title: 'Connection Types Dictionary'
        };
        var dn = {
            operation: 'dn',
            constant: 'DN Type',
            title: 'DN Type Dictionary'
        };
        var connectionAngleTypes = {
            operation: 'connection angle type',
            constant: 'Connection Angle Type',
            title: 'Connection Angle Types Dictionary'
        };
        var pressures = {
            operation: 'pressure limit',
            constant: 'Pressure Limit',
            title: 'Pressure Limits Dictionary'
        };
        var temperatures = {
            operation: 'temperature limit',
            constant: 'Temperature Limit',
            title: 'Temperature Limit Dictionary'
        };
        var driverAssemblyTypes = {
            operation: 'driver assembly type',
            constant: 'Driver Assembly Type',
            title: 'Driver Assembly Types Dictionary'
        };
        var explosionProofTypes = {
            operation: 'explosion proof',
            constant: 'Explosion Proof Type',
            title: 'Explosion Proof Types Dictionary'
        };
        var motorPowerTypes = {
            operation: 'motor power',
            constant: 'Motor Power Type',
            title: 'Motor Power Types Dictionary'
        };
        var motorFrameSizes = {
            operation: 'motor frame size',
            constant: 'Motor Frame Size',
            title: 'Motor Frame Sizes Dictionary'
        };
        var motorSpeedTypes = {
            operation: 'motor speed',
            constant: 'Motor Speed Type',
            title: 'Motor Speed Types Dictionary'
        };

        switch ($state.current.name) {
            case 'main.manage.countries':
                $scope.config = countries;
                break;
            case 'main.manage.pumpTypes':
                $scope.config = pumpTypes;
                break;
            case 'main.manage.sealTypes':
                $scope.config = sealTypes;
                break;
            case 'main.manage.materials':
                $scope.config = materials;
                break;
            case 'main.manage.sealMaterials':
                $scope.config = sealMaterials;
                break;
            case 'main.manage.bushingMaterials':
                $scope.config = bushingMaterials;
                break;
            case 'main.manage.connectionTypes':
                $scope.config = connectionTypes;
                break;
            case 'main.manage.dn':
                $scope.config = dn;
                break;
            case 'main.manage.connectionAngleTypes':
                $scope.config = connectionAngleTypes;
                break;
            case 'main.manage.pressures':
                $scope.config = pressures;
                break;
            case 'main.manage.temperatures':
                $scope.config = temperatures;
                break;
            case 'main.manage.driverAssemblyTypes':
                $scope.config = driverAssemblyTypes;
                break;
            case 'main.manage.explosionProofTypes':
                $scope.config = explosionProofTypes;
                break;
            case 'main.manage.motorPowerTypes':
                $scope.config = motorPowerTypes;
                break;
            case 'main.manage.motorFrameSizes':
                $scope.config = motorFrameSizes;
                break;
            case 'main.manage.motorSpeedTypes':
                $scope.config = motorSpeedTypes;
                break;
            default:
                $rootScope.addNotification('danger', $rootScope.error);
        }

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
                    $('#editModal').modal('show');
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