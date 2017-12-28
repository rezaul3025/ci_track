module.controller('UserController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		$controller('CoreController', {
	        $scope: $scope
	    });
		
		$scope.titles = ["Mr.","Mrs.","Miss","Dr.","Prof.","Mr. Dr.","Mrs. Dr.","Miss. Dr.","Prof. Dr."]
		
		$scope.designations = ["Doctor","Others"]
		
		$scope.submitted = false;
		
        $scope.addUser = function(user, form){
        	$scope.submitted = true;
        	
        	if (form.$valid) {
               
	        	$http({
	                method: "POST",
	                url: "/rest/user/add",
	                data: user,
	            }).then(function mySucces(response) {
	            	
	            }, function myError(response) {
	               
	            });
        	}
        	
        }
    }]);