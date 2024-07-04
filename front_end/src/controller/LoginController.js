function LoginController($scope, $http, $window,) {

    const USER_API = "http://localhost:26382/Assignment-Java5/user/";

    $scope.AccountLoginRequest = {
        username: "",
        password: ""
    }

    $scope.login = function () {
        console.log($scope.AccountLoginRequest);
        $http.post(USER_API + "checkAccount-response", $scope.AccountLoginRequest)
            .then(function (response) {
                console.log(response.data);
                if (response.data.data != null) {
                    localStorage.setItem('responseData', JSON.stringify(response.data.data));
                    alert("Loggin in successfully !!!")
                    $window.open("/src/index.html");
                }
                else {
                    alert("Login failed ")
                }
            })
    }

    $scope.loginAsGuest = function () {
        $window.open("/src/index.html");
    }

}