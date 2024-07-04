function ManageBillController($http,$scope){

    ADM_API = "http://localhost:26382/Assignment-Java5/admin/";

    $scope.listBill = [];

    $http.get(ADM_API+"findAll-Order-response")
    .then(function(response){
        console.log(response.data);
        $scope.listBill = response.data;
    })
}