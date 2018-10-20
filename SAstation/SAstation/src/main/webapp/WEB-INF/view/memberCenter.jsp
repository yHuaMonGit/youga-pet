<%--
  Created by IntelliJ IDEA.
  User: ZHENG
  Date: 2018/10/21
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>有家宠物会员中心</title>
    <link rel="stylesheet" href="">
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../static/css/style.css" rel="stylesheet">
    <script src="../static/js/jquery.min.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="../static/css/menu_elastic.css" />
    <script src="../static/js/snap.svg-min.js"></script>
    <script src="../static/js/classie.js"></script>
    <script src="../static/js/member.js"></script>
    <script src="../static/js/main3.js"></script>
    <!--[if IE]>
    <script src="../static/js/html5.js"></script>
    <![endif]-->
</head>
<body class="huibg">
<div class="vipcenter">
    <div class="vipheader" id="vipHead">

        <script>
            getIcon("vipHead",${userInfoList})
            getName("vipHead",${userInfoList})
        </script>

        <div class="gztt">认证会员，已关注</div>
    </div>
    <div class="vipsan">
        <div class="col-xs-4 text-center"><a ><h4>等级</h4><p>Vip1</p></a></div>
        <div class="col-xs-4 text-center"><a ><h4>积分</h4><p>1200</p></a></div>
        <div class="col-xs-4 text-center"><a ><h4>领取码</h4><p>3</p></a></div>
    </div>
    <ul class="vipul">
        <li>
            <a href="#">
                <div class="icc"><i class="iconfont icon-xitongmingpian"></i></div>
                <div class="lzz">会员认证</div>
                <div class="rizi lvzi">已认证</div>
            </a>
        </li>
        <li>
            <a href="#">
                <div class="icc"><i class="iconfont icon-huodongfj"></i></div>
                <div class="lzz">活动中心</div>
                <div class="rizi"><i class="iconfont icon-jiantouri"></i></div>
            </a>
        </li>
        <li>
            <a href="ddcenter.html">
                <div class="icc"><i class="iconfont icon-liebiao"></i></div>
                <div class="lzz">订单中心</div>
                <div class="rizi"><i class="iconfont icon-jiantouri"></i></div>
            </a>
        </li>
        <li>
            <a href="userinfo.html">
                <div class="icc"><i class="iconfont icon-yonghux"></i></div>
                <div class="lzz">个人信息</div>
                <div class="rizi"><i class="iconfont icon-jiantouri"></i></div>
            </a>
        </li>
        <li>
            <a href="http://localhost:8080/main/dizhi">
                <div class="icc"><i class="iconfont icon-chakangonglve"></i></div>
                <div class="lzz">收货地址</div>
                <div class="rizi"><i class="iconfont icon-jiantouri"></i></div>
            </a>
        </li>
    </ul>
</div>
<div class="footnav">
    <div class="col-xs-3 text-center"><a href="index.html"><i class="iconfont icon-shop"></i><p>积分商城</p></a></div>
    <div class="col-xs-3 text-center"><a href="#"><i class="iconfont icon-huodongfj"></i><p>活动中心</p></a></div>
    <div class="col-xs-3 text-center"><a href="ddcenter.html"><i class="iconfont icon-liebiao"></i><p>订单中心</p></a></div>
    <div class="col-xs-3 text-center"><a href="mendian.html"><i class="iconfont icon-dizhi"></i><p>附近门店</p></a></div>
</div>



</body>
</html>
