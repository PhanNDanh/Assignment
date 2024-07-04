function ADMController($scope, $http, $routeParams) {


    const ADM_API = "http://localhost:26382/Assignment-Java5/admin/";

    $scope.listProductDetail = [];

    $scope.currentPage = "";
    $scope.productName = "";
    $scope.price1 = "";
    $scope.price2 = "";
    $scope.categoryName = "";
    $scope.sizeName = "";
    $scope.colorName = "";
    $scope.materialName = "";

    $http.get(ADM_API + "getAll-Product")
        .then(function (response) {
            $scope.listProduct = response.data;
        })

    $http.get(ADM_API + "getAll-Category")
        .then(function (response) {
            $scope.listCategory = response.data;
        })

    $http.get(ADM_API + "getAll-Color")
        .then(function (response) {
            $scope.listColor = response.data;
        })

    $http.get(ADM_API + "getAll-Material")
        .then(function (response) {
            $scope.listMaterial = response.data;
        })

    $http.get(ADM_API + "getAll-Size")
        .then(function (response) {
            $scope.listSize = response.data;
        })

    $http.get(ADM_API + "findAll-ProductDetail")
        .then(function (response) {
            $scope.listProductDetail = response.data.list;
            $scope.PageProperties = response.data;
        });

    function loadProductDetail() {
        $http.get(ADM_API + "findAll-ProductDetail-response?currentPage=" + $scope.currentPage + "&productName=" + $scope.productName + "&categoryName=" +
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

    $scope.AddProductDetailRequest = {
        productId: "",
        categoryId: "",
        sizeId: "",
        colorId: "",
        materialId: "",
        price: 0,
        quantity: 0,
        description: ""
    }

    $scope.addProductDetail = function (event) {
        $http.post(ADM_API + "add-ProductDetail", $scope.AddProductDetailRequest)
            .then(function () {
                alert("Add successfully !!!");
            })
    }

    var id = $routeParams.id || "";

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

    $http.get(ADM_API + "getProductDetail-response/" + id)
        .then(function (response) {
            $scope.ProductDetailByIdResponse = response.data.data;
        });

    $scope.UpdateProductDetailRequest = {
        productId: "",
        categoryId: "",
        sizeId: "",
        colorId: "",
        materialId: "",
        price: 0,
        quantity: 0,
        description: "",
        _CreatedDate: "",
        _LastModifiedDate: "",
        isDelete: ""
    }

    $http.get(ADM_API + "getProductDetail/" + id)
        .then(function (response) {
            $scope.UpdateProductDetailRequest = response.data.data;
        });

    $scope.updateProductDetail = function (event) {
        $http.put(ADM_API + "update-ProductDetail/" + id, $scope.UpdateProductDetailRequest)
            .then(function () {
                alert("Update successfully !!!");
            })
    }

    $scope.deleteProductDetail = function (index) {
        $http.delete(ADM_API + "delete-ProductDetail/" + $scope.listProductDetail[index].id)
            .then(function () {
                alert("Delete successfully");
                loadProductDetail();
            })
    }
}