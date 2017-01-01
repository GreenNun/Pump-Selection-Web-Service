angular.module('pump.modules.search',
    []
);

angular.module('pump.modules.manage',
    [
        'dualListBoxMultiSelect',
        'itemsAppender'
    ]
);

angular.module('pump.modules.route',
    [
        'ngRoute',
        'ui.bootstrap',
        'ngSanitize',
        'pump.modules.search',
        'pump.modules.manage'
    ]
);

angular.module('pump.modules.route')
    .config(function ($routeProvider) {

        function getViewPath(view) {
            return '/pump/view/' + view;
        }

        $routeProvider
            .when('/search', {
                templateUrl: getViewPath('search.html'),
                controller: 'searchCtrl'
            })

            .when('/manage', {
                templateUrl: getViewPath('manage.html'),
                controller: 'manageCtrl'
            })

            .otherwise({
                redirectTo: '/search'
            });
    })

    .run(function ($rootScope) {


        $rootScope.state = {};

        $rootScope.startViewReload = function () {
            $rootScope.state.viewReload = true;
        };

        $rootScope.stopViewReload = function () {
            $rootScope.state.viewReload = false;
        };

        $rootScope.cleanUpNotification = function () {
            $rootScope.state.notification = undefined;
        };

        $rootScope.showPostReloadNotification = function () {
            $rootScope.state.notification = $rootScope.state.postReloadNotification;
            $rootScope.state.postReloadNotification = undefined;
        };

        $rootScope.addNotification = function (type, message, hideView) {
            $rootScope.state.notification = {
                type: type,
                message: message,
                hideView: hideView || false
            };
        };

        $rootScope.addPostReloadNotification = function (type, message, hideView) {
            $rootScope.state.postReloadNotification = {
                type: type,
                message: message,
                hideView: hideView || false
            };
        };

        //Global route events
        $rootScope.$on('$routeChangeStart', function (next, current) {
            $rootScope.cleanUpNotification();
            $rootScope.startViewReload();
        });

        $rootScope.$on('$routeChangeError', function (event, current, previous, rejection) {

            $rootScope.showPostReloadNotification();
            $rootScope.stopViewReload();

            if (rejection.status == 500) {
                $rootScope.addNotification('danger', 'Internal server error: "' + rejection.data + '"', true);
            } else if (rejection.status == 400) {
                var headerError = rejection.headers("error-msg");
                if (headerError) {
                    $rootScope.addNotification('danger', 'Unable to get data: "' + headerError + '"', true);
                } else {
                    $rootScope.addNotification('danger', 'Unable to get data: "' + rejection.data + '"', true);
                }
            } else {
                $rootScope.addNotification('danger', 'Service error, code: "' + rejection.status + '"', true);
            }
        });

        $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
            $rootScope.showPostReloadNotification();
            $rootScope.stopViewReload();
        });
    });