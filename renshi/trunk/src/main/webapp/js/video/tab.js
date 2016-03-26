$(document).ready(function(){


	loadTabEvent();
	function loadTabEvent(){
		$("#tabEvent span").bind("click",function(){
			var _self = $(this);
			var data_tab = _self.attr("data-tab");
			var class_data_tab = "."+data_tab;

			_self.addClass('choice').siblings('span').removeClass('choice');
			if($(class_data_tab).hasClass('hidden')){
				$(class_data_tab).removeClass("hidden").siblings("div.expert-list").addClass("hidden");
			}else{

			}
		});
	}
});