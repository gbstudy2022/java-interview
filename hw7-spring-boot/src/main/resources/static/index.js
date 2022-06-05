(function() {
    angular
        .module('app', ['ngRoute','ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'students/students.html',
                controller: 'studentController'
            })
            .when('/update/:param1', {
                templateUrl: 'update/update.html',
                controller: 'updateController'
            });
    }

    function run($rootScope, $http){

    }
})();

angular.module('app').controller('indexController', function ($scope, $rootScope, $http, $location) {

});
