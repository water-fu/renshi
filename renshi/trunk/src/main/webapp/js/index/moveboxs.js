(function ($) {
    //图片移动插件版本1.0.1
    //movebox('#wonderfulAtlas', 180, 4);
    //movepx shownumber,currentindex 
    $.fn.extend({
        moveboxs:function (movepx, shownumber) {            
            var oPic = $(this).find('ul');
            var oImg = oPic.find('li');
            var oLen = oImg.length;
            var oLi = oImg.width();
            var parent = $(this).parent();
            var prev = parent.find(".prev");
            var next = parent.find(".next");

            oPic.width(oLen * movepx);//计算总长度
            var iNow = 0;
            var iTimer = null;
            prev.click(function () {
                if (iNow > 0) {
                    iNow--;
                    ClickScroll();                    
                }
            })
            next.click(function () {
                if (iNow < oLen - shownumber) {
                    iNow++
                    ClickScroll();                    
                }

            })
            function ClickScroll() {
                iNow == 0 ? prev.addClass('no_click') : prev.removeClass('no_click');
                iNow == oLen - shownumber ? next.addClass("no_click") : next.removeClass("no_click");
                oPic.animate({ left: -iNow * movepx })
                //$("#hideindex").val(iNow)                
            }
            return this;
        }    
    }) 
})(jQuery);



