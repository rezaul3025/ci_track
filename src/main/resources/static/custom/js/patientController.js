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
		$scope.patientGender = [{"id":1,text:"Male"},{id:2,text:"Female"},{id:3,text:"Others"}];
		
		$scope.patientGender1 = ["Male","Female","Others"];
		  
		  
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
        
        $scope.loadAllPatient = function(idf){
        	
        	$scope.idf = idf;
        	
        	$http({
                method: "GET",
                url: "/rest/patient/get-all",
                params: {}
            }).then(function succes(response) {
                $scope.patients = response.data;
               
                $(document).ready(function() {
                	var patientListTable = $('#patients').DataTable(
                			{
                		        data: response.data,
                		        columns: [
                		            { title: "ID", "data":"id" },
                		            { title: "First Name", "data":"firstName" },
                		            { title: "Last Name", "data":"lastName" },
                		            { title: "Date of birth","data":"dob" },
                		            { title: "Age","data":"age" },
                		            { title: "Height(cm)","data":"height" },
                		            { title: "Weight(kg)","data":"weight" },
                		            { title: "Address","data":"address" },
                		            { title: "Action"}
                		        ],
                		        "columnDefs": [ {
                		            "targets": 8,
                		            "data": null,
                		            "orderable": false,
                		            "defaultContent": "<a id='addprescription' class ='btn btn-default' href='#'>Add Prescription</a><br/><a style='margin-top:3px;' class='btn btn-default' id='addlabtest' href='#'>Add lab test</a>"
                		        } ]
                		    }
                	);
                	
                	$('#patients tbody').on( 'click', '#addprescription', function () {
                        var data = patientListTable.row( $(this).parents('tr') ).data();
                        //alert( 'patient id is : '+data.id );
                        location.href = '/prescription/add/'+data.id;
                    } );
                	
                	$('#patients tbody').on( 'click', '#addlabtest', function () {
                        var data = patientListTable.row( $(this).parents('tr') ).data();
                        //alert( 'patient id is : '+data.id );
                        location.href = '/lab/test/blood/'+data.id;
                    } );
                	
                	
                	var patientListTableShort = $('#patientsShort').DataTable(
                			{
                		        "pagingType": "simple"
                		    }
                	);
                	
                	$("#patientsShort_length").parent().remove();
                	$("#patientsShort_info").parent().removeClass('col-sm-5');
                	$("#patientsShort_paginate").parent().removeClass('col-sm-7');
                	$("#patientsShort_paginate").parent().addClass('col-sm-10');
                	/*var patientDTinfo = $("#patientsShort_info").parent().html();
                	var patientDTpaginateInfo = $("#patientsShort_paginate").parent().html();
                	//$("#patientsShort_paginate").parent().parent().remove();
                	$("#patientsShort_wrapper").append("<div class='row'><div class='col-sm-12'>"+patientDTinfo+"</div></div>");
                	$("#patientsShort_wrapper").append("<div class='row'><div class='col-sm-12'>"+patientDTpaginateInfo+"</div></div>");
                	*/
                	$('#patientsShort tbody').on( 'click', '#viewMore', function () {
                        var data = patientListTableShort.row( $(this).parents('tr') ).data();
                        //alert( 'patient id is : '+data.id );
                        location.href = '/patient/view/'+data.id;
                    } );
                } );
                
            }, function error(response) {
            });
        };
        
        $scope.init = function(id, userId){
        	$scope.patientById(id);
        	$scope.loadPrescriptions(id);
        	$scope.patientId = id;
        	$scope.userId =  userId;
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
        
        $scope.loadPrescriptions = function(patientId){
        	$http({
                method: "GET",
                url: "/rest/prescription/patient/"+patientId,
                params: {}
            }).then(function succes(response) {
                $scope.prescriptions = response.data;
                
                var ids = [];
                for(p in $scope.prescriptions){
                	ids.push($scope.prescriptions[p].doctorId);
                }
                
                if(ids.length>0){
                	 findDoctorsByIds(ids);
                }
                
            }, function error(response) {
            });
        };
        
        $scope.doctorsIdMap = {};
        
        findDoctorsByIds = function(ids){
        	$http({
                method: "POST",
                url: "/rest/user/find_by_ids",
                data: ids,
            }).then(function mySucces(response) {
            	$scope.doctors = response.data;
            	if(typeof $scope.doctors != 'undefined' && $scope.doctors.length > 0){
            		for(d in $scope.doctors){
            			$scope.doctorsIdMap[$scope.doctors[d].id]=$scope.doctors[d];
            		}
            	}
            }, function myError(response) {
               
            });
        };

    }]);
    
    
    