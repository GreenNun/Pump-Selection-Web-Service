angular.module('pump.modules.search',
    []
);
angular.module('pump.modules.manage',
    []
);
angular.module('pump.modules.constant',
    []
);
angular.module('pump.modules.producer',
    []
);
angular.module('pump.modules.motor',
    []
);
angular.module('pump.modules.reducer',
    []
);
angular.module('pump.modules.frame',
    []
);
angular.module('pump.modules.seal',
    []
);
angular.module('pump.modules.assembly',
    []
);
angular.module('pump.modules.pump',
    [
        'tc.chartjs'
    ]
);
angular.module('pump.modules.route',
    [
        'ngRoute',
        'ngSanitize',
        'ngAnimate',
        'ui.router',
        'ui.bootstrap',
        'pump.modules.search',
        'pump.modules.manage',
        'pump.modules.constant',
        'pump.modules.producer',
        'pump.modules.motor',
        'pump.modules.reducer',
        'pump.modules.frame',
        'pump.modules.seal',
        'pump.modules.assembly',
        'pump.modules.pump'
    ]
);

angular.module('pump.modules.route')
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider',function ($stateProvider, $urlRouterProvider, $locationProvider) {
        $locationProvider.hashPrefix('');

        $stateProvider
            .state('main', {
                url: '',
                templateUrl: getViewPath('components/menu-main.html')
            })
            .state('main.search', {
                url: '/search',
                templateUrl: getViewPath('search.html'),
                controller: 'searchCtrl'
            })
            .state('main.manage.manage', {
                url: '/manage0',
                templateUrl: getViewPath('manage.html'),
                controller: 'manageCtrl'
            })
            // MANAGE
            .state('main.manage', {
                url: '/manage',
                templateUrl: getViewPath('components/menu-edit-left.html')
            })
            .state('main.manage.producers', {
                url: '/producers',
                templateUrl: getViewPath('manage/producer.html'),
                controller: 'producerCtrl'
            })
            .state('main.manage.motors', {
                url: '/motors',
                templateUrl: getViewPath('manage/motor.html'),
                controller: 'motorCtrl'
            })
            .state('main.manage.reducers', {
                url: '/reducers',
                templateUrl: getViewPath('manage/reducer.html'),
                controller: 'reducerCtrl'
            })
            .state('main.manage.frames', {
                url: '/frames',
                templateUrl: getViewPath('manage/frame.html'),
                controller: 'frameCtrl'
            })
            .state('main.manage.seals', {
                url: '/seals',
                templateUrl: getViewPath('manage/seal.html'),
                controller: 'sealCtrl'
            })
            .state('main.manage.assemblies', {
                url: '/assemblies',
                templateUrl: getViewPath('manage/assembly.html'),
                controller: 'assemblyCtrl'
            })
            .state('main.manage.pumps', {
                url: '/pumps',
                templateUrl: getViewPath('manage/pump.html'),
                controller: 'pumpCtrl'
            })
            .state('main.manage.countries', {
                url: '/countries',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'country',
                    constant: 'Country',
                    title: 'Countries Dictionary'
                }
            })
            .state('main.manage.pumpTypes', {
                url: '/pumpTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'pump type',
                    constant: 'Pump Type',
                    title: 'Pump Types Dictionary'
                }
            })
            .state('main.manage.sealTypes', {
                url: '/sealTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'seal type',
                    constant: 'Seal Type',
                    title: 'Seal Types Dictionary'
                }
            })
            .state('main.manage.materials', {
                url: '/materials',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'pump material',
                    constant: 'Material',
                    title: 'Pump Casting Materials Dictionary'
                }
            })
            .state('main.manage.sealMaterials', {
                url: '/sealMaterials',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'seal material',
                    constant: 'Seal O-Ring Material',
                    title: 'Seal Materials Dictionary'
                }
            })
            .state('main.manage.bushingMaterials', {
                url: '/bushingMaterials',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'bushing material',
                    constant: 'Bushing Material',
                    title: 'Bushing Materials Dictionary'
                }
            })
            .state('main.manage.connectionTypes', {
                url: '/connectionTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'connection type',
                    constant: 'Connection Type',
                    title: 'Connection Types Dictionary'
                }
            })
            .state('main.manage.dn', {
                url: '/dn',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'dn',
                    constant: 'DN Type',
                    title: 'DN Types Dictionary'
                }
            })
            .state('main.manage.connectionAngleTypes', {
                url: '/connectionAngleTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'connection angle type',
                    constant: 'Connection Angle Type',
                    title: 'Connection Angle Types Dictionary'
                }
            })
            .state('main.manage.pressures', {
                url: '/pressures',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'pressure limit',
                    constant: 'Pressure Limit',
                    title: 'Pressure Limits Dictionary'
                }
            })
            .state('main.manage.temperatures', {
                url: '/temperatures',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'temperature limit',
                    constant: 'Temperature Limit',
                    title: 'Temperature Limit Dictionary'
                }
            })
            .state('main.manage.driveAssemblyTypes', {
                url: '/driveAssemblyTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'drive assembly type',
                    constant: 'Drive Assembly Type',
                    title: 'Drive Assembly Types Dictionary'
                }
            })
            .state('main.manage.explosionProofTypes', {
                url: '/explosionProofTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'explosion proof',
                    constant: 'Explosion Proof Type',
                    title: 'Explosion Proof Types Dictionary'
                }
            })
            .state('main.manage.motorPowerTypes', {
                url: '/motorPowerTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'motor power',
                    constant: 'Motor Power Type',
                    title: 'Motor Power Types Dictionary'
                }
            })
            .state('main.manage.motorFrameSizes', {
                url: '/motorFrameSizes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'motor frame size',
                    constant: 'Motor Frame Size',
                    title: 'Motor Frame Sizes Dictionary'
                }
            })
            .state('main.manage.motorSpeedTypes', {
                url: '/motorSpeedTypes',
                templateUrl: getViewPath('manage/constant.html'),
                controller: 'constantCtrl',
                data: {
                    operation: 'motor speed',
                    constant: 'Motor Speed Type',
                    title: 'Motor Speed Types Dictionary'
                }
            });

        $urlRouterProvider.otherwise('/search');

        function getViewPath(view) {
            return '/pump/view/' + view;
        }

    }])

    .run(function ($rootScope, $timeout, $transitions) {


        $rootScope.state = {};
        $rootScope.success = 'Completed';
        $rootScope.error = 'Something goes wrong =(';

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
            $timeout(function () {
                $rootScope.cleanUpNotification();
            }, 1200);
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

        $transitions.onStart({}, function (trans) {
            $rootScope.cleanUpNotification();
            $rootScope.startViewReload();
            // trans.promise.finally($timeout(function () {
            //     $rootScope.stopViewReload();
            // }, 1000));
            trans.promise.finally($rootScope.stopViewReload());
        });
    });