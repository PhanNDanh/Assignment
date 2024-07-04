function ViewProductDetail($http, $scope, $routeParams) {

    const GUEST_API = "http://localhost:26382/Assignment-Java5/guest/";
    const USER_API = "http://localhost:26382/Assignment-Java5/user/";

    var responseData = JSON.parse(localStorage.getItem('responseData'));


    var closeBtn = document.getElementsByClassName("close")[0];

    closeBtn.onclick = function () {
        var modal = document.getElementById("resetPasswordModal");
        modal.style.display = "none";
    };


    $scope.ProductDetailByIdResponse = {
        id: "",
        productName: "",
        categoryName: "",
        sizeName: "",
        colorName: "",
        materialName: "",
        price: 0,
        description: "",
    }

    $http.get(GUEST_API + "getProductDetail-response/" + $routeParams.id)
        .then(function (response) {
            $scope.ProductDetailByIdResponse = response.data.data;
        });

    $scope.addToCart = function () {
        $http.post(USER_API + "add-Product" + "/" + $routeParams.id + "?quantity=" + $scope.quantityByCart)
            .then(function (response) {
                if (response.data == false) {
                    alert("The quantity in stock is not enough !!!");
                }
                else {
                    alert("Add to cart successfully !!!");
                    var modal = document.getElementById("resetPasswordModal");
                    modal.style.display = "none";
                }
            })
    }
}