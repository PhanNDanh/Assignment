function ForgotController($scope, $http, $location) {

    const USER_API = "http://localhost:26382/Assignment-Java5/user/";

    $scope.email = "";
    $scope.showErrorMessage = false;
    $scope.showErrorMessageCode = false;
    $scope.codeAutoGen = "";

    var closeBtn = document.getElementsByClassName("close")[0];
    
    closeBtn.onclick = function () {
        var modal = document.getElementById("resetPasswordModal");
        modal.style.display = "none";
    };

    $scope.checkEmail = function () {

        $http.post(USER_API + "checkEmail", $scope.email)
            .then(function (response) {
                if (response.data == true) {
                    var modal = document.getElementById("resetPasswordModal");
                    modal.style.display = "block";
                    $scope.showErrorMessage = false;

                    $http.post(USER_API + "sendMail", $scope.email)
                        .then(function () {

                        });

                }
                else {
                    $scope.showErrorMessage = true;
                }
            });

    };


    $scope.checkCode = function () {

        $http.post(USER_API + "checkCode", $scope.codeAutoGen)
            .then(function (response) {
                if (response.data == false) {
                    $scope.showErrorMessageCode = true;
                }
                else {
                    $location.path('/new-password');
                    $location.search('email', $scope.email);
                }
                $scope.codeAutoGen = "";
            });
    };


}