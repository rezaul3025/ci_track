module.controller('PatientController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		$controller('CoreController', {
	        $scope: $scope
	    });
		
		var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $http.defaults.headers.common[header] = token;
        console.log(token);
		
		$scope.submitted = false;
		
		/*$scope.today = function() {
			$scope.patient.dob = new Date();
		  };
		  $scope.today();*/

		  $scope.clear = function() {
			  $scope.patient.dob = null;
		  };

		  $scope.inlineOptions = {
		    customClass: getDayClass,
		    minDate: new Date(),
		    showWeeks: true
		  };

		 /* $scope.dateOptions = {
		    dateDisabled: disabled,
		    formatYear: 'yy',
		    maxDate: new Date(2020, 5, 22),
		    minDate: new Date(),
		    startingDay: 1
		  };*/

		  // Disable weekend selection
		  function disabled(data) {
		    var date = data.date,
		      mode = data.mode;
		    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
		  }

		  $scope.toggleMin = function() {
		    $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
		   // $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
		  };

		  $scope.toggleMin();

		  /*$scope.open1 = function() {
		    $scope.popup1.opened = true;
		  };*/

		  $scope.open2 = function() {
		    $scope.popup2.opened = true;
		  };

		  $scope.setDate = function(year, month, day) {
		    $scope.patient.dob = new Date(year, month, day);
		  };

		  /*$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
		  $scope.format = $scope.formats[0];
		  $scope.altInputFormats = ['M!/d!/yyyy'];*/

		  /*$scope.popup1 = {
		    opened: false
		  };*/

		  $scope.popup2 = {
		    opened: false
		  };

		  var tomorrow = new Date();
		  tomorrow.setDate(tomorrow.getDate() + 1);
		  var afterTomorrow = new Date();
		  afterTomorrow.setDate(tomorrow.getDate() + 1);
		  $scope.events = [
		    {
		      date: tomorrow,
		      status: 'full'
		    },
		    {
		      date: afterTomorrow,
		      status: 'partially'
		    }
		  ];

		  function getDayClass(data) {
		    var date = data.date,
		      mode = data.mode;
		    if (mode === 'day') {
		      var dayToCheck = new Date(date).setHours(0,0,0,0);

		      for (var i = 0; i < $scope.events.length; i++) {
		        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

		        if (dayToCheck === currentDay) {
		          return $scope.events[i].status;
		        }
		      }
		    }

		    return '';
		  }
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

  */      
        $scope.addPatient = function(patient, form){
        	$scope.submitted = true;
        	if (form.$valid) {
               
	        	$http({
	                method: "POST",
	                url: "/rest/patient/add",
	                data: patient,
	            }).then(function mySucces(response) {
	            	
	            }, function myError(response) {
	               
	            });
        	}
        	
        };
        
        $scope.loadAllPatient = function(){
        	$http({
                method: "GET",
                url: "/rest/patient/get-all",
                params: {}
            }).then(function succes(response) {
                $scope.patients = response.data;
                
            }, function error(response) {
            });
        };
        
        $scope.init = function(id){
        	$scope.patientById(id);
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


    }])
    