 //控制层 
app.controller('evaluateController' ,function($scope,$controller   ,evaluateService,loginService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		evaluateService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){
		evaluateService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){
		evaluateService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
		evaluateService.add($scope.entity ).success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(id){
		console.log("controller"+id);
		evaluateService.dele(id).success(
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
		evaluateService.findAll().success(
			function(response){
				$scope.list=response;
			}
		);
	}

	$scope.doDownLoad=function (){
		window.location.href='../file/userDownload.do?name='+'评论详情';
	}

	$scope.EnterSearch=function(id){
		$scope.searchEntity={filmType:text};
		$scope.reloadList();
	}


	$scope.login=function(){
		loginService.login().success(
			function(response){
				$scope.searchEntity.userId=response.userId;
			}
		)
	}
    
});	
