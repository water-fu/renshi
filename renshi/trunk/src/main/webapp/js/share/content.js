$(document).ready(function() {
	// 加载头像
	$('.list-logo img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	// 加载附件
	$('.list-content ul[id^="attach"]').each(function() {
		var $this = $(this);
		$.ajaxRequest({
			url: path + '/blog/getShareAttach',
			data: {
				shareId: $this.attr('val')
			},
			success: function(data) {
				data = data.obj;
				for(var i = 0; i < data.length; i++) {
					var $li = $('<li>'), $a = $('<a>'), $img = $('<img>');
					$img.attr('alt', '');
					if(data[i].attachType == 1) {
						$img.attr('src', path + '/common/showImage?imageUrl=' + data[i].attachUrl);
						$a.append($img);
					} else if (data[i].attachType == 2) {
						$a.html(data[i].attachName);
						$a.attr('href', path + '/common/downFile?fileUrl=' + data[i].attachUrl + '&fileName=' + data[i].attachName);
						$li.css({'width': 500, 'height': 20});
					} else if (data[i].attachType == 3) {
						$img.attr('src', path + '/images/person/play.jpg');
						$a.append($img);
					}
					$li.append($a);
					
					$this.append($li);
				}
			}
		});
	});
	
	// 收藏按钮点击
	$('.collection').click(function() {
		var $this = $(this);
		// 收藏
		if($this.attr('type') == 1) {
			$.ajaxRequest({
				url: path + '/blog/addCollection',
				type: 'post',
				data: {
					shareId: $this.attr('val')
				},
				success: function() {
					var num = parseInt($this.attr('num'));
					$this.text('\u53D6\u6D88\u6536\u85CF(' + (num + 1) + ')');
					$this.attr('type', -1);
					$this.attr('num', num + 1);
				}
			});
		} 
		// 取消收藏
		else {
			$.ajaxRequest({
				url: path + '/blog/delCollection',
				type: 'post',
				data: {
					shareId: $this.attr('val')
				},
				success: function() {
					var num = parseInt($this.attr('num'));
					$this.text('\u6536\u85CF(' + (num - 1) + ')');
					$this.attr('type', 1);
					$this.attr('num', num - 1);
				}
			});
		}
	});
	
	// 点赞
	$('.praise').click(function() {
		var $this = $(this);
		
		if($this.attr('type') == 1) {
			$.ajaxRequest({
				url: path + '/blog/addPraise',
				type: 'post',
				data: {
					shareId: $this.attr('val')
				},
				success: function() {
					var num = parseInt($this.attr('num'));
					$this.text('\u53D6\u6D88\u8D5E(' + (num + 1) + ')');
					$this.attr('type', -1);
					$this.attr('num', num + 1);
				}
			});
		} else {
			$.ajaxRequest({
				url: path + '/blog/delPraise',
				type: 'post',
				data: {
					shareId: $this.attr('val')
				},
				success: function() {
					var num = parseInt($this.attr('num'));
					$this.text('\u8D5E(' + (num - 1) + ')');
					$this.attr('type', 1);
					$this.attr('num', num - 1);
				}
			});
		}
	});
});