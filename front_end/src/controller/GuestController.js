function GuestController($scope, $http, $location) {

    const GUEST_API = "http://localhost:26382/Assignment-Java5/guest/";

    var responseData = JSON.parse(localStorage.getItem('responseData'));

    $scope.username = responseData !== null ? responseData.userName : "guest";

    $scope.logout = function () {
        localStorage.removeItem('responseData');
        console.log(responseData);
    };

    $scope.viewManageProduct = function () {
        if (responseData == null || responseData.role == false) {
            alert("You do not have permission to access this page");
        }
        else {
            $location.path('/manager/product-detail');
        }
    }

    $scope.viewManageBill = function () {
        if (responseData == null || responseData.role == false) {
            alert("You do not have permission to access this page");
        }
        else {
            $location.path('/manager/bill');
        }
    }

    $scope.viewManageCharts = function () {
        if (responseData == null || responseData.role == false) {
            alert("You do not have permission to access this page");
        }
        else {
            $location.path('/charts/top-10');
        }
    }

    $scope.viewManageChartsExist = function () {
        if (responseData == null || responseData.role == false) {
            alert("You do not have permission to access this page");
        }
        else {
            $location.path('/charts/top-10/exist');
        }
    }

    $scope.listProductDetail = [];

    $scope.currentPage = "";
    $scope.productName = "";
    $scope.price1 = "";
    $scope.price2 = "";
    $scope.categoryName = "";
    $scope.sizeName = "";
    $scope.colorName = "";
    $scope.materialName = "";

    $http.get(GUEST_API + "getAll-Product")
        .then(function (response) {
            $scope.listProduct = response.data;
        })

    $http.get(GUEST_API + "getAll-Category")
        .then(function (response) {
            $scope.listCategory = response.data;
        })

    $http.get(GUEST_API + "getAll-Color")
        .then(function (response) {
            $scope.listColor = response.data;
        })

    $http.get(GUEST_API + "getAll-Material")
        .then(function (response) {
            $scope.listMaterial = response.data;
        })

    $http.get(GUEST_API + "getAll-Size")
        .then(function (response) {
            $scope.listSize = response.data;
        })

    function loadProductDetail() {
        $http.get(GUEST_API + "findAll-ProductDetail-response?currentPage=" + $scope.currentPage + "&productName=" + $scope.productName + "&categoryName=" +
            $scope.categoryName + "&colorName=" + $scope.colorName + "&sizeName=" + $scope.sizeName + "&materialName=" + $scope.materialName + "&price1=" + $scope.price1 + "&price2=" + $scope.price2)
            .then(function (response) {
                $scope.listProductDetail = response.data.list;
                $scope.PageProperties = response.data;
            });
    }

    loadProductDetail();

    $scope.onNameChange = function () {
        loadProductDetail();
    }

    $scope.selectedPriceRange = "";

    $scope.onPriceChange = function () {
        var rangeValues = $scope.selectedPriceRange.split('-');
        $scope.price1 = parseInt(rangeValues[0]);
        $scope.price2 = parseInt(rangeValues[1]);
        loadProductDetail();
    };

    $scope.onCategoryChange = function () {
        loadProductDetail();
    }

    $scope.onSizeChange = function () {
        loadProductDetail();
    }

    $scope.onColorChange = function () {
        loadProductDetail();
    }

    $scope.onMaterialChange = function () {
        loadProductDetail();
    }

    $scope.prePage = function () {
        if ($scope.currentPage > 1) {
            $scope.currentPage--;
            loadProductDetail();
        }
    };

    $scope.nextPage = function () {
        if ($scope.currentPage < $scope.PageProperties.totalPages) {
            $scope.currentPage++;
            loadProductDetail();
        }
    };

    $scope.lastPage = function () {
        $scope.currentPage = $scope.PageProperties.totalPages;
        loadProductDetail();
    };

}