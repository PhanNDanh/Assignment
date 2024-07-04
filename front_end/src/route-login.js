var myApp = angular.module("myApp-Login", ["ngRoute"]);
myApp.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix(""),
    $routeProvider
      .when("/login", {
        templateUrl: "./pages/Login.html",
        controller: "LoginController"
      })
      .when("/forgot-password", {
        templateUrl: "./pages/ForgotPassword.html",
        controller: "ForgotController"
      })
      .when("/register", {
        templateUrl: "./pages/Register.html",
        controller: "LoginController"
      })
      .when("/new-password", {
        templateUrl: "./pages/NewPassword.html",
        controller: "NewPasswordController"
      })
      .otherwise({
        redirectTo: "/login"
      })
})
myApp.controller("LoginController", LoginController);
myApp.controller("ForgotController", ForgotController);
myApp.controller("NewPasswordController", NewPasswordController);



