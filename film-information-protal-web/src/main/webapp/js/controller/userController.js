 //控制层 
app.controller('userController' ,function($scope,$controller   ,userService,loginService){
	
	$controller('baseController',{$scope:$scope});//继承
	
	//分页
	$scope.findPage=function(page,rows){			
		userService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		userService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
		var serviceObject;//服务层对象  				
		if($scope.entity.userId!=null){//如果有ID
			serviceObject=userService.update( $scope.entity ); //修改  
		}else{
			serviceObject=userService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					window.location.href='../login.html';
				}else{
					alert(response.message);
				}
			}		
		);				
	}

	$scope.update=function(){
		var serviceObject;//服务层对象
		if($scope.entity.userId!=null){//如果有ID
			serviceObject=userService.update( $scope.entity ); //修改
		}else{
			serviceObject=userService.add( $scope.entity  );//增加
		}
		serviceObject.success(
			function(response){
				if(response.success){
					alert(response.message);
				}else{
					alert(response.message);
				}
			}
		);
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		userService.dele( $scope.selectids ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		userService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	$scope.setCode=function(email){
		if(email!=null){
			userService.SetCode(email).success(
				function (response){
					if(response.success){
						alert(response.message);
					}else {
						alert(response.message);
					}
				}
			);
		}else {
			alert("输入邮箱");
		}

	}



	$scope.verification=function(accountCode,entity){
		userService.verification(accountCode,entity).success(
			function(response){
				if(response.success){
					alert("状态："+response.message);
				}else {
					alert("状态："+response.message);
				}
			}
		)
	}

	$scope.login=function(){
		loginService.login().success(
			function(response){
				userService.findOne(response.userId).success(
					function(response){
						$scope.entity= response;
					}
				);
			}
		)
	}

});	
