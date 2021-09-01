//服务层
app.service('evaluateService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../evaluate/findAll.do');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../evaluate/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../evaluate/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../evaluate/add.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../evaluate/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../evaluate/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});
