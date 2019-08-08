<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%--javascript 方式获取SDK--%>
    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>

    <%--引入echarts--%>
    <script src="${path}/js/echarts.js"></script>
    <script src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript">

        $(function () {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            $.get("${path}/charts/queryUser", function (data) {
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '用户月注册统计表',
                        link: "${path}/main/main.jsp",
                    },
                    tooltip: {},//鼠标的提示
                    legend: {
                        data: ['男孩', '女孩']
                    },
                    xAxis: {
                        data: data.month
                    },
                    yAxis: {},
                    series: [{
                        name: '男孩',
                        type: 'bar',
                        data: data.boys
                    }, {
                        name: '女孩',
                        type: 'bar',
                        data: data.girls
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }, "json");

        });
        $(function () {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            var goEasy = new GoEasy({
                appkey: "BC-ec0591bea40342be80bad8cc240ec43e" //自己的appkeys
            });
            goEasy.subscribe({
                channel: "myChannelZ", //管道标识
                onMessage: function (message) {
                    var data = JSON.parse(message.content);
                    // $.get("${path}/charts/queryUser", function (data) {
                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '用户月注册统计表',
                            link: "${path}/main/main.jsp",
                        },
                        tooltip: {},//鼠标的提示
                        legend: {
                            data: ['男孩', '女孩']
                        },
                        xAxis: {
                            data: data.month
                        },
                        yAxis: {},
                        series: [{
                            name: '男孩',
                            type: 'bar',
                            data: data.boys
                        }, {
                            name: '女孩',
                            type: 'bar',
                            data: data.girls
                        }]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    // }, "json");

                }
            });
        });
    </script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>

</body>
</html>


