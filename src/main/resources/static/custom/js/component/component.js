
module.directive('ciTextField', [function () {
        return {
            restrict: 'E',
            replace: true,
            template: function (element, attrs) {
                var form = ci.getProperty(attrs, "ciForm", "textFieldForm");
                var field = ci.getProperty(attrs, "ciField", attrs.name);
                var type = ci.getProperty(attrs, "type", attrs.type);
                var errors = ci.getProperty(attrs, "ciErrorMessages", attrs.errormessage);
                return ciDirective.inputFieldTemplate(form, type, field, errors, "ci-text=''", attrs.placeholder, element);
            }
        };
    }]);

module.directive('ciText', ['ciUtilsService', '$parse', function (ciUtilsService, $parse) {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function (scope, element, attrs, ngModel) {
            	//ngModel.$validators.mandatory = true;
            	ngModel.$validators.mandatory = function(value){
            		return ciUtilsService.mandatoryCheck(value);
            	}
                
                /*ngModel.$validators.validFileCheck = function (value) {
                    if (typeof value == 'undefined') {
                        return true;
                    } else if (!ciUtilsService.isValidFileFormat(attrs.formats, value[0].name)) {
                        return false;
                    } else {
                        return true;
                    }
                };

                ngModel.$validators.validFileNameCheck = function (value) {
                    if (typeof value == 'undefined') {
                        return true;
                    } else if (value[0].name.split(".").length > 2) {
                        return false;
                    } else {
                        return true;
                    }
                };

                ngModel.$validators.fileSizeCheck = function (value) {
                    var maxDocSize = parseInt(attrs.docmaxsize);
                    if (typeof value == 'undefined') {
                        return true;
                    } else if (Math.round(value[0].size / 1024) > maxDocSize) {
                        return false;
                    } else {
                        return true;
                    }
                };*/
            }
        };
    }]);

module.directive('ciTextArea', [function () {
    return {
        restrict: 'E',
        replace: true,
        template: function (element, attrs) {
            var form = ci.getProperty(attrs, "ciForm", "textFieldForm");
            var field = ci.getProperty(attrs, "ciField", attrs.name);
            var errors = ci.getProperty(attrs, "ciErrorMessages", attrs.errormessage);
            var cols = ci.getProperty(attrs, "cols", 50);
            var rows = ci.getProperty(attrs, "rows", 10);
            return ciDirective.inputAreaFieldTemplate(form, field,rows, cols, errors, "ci-area=''", attrs.placeholder, element);
        }
    };
}]);

module.directive('ciArea', ['ciUtilsService', '$parse', function (ciUtilsService, $parse) {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
        	//ngModel.$validators.mandatory = true;
        	ngModel.$validators.mandatory = function(value){
        		return ciUtilsService.mandatoryCheck(value);
        	}
        	
        	
            
            /*ngModel.$validators.validFileCheck = function (value) {
                if (typeof value == 'undefined') {
                    return true;
                } else if (!ciUtilsService.isValidFileFormat(attrs.formats, value[0].name)) {
                    return false;
                } else {
                    return true;
                }
            };

            ngModel.$validators.validFileNameCheck = function (value) {
                if (typeof value == 'undefined') {
                    return true;
                } else if (value[0].name.split(".").length > 2) {
                    return false;
                } else {
                    return true;
                }
            };

            ngModel.$validators.fileSizeCheck = function (value) {
                var maxDocSize = parseInt(attrs.docmaxsize);
                if (typeof value == 'undefined') {
                    return true;
                } else if (Math.round(value[0].size / 1024) > maxDocSize) {
                    return false;
                } else {
                    return true;
                }
            };*/
        }
    };
}]);

module.directive('ciSelectField', [function () {
    return {
        restrict: 'E',
        replace: true,
        template: function (element, attrs) {
            var form = ci.getProperty(attrs, "ciForm", "textFieldForm");
            var field = ci.getProperty(attrs, "ciField", attrs.name);
            var type = ci.getProperty(attrs, "type", attrs.type);
            var errors = ci.getProperty(attrs, "ciErrorMessages", attrs.errormessage);
          
            return ciDirective.selectFieldTemplate(form, type, field, errors, "ci-select=''", "Select item", element);
        }
    };
}]);

module.directive('ciSelect', ['ciUtilsService', '$parse', function (ciUtilsService, $parse) {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
        	//ngModel.$validators.mandatory = true;
        	element[0].options = scope.patientGender;
        	var selectParams = ciUtilsService.getRemoteConfig("Select gender", true, scope.patientGender1, "");
        	ciUtilsService.generateSelect2Box(element, selectParams, scope, ngModel);
        	ngModel.$validators.mandatory = function(value){
        		return ciUtilsService.mandatoryCheck(value);
        	}
            
            /*ngModel.$validators.validFileCheck = function (value) {
                if (typeof value == 'undefined') {
                    return true;
                } else if (!ciUtilsService.isValidFileFormat(attrs.formats, value[0].name)) {
                    return false;
                } else {
                    return true;
                }
            };

            ngModel.$validators.validFileNameCheck = function (value) {
                if (typeof value == 'undefined') {
                    return true;
                } else if (value[0].name.split(".").length > 2) {
                    return false;
                } else {
                    return true;
                }
            };

            ngModel.$validators.fileSizeCheck = function (value) {
                var maxDocSize = parseInt(attrs.docmaxsize);
                if (typeof value == 'undefined') {
                    return true;
                } else if (Math.round(value[0].size / 1024) > maxDocSize) {
                    return false;
                } else {
                    return true;
                }
            };*/
        }
    };
}]);


