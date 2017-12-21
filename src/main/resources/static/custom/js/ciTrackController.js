//module = angular.module('ciTrackApp', ['ui.bootstrap']);
module.controller('CiTrackController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		$controller('CoreController', {
	        $scope: $scope
	    });
		
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $http.defaults.headers.common[header] = token;
	    console.log(token);
    
        
/*
        $scope.getSearchKey = function (val) {
            return $http.get('/rest/healthcare/search-autocomplete', {
                params: {
                    queryStr: val
                }
            }).then(function (response) {
                return response.data;
            });
        };

        
        $scope.addComment = function(comment, userId){
        	if(typeof $scope.isAuthenticated != 'undefined' && $scope.isAuthenticated){
	        	comment['rate'] = $scope.ratingPoints;
	        	comment['doctorId'] = $scope.doctorId; 
	        	comment['userId'] = userId;
	        	
	        	$http({
	                method: "POST",
	                url: "/rest/healthcare/comment-on-doctor",
	                data: comment,
	            }).then(function mySucces(response) {
	            	 $scope.initDoctorView($scope.doctorId);
	            }, function myError(response) {
	                $scope.myWelcome = response.statusText;
	            });
        	}
        	else{
        		window.location.href = 'healthcare/login';
        	}
        }*/

    }])
    