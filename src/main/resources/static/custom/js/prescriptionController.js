module.controller('PrescriptionController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		$controller('CoreController', {
	        $scope: $scope
	    });
		
		var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $http.defaults.headers.common[header] = token;
		
		$scope.init = function(id){
        	$scope.patientId = id;
        }
		
		$scope.submitted = false;
		
		$scope.prescriptionItem = [{"description":"","dose":"","othersDose":""}];
		
        $scope.addPrescription = function(prescription, form){
        	$scope.submitted = true;
        	
        	var data = {
        			"prescriptionItem":$scope.prescriptionItem,
        			"date":new Date(),
        			"doctorId":232323,
        			"patientId":$scope.patientId,
        			"comments":typeof prescription !='undefined'?prescription.comments:''
        	}
        	
        	if (form.$valid) {
               
	        	$http({
	                method: "POST",
	                url: "/rest/prescription/add",
	                data: data,
	            }).then(function mySucces(response) {
	            	
	            }, function myError(response) {
	               
	            });
        	}
        	
        }
		
		$scope.addMoreMedication = function(){
			$scope.prescriptionItem.push({"description":"","dose":"","othersDose":""});
		}
		
		$scope.removeMedication = function(index){
			$scope.prescriptionItem.splice(index, 1);
		}
		
		$scope.resetDoes = function(index){
			$('input:radio[name=doseOptions'+index+']').each(function () { $(this).prop('checked', false); });
		}

    }]);
    