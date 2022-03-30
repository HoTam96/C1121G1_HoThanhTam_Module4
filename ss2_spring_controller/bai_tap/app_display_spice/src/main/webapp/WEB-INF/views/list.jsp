<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/30/2022
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" items="${condiment}">
    <p>${i}</p>
</c:forEach>

</body>
</html>
