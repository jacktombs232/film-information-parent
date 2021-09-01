 //控制层 
app.controller('filmDescController' ,function($scope,$controller   ,filmDescService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		filmDescService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		filmDescService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		filmDescService.findOne(id).success(
			function(response){
				$scope.entity= response;
				$scope.entity.filmType=JSON.parse($scope.entity.filmType);
				$scope.entity.releaseDate=Date.parse($scope.entity.releaseDate);
			}
		);				
	}
	//保存 
	$scope.save=function(){				
		filmDescService.update( $scope.entity ).success(
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

	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		filmDescService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}


	$scope.doDownLoad=function (){
		window.location.href='../file/userDownload.do?name='+'影视信息';
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
