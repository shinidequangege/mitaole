<%--
  Created by IntelliJ IDEA.
  User: viphu
  Date: 2017-11-06
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String basePath=application.getInitParameter("localPath");//获取的是项目的根路径
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>iphone 7的30天内回收平均价格3360元-回购网 - 二手数码回收平台</title>
    <link href="<%=basePath%>/favicon.ico" type=image/x-icon rel="Icon">
    <link href="<%=basePath%>/css/new_css/global.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.bootcss.com/jquery/1.4.2/jquery.min.js"></script>
    <script src="<%=basePath%>/js/new_js/new_public.js" type="text/javascript"></script>
    <script type="text/javascript">
    </script>
    <link href="<%=basePath%>/css/new_css/sub.css" rel="stylesheet" type="text/css">
    <script src="<%=basePath%>/js/public.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/new_js/menu.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/new_js/new_goods.js" type="text/javascript"></script>
</head>
<body>
<%@include file="header.jsp"%>
<!--手机回收-->
<div class="recovery">
    <script type="text/javascript">
        $(document).ready(function () {
            $(".new_search_btn").click(function () {
                $(".new_search").slideToggle();
            });
        });
    </script>
    <div class="page2" style="position:relative">
        <div class="new_search_btn" style="position:absolute; left:-40px; top:-11px; cursor:pointer;"><img
                src="<%=basePath%>/images/new_images/search_btn.png" alt="搜索您要评估价格的机型"/></div>
        <div style="height:30px; line-height:30px; font-size:14px;"><a href="">首页</a> &gt;<a
                href="ershoushouji.html">手机</a> &gt;<a href="ershouiphone.html"> iPhone</a> &gt; iphone 7
        </div>
        <div class="heat_l">
            <div class="heat_img">
                <img src="${product.modelImg}" alt="iphone 7回收价格评估"
                     width="264" height="197"/>
            </div>
            <div class="heat_txt">
                <div class="heat_name"><span>${product.modelName}</span></div>
                <dl class="heat_ts">
                    <dd><em><fmt:formatNumber value="${product.modelPrice*0.8/100}" pattern="#0.00"/></em>元<br/>
                        30天内回收最高价
                    </dd>
                    <dt class="clear"></dt>
                </dl>
                <div class="heat_bao"><img src="<%=basePath%>/images/new_images/icon10.gif" alt="iphone 7回收免费享受第三方理赔服务"/>可免费享受第三方理赔服务
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
        <script src="<%=basePath%>/js/new_js/morris/raphael-2.1.0.min.js"></script>
        <script src="<%=basePath%>/js/new_js/morris/morris.js"></script>
        <link rel="stylesheet" href="<%=basePath%>/js/new_js/morris/morris.css">
        <div class="heat_r">
            <div class="heat_title"><span>回购价格趋势</span><samp>单位：元</samp></div>
            <div class="heat_pic">
                <div id="graph" style="width:360px; height:210px; margin-top:0px;"></div>
            </div>
            <script>
                var day_data = [
                    {"elapsed": "7", "价格": "2614"}
                    , {"elapsed": "8", "价格": "2607"}
                    , {"elapsed": "9", "价格": "2660"}
                    , {"elapsed": "10", "价格": "2822"}
                    , {"elapsed": "11", "价格": "2929"}
                ];
                Morris.Line({
                    element: 'graph',
                    data: day_data,
                    xkey: 'elapsed',
                    ykeys: ['价格'],
                    labels: ['价格'],
                    parseTime: false
                });
            </script>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!--手机回收-->
<!--评估流程-->
<div id="ahs_trade_body">
    <input type="hidden" id="view" value="goods_info"/>
    <input type="hidden" id="if_show_price" value="1"/>
    <input type="hidden" id="gid" name="gid" value="${product.modelId}"/>
    <input type="hidden" id="package_id" name="package_id" value="571"/>
    <div id="ahs_property_head">
        <p>开始评估你的手机，只需3步，获得产品精准评估报价</p>
        <!--步骤一-->
        <div class="speed" id="speed1"><img src="<%=basePath%>/images/new_images/step1.gif" alt="第1步评估手机的基本情况"/></div>
        <!--步骤一-->
        <!--步骤二-->
        <div class="speed" id="speed2"><img src="<%=basePath%>/images/new_images/step2.gif" alt="第2步评估手机的功能使用情况"/></div>
        <!--步骤二-->
        <!--步骤三-->
        <div class="speed" id="speed3"><img src="<%=basePath%>/images/new_images/step3.gif" alt="第一步评估手机的外观成色"/></div>
        <!--步骤三-->
    </div>
    <div id="ahs_property_body">
        <!--第一步-->
        <div id="property_step1">
            <dl>
                <c:forEach var="type" items="${info.get(0)}">
                    <dd>
                        <input type="hidden" name="property[]" id="property_${type.value.first().configTbDTO.typeTbDTO.typeId}" value="0"/>
                        <div class="property_title"><h3>${type.key}</h3></div>
                        <ul>
                            <c:forEach var="config" items="${type.value}">
                                <li class="" onClick="property_click(this,'${config.configTbDTO.typeTbDTO.typeId}','${config.mcId}')" name="sx_child_${config.configTbDTO.typeTbDTO.typeId}">
                                    <div class="pro_div">
                                        <span class="property_value"><i>${config.configTbDTO.configName}</i><ins>${config.mcDescribe}</ins></span>
                                        <span  class="gou"></span>
                                    </div>
                                </li>
                            </c:forEach>
                            <div class="clear"></div>
                        </ul>
                    </dd>
                </c:forEach>
                <div id="step1_nav" class="property_nav">
                    <div id="btn_step1_next" class="btn_next">下一步</div>
                </div>
            </dl>
        </div>
        <!--第一步-->
        <!--第二步-->
        <div id="property_step2" class="hide">
            <dl>
                <c:forEach var="type" items="${info.get(1)}">
                <dd>
                    <div class="property_title">
                        <h3>${type.key}</h3>
                    </div>
                    <ul>
                        <c:forEach var="config" items="${type.value}">
                        <%--<input type="hidden" name="desc_pid[]" value="944"/>--%>
                        <input type="hidden" name="desc_id[]" id="desc_id_${config.mcId}" value="0"/>
                            <li onClick="item_click(this,${config.mcId})" name="mx_child_${config.mcId}">
                                <div class="pro_div"><span class="property_value"><i>${config.configTbDTO.configName}</i><ins>${config.mcDescribe}</ins></span>
                                <span class="gou"></span></div>
                            </li>
                        </c:forEach>
                        <div class="clear"></div>
                    </ul>
                </dd>
                </c:forEach>
            </dl>
            <div id="step2_nav" class="property_nav">
                <div id="btn_step2_back" class="btn_back">< 返回上一步</div>
                <div id="btn_step2_next" class="btn_next">都没问题，跳过 ></div>
            </div>
        </div>
        <!--第二步-->
        <!--第三步-->
        <div id="property_step3" class="hide">
            <dl>
                <c:forEach var="type" items="${info.get(2)}">
                    <dd>
                        <input type="hidden" name="property[]" id="property_${type.value.first().configTbDTO.typeTbDTO.typeId}" value="0"/>
                        <div class="property_title"><h3>${type.key}</h3></div>
                        <ul>
                            <c:forEach var="config" items="${type.value}">
                                <li class="" onClick="property_click(this,'${config.configTbDTO.typeTbDTO.typeId}','${config.mcId}')" name="sx_child_${config.configTbDTO.typeTbDTO.typeId}">
                                    <div class="pro_div"><span class="property_value"><i>${config.configTbDTO.configName}</i><ins>${config.mcDescribe}</ins></span><span
                                            class="gou"></span></div>
                                </li>
                            </c:forEach>
                            <div class="clear"></div>
                        </ul>
                    </dd>
                </c:forEach>
            </dl>
            <div id="step3_nav" class="property_nav">
                <div id="btn_step3_back" class="btn_back">< 返回上一步</div>
                <div id="btn_step3_next" class="btn_next"
                     <%--onclick="new_show_price('ajax/new_get_pg_price.html','show_price')"--%>>查看价格 >
                </div>
            </div>
        </div>
        <!--第三步-->
    </div>
</div>
<script>
    $('#btn_step3_next').click(function () {
        var configIds = new Array();
        var flag=true;

        $('#property_step1 input').each(function () {
            var configId=$(this).val();
            if(configId==0)
            {
                alert("请选择评估参数");
                flag=false;
                return false;
            }else{
                configIds.push(configId);
            }
        });
        $('#property_step2 input').each(function () {
            var configId=$(this).val();
            if(configId!=0){
                configIds.push(configId);
            }
        });
        $('#property_step3 input').each(function () {
            var configId=$(this).val();
            if(configId==0)
            {
                alert("请选择评估参数");
                flag=false;
                return false;
            }else{
                configIds.push(configId);
            }
        });
        if(flag){
            var params = new Array();
            params['configIds']=configIds;
            params['ModelId']=$('#gid').val();
            post('<%=request.getContextPath()%>/goods/price',params)
        }
    });
    /*发送post请求*/
    function post(URL, PARAMS) {
        var temp = document.createElement("form");
        temp.action = URL;
        temp.method = "post";
        temp.style.display = "none";
        for (var x in PARAMS) {
            var opt = document.createElement("textarea");
            opt.name = x;
            opt.value = PARAMS[x];
            // alert(opt.name)
            temp.appendChild(opt);
        }
        document.body.appendChild(temp);
        temp.submit();
        return temp;
    }
</script>
<!--评估流程-->
<!--隐藏的评估描叙选项start-->
<div style="display:none; background-color:#CCCCCC;">
</div>
<!--隐藏的评估描叙选项end-->
<script>
    $(document).ready(function () {
        $("#step1_nav .btn_next").bind('click', step1_next);
        $("#step2_nav .btn_next").bind('click', step2_next);
        $("#step2_nav .btn_back").bind('click', step2_back);
        $("#step3_nav .btn_back").bind('click', step3_back);

        $("input[name='property[]']").each(function () {
            $(this).val(0);
        })
        $("#property_step1 input[name='desc_id[]']").each(function () {
            $(this).val(0);
        })
        $("#property_step3 input[name='desc_id[]']").each(function () {
            $(this).val(0);
        })
        $("#pj_ids").val(0);
    })
</script>
<%@include file="footer.jsp"%>
</body>
</html>
