angular.module('app').controller('studentController', function ($scope, $rootScope, $http, $location) {
    const contextPath = 'http://localhost:8189/app/api/v1/students/';

    $rootScope.loadStudents = function () {
        $http.get(contextPath)
            .then(function successCallback(response) {
                $rootScope.StudentList = response.data;
            }, function errorCallback(response) {
                console.log(response);
            });
    }

    $rootScope.delete = function (id) {
        $http.get(contextPath + 'delete/' + id)
            .then(function successCallback(response) {
                $rootScope.loadStudents();
            }, function errorCallback(response) {
                console.log(response);
            });
    }

    $rootScope.addStudent = function () {
        $rootScope.newStudent=$scope.newStudent;
        $http.post(contextPath, $rootScope.newStudent)
            .then(function successCallback(response) {
                $rootScope.newStudent = undefined;
                $scope.newStudent = undefined;
                $rootScope.loadStudents();
            }, function errorCallback(response) {
                console.log(response);
            });
    };

    $rootScope.update = function (id) {
        $location.path('/update/'+id);
    }


    $rootScope.loadStudents();
});