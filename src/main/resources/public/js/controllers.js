angular.module('app.controllers', [])
    .controller('RegisterController', function ($scope, $http) {
        $scope.user = {};
        $scope.showrole = false;
        $scope.show = true;
        $scope.required = true;
        $scope.roles = ['ROLE_USER', 'ROLE_ADMIN'];
        $scope.registerUser = function () {
            if ($scope.user.password != $scope.user.confirmpassword)
                $scope.error = 'Password Not Matching';
            else
                $http.post('register', $scope.user).success(function (res) {
                    $scope.success = 'Registration successful!';
                    $scope.user = {};
                }).error(function (error) {
                    $scope.error = error.message;
                });
        }
    })
    .controller('UserListController', function ($scope, $state, popupService, $window, User, AuthService) {
        $scope.users = User.query();
        $scope.cancreate = false;
        if (!AuthService.user)
            $scope.message = 'You are not logged in.';
        else
            $scope.cancreate = AuthService.user.principal.role == 'ROLE_ADMIN';

        $scope.deleteUser = function (user) {
            if (popupService.showPopup('Really delete this?')) {
                user.$delete(function () {
                    $scope.users = User.query();
                    $state.go('users');
                });
            }
        };

    })
    .controller('UserViewController', function ($scope, $stateParams, User) {
        $scope.user = User.get({id: $stateParams.id});
    })
    .controller('UserCreateController', function ($scope, $state, $stateParams, User) {
        $scope.roles = ['ROLE_USER', 'ROLE_ADMIN'];
        $scope.showrole = true;
        $scope.show = true;
        $scope.required = true;
        $scope.user = new User();

        $scope.addUser = function () {
            $scope.user.$save(function () {
                $scope.success = 'User created';
                $state.go('users');
            });
        };
    })
    .controller('UserEditController', function ($scope, $state, $stateParams, User, AuthService) {
        $scope.userid = AuthService.user.principal.id;
        $scope.show = $state.current.name == 'editUser' && $state.params.id == $scope.userid;
        $scope.required = $state.params.id == $scope.userid;
        $scope.showrole = AuthService.user.principal.role == 'ROLE_ADMIN';
        $scope.roles = ['ROLE_USER', 'ROLE_ADMIN'];
        $scope.$state = $state;
        $scope.updateUser = function () {
            $scope.user.$update(function () {
                $state.go('users');
            });
        };

        $scope.loadUser = function () {
            $scope.user = User.get({id: $stateParams.id});
        };

        $scope.loadUser();
    })
    .controller('SuperiorListController', function ($scope, $state, popupService, $window, Superior, AuthService) {
        $scope.superiors = Superior.query();

        if (!AuthService.user)
            $scope.message = 'You are not logged in.';

        $scope.deleteSuperior = function (superior) {
            if (popupService.showPopup('Really delete this?')) {
                superior.$delete(function () {
                    $scope.superiors = Superior.query();
                    $state.go('superiors');
                });
            }
        };
    })
    .controller('SuperiorViewController', function ($scope, $stateParams, Superior) {
        $scope.superior = Superior.get({id: $stateParams.id});
    })
    .controller('ChiefCreateController', function ($scope, $state, $stateParams, Superior) {
        $scope.superior = new Superior();
        $scope.addSuperior = function () {
            $scope.superior.$save(function () {
                $state.go('superiors');
            });
        };
    })
    .controller('SuperiorEditController', function ($scope, $state, $stateParams, Superior) {
        $scope.updateSuperior = function () {
            $scope.superior.$update(function () {
                $state.go('superiors');
            });
        };

        $scope.loadSuperior = function () {
            $scope.category = Superior.get({id: $stateParams.id});
        };

        $scope.loadSuperior();
    })


    .controller('EmployeeListController', function ($rootScope, $scope, $state, popupService, $window, Employee, AuthService) {
        $scope.employees = Employee.query();
        if (!AuthService.user)
            $scope.message = 'You are not logged in.';
        $scope.deleteEmployee = function (employee) {
            if (popupService.showPopup('Really delete this?')) {
                employee.$delete(function () {
                    $scope.employees = Employee.query();
                    $state.go('employees');
                });
            }
        };
    })
    .controller('EmployeeViewController', function ($scope, $stateParams, Employee) {
        $scope.employee = Employee.get({id: $stateParams.id});
    })
    .controller('EmployeeCreateController', function ($scope, $state, $stateParams, Employee, Superior) {
        $scope.superiors = Superior.query();
        $scope.employees = new Employee();
        $scope.addEmployee = function () {
            $scope.employee.$save(function () {
                $state.go('employees');
            });
        };
    })
    .controller('EmployeeEditController', function ($scope, $state, $stateParams, Employee, Superior) {
        $scope.superiors = Superior.query();
        $scope.updateEmployee = function () {
            $scope.employee.$update(function () {
                $state.go('employees');
            });
        };

        $scope.loadEmployee = function () {
            $scope.employee = Employee.get({id: $stateParams.id});
        };

        $scope.loadEmployee();
    });
