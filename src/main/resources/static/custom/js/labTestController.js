module.controller('LabTestController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		$controller('CoreController', {
	        $scope: $scope
	    });
		
		var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $http.defaults.headers.common[header] = token;
		
		$scope.init = function(id, userId){
        	$scope.patientId = id;
        	
        	$scope.patientById(id);
        	
        	$scope.userId = userId;
        }
		
		$scope.submitted = false;
		
		$scope.prescriptionItem = [{"description":"","dose":"","othersDose":""}];
		
        $scope.addBloodTest = function(prescription, form){
        	$scope.submitted = true;
        	
        	var data = {
        			"prescriptionItem":$scope.prescriptionItem,
        			"date":new Date(),
        			"doctorId":$scope.userId,
        			"patientId":$scope.patientId,
        			"modifiedDate":null,
        			"modifiedById":null,
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
        	
        };
		
		$scope.labBloodTestStValues = [
		   {
			   "name":"Sodium (Na)",
			   "unit":[{"name":"mmol/L","value":["135-145","137-147"]},{"name":"mg/dl","value":["310-330","320-340"]}]
		   },
		   {
				"name":"Potassium (K)",
				"unit":[{"name":"mmol/L","value":["3.5-5.0","3.6-5.1"]},{"name":"mg/dl","value":["14-20"]}]
		   },
		   {
				"name":"Chloride (Cl)",
				"unit":[{"name":"mmol/L","value":["95-105","98-106","100-110"]},{"name":"mg/dl","value":["340-370"]}]
		   },
		   {
				"name":"Ionized calcium (Ca)",
				"unit":[{"name":"mmol/L","value":["1.03-1.23","1.10-1.30"]},{"name":"mg/dl","value":["4.1-4.9","4.4-5.2"]}]
		   },
		   {
				"name":"Total calcium (Ca)",
				"unit":[{"name":"mmol/L","value":["2.1-2.5","2.2-2.6"]},{"name":"mg/dl","value":["8.4-10.2","8.5-10.5"]}]
		   },
		   {
				"name":"Total serum iron (TSI) – male",
				"unit":[{"name":"µg/dL","value":["65-176","76-198"]},{"name":"μmol/L","value":["11.6-30","13.6-32"]}]
		   },
		   {
				"name":"Total serum iron (TSI) – female",
				"unit":[{"name":"µg/dL","value":["26-170","76-198"]},{"name":"μmol/L","value":["4.6-30.4"]}]
		   }
		];
		
		$scope.labBloodTestResults = [{"name":"","stdValues":"","selectedStdValues":"","units":"","unitSelected":"","result":""}];
		
		$scope.loadSelectedTestDetials = function(item, model, label, event, index){
			var units = [];
			for(u in item.unit){
				units.push(item.unit[u].name);
			}
			
			$scope.labBloodTestResults[index]['units']=units;
			
			$scope.labBloodTestResults[index]['unitsArrOb']=item.unit;
			
			for(var lbt in $scope.labBloodTestStValues){
				for(var lbtr in $scope.labBloodTestResults){
					if($scope.labBloodTestStValues[lbt].name==$scope.labBloodTestResults[lbtr].name){
						$scope.labBloodTestStValues.splice(lbt, 1);
						break;
					}
				}
			}
		}
		
		$scope.loadSelectedTestStdValues=function(index, selectedUnit, units){
			var stadValues = [];
			for(u in units){
				if(units[u].name==selectedUnit){
					stadValues = units[u].value;
					//$scope.labBloodTestResults[index]['unitSelected']=selectedUnit.name
				}
			}
			$scope.labBloodTestResults[index]['stdValues']=stadValues;
		}
		
		$scope.addMoreLabBloodTest = function(){
			$scope.labBloodTestResults.push({"name":"","stdValues":"","selectedStdValues":"","units":"","unitSelected":"","result":""});
		}
		
		$scope.removeLabBloodTest = function(index){
			$scope.labBloodTestResults.splice(index, 1);
		}
		
		$scope.patientById = function(id){
        	$http({
                method: "GET",
                url: "/rest/patient/findbyid/"+id,
                params: {}
            }).then(function succes(response) {
                $scope.patient = response.data;
                
            }, function error(response) {
            });
        };

    }]);
    