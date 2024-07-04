function ViewBillDetailController($http, $scope, $routeParams) {

    ADM_API = "http://localhost:26382/Assignment-Java5/admin/";

    $scope.listBillDetail = [];

    $http.get(ADM_API + "findAll-OrderDetail-ByCode-response?code=" + $routeParams.code)
        .then(function (response) {
            $scope.listBillDetail = response.data;
        })

}