 //控制层 
app.controller('briefController' ,function($scope,$controller,userService,filmService,typeService,evaluateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAlluser=function(){
		userService.countNumber().success(
			function(response){
				$scope.usercount=response;
			}			
		);
	}

	//读取列表数据绑定到表单中
	$scope.findAllevaluate=function(){
		evaluateService.countNumber().success(
			function(response){
				$scope.evaluatecount=response;
			}
		);
	}

	//读取列表数据绑定到表单中
	$scope.findAllfilm=function(){
		filmService.countNumber().success(
			function(response){
				$scope.filmcount=response;
			}
		);
	}

	//读取列表数据绑定到表单中
	$scope.findAlltype=function(){
		typeService.countNumber().success(
			function(response){
				$scope.typecount=response;
			}
		);
	}


	$scope.all=function(){
		$scope.findAlluser();
		$scope.findAllfilm();
		$scope.findAlltype();
		$scope.findAllevaluate();
	}

});
