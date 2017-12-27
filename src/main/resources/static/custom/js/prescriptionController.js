module.controller('PrescriptionController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		$controller('CoreController', {
	        $scope: $scope
	    });
		
		$scope.submitted = false;
		
		$scope.prescriptionItem = [{"description":"","dose":""}]
		
        $scope.addPrescription = function(prescription, form){
        	$scope.submitted = true;
        	if (form.$valid) {
               
	        	$http({
	                method: "POST",
	                url: "/rest/prescription/add",
	                data: patient,
	            }).then(function mySucces(response) {
	            	
	            }, function myError(response) {
	               
	            });
        	}
        	
        }

    }])
    