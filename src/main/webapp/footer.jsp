<%--
  Created by IntelliJ IDEA.
  User: viphu
  Date: 2017-11-05
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="footer">
    <div class="page2">
        <dl class="foot_list1">
            <dt>关于我们</dt>
            <dd><a href="#" rel="nofollow" target="_blank" title="回购网高价在线手机回收平台">关于回购网</a></dd>
            <dd><a href="#" target="_blank" rel="nofollow" title="回购网手机回收联系方式">联系我们</a></dd>
            <dd><a href="#" target="_blank" rel="nofollow" title="回购网长期招聘爱好手机回收行业的小伙伴">人才招聘</a></dd>
        </dl>
        <dl class="foot_list2">
            <dt>服务</dt>
            <dd><a href="#" target="_blank" rel="nofollow" title="手机回收常见问题与解答">服务条款</a></dd>
            <dd><a href="#" target="_blank" rel="nofollow" title="感谢您对手机回收相关问题的投诉与建议">投诉建议</a>
            </dd>
            <dd><a href="#" target="_blank" title="回购网的网站地图导航">网站地图</a></dd>
        </dl>
        <dl class="foot_list3">
            <dt>客服热线</dt>
            <dd>
                <p><img src="<%=basePath%>/images/new_images/tel.png"/></p>
                <div><a href="#" rel="nofollow" target="_blank" class="rk1" title="手机回收业务大客户登录入口">大客户入口</a><a
                        href="#" rel="nofollow" target="_blank" class="rk2" title="手机回收合作商登录入口">合作商入口</a>
                </div>
            </dd>
        </dl>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".weixin2").hover(function () {
                    $(this).find(".weixin-qrcode2").show();
                }, function () {
                    $(this).find(".weixin-qrcode2").hide();
                });
            });
        </script>
        <dl class="foot_list4">
            <dt>关注我们</dt>
            <dd class="sina"><a href="http://e.weibo.com/ihuigo?topnav=11" rel="nofollow" target="_blank">&nbsp;</a>
            </dd>
            <dd class="weixin"><a rel="nofollow" class="weixin2" target="_blank">
                <div class="weixin-qrcode2"></div>
            </a></dd>
        </dl>
        <div class="clear"></div>
        <div class="statist">
            <p><em>Copyright Reserved 2009-2016 @</em>
                回购网ihuigo.com版权所有
                <span>
                    <a href="#" target="_blank" rel="nofollow">粤ICP备10071783号</a>
                </span>
            </p>
        </div>
        <!--购物车-->
        <div class="mui-mbar">
            <!--黑色栏-->
            <div class="mui-mbar-mask">
                <div class="mui-mbar-gwc">
                    <div class="mui-mbar-wz"><em class="cart_total_items">0</em>
                        <p><img src="<%=basePath%>/images/new_images/cart.png"/></p>
                        <span>回购车</span>
                    </div>
                </div>
                <!--在线客服-->
                <div class="mui-mbar-kefu mui-mbar-all">
                    <div class="mui-mbar-go"><a rel="nofollow" href="javascript:void(0)"
                                                onclick="zixunserver('index/zixunserver.html')"><img
                            src="<%=basePath%>/images/new_images/cart_icon1.png"/></a></div>
                    <div class="mui-zaixian mui-mbar-last"><a href="javascript:void(0)"
                                                              onclick="zixunserver('index/zixunserver.html')">在线客服</a>
                    </div>
                </div>
                <!--在线客服-->
                <!--微信二维码-->
                <div class="mui-mbar-weixin">
                    <div class="mui-mbar-go"><a href="#" rel="nofollow" target="_blank"><img
                            src="<%=basePath%>/images/new_images/cart_icon2.png"/></a></div>
                    <div class="mui-weima"><a href="#" rel="nofollow" target="_blank"><img
                            src="<%=basePath%>/images/new_images/weixin.png" width="192" height="192"/></a></div>
                </div>
                <!--微信二维码-->
                <!--投诉建议-->
                <div class="mui-mbar-tousu mui-mbar-all">
                    <div class="mui-mbar-go"><a href="#" rel="nofollow" target="_blank"><img
                            src="<%=basePath%>/images/new_images/cart_icon3.png"/></a></div>
                    <div class="mui-jianyi mui-mbar-last"><a href="#" rel="nofollow"
                                                             target="_blank">投诉建议</a></div>
                </div>
                <!--投诉建议-->
                <!--返回顶部-->
                <div class="mui-mbar-top mui-mbar-all">
                    <div class="mui-mbar-go"><a rel="nofollow" href="javascript:goTop();" class="sidetop"><img
                            src="<%=basePath%>/images/new_images/go_top.png"/></a></div>
                    <div class="mui-fanhui mui-mbar-last">返回顶部</div>
                </div>
                <!--返回顶部-->
            </div>
            <!--黑色栏-->
            <!--购物车-->
            <div class="mui-mbar-cart">
                <div class="mui-list">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
                        <tr id="cart_tr_title">
                            <th class="table-padding">机型</th>
                            <th width="100">&nbsp;</th>
                            <th width="68">评估价</th>
                        </tr>
                    </table>
                </div>
                <!--结算-->
                <div class="mui-jiesuan">
                    <p>已选<em class="cart_total_items">0</em>台共计<em id="cart_total">￥0</em></p>
                    <input type="button" value="去结算" class="mui-button"
                           onclick="gocart('ajax/check_iflogin.html','order/cart.html')"/>
                </div>
                <!--结算-->
            </div>
            <!--购物车-->
        </div>
        <!--购物车-->
    </div>
</div>
<!--[if lte IE 6]>
<script src="<%=basePath%>/js/new_js/png.js" type="text/javascript"></script>
<script type="text/javascript">
DD_belatedPNG.fix('img,.banner ul, li, dl, dt, dd, span, em, div, i, samp, a, b, .kuang');
</script>
<![endif]-->
