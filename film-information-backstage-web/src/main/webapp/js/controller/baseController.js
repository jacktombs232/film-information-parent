app.controller('baseController' ,function($scope){/*构建父控制器*/
    $scope.searchEntity={};

    $scope.reloadList=function(){
        console.log($scope.searchEntity);
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }

    $scope.paginationConf={
        currentPage:1,
        totalItems:5,
        itemsPerPage:5,
        perPageOptions:[3,4,5,6,7,8,9,10],
        onChange: function(){
            $scope.reloadList();
        }
    }
    $scope.selectids=[];

    $scope.selectOption=function($event,id){
        console.log(id);
        if($event.target.checked){
            $scope.selectids.push(id);
        }else{
            var idx = $scope.selectids.indexOf(id);
            $scope.selectids.splice(idx,1);
        }

        console.log($scope.selectids);
    }




});