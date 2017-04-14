/**
 * Created by GreenNun on 12.04.17.
 */
angular.module('pump.modules.constant')
    .controller('editPumpCtrl', function ($rootScope, $scope, $http) {

        $http({
            method: 'GET',
            url: '/pump/api/constant/list'
        })
            .success(function (data) {
                $scope.constants = data;
            })
            .error(function (data) {
                $rootScope.addNotification('danger', data);
            });


        $scope.doSave = function () {
            $http({
                method: 'POST',
                url: '/pump/api/constant/save',
                data: $scope.constants[0]
            })
                .success(function (data) {
                    $rootScope.addNotification('success', data);
                    $scope.constants[0] = data;
                })
                .error(function (data) {
                    $rootScope.addNotification('warning', data);
                })

        };

    });



