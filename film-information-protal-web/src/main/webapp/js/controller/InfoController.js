 //控制层 
app.controller('InfoController' ,function($scope,$controller,loginService,userService,filmService,typeService,filmDescService,evaluateService){
	
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

		if($scope.evalData.userId!=null) {
			$scope.evalData.filmId=$scope.film_id
			evaluateService.add($scope.evalData).success(
				function (response) {
					if (response.success){
						$scope.evalData.comment=null;
						//重新查询
						$scope.reloadList();//重新加载
					} else{
						alert(response.message);
					}
				}
			);
		}else {
			alert("登录后发布评论");
		}
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
		evaluateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数

				console.log($scope.list);
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
				$scope.filmTypeList=response;
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


	$scope.EnterSearch=function(text){
		console.log(text);
		$scope.searchEntity={filmType:text};
		$scope.reloadList();
	}

	$scope.filmForDesc=[];

	$scope.getDescForFilm=function(){
		filmDescService.findAll().success(
			function(response){
				$scope.filmForDesc = response;
			}
		)
	}

	$scope.getImage=function(data){
		for(var i =0;i<$scope.filmForDesc.length;i++){
			if(data==$scope.filmForDesc[i].filmId){
				return $scope.filmForDesc[i].filmImage;
			}
		}
	}

	$scope.getIntroduce=function(data){
		for(var i =0;i<$scope.filmForDesc.length;i++){
			if(data==$scope.filmForDesc[i].filmId){
				return $scope.filmForDesc[i].introduce;
			}
		}
	}

	$scope.UserInformation=[];

	$scope.getUserInformation=function(){
		userService.findAll().success(
			function(response){
				$scope.UserInformation = response;
				console.log($scope.UserInformation);
			}
		)
	}

	$scope.getNickname=function(data){
		for(var i =0;i<$scope.UserInformation.length;i++){
			if(data==$scope.UserInformation[i].userId){
				return $scope.UserInformation[i].nicknmae;
			}
		}
	}



	$scope.setInformation=function(){
		$scope.film_id = (window.location.href.split("?")[1]).split("=")[1];
		$scope.searchEntity={filmId:$scope.film_id};
		$scope.findOne($scope.film_id);
		$scope.reloadList();
	}

	$scope.evalData={};


	$scope.login=function(){
		loginService.login().success(
			function(response){
				userService.findOne(response.userId).success(
					function(response){
						$scope.evalData.userId= response.userId;
						console.log("login:"+$scope.evalData.userId);
					}
				);
			}
		)
	}
});	
