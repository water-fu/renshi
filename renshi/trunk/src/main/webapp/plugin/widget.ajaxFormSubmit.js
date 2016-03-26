;(function($) {
	
	// 表单异步提交
	$.ajaxFormSubmit = function(opti) {
		var option = {
			formId: '',
	    	success: function(data) {
	    		
	    	}
	    };
		
		$.extend(option, opti);
		
    	$('#' + option.formId).ajaxSubmit(option);
	};
	
})(jQuery);