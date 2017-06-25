angular.module('pump.modules.search')
    .controller('searchCtrl', function ($rootScope, $scope, $http) {

        // default values
        $scope.search = {
            pumpType: 'Internal Eccentric Gear Pump',
            casingMaterial: 'Cast Iron',
            sealType: 'Packing',
            driveAssemblyType: 'Coupling',
            reliefValve: "true",
            heatingJacket: "false",
            explosionProof: "false"
        };

        $scope.units = {
            capacity: "1"
        };

        $http({
            method: 'GET',
            url: '/pump/api/select/constants'
        })
            .then(function (success) {
                $scope.constants = success.data;
            }, function (error) {
                $rootScope.addNotification('danger', error.data);
            });

        $scope.doSearch = function () {

            $scope.result = {
                list: []
            };

            $http({
                method: 'POST',
                url: '/pump/api/select/search',
                data: $scope.search
            })
                .then(function (success) {
                    $scope.result = {
                        list: success.data
                    };
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };
    });