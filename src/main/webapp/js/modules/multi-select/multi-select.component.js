angular.module('multiSelect')
    .component('multiSelect', {
        templateUrl: '../js/modules/multi-select/multi-select.template.html',
        controller: ['$http', '$scope', function MultiSelectController($http, $scope) {
            $scope.orderProp = 'modelName';
            $scope.selectedFrom = [];
            $scope.perSelectedFrom = [];
            $scope.selectedTo = [];

            $http.get('/pump/api/DataBaseManagement/seals')
                .then(function (response) {
                    $scope.available = response.data;
                });

            $scope.move = function (from, selected, to) {
                angular.forEach(selected, function (item) {
                    to.push(item);
                    var index = from.indexOf(item);
                    from.splice(index, 1)
                });
            };

            $scope.moveAll = function (from, to) {
                angular.forEach(from, function (item) {
                    to.push(item);
                });
                from.length = 0;
            };
        }]
    });
