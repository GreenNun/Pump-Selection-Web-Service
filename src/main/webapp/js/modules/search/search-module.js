angular.module('pump.modules.search')
    .controller('searchCtrl', function($rootScope, $scope, $http) {
        
        // $scope.test = 'TEST';
        // $scope.search = {
        //     medium: 'default-medium'
        // };
        // $scope.search = {
        //     value: 'default-name'
        //     };

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