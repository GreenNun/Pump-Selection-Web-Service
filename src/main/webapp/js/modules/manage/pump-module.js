/**
 * Created by GreenNun on 27.06.17.
 */
angular.module('pump.modules.pump')
    .controller('pumpCtrl', ['$rootScope', '$scope', '$http', function ($rootScope, $scope, $http) {
        $scope.tempItem = [];
        // $scope.tempPumps = [];
        $scope.newItem = {
            id: null,
            version: null,
            modelName: null,
            producer: null,
            price: null,
            constPumpType: null,
            reliefValve: false,
            heatingJacketOnCover: false,
            heatingJacketOnCasing: false,
            heatingJacketOnBracket: false,

            constCasingMaterial: null,
            constRotorGearMaterial: null,
            constIdlerGearMaterial: null,
            constShaftSupportMaterial: null,
            constShaftMaterial: null,

            constConnectionsType: null,
            constDn: null,
            constMaxPressure: null,
            constConnectionsAngle: null,
            constMaxTemperature: null,

            rpmCoefficient: null,
            speedCorrectionCoefficients: []
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

        $scope.getConstPumpTypeList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'pump type'}
            })
                .then(function (success) {
                    $scope.pumpTypes = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConsPumpMaterialList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'pump material'}
            })
                .then(function (success) {
                    $scope.pumpMaterials = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConsBushingMaterialList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'bushing material'}
            })
                .then(function (success) {
                    $scope.busingMaterials = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstConnectionTypeList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'connection type'}
            })
                .then(function (success) {
                    $scope.connections = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstDNList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'dn'}
            })
                .then(function (success) {
                    $scope.dn = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstMaxPressureList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'pressure limit'}
            })
                .then(function (success) {
                    $scope.pressures = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstConnectionAngleTypeList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'connection angle type'}
            })
                .then(function (success) {
                    $scope.connectionAngles = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.getConstMaxTemperatureList = function () {
            $http({
                method: 'GET',
                url: '/pump/api/constant/list',
                params: {name: 'temperature limit'}
            })
                .then(function (success) {
                    $scope.temperatures = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.new = function () {
            // $scope.tempPumps = jQuery.extend(true, [], $scope.pumps);
            // $scope.initAvailablePumpList($scope.tempPumps, $scope.newItem.suitablePumps);
        };

        $scope.edit = function (value) {
            $scope.tempItem = jQuery.extend(true, {}, value);
            // $scope.tempPumps = jQuery.extend(true, [], $scope.pumps);
            // $scope.initAvailablePumpList($scope.tempPumps, $scope.tempItem.suitablePumps);
        };

        $scope.save = function (index) {
            $http({
                method: 'POST',
                url: '/pump/api/pump/save',
                data: $scope.tempItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.pumps[index] = success.data;
                    // $scope.pumps = [];
                    // console.log($scope.pumps, "pumps msg");
                    console.log(index, "pumps msg");
                    // $scope.tempPumps = [];
                    $('.modal-backdrop').remove();
                    // $('.modal-backdrop').modal('hide');
                    $('body').removeClass('modal-open');
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        $scope.add = function () {
            $http({
                method: 'POST',
                url: '/pump/api/pump/save',
                data: $scope.newItem
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    $scope.pumps.push(success.data);
                    $scope.newItem =  {
                        id: null,
                        version: null,
                        modelName: null,
                        producer: null,
                        price: null,
                        constPumpType: null,
                        reliefValve: null,
                        heatingJacketOnCover: null,
                        heatingJacketOnCasing: null,
                        heatingJacketOnBracket: null,
                        constCasingMaterial: null,
                        constRotorGearMaterial: null,
                        constIdlerGearMaterial: null,
                        constShaftSupportMaterial: null,
                        constShaftMaterial: null,
                        constConnectionsType: null,
                        constDn: null,
                        constMaxPressure: null,
                        constConnectionsAngle: null,
                        constMaxTemperature: null,
                        rpmCoefficient: null,
                        speedCorrectionCoefficients: []
                    };
                    // $scope.tempPumps = [];
                    // $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', $rootScope.error);
                    $('#createModal').modal('show');
                });
        };

        $scope.delete = function (item) {
            $http({
                method: 'POST',
                url: '/pump/api/pump/delete',
                data: item
            })
                .then(function (success) {
                    $rootScope.addNotification('success', $rootScope.success);
                    var index = $scope.pumps.indexOf(item);
                    $scope.pumps.splice(index, 1);
                    $('.modal-backdrop').remove();
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        // COEFFICIENTS
        $scope.addCoeff = function (pump) {
            pump.speedCorrectionCoefficients.push({
                id: null,
                version: null,
                viscosity: null,
                coefficient: null
            });
        };

        $scope.removeCoeff = function ($index, pump) {
            pump.speedCorrectionCoefficients.splice($index, 1);
        };
        // DIRECTIVE
        // $scope.selectedFrom = [];
        // $scope.perSelectedFrom = [];
        // $scope.selectedTo = [];
        //
        // $scope.move = function (from, selected, to) {
        //     angular.forEach(selected, function (item) {
        //         to.push(item);
        //         var index = from.indexOf(item);
        //         from.splice(index, 1);
        //     });
        // };
        //
        // $scope.moveAll = function (from, to) {
        //     angular.forEach(from, function (item) {
        //         to.push(item);
        //     });
        //     from.length = 0;
        // };
        //
        // $scope.initAvailablePumpList = function (available, current){
        //     for (var i = 0; i < current.length; i++) {
        //         for (var j = 0; j < available.length; j++) {
        //             if(angular.toJson(current[i]) === angular.toJson(available[j])){
        //                 available.splice(j, 1);
        //             }
        //         }
        //     }
        // };

        $scope.getPumpList();
        $scope.getProducerList();
        $scope.getConstPumpTypeList();
        $scope.getConsPumpMaterialList();
        $scope.getConsBushingMaterialList();
        $scope.getConstConnectionTypeList();
        $scope.getConstDNList();
        $scope.getConstMaxPressureList();
        $scope.getConstConnectionAngleTypeList();
        $scope.getConstMaxTemperatureList();
    }]);
