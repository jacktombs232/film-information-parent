 //控制层 
app.controller('filmController' ,function($scope,$controller   ,filmService,typeService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		filmService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		filmService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		filmService.findOne(id).success(
			function(response){
				$scope.entity= response;
				$scope.entity.filmType=JSON.parse($scope.entity.filmType);
				$scope.entity.releaseDate=Date.parse($scope.entity.releaseDate);
			}
		);				
	}
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象
		if($scope.entity.filmId!=null){//如果有ID
			serviceObject=filmService.update( $scope.entity ); //修改
			console.log("修改");
		}else{
			serviceObject=filmService.add( $scope.entity  );//增加
			console.log("增加");
			console.log($scope.entity);
		}
		serviceObject.success(
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
	$scope.dele=function(){
		//获取选中的复选框			
		filmService.dele($scope.selectids).success(
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
		filmService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}


	$scope.doDownLoad=function (){
		window.location.href='../file/userDownload.do?name='+'影视信息';
	}


	$scope.filmTypeList={data:[]};

	$scope.findfilmTypeList=function(){
		typeService.findfilmTypeList().success(
			function (response){
				$scope.filmTypeList={data:response};
				console.log($scope.filmTypeList);
			})
	}


	$scope.jsonToString=function(jsonstring,key){
		var json = JSON.parse(jsonstring);
		var value="";

		for(var i=0;i<json.length;i++){
			if(i>0){
				value+=",";
			}
			value+=json[i][key];
		}

		return value;
	}

    
});	
