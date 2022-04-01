<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/31/2022
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/list" modelAttribute="email" >
<table>
<tr>
    <th>
        language
    </th>
    <td>${email.language}</td>
</tr>
    <tr>
        <th>
            page size
        </th>
        <td>${email.pageSize}</td>
    </tr>

    <tr>
        <th>
            spams fillter
        </th>
        <td>${email.spams}</td>
    </tr>

    <tr>
        <th>
            singnature
        </th>
        <td>${email.sign}</td>
    </tr>

    <form:hidden  path="language"  value="${email.language}"/>
    <form:hidden  path="pageSize" value="${email.pageSize}"/>
    <form:hidden  path="spams" value="${email.spams}"/>
    <form:hidden  path="sign" value="${email.sign}"/>
    <form:button>show list</form:button>
</table>
</form:form>
</body>
</html>
