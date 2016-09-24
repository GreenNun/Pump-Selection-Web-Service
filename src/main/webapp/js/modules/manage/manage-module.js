angular.module('pump.modules.manage')
    .controller('manageCtrl', function ($rootScope, $scope, $http) {

        // default values
        

        // $scope.doManage = function() {

        $scope.result = {
            list: []
        };

        $http({
            method: 'GET',
            url: '/pump/api/DataBaseManagement/constants'
            // url: '/pump/api/DataBaseManagement/list'
            // ,
            // data: $scope.manage
        })
            .success(function (data) {
                $scope.result = {
                    list: data
                };
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });
        // };

        $scope.getProducers = function () {

            $scope.producers = {
                list: []
            };

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
        };

        $scope.getSeals = function () {

            $scope.seals = {
                list: []
            };

            $http({
                method: 'GET',
                url: '/pump/api/DataBaseManagement/seals'
            })
                .success(function (data) {
                    $scope.seals = {
                        list: data
                    };
                })
                .error(function (data) {
                    $rootScope.addNotification('danger', data);
                });
        };


    });
