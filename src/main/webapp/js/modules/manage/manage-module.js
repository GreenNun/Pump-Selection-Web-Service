angular.module('pump.modules.manage')
    .controller('manageCtrl', function($rootScope, $scope, $http) {

        // // some default values
        // $scope.manage = {
        //   
        // };

        // $scope.doManage = function() {

            $scope.result = {
                list: []
            };

            $http({
                method: 'GET',
                url: '/pump/api/DataBaseManagement/list'
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



    });
