<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>E帮护</title>
    <link href="${cssPath}/index/base.css" rel="stylesheet" />
    <link href="${cssPath}/index/index.css" rel="stylesheet" />
    <link href="${cssPath}/index/flexslider.css" rel="stylesheet" />
    <link href="${cssPath}/index/movebox.css" rel="stylesheet" />
</head>
<body>
    <!--头部开始-->
    <!--#include file="/include/header.inc"-->
    <%@ include file="/WEB-INF/pages/common/header.jsp" %>
    
    <!--头部结束-->
   <div class="wrapmax">
        <!--banner-->
        <div id="banner">
            <div class="flexslider">
	            <ul class="slides">		           
		            <li style="background:url('${imagePath}/flexslider/img7.jpg') 50% 0 no-repeat;"><a style="display: block;width: 100%;height: 100%;" href="http://www.renshine.com/mpmain/meetinginfo.htm?id=75" alt="第12届世界重症监护医学协会联合会大会（WFSICCM)" title="第12届世界重症监护医学协会联合会大会（WFSICCM)">
			    </a></li>
		            <li style="background:url('${imagePath}/flexslider/img9.jpg') 50% 0 no-repeat;"><a style="display: block;width: 100%;height: 100%;" href="http://www.renshine.com/mpmain/meetinginfo.htm?id=79" alt="2015第9届欧洲疼痛联合会大会（EFIC）" title="2015第9届欧洲疼痛联合会大会（EFIC）">			
			    </a></li>
		            <li style="background:url('${imagePath}/flexslider/img4.jpg') 50% 0 no-repeat;"><a style="display: block;width: 100%;height: 100%;" href="/mpmain/presidentClass.htm" alt="浙江互联网+医疗企业家高级研修班" title="浙江互联网+医疗企业家高级研修班">			
			    </a></li>
	            </ul>
            </div>
        </div>
        <!--banner 结束-->
    </div>
    <div class="wrapmax">
       <!--权威医师开始-->
            <div class="column-top wrap">
                <img src="images/index/column-1.png" />
                <a href="#">更多<b class="more-green"></b></a>
            </div>             
           <div class="slider wrap clear">         
                <em class="prev" id="prev"></em>
                <em class="next" id="next"></em>
                <div id="authority">
                    <ul>
                    <li>
                        <img class="expert-photo" src="images/index/expert-photo01.jpg" />
                        <h3>王忠友</h3>
                        <span>浙江医学会主任医师</span>
                        <a href="#"></a>                
                    </li>
                    <li>
                        <img class="expert-photo" src="images/index/expert-photo01.jpg" />
                        <h3>王忠友</h3>
                        <span>浙江医学会主任医师</span>
                        <a href="#"></a>                
                    </li>
                    <li>
                        <img class="expert-photo" src="images/index/expert-photo01.jpg" />
                        <h3>王忠友</h3>
                        <span>浙江医学会主任医师</span>
                        <a href="#"></a>                
                    </li>

                    <li>
                        <img class="expert-photo" src="images/index/expert-photo01.jpg" />
                        <h3>王忠友</h3>
                        <span>浙江医学会主任医师</span>
                        <a href="#"></a>                
                    </li>
                    <li>
                        <img class="expert-photo" src="images/index/expert-photo01.jpg" />
                        <h3>王忠友</h3>
                        <span>浙江医学会主任医师</span>
                        <a href="#"></a>                
                    </li>
                    <li>
                        <img class="expert-photo" src="images/index/expert-photo01.jpg" />
                        <h3>王忠友</h3>
                        <span>浙江医学会主任医师</span>
                        <a href="#"></a>                
                    </li>                   
                    </ul>
                </div>
            </div>
        
       <!--权威医师结束-->
   </div>
   <!--认仕专栏开始-->
   <div class="wrapmax rs-column">
       <div class="wrapmax rs-column-top">
            <div class="column-top wrap">
                <img src="images/index/column-2.png" />
                <!--<a href="#"  style="color:#fff;">更多<b class="more"></b></a>-->
            </div> 
       </div>
       <div class="wrap rs-columns" id="rs-columns">
           <ul>
               <li class="rs-column-1">
                   <h3>医学视频</h3>
                   <dl>
                       <dt><a href="#"> 结核性腹膜炎治疗中腹痛的经典会议视频</a></dt>
                       <dd>在初次全髋关节置换中，骨水泥型柄具有疼痛更少、早期失败率更少哈卫生经济效益更佳以及长期随访结果优良 ...</dd>
                   </dl>
                   <em class="getmore">
                       <a href="#">更多视频<b class="more"></b></a>
                   </em>
                   <em class="oriented-arrow oriented-arrow-right"></em>
               </li>
               <li class="rs-column-2"><a href="#">
                   <img src="images/index/rs-2.jpg" class="rs-column-img"/>
                   <em class="play"></em>
                                       </a>
                   
               </li>
               <li class="rs-column-1">
                   <h3>热点医问</h3>
                   <dl>
                       <dt><a href="#">结核性腹膜炎治疗中腹痛的经典会议视频</a></dt>
                       <dd>在初次a全髋关节置换中，骨水泥型柄具有疼痛更少、早期失败率更少哈卫生经济效益更佳以及长期随访结果优良 ...</dd>
                   </dl>
                   <em class="getmore">
                       <a href="#">更多医问<b class="more"></b></a>
                   </em>
                   <em class="oriented-arrow oriented-arrow-bottom"></em>
               </li>

               <li class="rs-column-1"><a href="#">
                   <img src="images/index/rs-4.jpg"  class="rs-column-img"/></a></li>
               <li class="rs-column-2"><a href="#">
                   <img src="images/index/rs-5.png" class="rs-column-img"/></a></li>
               <li class="rs-column-1"><a href="#">
                   <img src="images/index/rs-6.jpg" class="rs-column-img"/></a></li>

               <li class="rs-column-1">
                   <h3>热议观点</h3>
                   <dl>
                       <dt><a href="#">结核性腹膜炎治疗中腹痛的热议观点</a></dt>
                       <dd>在初次全髋关节置换中，骨水泥型柄具有疼痛更少、早期失败率更少哈卫生经济效益更佳以及长期随访结果优良 . .. </dd>
                   </dl>
                   <em class="getmore">
                       <a href="#">更多观点<b class="more"></b></a>
                   </em>
                   <em class="oriented-arrow oriented-arrow-up"></em>
               </li>
               <li class="rs-column-2">
                   <h3>热荐文库</h3>
                   <ul class="rs-columns2">
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                   </ul>
                   <em class="getmore">
                       <a href="#">更多文库<b class="more"></b></a>
                   </em>

               </li>
               <li class="rs-column-1">
                   <h3>热荐病例</h3>
                   <ul class="rs-columns2">
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                       <li><em></em><a href="#">女12岁，右股骨颈.右肱骨外科颈骨骨折之后 eqweqweqweqwe</a></li>
                   </ul>
                   <em class="getmore">
                       <a href="#">更多病例<b class="more"></b></a>
                   </em>

               </li>

           </ul>
       </div>
   </div>
    <!--认仕专栏结束-->
    <!--我们的优势开始-->
    <div class="wrapmax" style="background-color:#fafafa;">
        <div class="wrapmax column-top"  style="margin-bottom: 0px;">
            <div class="column-top wrap">
                <img src="images/index/column-3.png" />
                <a href="#" class="advantage-reg-btn"></a>
            </div> 
       </div>
        <div class="wrap advantage" id="advantage">
                            
                    <ul>
                    <li>
                        <img class="advantage-photo" src="images/index/s1.jpg" />
                        <h3>发现权威</h3>
                        <span>签约各大医院权威医师，医师力量雄厚，多互动交流学习</span>
                                    
                    </li>
                    <li>
                        <img class="advantage-photo" src="images/index/s2.jpg" />
                        <h3>交流学习</h3>
                        <span>签约各大医院权威医师，医师力量雄厚，多互动交流学习</span>
                                     
                    </li>
                    <li>
                        <img class="advantage-photo" src="images/index/s3.jpg" />
                        <h3>专属空间</h3>
                        <span>签约各大医院权威医师，医师力量雄厚，多互动交流学习</span>
                                      
                    </li> 
                    <li>
                        <img class="advantage-photo" src="images/index/s4.jpg" />
                        <h3>成就展现</h3>
                        <span>签约各大医院权威医师，医师力量雄厚，多互动交流学习</span>
                                     
                    </li>                                                                     
                    </ul>
                
        </div>
    </div>
    <!--我们的优势结束-->
 
    <!--底部开始-->
    <!--#include file="/include/footer.inc"-->
    <%--<%@ include file="/WEB-INF/pages/common/footer.jsp" %>--%>
    <!--底部结束-->

</body>
<script src="${jsPath}/index/jquery.flexslider-min.js"></script>
<script src="${jsPath}/index/moveboxs.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //轮播
        $('.flexslider').flexslider({
            directionNav: true,
            pauseOnAction: false
        });
        //图片
        $("#authority").moveboxs(255, 4);

        $("#rs-columns li").hover(function () {
            var index = $("#rs-columns li").index(this);
            if (index == 0) {
                var em = $(this).find(".oriented-arrow")
                $(em).removeClass("oriented-arrow-right");
                $(em).addClass("oriented-arrow-right2");
            }
            if (index == 2) {
                var em = $(this).find(".oriented-arrow")
                $(em).removeClass("oriented-arrow-bottom");
                $(em).addClass("oriented-arrow-bottom2");
            }
            if (index == 6) {
                var em = $(this).find(".oriented-arrow")
                $(em).removeClass("oriented-arrow-up");
                $(em).addClass("oriented-arrow-up2");
            }
            
        }).mouseleave(function () {

            var index = $("#rs-columns li").index(this);
            if (index == 0) {
                var em = $(this).find(".oriented-arrow")
                $(em).removeClass("oriented-arrow-right2");
                $(em).addClass("oriented-arrow-right");
            }
            if (index == 2) {
                var em = $(this).find(".oriented-arrow")
                $(em).removeClass("oriented-arrow-bottom2");
                $(em).addClass("oriented-arrow-bottom");
            }
            if (index == 6) {
                var em = $(this).find(".oriented-arrow")
                $(em).removeClass("oriented-arrow-up2");
                $(em).addClass("oriented-arrow-up");
            }
        });
    });
</script>
</html>
