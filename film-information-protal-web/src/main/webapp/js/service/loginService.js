app.service('loginService',function($http){/*自定义服务*/


    this.login=function(){
        return $http.get('../login/name.do');
    }
});