function NewPasswordController($http, $routeParams, $scope, $location) {

    USER_API = "http://localhost:26382/Assignment-Java5/user/";

    $scope.UpdatePasswordRequest = {
        email: $routeParams.email,
        password1: "",
        password2: ""

    }

    $scope.modalVisible = true;

    $scope.updatePassword = function () {
        $http.put(USER_API + "update-paswordByEmail", $scope.UpdatePasswordRequest)
            .then(function (response) {
                if (response.data == true) {
                    $scope.modalVisible = false;
                    alert("Update successfully !!!");
                    $location.path('/login').search('email', null);
                }
                else {
                    alert("Pass word false !!!");
                }
            })
    }

}