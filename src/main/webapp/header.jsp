<%--
  Created by IntelliJ IDEA.
  User: viphu
  Date: 2017-11-05
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/alert_zhe.css"/>
<script type="text/javascript" src="<%=basePath%>/js/alert_zhe.js"></script>
<div id="Loading_child" class="Loading" style="display:none; height:480px;" onDblClick="ttt('Loading_child');">
    <div class="tyd_box">
        <div class="tyd_box_c">
            <div class="tyd_box_title">
                <span id="Loading_child_title"></span><a href="javascript:ttt('Loading_child')"><img
                    src="<%=basePath%>/images/close1.gif" border="0"/></a>
            </div>
            <div class="tyd_box_content" style="width:612px;overflow:auto; height:450px;">
                <iframe id="Loading_child_iframe_id" name="iframe_id" width="612" height="450" border="0"
                        frameborder="0"></iframe>
            </div>
        </div>
    </div>
</div>
<div id="mbDIV" style="display:none;"></div><!--头部-->
<div class="shortcut">
    <div class="page">
        <div class="shortcut-left">
            <ul>
                <li class="item-more"><a rel="nofollow" href="javascript:void(0)"><span>&nbsp;</span><em>手机逛回购</em></a>
                    <div class="sub-nav">
                        <div><a href="http://m.ihuigo.com" rel="nofollow" target="_blank"><img
                                src="<%=basePath%>/images/new_images/shortcut_wx.gif" width="145" height="145"/></a></div>
                        <div>扫描进入手机站</div>
                    </div>
                </li>
                <li class="city"><span>当前：
        <span id="selectcity_new">
        </span>
        <a rel="nofollow" href="javascript:void(0);">[切换城市]</a></span></li>
            </ul>
        </div>
        <div class="shortcut-right">
            <ul id='login_show'>
                <shiro:notAuthenticated>
                    <li><a href="<%=request.getContextPath()%>/user/login" rel="nofollow">登录</a></li>
                    <li><a href="<%=request.getContextPath()%>/user/login" rel="nofollow">注册</a></li>
                </shiro:notAuthenticated>
                <shiro:authenticated>
                    <li><a href="<%=request.getContextPath()%>/user_center.jsp" rel="nofollow">个人中心</a></li>
                </shiro:authenticated>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="header">
    <div class="page">
        <h1 class="logo"><a href=""><img src="<%=basePath%>/images/new_images/logo.png" width="171" height="43"
                                         title="二手手机回收交易网"/></a></h1>
        <div class="nav">
            <a title="闲置二手手机回收估价" href="goods.html" class="on">
                <!--<span id="nav_xz">&nbsp;</span>-->闲置回收</a>
            <a title="二手手机以旧换新活动" href="huanxin.html"><!--<span id="nav_hx">&nbsp;</span>-->旧机换新<img
                    src="<%=basePath%>/images/new_images/new.png"/></a>
            <a title="二手优品手机抢购" href="youpin.html"><!--<span id="nav_hx">&nbsp;</span>-->二手优品</a><a target="_blank"
                                                                                                    href="kucun.html"
                                                                                                    rel="nofollow"
                                                                                                    style="margin-right:0;"><img
                src="<%=basePath%>/images/new_images/kc.gif" style="vertical-align:middle"></a>
        </div>
    </div>
</div>
