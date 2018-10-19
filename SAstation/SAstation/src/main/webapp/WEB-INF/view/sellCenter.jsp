<%--
  Created by IntelliJ IDEA.
  User: ZHENG
  Date: 2018/10/18
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>有家宠物双十一活动大放送</title>
    <link rel="stylesheet" href="../static/css/normalize.css"/>
    <--link rel="stylesheet" href="../static/libs/font-awesome-4.5.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="../static/css/app.css"/>
    <script src="../static/libs/zepto/zepto.min.js"></script>
    <script src="../static/js/app.js"></script>

</head>
<body>
<!--头部 -->
<header class="top-header fixed-head">
    <i class="fa fa-bars"></i>
    <h3>有家宠物</h3>
    <div class="pull-right">
        <i class="fa fa-shopping-cart"><em>1</em></i>
        <i class="fa fa-tag"></i>
    </div>
    <!--排序-->
    <div class="shop-sort">
        <a href="shop-sort.html">推荐</a>
        <a href="shop-sort.html">最新</a>
        <a href="shop-sort.html">流行</a>
    </div>
    <!--购物车快捷-->
    <div class="shop-cart">
        <div class="cart-item">
            <button type="button"><i class="fa fa-trash-o"></i></button>
            <ul>
                <li>
                    <span><img src="../static/img/pic1.png"/></span>
                </li>
                <li>
                    <h4>史上最美连衣裙</h4>
                    <p>尺码：L</p>
                    <small>￥39.99</small>
                </li>
                <li>
                    <b>1</b>
                    <div class="add">
                        <i class="fa fa-chevron-up"></i>
                        <i class="fa fa-chevron-down"></i>
                    </div>
                </li>
            </ul>
        </div>
        <div class="cart-item">
            <button type="button"><i class="fa fa-trash-o"></i></button>
            <ul>
                <li>
                    <span><img src="../static/img/pic1.png"/></span>
                </li>
                <li>
                    <h4>史上最美连衣裙</h4>
                    <p>尺码：L</p>
                    <small>￥39.99</small>
                </li>
                <li>
                    <b>1</b>
                    <div class="add">
                        <i class="fa fa-chevron-up"></i>
                        <i class="fa fa-chevron-down"></i>
                    </div>
                </li>
            </ul>
        </div>
        <h3>￥396.99</h3>
        <input type="button" value="去结算" />
    </div>
</header>
<!--弹窗-->
<!--<div class="popupbox">
    <div class="popup">
        <p>确定删除该商品吗？</p>
        <button type="button" class="true-btn">确定</button>
        <button type="button" class="false-btn">取消</button>
    </div>
</div>-->
<!--侧边-->
<aside class="aside-menu hide-aside">
    <div class="none"></div>
    <div class="menu">
        <header class="side-head">
            <h4>You looking for?</h4>
            <span class="active">man</span>
            <span>woman</span>
        </header>
        <ul>
            <li>
                <div class="item">
                    <h5>服装</h5>
                    <i class="fa fa-angle-down"></i>
                </div>
                <dl class="item-body">
                    <dd>
                        <a href="products.html">连衣裙</a>
                    </dd>
                    <dd>
                        <a href="products.html">半身裙</a>
                    </dd>
                    <dd>
                        <a href="products.html">高腰裙</a>
                    </dd>
                    <dd>
                        <a href="products.html">长裙</a>
                    </dd>
                </dl>
            </li>
            <li>
                <div class="item">
                    <h5>鞋子</h5>
                    <i class="fa fa-angle-down"></i>
                </div>
                <dl class="item-body">
                    <dd>
                        <a href="products.html">短靴</a>
                    </dd>
                    <dd>
                        <a href="products.html">高筒靴</a>
                    </dd>
                    <dd>
                        <a href="products.html">雪地靴</a>
                    </dd>
                    <dd>
                        <a href="products.html">高跟鞋</a>
                    </dd>
                </dl>
            </li>
            <li>
                <div class="item">
                    <h5>外套</h5>
                    <i class="fa fa-angle-down"></i>
                </div>
                <dl class="item-body">
                    <dd>
                        <a href="products.html">皮衣</a>
                    </dd>
                    <dd>
                        <a href="products.html">大衣</a>
                    </dd>
                    <dd>
                        <a href="products.html">牛仔</a>
                    </dd>
                    <dd>
                        <a href="products.html">蕾丝</a>
                    </dd>
                </dl>
            </li>
            <li>
                <div class="item">
                    <h5>首饰</h5>
                    <i class="fa fa-angle-down"></i>
                </div>
                <dl class="item-body">
                    <dd>
                        <a href="products.html">戒指</a>
                    </dd>
                    <dd>
                        <a href="products.html">耳环</a>
                    </dd>
                    <dd>
                        <a href="products.html">项链</a>
                    </dd>
                    <dd>
                        <a href="products.html">手环</a>
                    </dd>
                </dl>
            </li>
        </ul>
        <hr />
        <ol>
            <li>
                <a href="index.html">
                    <i class="fa fa-home"></i>
                    <p>首页</p>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-calendar"></i>
                    <p>我的订单</p>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-cog"></i>
                    <p>设置</p>
                </a>
            </li>
        </ol>
    </div>
</aside>
<div class="container">
    <div class="banner">
        <img src="../static/img/test.jpg"/>
    </div>
    <div class="search-box">
        <i class="fa fa-search"></i>
        <input type="search" placeholder="蕾丝裙" />
    </div>
    <div class="prodoct">
        <ul id="goodslist">
            <script>
                addGoodsLi("goodslist","../static/img/bnwgxy.jpg","${good1._goosName}","${good1._goosPrice}","${good1._goosNum}")
            </script>

        </ul>
    </div>
</div>


</body>
</html>
