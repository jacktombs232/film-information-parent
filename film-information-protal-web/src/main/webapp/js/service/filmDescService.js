//服务层
app.service('filmDescService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../filmDesc/findAll.do');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../filmDesc/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../filmDesc/findOne.do?id='+id);
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../filmDesc/update.do',entity );
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../filmDesc/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});
