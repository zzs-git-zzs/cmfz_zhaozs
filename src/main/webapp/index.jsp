<%@  page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<div align="denter"><br>
    <table cellpadding="0" cellspacing="0" align="center" border="1" width="300" height="20">
     <tr align="center">
         <td>ID</td><td>USERNAME</td><td>PATH</td><td>STATUS</td><td>UPDATE</td><td>DESCRIBE</td>
     </tr>
         <c:forEach var="ca" items="${sessionScope.carousels}">
          <tr>
            <td>${ca.id}</td>
             <td>${ca.username}</td>
             <td><img align="center" width="70" height="50" src="${pageContext.request.contextPath}/${ca.path}"></td>
             <td>${ca.status}</td>
             <td>${ca.update}</td>
             <td>${ca.describe}</td>
          </tr>
         </c:forEach>
    </table>
</div>

</body>
    