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
	    
$scope.loadAllPatient = function(idf){
        	
        	$scope.idf = idf;
        	
        	$http({
                method: "GET",
                url: "/rest/patient/get-all",
                params: {}
            }).then(function succes(response) {
                $scope.patients = response.data;
               
                $(document).ready(function() {
                	
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

    }])
    