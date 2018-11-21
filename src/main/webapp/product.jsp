<%@ page import="cc.xpress.mitaole.user.bean.PageBean" %>
<%@ page import="cc.xpress.mitaole.user.dto.ModelTbDTO" %><%--
  Created by IntelliJ IDEA.
  User: viphu
  Date: 2017-11-05
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String basePath=application.getInitParameter("localPath");//获取的是项目的根路径
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>手机回收_二手手机,旧手机,废旧手机回收交易,价格评估_回购网_第1页</title>
    <meta name="applicable-device" content="pc">
    <link href="<%=basePath%>/favicon.ico" type=image/x-icon rel="Icon">
    <link href="<%=basePath%>/css/new_css/global.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.bootcss.com/jquery/1.4.2/jquery.min.js"></script>
    <script src="<%=basePath%>/js/new_js/new_public.js" type="text/javascript"></script>
    <script type="text/javascript">
        function selectcity(url) {
            open_div_extends('切换地区', url, 'Loading_child');
        }
    </script>
    <link href="<%=basePath%>/css/new_global.css" rel="stylesheet" type="text/css">
    <script src="<%=basePath%>/js/new_js/jquery.kinMaxShow-1.1.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/new_js/lrtk.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/new_js/menu.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/new_js/index.js" type="text/javascript"></script>
</head>
<body>
<%@include file="header.jsp"%>
<!--头部-->
<script type="text/javascript" src="<%=basePath%>/js/goods.js"></script>
<div class="new_search" style="padding-bottom:20px">
    <div class="search-box">
        <div class="search-title">搜一下，看看你的二手闲置还值多少钱</div>
        <div class="search">
            <div class="search-fenlei" id="search-fenlei">
                <div class="set" id="all_type">手机</div>
                <div class="search-list">
                    <ul>
                        <li class="search-list-iconall"><a href="javascript:void(0)" rel="nofollow"><span
                                onClick="t_click(this,'goods.html')">全部分类</span></a></li>
                        <li class="search-list-icon1"><a href="javascript:void(0)" rel="nofollow"><span
                                onClick="t_click(this,'ershoushouji.html')">手机</span></a></li>
                    </ul>
                </div>
            </div>
            <form name="top_goods_search" id="top_goods_search" action="ershoushouji.html" method="get">
                <input type="text" name="gname" id="top_name" value="请输入品牌型号搜索" class="input-txt"
                       onkeydown="if(event.keyCode==13) return top_search_goods();"
                       onFocus="if(this.value=='请输入品牌型号搜索'){this.value='';}"
                       onblur="if(this.value==''){this.value='请输入品牌型号搜索';}"/>
                <input type="button" value="" class="input-btn" onclick="top_search_goods()"/>
            </form>
        </div>
    </div>
</div>
<!--查询结果-->
<div class="search_list">
    <div class="page">
        <div class="current"><a href="">首页</a><span>></span><a href="goods.html">闲置回收</a>
            <span>></span><a href="ershoushouji.html">手机</a>
            <em></em>
        </div>
        <div class="side_left">
            <dl class="side_list">
                <dt>搜索结果分类</dt>
                <dd class="item_on"><a href="ershoushouji.html" title="手机回收价格评估"><b
                        class="item1">&nbsp;</b><em>手机</em><span>&nbsp;</span></a></dd>
                <dd class=""><a href="ershoupingguo.html" title="苹果系列回收价格评估"><b
                        class="item2">&nbsp;</b><em>苹果系列</em><span>&nbsp;</span></a></dd>
                <dd class=""><a href="ershoupingban.html" title="平板电脑回收价格评估"><b
                        class="item3">&nbsp;</b><em>平板电脑</em><span>&nbsp;</span></a></dd>
                <dd class=""><a href="ershoubijiben.html" title="笔记本回收价格评估"><b
                        class="item4">&nbsp;</b><em>笔记本</em><span>&nbsp;</span></a></dd>
                <dd class=""><a href="ershoushumaxiangji.html" title="数码相机回收价格评估"><b
                        class="item5">&nbsp;</b><em>数码相机</em><span>&nbsp;</span></a></dd>
                <dd class=""><a href="ershouyouxiji.html" title="游戏机回收价格评估"><b
                        class="item6">&nbsp;</b><em>游戏机</em><span>&nbsp;</span></a></dd>
                <dd class=""><a href="ershoujingtou.html" title="镜头回收价格评估"><b class="item7">&nbsp;</b><em>镜头</em><span>&nbsp;</span></a>
                </dd>
                <dd class="last"><a href="wurenji.html" title="无人机回收价格评估"><b class="item8">&nbsp;</b><em>无人机</em><span>&nbsp;</span></a>
                </dd>
            </dl>
            <dl class="side_hot">
                <dt>最近热门回收</dt>
                <dd>
                    <div class="img2">
                        <img src="http://img.ihuigo.com/goods_a/f6a645a58a6b36cb42e8ef1af0364101.jpg" width="42"
                             height="31" title="ipad mini回收价格评估"/>
                    </div>
                    <div class="txt2">
                        <p style="width:120px;">
                            <a href="goods/info/17015.html" title="ipad mini回收价格评估">ipad mini</a></p>462
                    </div>
                    <div class="clear"></div>
                </dd>
            </dl>
            <ul class="hotline">
                <li><img src="<%=basePath%>/images/icon30.png" alt="回购网手机回收400电话咨询"
                         style="vertical-align:middle"><span>400-9608-558</span></li>
            </ul>
        </div>
        <div class="side_right">
            <!--全部手机品牌-->
            <div class="brand">
                <div class="title2"><span><a href="<%=request.getContextPath()%>/goods/all/1.html">"<strong>手机</strong> 品牌</a></span></div>
                <div class="brand_main">
                    <div class="brand_hot">
                        <a href="<%=request.getContextPath()%>/goods/1/1.html">华为</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/2/1.html">三星</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/3/1.html">魅族</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/4/1.html">HTC</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/5/1.html">诺基亚</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/6/1.html">小米</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/7/1.html">iPhone</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/8/1.html">vivo</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/9/1.html">联想</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/10/1.html">中兴</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/11/1.html">OPPO</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/12/1.html">索尼</a>
                    </div>
                    <div class="brand_hots">
                        <a href="<%=request.getContextPath()%>/goods/13/1.html">摩托罗拉</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/14/1.html">黑莓</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/15/1.html">锤子</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/16/1.html">乐视</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/17/1.html">酷派</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/19/1.html">天语</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/21/1.html">金立</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/22/1.html">飞利浦</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/23/1.html">一加 </a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/24/1.html">海信</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/25/1.html">美图</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/26/1.html">华硕</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/27/1.html">中国移动</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/28/1.html">微软</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/30/1.html">360</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/31/1.html">LG</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/32/1.html">palm</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/33/1.html">多普达</a><em>|</em>
                        <a href="<%=request.getContextPath()%>/goods/34/1.html">夏普</a>
                    </div>
                </div>
            </div>
            <!--全部手机品牌-->
            <div class="search_main">
                <div class="search_title"><h2 class="list-item">手机回收</h2>&nbsp;&nbsp;&nbsp;&nbsp;<em></em>搜索到<em>${pageBean.entityCount}</em>个结果
                </div>
                <dl class="pic_list">
                    <c:forEach var="product" items="${pageBean.list}">
                    <dd>
                        <div class="pic_list_box">
                            <div class="pic_list_img"><a href="<%=request.getContextPath()%>/goods/info/${product.modelId}.html" title="iphone 7回收价格评估"><img
                                    src="${product.modelImg}" width="180"
                                    height="135" alt="${product.modelName}  闲置回收价格评估"/></a></div>
                            <p class="name">${product.modelName}</p>
                            <p class="pinggu"><a href="<%=request.getContextPath()%>/goods/info/${product.modelId}.html" title="在线评估${product.modelName}回收价格"><!--去评估--></a>
                            </p>
                            <div class="hot"><img src="<%=basePath%>/images/hot.png"/></div>
                        </div>
                    </dd>
                    </c:forEach>
                    <div class="clear"></div>
                </dl>
                <div class="clear"></div>
                <%--分页计算页码--%>
                <%
                    PageBean<ModelTbDTO> pageBean = (PageBean<ModelTbDTO>) request.getAttribute("pageBean");
                    /*循坏开始*/
                    int start=0;
                    /*循环结束*/
                    int end=0;
                    /*当前显示业*/
                    int pageNo=pageBean.getPageNo();
                    /*数据总页数*/
                    int pageCount=pageBean.getPageCount();
                    /*计算页码*/
                    if(pageNo-3<1){
                        start=1;
                        end=7<pageCount?7:pageCount;
                    }else if(pageNo+3>pageCount){
                        end=pageCount;
                        start=pageCount-6>0?pageCount-6:1;
                    }
                    else{
                        start=pageNo-3;
                        end=pageNo+3;
                    }
                %>
                <div class="pageStr">
                    <div class="ihuigo_page">
                        <c:forEach var="i" begin="<%=start%>" end="<%=end%>">
                            <c:choose>
                                <c:when test="${pageBean.pageNo==i}">
                                    <span class="cur_link">${i}</span>
                                </c:when>
                                <c:otherwise>
                                    <span><a href="${i}.html">${i}</a></span>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <span class="last_link"><a href="${pageBean.pageCount}.html">尾页</a></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!--查询结果-->
<script type="text/javascript">
    $(document).ready(function () {
        $('.pic_list dd').mousemove(function () {
            $(this).find('.pic_list_box').addClass('kuang');
        });
        $('.pic_list dd').mouseleave(function () {
            $(this).find('.pic_list_box').removeClass('kuang');
        });
    });
</script>
<%@include file="footer.jsp"%>
</body>
</html>
