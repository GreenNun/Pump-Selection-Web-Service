angular.module('pump.modules.manage')
    .controller('manageCtrl', function ($rootScope, $scope, $http) {

        // used by coeff box
        $scope.pump = {};

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

        /*coefficients box*/
        $scope.pump.speedCorrectionCoefficients = [];

        $scope.add = function () {
            $scope.pump.speedCorrectionCoefficients.push({});
        };

        $scope.delete = function ($index) {
            $scope.pump.speedCorrectionCoefficients.splice($index, 1);
        };

        /*seals box*/
        $scope.sealsBoxOrderProp = 'id';
        $scope.sealsBoxSelectedFrom = [];
        $scope.sealsBoxPerSelectedFrom = [];
        $scope.sealsBoxSelectedTo = [];

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/seals'
        })
            .success(function (data) {
                $scope.sealsBoxAvailable = data;
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });

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

        /*frames box*/
        $scope.framesBoxOrderProp = 'id';
        $scope.framesBoxSelectedFrom = [];
        $scope.framesBoxPerSelectedFrom = [];
        $scope.framesBoxSelectedTo = [];

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/frames'
        })
            .success(function (data) {
                $scope.framesBoxAvailable = data;
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });

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

        /*driverAssemblies box*/
        $scope.driverAssembliesBoxOrderProp = 'id';
        $scope.driverAssembliesBoxSelectedFrom = [];
        $scope.driverAssembliesBoxPerSelectedFrom = [];
        $scope.driverAssembliesBoxSelectedTo = [];

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/assemblies'
        })
            .success(function (data) {
                $scope.driverAssembliesBoxAvailable = data;
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });

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

        // Create Button
        $scope.pump.seals = [];
        $scope.pump.frames = [];
        $scope.pump.driverAssemblies = [];

        $scope.doCreate = function () {
            // copy seals. frames and assemblies id's to request
            angular.forEach($scope.sealsBoxSelectedFrom, function (item) {
                $scope.pump.seals.push(item.id);
            });
            angular.forEach($scope.framesBoxSelectedFrom, function (item) {
                $scope.pump.frames.push(item.id);
            });
            angular.forEach($scope.driverAssembliesBoxSelectedFrom, function (item) {
                $scope.pump.driverAssemblies.push(item.id);
            });

            $http({
                method: 'POST',
                url: '/pump/api/DataBaseManagement/create',
                data: $scope.pump
            })
                .success(function (data) {
                    $rootScope.addNotification('success', data);
                })
                .error(function (data) {
                    $rootScope.addNotification('warning', data);
                })
                .then(function () {
                    // empty array after request sent
                    $scope.pump.seals.length = 0;
                    $scope.pump.frames.length = 0;
                    $scope.pump.driverAssemblies.length = 0;
                });
        };
    });
