function UserController($http, $scope, $window) {
    USER_API = "http://localhost:26382/Assignment-Java5/user/";

    $scope.listProducts = [];
    $scope.totalMoney = 0;

    var responseData = JSON.parse(localStorage.getItem('responseData'));

    var closeBtn = document.getElementsByClassName("close")[0];

    closeBtn.onclick = function () {
        var modal = document.getElementById("resetPasswordModal");
        modal.style.display = "none";
    };

    $scope.checkOut = function () {
        if ($scope.listProducts == null) {
            alert("Your shopping cart is empty");
        }
        else if (responseData == null) {
            alert("Please login to buy product");
        }
        else {
            var modal = document.getElementById("resetPasswordModal");
            modal.style.display = "block";
        }
    }

    $scope.order = function () {
        console.log(responseData);

        $http.post(USER_API + "create-Bill?idAccount=" + responseData.id)
            .then(function () {
                loadData();
                var modal = document.getElementById("resetPasswordModal");
                modal.style.display = "none";
                alert("Order Successfully !!!")
            })
    }


    function loadData() {
        $http.get(USER_API + "getAllProduct-InCart")
            .then(function (response) {
                $scope.listProducts = response.data.productsInCart;
                $scope.totalMoney = response.data.totalMoney;
            })
    };

    loadData();

    $scope.deleteFromCart = function (index) {
        var id = $scope.listProducts[index].productId;
        $http.delete(USER_API + "delete-Product/" + id)
            .then(function () {
                alert("Product deleted successfully !!!");
                $window.location.reload();
            })
    };

    $scope.deleteOne = function (index) {
        var id = $scope.listProducts[index].productId;
        $http.delete(USER_API + "delete-Product/" + id + "?quantity=" + 1)
            .then(function (response) {
                if (response.data == false) {
                    alert("There must be at least one product in the cart");
                }
                else {
                    loadData();
                }
            })
    }

    $scope.updateToCart = function (index, quantity) {
        var id = $scope.listProducts[index].productId;
        $http.post(USER_API + "update-Product" + "/" + id + "?quantity=" + quantity)
            .then(function (response) {
                if (response.data == false) {
                    alert("The quantity in stock is not enough !!!");
                }
                else {
                    alert("Product update successfully !!!");
                    loadData();
                }
            })
    }

    $scope.addOne = function (index) {
        var id = $scope.listProducts[index].productId;
        $http.post(USER_API + "add-Product" + "/" + id + "?quantity=" + 1)
            .then(function (response) {
                if (response.data == false) {
                    alert("The quantity in stock is not enough !!!");
                }
                else {
                    loadData();
                }
            })
    }

}