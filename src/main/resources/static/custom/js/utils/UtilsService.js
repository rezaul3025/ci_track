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
        };
        
        this.generateSelect2Box = function (element, params, scope, ngModel, path) {
            var validation = this.triggerValidation;
            $(element).select2(params).on("select2-blur", function (elem) {
                //validation(ngModel, scope);
            }).on("select2-close", function (elem) {
                var select2Data = $(this).data("select2");
                // Manually blur search input on close to let placeholder reappear
                // See https://github.com/ivaynberg/select2/issues/1545
                if (select2Data) {
                    select2Data.search.blur();
                }
               // validation(ngModel, scope);
            });
            scope.$watchCollection(path, function () {
                var value = ngModel.$viewValue;
                $(element).select2('data', null);
                if (value !== undefined && value != null) {
                    //                    if (typeof value === 'string') {
                    //                        value = value.split(",");
                    //                    }
                    $(element).select2('val', value);
                   // validation(ngModel, scope);
                }
            });
        };
        
        this.getRemoteConfig = function (placeholder, allowClear, data, params) {
            return {
                placeholder: placeholder,
                //multiple: false,
                dropdownAutoWidth: true,
                allowClear: allowClear,
                quietMillis: 100,
                /*ajax: {
                    url: this.utilsService.getLocalUrl() + 'rest/' + url,
                    data: function (term) {
                        var result = { query: term };
                        $.extend(result, params);
                        return result;
                    },
                    results: function (data) {
                        return { results: data };
                    }
                },*/
                data:data,
                
                formatSelection: function (item) {
                    return item;
                },
                formatResult: function (item) {
                    return item;
                }/*,
                id: function (item) {
                    return item;
                }*/
                /*,
                initSelection: function (element, callback) {
                    callback($(element).val());
                }*/
            };
        };
        
	}
	
	return UtilsService;
	
})();
//]]> 