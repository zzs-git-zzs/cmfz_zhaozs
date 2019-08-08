<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>注册用户</title>
</head>

<body>
<table border="1px" cellpadding="10px" cellspacing="0px"
       style="width: 30%;margin:auto;background:rgb(195,195,195)"
       bordercolor="red" >
    <caption>注册用户</caption>
    <form action="#" method="get">

        <tr>
            <th>用户名:</th>
            <td><input type="text" name="name"></th>
        </tr>
        <tr>
            <th>密码:</th>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <th>性别:</th>
            <td>
                <input type="radio" name="sex" value="man" checked="checked">男 &nbsp;&nbsp;
                <input type="radio" name="sex" value="woman">女
            </td>
        </tr>

        <tr>
            <th>所在城市:</th>
            <td><input type="text" name="city"></th>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="提交">
            </th>
        </tr>
    </form>
</table>
</body>
</html>
    