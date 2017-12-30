module.controller('UserController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		$controller('CoreController', {
	        $scope: $scope
	    });
		
		var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $http.defaults.headers.common[header] = token;
        console.log(token);
		
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