// <![CDATA[
module = angular.module('ciTrackApp', ['ui.bootstrap','ngMessages']);
module.factory('ciUtilsService', [ '$timeout', '$http', function($timeout, $http) {
	return new UtilsService();
} ]);
var UtilsService = (function(){
	function UtilsService(){
		var _this = this;
		
		this.isValidFileFormat = function(fileTypes, checkFileType){
        	/*var fileTypeArr = fileTypes.split(",");
        	
        	for(var i in fileTypeArr){
        		if(checkFileType.indexOf(fileTypeArr[i]) != -1){
        			return true;
        		}
        	}*/
        	
        	return false;
        };
        
        this.mandatoryCheck = function(value){
        	 return value != "" && value != undefined && value != null;
        }
		
	}
	
	return UtilsService;
	
})();
//]]> 