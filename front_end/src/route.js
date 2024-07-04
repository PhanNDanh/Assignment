var myApp = angular.module("myApp", ["ngRoute"]);
myApp.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix(""),
    $routeProvider
      .when("/home", {
        templateUrl: "./pages/Home.html",
        controller: "GuestController"
      })
      .when("/charts/top-10", {
        templateUrl: "./pages/ChartsTop10.html",
        controller: "ChartsTop10Controller"
      })
      .when("/charts/top-10/exist", {
        templateUrl: "./pages/ChartsTop10Exist.html",
        controller: "ChartsTop10ExistController"
      })
      .when("/product-detail/:id", {
        templateUrl: "./pages/ViewProductDetail.html",
        controller: "ViewProductDetail"
      })
      .when("/my-cart", {
        templateUrl: "./pages/Cart.html",
        controller: "UserController"
      })
      .when("/manager/bill", {
        templateUrl: "./pages/ManageBill.html",
        controller: "ManageBillController"
      })
      .when("/manager/bill-detail/:code", {
        templateUrl: "./pages/BillDetailByCode.html",
        controller: "ViewBillDetailController"
      })
      .when("/manager/product-detail", {
        templateUrl: "./pages/ManageProductDetail.html",
        controller: "ADMController"
      })
      .when("/manager/product-detail/add", {
        templateUrl: "./pages/AddProductDetaill.html",
        controller: "ADMController"
      })
      .when("/manager/product-detail/:id", {
        templateUrl: "./pages/ProductDetailById.html",
        controller: "ADMController"
      })
      .when("/manager/product-detail/update/:id", {
        templateUrl: "./pages/UpdateProductDetail.html",
        controller: "ADMController"
      })
      .otherwise({
        redirectTo: "/home"
      })
})
myApp.controller("ADMController", ADMController);
myApp.controller("GuestController", GuestController);
myApp.controller("ViewProductDetail", ViewProductDetail);
myApp.controller("UserController", UserController);
myApp.controller("ManageBillController", ManageBillController);
myApp.controller("ViewBillDetailController", ViewBillDetailController);
myApp.controller("ChartsTop10Controller", ChartsTop10Controller);
myApp.controller("ChartsTop10ExistController", ChartsTop10ExistController);




