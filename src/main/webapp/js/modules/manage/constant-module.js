/**
 * Created by GreenNun on 12.04.17.
 */
angular.module('pump.modules.constant')
    .controller('editPumpCtrl', function ($rootScope, $scope, $http) {

        $http({
            method: 'GET',
            url: '/pump/api/constant/list',
            params: {name: "country"}
        })
            .then(function (success) {
                $scope.constant_module = success.data;
            }, function (error) {
                $rootScope.addNotification('danger', error.data);
            });

        // var index = 451;
        // $scope.constant_module = [];
        //
        // $http({
        //     method: 'GET',
        //     url: '/pump/api/constant/one',// + index
        //     params: {id: index}
        // })
        //     .success(function (data) {
        //         $scope.constant_module[0] = data;
        //     })
        //     .error(function (data) {
        //         $rootScope.addNotification('danger', data);
        //     });


        $scope.doSave = function () {
            $http({
                method: 'POST',
                url: '/pump/api/constant/save',
                data: $scope.constant_module[0]
            })
                .then(function (success) {
                    $rootScope.addNotification('success', success.data);
                    $scope.constant_module[0] = success.data;
                }, function (error) {
                    $rootScope.addNotification('danger', error.data);
                });
        };

        // PRODUCER

        $http({
            method: 'GET',
            url: '/pump/api/producer/list'
        })
            .then(function (success) {
                $scope.constant_module_producer = success.data;
            }, function (error) {
                $rootScope.addNotification('danger', error.data);
            });

        $scope.doSaveProducer = function () {
            $http({
                method: 'POST',
                url: '/pump/api/producer/save',
                data: $scope.constant_module_producer[2]
            })
                .then(function (success) {
                    $rootScope.addNotification('success', success.data);
                    $scope.constant_module_producer[2] = success.data;
                }, function (error) {
                    $rootScope.addNotification('warning', error.data);
                })

        };
    });



