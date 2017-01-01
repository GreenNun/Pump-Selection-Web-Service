angular.module('itemsAppender', []);

angular.module('itemsAppender', [])
    .controller('itemsAppenderController', ['$scope', '$http', function ($scope, $http) {

        $http.get('/pump/api/DataBaseManagement/seals')
            .then(function (response) {
                $scope.available = response.data;
            });

        $scope.add = function () {
            $scope.available.push({
                "age": 0,
                "id": "test",
                "imageUrl": "test",
                "name": "test",
                "snippet": "test"
            });
        };

        $scope.delete = function (index) {
            $scope.available.splice(index, 1);
        };
    }])
    .directive('parametersAppender', function () {
        return {
            templateUrl: '../js/modules/items-appender/items-appender.template.html'
        };
    });