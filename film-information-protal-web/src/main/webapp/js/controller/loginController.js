//控制层
app.controller('loginController' ,function($scope,$controller   ,loginService) {

    $controller('baseController', {$scope: $scope});//继承

    nickName=null;

    $scope.login=function(){
        loginService.login().success(
            function(response){
               $scope.nickName=response.nickname;
            }
        )
    }

});