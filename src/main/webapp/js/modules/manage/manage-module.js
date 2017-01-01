angular.module('pump.modules.manage')
    .controller('manageCtrl', function ($rootScope, $scope, $http) {

        $scope.constants = {
            list: []
        };

        $scope.producers = {
            list: []
        };

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/constants'
        })
            .success(function (data) {
                $scope.constants = {
                    list: data
                };
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/producers'
        })
            .success(function (data) {
                $scope.producers = {
                    list: data
                };
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });
    });
