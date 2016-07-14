angular.module('pump.modules.search')
    .controller('searchCtrl', function($rootScope, $scope, $http) {
        
        $scope.search = {
            pumpType: 'Internal Eccentric Gear Pump',
            casingMaterial: 'Cast Iron',
            sealType:'Packing',
            driverAssemblyType: 'Coupling',
            reliefValve: true,
            heatingJacket: false,
            explosionProof: false
        };

        $scope.doSearch = function() {

            $scope.result = {
                list: []
            };

            $http({
                method: 'POST',
                url: '/pump/api/PumpSelectionService/search',
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