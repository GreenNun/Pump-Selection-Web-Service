angular.module('pump.modules.search')
    .controller('searchCtrl', function ($rootScope, $scope, $http) {

        // default values
        $scope.search = {
            pumpType: 'Internal Eccentric Gear Pump',
            casingMaterial: 'Cast Iron',
            sealType: 'Packing',
            driverAssemblyType: 'Coupling',
            reliefValve: "true",
            heatingJacket: "false",
            explosionProof: "false"
        };

        $scope.units = {
            capacity: "1"
        };

        // $http({
        //     method: 'GET',
        //     url: '/pump/api/select/constants'
        // })
        //     .success(function (data) {
        //         $scope.constants = data;
        //     })
        //     .error(function (data) {
        //         $rootScope.addNotification('danger', data);
        //     });

        $scope.doSearch = function () {

            $scope.result = {
                list: []
            };

            $http({
                method: 'POST',
                url: '/pump/api/select/search',
                data: $scope.search
            })
                .success(function (data) {
                    $scope.result = {
                        list: data
                    };
                })
                .error(function (data) {
                    $rootScope.addNotification('danger', data);
                });
        };
    });