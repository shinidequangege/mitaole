<%--
  Created by IntelliJ IDEA.
  User: viphu
  Date: 2017-11-08
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=application.getInitParameter("localPath");//获取的是项目的根路径
%>
<meta name="baidu-site-verification" content="t2itB2aISc">
<meta name="baidu-site-verification" content="uxd62RWAmv">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>米淘乐，二手手机，二手手机市场，二手手机价格，二手手机平台，二手手机交易，二手手机买卖，二手手机转让，求购二手手机，二手数码。</title>
<meta name="keywords" content="米淘乐，二手手机，二手手机市场，二手手机价格，二手手机平台，二手手机交易，二手手机买卖，二手手机转让，求购二手手机，二手数码。">
<meta name="description" content="米淘乐是中国首创二手数码产品竞价出售的交易平台。在这里可以闲置转让，参加竞价；还可以淘二手，卖二手良品；同时还有最专业的官方鉴定，专业质检,品质认证,让你放心买卖!选择米淘乐，让二手买卖，如此简单，而有趣！">
<link href="<%=basePath%>/css/global.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/css/eject.css" rel="stylesheet" type="text/css">
<script src="https://cdn.bootcss.com/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/public.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/all.js"></script>
<link href="http://www.mitaole.com/favicon.ico" type="image/x-icon" rel="Icon">
<link href="<%=basePath%>/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>/js/checkData.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jqBackgroundPositionAnimate.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".login_btn").click(function(){
            $("body").animate({ "background-position-x": "center",
                "background-position-y": "-300px"},1000);
        });

        $(".register_btn").click(function(){
            $("body").animate({ backgroundPositionX: "center",
                backgroundPositionY: "-300px"},1000);
        });
        $(".login_btn").click(function(){
            $(".login_btn").animate({width:'264px'},500);
            $(".login_btn").text("登录米淘乐");
            $(".register_btn").animate({width:'125px'},500);
            $(".register_btn").text("注册");
            $(".login").fadeIn(3000)
            $(".register").fadeOut('slow')
        });

        $(".register_btn").click(function(){
            $(".login_btn").animate({width:'125px'},500);
            $(".login_btn").text("登录");
            $(".register_btn").animate({width:'264px'},500);
            $(".register_btn").text("注册米淘乐");
            $(".register").fadeIn(3000)
            $(".login").fadeOut('slow')
        });
        $('#mtl_submit_re').click(function(){
            if(check_register_data()&&V('status','v') == 1){
                var form = V('reg','o');
                form.attr('action',"<%=request.getContextPath()%>/user/register")
                form.submit();
            }else{
                return false;
            }
        });
        $('#l_login').click(function(){
            if(check_login()){
                var form = V('login','o');
                form.attr('action',"<%=request.getContextPath()%>/user/login")
                form.submit();
            }else{
                return false;
            }
        });
        V('l_user','o').focus(function(){C('l_user','邮箱/手机号','login_user','手机号需要绑定，才可以用来登录！');});
        V('l_user','o').keyup(function(){
            if(!$(this).val()){
                $('#l_pwd').val('');
                $('input[name="jizhu_pwd"]').attr('checked',false);
            }
        });
        V('l_user','o').blur(function(){

            if(!$(this).val()){
                $(this).val('邮箱/手机号');
            }
            return false;
        });

        V('l_pwd','o').focus(function(){V('l_password_html','o').html('');});
        V('userLoginAccount','o').focus(function(){C('userLoginAccount','邮箱','re_user','请输入您注册的邮箱');});
        V('userLoginAccount','o').blur(function(){
            if(!$(this).val()){
                $(this).val('邮箱');
            }
            return false;
        });
        V('userLoginPwd','o').focus(function(){V('userLoginPwd_html','o').html('');});
        V('register_comfirm_pwd','o').focus(function(){V('register_comfirm_html','o').html('');});
        V('userLoginAccount','o').blur(function(){
            var user_value = V('userLoginAccount','v');
            if(!mtl_checkemail(user_value)){
                mtl_tip('re_user','您输入的邮箱格式不正确。',null,null,'hidden');
                return false;
            }
            var post_arr =  new Array();
            post_arr["userLoginAccount"]  = user_value;
            url = '<%=request.getContextPath()%>/user/check';
            ajax_post(url,post_arr,check_user);
        });
        V('userLoginPwd','o').blur(function(){
            if(V('userLoginPwd','v') == ''){
                mtl_tip('re_pwd','请设置密码！',null,null,'hidden');
                return false;
            }else{

                if(V('userLoginPwd','v').length>16){
                    mtl_tip('re_pwd','设置的密码最长16位！',null,null,'hidden');
                    V('userLoginPwd','o').val('');
                    return false;
                }
            }
        });
        V('register_comfirm_pwd','o').keyup(function(){
            var comfirm_value = V('register_comfirm_pwd','v');
            var pwd           = V('userLoginPwd','v');
            if(V('status','v') == 0){
                mtl_tip('re_user','请输入您的邮箱',null,null,'hidden');
                V('userLoginAccount','o').val('');
                return false;
            }
            if( comfirm_value== ''){
                mtl_tip('re_pwd_comfirm','请输入确认密码！',null,null,'hidden');
                return false;
            }
            if(comfirm_value != pwd){
                mtl_tip('re_pwd_comfirm','输入的确认密码不一致！',null,null,'hidden');
                return false;
            }else{
                mtl_tip('re_pwd_comfirm','信息填写成功！',null,null);
                V('status','o').val(1);
                return false;
            }
        });
        V('getCode','o').click(function(){
            $.ajax({
                url:'<%=request.getContextPath()%>/user/code',
                type:'get',
                data:{
                    'userLoginAccount':V('userLoginAccount','v')
                },
                success:function (data) {
                    alert(data);
                }
            });
        });
    });
</script>
</head>
<body class="wrapper_login" style="">
<div class="login_main">
    <div class="login_title">
        <a href="javascript:;" class="login_btn">登录米淘乐</a><a href="javascript:;" class="register_btn">注册</a>
        <div class="clear"></div>
    </div>
    <div class="register">
        <form method="POST" id="reg">
            <input type="hidden" value="1" id="status" name="status">
            <input type="hidden" value="3b7a9aaa6b08e946f1493d5557eb9166" name="safe_code">
            <div class="c1">
                <span class="c1_span"><img src="<%=basePath%>/images/login_icon3.gif"></span>
                <input type="text" value="邮箱" class="input_txt" id="userLoginAccount" name="userLoginAccount">
                <div class="login_tip" id="re_user"><span></span></div>
                <div class="clear"></div>
            </div>
            <div class="c1"><span class="c1_span"><img src="<%=basePath%>/images/login_icon2.gif"></span>
                <label>
                    <samp id="userLoginPwd_html">设置密码</samp>
                    <input type="password" maxlength="16" value="" class="input_txt" id="userLoginPwd" name="userLoginPwd">
                </label>
                <div class="login_tip" id="re_pwd"><span></span></div>

                <div class="clear"></div>
            </div>
            <div class="c1"><span class="c1_span"><img src="<%=basePath%>/images/login_icon2.gif"></span>
                <label><samp id="register_comfirm_html">确认密码</samp>
                    <input type="password" value="" class="input_txt" id="register_comfirm_pwd" name="register_comfirm_pwd">
                </label>
                <div class="clear"></div>
                <div class="login_tip" id="re_pwd_comfirm"><span></span></div>
            </div>
            <div class="c1"><span class="c1_span"><img src="<%=basePath%>/images/login_icon2.gif"></span>
                <label><samp id="registerCode_html"></samp>
                    <input type="text" value="" class="input_txt code_input" id="registerCode" name="registerCode">
                    <a class="input_txt code_check" id="getCode">获取验证码</a>
                </label>
                <div class="clear"></div>
                <div class="login_tip" id="re_code"><span></span></div>
            </div>
            <input type="hidden" name="back" value="aW5kZXg=">
        </form>
        <div class="c1">
            <input type="submit" value="提交注册" class="input_btn2" id="mtl_submit_re">
        </div>
        <div class="fast_login">
            <span>快速注册</span><samp>|</samp>
            <a href="javascript:open_link_pop(&#39;https://api.weibo.com/oauth2/authorize?client_id=3875553626&amp;redirect_uri=http%3A%2F%2Fwww.mitaole.com%2Fapi%2Fsina_callback&amp;response_type=code&amp;state=22ed0468b9acfc603625fa7682f5a80f&#39;);"><img src="<%=basePath%>/images/login_sina.png"></a>
            <a href="javascript:open_link_pop(&#39;http://www.mitaole.com/api/qq_url.html&#39;);"><img src="<%=basePath%>/images/login_QQ.png"></a>
            <a href="javascript:open_link_pop(&#39;http://www.mitaole.com/weixin_login/create_login_qrcode.html&#39;);"><img src="<%=basePath%>/images/login_wx.png"></a>
        </div>
    </div>
    <div class="login">
        <form id="login" method="POST">
            <input type="hidden" value="3b7a9aaa6b08e946f1493d5557eb9166" name="safe_code">
            <input type="hidden" value="form" name="from_form">
            <div class="c1"><span class="c1_span"><img src="<%=basePath%>/images/login_icon1.gif"></span>
                <input type="text" value="邮箱/手机号" class="input_txt" id="l_user" name="userLoginAccount">
                <div class="login_tip" id="login_user"><span></span></div>
                <div class="clear"></div>
            </div>
            <div class="c1"><span class="c1_span"><img src="<%=basePath%>/images/login_icon2.gif"></span><label><samp id="l_password_html">密码</samp><input type="password" value="" class="input_txt" id="l_pwd" name="userLoginPwd"></label>
                <div class="clear"></div>
            </div>
            <div class="login_tip" id="login_pwd"><span></span></div>
            <div class="c1">
                <input type="hidden" name="back" value="aW5kZXg=">
                <input type="submit" value="提交登录" class="input_btn" id="l_login">
            </div>
            <div class="fast_login">
                <span>快速登录</span>
                <samp>|</samp>
                <a href="javascript:open_link_pop(&#39;https://api.weibo.com/oauth2/authorize?client_id=3875553626&amp;redirect_uri=http%3A%2F%2Fwww.mitaole.com%2Fapi%2Fsina_callback&amp;response_type=code&amp;state=22ed0468b9acfc603625fa7682f5a80f&#39;);"><img src="<%=basePath%>/images/login_sina.png"></a>
                <a href="javascript:open_link_pop(&#39;http://www.mitaole.com/api/qq_url.html&#39;);"><img src="<%=basePath%>/images/login_QQ.png"></a>
                <a href="javascript:open_link_pop(&#39;http://www.mitaole.com/weixin_login/create_login_qrcode.html&#39;);"><img src="<%=basePath%>/images/login_wx.png"></a>
                <em><a href="http://www.mitaole.com/members/find_login_pwd.html">忘记密码</a></em>
                <em><input value="y" type="checkbox" name="jizhu_pwd"><a href="http://www.mitaole.com/members.html?b=aW5kZXg=###">记住密码|</a></em>
                <div class="clear"></div>
            </div>
        </form>
    </div>
</div>
<!--[if lte IE 6]>
<script src="http://www.mitaole.com/js/png.js" type="text/javascript"></script>
<script type="text/javascript">
    DD_belatedPNG.fix('img,.banner ul, li, dl, dt, dd, span, em, div, i, samp, b, a');
</script>
<![endif]-->
</body></html>
