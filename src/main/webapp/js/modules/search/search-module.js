angular.module('pump.modules.search')
    .controller('searchCtrl', function($rootScope, $scope, $http, $timeout) {
        
        $scope.test = 'TEST';

        $scope.doSearch = function() {

            $scope.result = {
                list: []
            };

            $http({
                method: 'POST',
                url: '/pump/api/PumpSelectionService/search',
                data: $scope.search
            })
                .success(function (data, status) {
                    $scope.result = {
                        list: data
                    };
                })
                .error(function (data, status) {
                    $rootScope.addNotification('danger', data);
                });
        };

      

    });