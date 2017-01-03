angular.module('pump.modules.manage')
    .controller('manageCtrl', function ($rootScope, $scope, $http) {
        
        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/constants'
        })
            .success(function (data) {
                $scope.constants = data;
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/producers'
        })
            .success(function (data) {
                $scope.producers = data;
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });


        /*seals box*/
        $scope.orderProp = 'id';
        $scope.selectedFrom = [];
        $scope.perSelectedFrom = [];
        $scope.selectedTo = [];

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/seals'
        })
            .success(function (data) {
                $scope.available = data;
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });

        $scope.move = function (from, selected, to) {
            angular.forEach(selected, function (item) {
                to.push(item);
                var index = from.indexOf(item);
                from.splice(index, 1)
            });
        };

        $scope.moveAll = function (from, to) {
            angular.forEach(from, function (item) {
                to.push(item);
            });
            from.length = 0;
        };


        /*coefficients box*/
        $scope.pump = {};
        $scope.pump.speedCorrectionCoefficients = [];
        
        $scope.add = function () {
            $scope.pump.speedCorrectionCoefficients.push({});
        };
        
        $scope.delete = function ($index) {
            $scope.pump.speedCorrectionCoefficients.splice($index, 1);
        };

        // Add Button
        $scope.doCreate = function () {

            $scope.pumpId = {
                list: []
            };

            $http({
                method: 'POST',
                url: '/pump/api/DataBaseManagement/create',
                data: $scope.pump
            })
                .success(function (data) {
                    $scope.pumpId = data;
                    // LOOKUP
                    $rootScope.addNotification('success', data);
                })
                .error(function (data) {
                    $rootScope.addNotification('warning', data);
                });
        };
    });
