 //控制层 
app.controller('playerController' ,function($scope,$controller,teamService,playerService,schoolService){
	
	$controller('baseController',{$scope:$scope});//继承

	$scope.findSchool = function(){
		schoolService.findAll().success(function (response) {
                $scope.sList=response;
        })
        teamService.findAll().success(function (response) {
            $scope.tList=response;
        })

	}
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		playerService.findAll().success(
			function(response){
				$scope.list=response;
			}
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		playerService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		playerService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=playerService.update( $scope.entity ); //修改  
		}else{
			serviceObject=playerService.add( $scope.entity  );//增加 
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
        alert($scope.selectIds)
		//获取选中的复选框			
		playerService.dele( $scope.selectIds ).success(

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
		playerService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
