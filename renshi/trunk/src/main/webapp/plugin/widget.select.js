;(function() {
	
	$.fn.select = function(opti) {
		var _this = $(this);
		var option = {
			targetId: 'targetId',
			multi: false  // 是否多选
		};
		
		$.extend(option, opti);
		
		var flag = true;
		// 点击页面任意位置隐藏下拉框
        $('body').on('click', function(event) {
        	if($('#' + option.targetId + ':visible').length > 0) {
        		var eventId = $(event.target).attr('id');
        		var downType = $('#'+option.targetId);
        		
        		// 如果是多选，选择后不隐藏下拉框
        		if(option.multi) {
        			var parentId = $(event.target).parents('div#'+option.targetId).attr('id');
        			if(parentId) {
        				return;
        			}
        		}
        		
        		if(eventId == _this.attr('id')) {
        			if(flag) {
        				downType.hide();
        			} else {
        				flag = true;
        			}
        		} else {
        			downType.hide();
        		}
        	}
        });
        
        // 单击下拉框
        _this.on('click', function() {
        	if($('#' + option.targetId + ':visible').length > 0) {
        		return;
        	}
        	var downType = $('#' + option.targetId), _position = _this.position();
    		downType.css({'top': _position.top+_this.height()+4, 'left': _position.left});
    		downType.css({'width': _this.width(), 'position': 'absolute'});
    		if(option.css) {
    			downType.css(option.css);
    		}
    		$('#' + option.targetId + ' li:odd').css('background-color', '#E8F2FE');
    		downType.show();
    		flag = false;
        });
        
        if(!option.multi) {
        	// 选择其中一项
        	$('#' + option.targetId +' li').each(function(i) {
        		$(this).on('click', function(event) {
        			if(option.choose) {
        				option.choose($(this));
        			} else {
        				_this.val($(this).html());
        			}
        		});
        	});
        } else {
        	$('#' + option.targetId +' span').each(function(i) {
        		$(this).on('click', function() {
        			option.choose(_this, $(this));
        		});
        	});
        }
        
        // 自动匹配搜索
        _this.on('keyup', function(e) {
        	var val = _this.val();
        	
    		$('#'+option.targetId+' li').hide();
    		$('#'+option.targetId+' li').each(function(i) {
    			var html = $(this).html();
    			if(val == '' || html.indexOf(val) > -1) {
    				$(this).show();
    			}
    		});
        });
	};
	
})(jQuery);