app.controller('baseController' ,function($scope){/*构建父控制器*/
    $scope.searchEntity={};

    $scope.reloadList=function(){
        console.log($scope.searchEntity);
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }

    $scope.paginationConf={
        currentPage:1,
        totalItems:9999,
        itemsPerPage:9999,
        perPageOptions:[3,4,5,6,7,8,9,10],
        onChange: function(){
            $scope.reloadList();
        }
    }


});