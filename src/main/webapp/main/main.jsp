<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>持明法州后台管理系统</title>
    <link rel="icon" href="${path}/bootstrap/img/arrow-up.png" type="image/x-icon">
    <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.css">

    <%--引入jqgrid中主题css--%>
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/css/css/hot-sneaks/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/boot/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${path}/bootstrap/js/jquery.min.js"></script>
    <script src="${path}/bootstrap/js/bootstrap.js"></script>
    <script src="${path}/bootstrap/jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="${path}/bootstrap/jqgrid/boot/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${path}/bootstrap/js/ajaxfileupload.js"></script>

</head>
<body>
<div>
    <!--顶部导航-->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <!--导航条将充满整个屏幕-->
        <div class="container-fluid">
            <!--导航条的标题-->
            <div class="navbar-header">

                <a class="navbar-brand" href="main.html">持名法州管理系统</a>
            </div>

            <!--具体的导航条的元素-->
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav navbar-right">

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"a>欢迎：${sessionScope.username}<span class="caret"></span></a>
                    </li>
                    <li><a href="${path}/admin/logout"><span class="glyphicon glyphicon-log-out">安全退出</span></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<hr>
<hr>
<div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <div class="panel-group" id="accordion">
                    <!--默认的面版样式-->
                    <div class="panel panel-default">
                        <!--面板头-->
                        <div class="panel-heading">
                            <!--面板标题-->
                            <h4 class="panel-title">
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    用户管理
                                </a>

                            </h4>
                            <div id="collapseOne" class="panel-collapse collapse">
                                <!--面板的主体内容-->
                                <div class="panel-body">
                                    <button class="btn btn-info" type="button"><a href="javascript:$('#mainId').load('${path}/user/user.jsp')">用户信息</a><br/></button><br/>
                                </div>
                                <div class="panel-body">
                                    <button class="btn btn-info" type="button"><a href="${path}/user/ChartsUser.jsp">用户统计</a> <br/></button><br/>
                                </div>
                                <div class="panel-body">
                                    <button class="btn btn-info" type="button"><a href="${path}/user/UserPro.jsp">用户分布</a> <br/></button>
                                </div>
                            </div>
                        </div>

                    </div>
                    <hr>
                    <div class="panel panel-danger">
                        <!--面板头-->
                        <div class="panel-heading">
                            <!--面板标题-->
                            <h4 class="panel-title">
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapset">
                                    轮播图管理
                                </a>
                            </h4>
                        </div>
                        <div id="collapset" class="panel-info collapse">
                            <!--面板的主体内容-->
                            <div class="panel-body">
                                <button class="btn btn-success" type="button">
                                <a href="javascript:$('#mainId').load('${path}/banner/banner.jsp')">轮播图信息</a> <br/>
                                </button>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="panel panel-success">
                        <!--面板头-->
                        <div class="panel-heading">
                            <!--面板标题-->
                            <h4 class="panel-title">
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapses">
                                    专辑管理
                                </a>
                            </h4>
                        </div>
                        <div id="collapses" class="panel-primary collapse">
                            <!--面板的主体内容-->
                            <div class="panel-body">
                                <button class="btn btn-danger" type="button">
                                <a href="javascript:$('#mainId').load('${path}/album/album.jsp')">专辑信息</a> <br/>
                                </button>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="panel panel-success">
                        <!--面板头-->
                        <div class="panel-heading">
                            <!--面板标题-->
                            <h4 class="panel-title">
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapsef">
                                    文章管理
                                </a>
                            </h4>
                        </div>
                        <div id="collapsef" class="panel-primary collapse">
                            <!--面板的主体内容-->
                            <div class="panel-body">
                                <button class="btn btn-info" type="button">
                                <a href="javascript:$('#mainId').load('${path}/article/article.jsp')">文章信息</a> <br/>
                                </button>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="panel panel-primary">
                        <!--面板头-->
                        <div class="panel-heading">
                            <!--面板标题-->
                            <h4 class="panel-title">
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapsev">
                                    上师管理
                                </a>
                            </h4>
                        </div>
                    </div>
                    <hr>
                    <div class="panel panel-danger">
                        <!--面板头-->
                        <div class="panel-heading">
                            <!--面板标题-->
                            <h4 class="panel-title">
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapsex">
                                    管理员管理
                                </a>
                            </h4>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-10" id="mainId">
                <div class="jumbotron">
                    <h3>欢迎来到持明法州管理系统</h3>
                </div>
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                    </ol>
                    <!--幻灯片的图片-->
                    <div class="carousel-inner" style="height: 400px">
                        <div class="item active" style="height: 400px">
                            <img src="${path}/bootstrap/img/shouye.jpg" style="height: 100%;width: 100%">
                        </div>
                        <div class="item" style="height: 400px">
                            <img src="${path}/bootstrap/img/1.png" style="height: 100%;width: 100%">
                        </div>
                        <div class="item" style="height: 400px">
                            <img src="${path}/bootstrap/img/2.png" style="height: 100%;width: 100%">
                        </div>
                        <div class="item" style="height: 400px">
                            <img src="${path}/bootstrap/img/3.png" style="height: 100%;width: 100%">
                        </div>
                        <div class="item" style="height: 400px">
                            <img src="${path}/bootstrap/img/4.png" style="height: 100%;width: 100%">
                        </div>
                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic"  data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic"  data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>
        </div>
    </div>
<div class="panel panel-footer" align="center">
    <div>@zzs 123456</div>
</div>
</div>


    <!--栅格系统-->
        <!--左边手风琴部分-->
        <!--巨幕开始-->
        <!--右边轮播图部分-->
        <!--页脚-->
    <!--栅格系统-->

</body>
</html>
