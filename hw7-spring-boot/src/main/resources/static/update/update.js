angular.module('app').controller('updateController', function ($scope, $rootScope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/app/api/v1/students/';

    $scope.loadStudent= function () {
        $http.get(contextPath + $routeParams.param1)
            .then(function successCallback(response) {
                $scope.student=response.data;
            }, function errorCallback(response) {
                console.log(response);
            });
    }

    $scope.back = function () {
        $location.path('/');
    }

    $scope.updateStudent = function () {
        $http.post(contextPath + 'update', $scope.student)
            .then(function successCallback(response) {
                $scope.loadStudent();
            }, function errorCallback(response) {
                console.log(response);
            });
    };

    $scope.loadStudent();
});