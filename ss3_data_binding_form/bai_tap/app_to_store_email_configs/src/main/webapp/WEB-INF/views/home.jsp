<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/31/2022
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/email" method="post" modelAttribute="email" >

    <table>
        <tr>
            <th>languages</th>
            <td><form:select path="language">
                <option>English</option>
                <option>Vietnamese</option>
                <option>Japanese</option>
                <option>Chinese</option>
            </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size</th>
            <td><form:select path="pageSize">
                <option>5</option>
                <option>10</option>
                <option>15</option>
                <option>20</option>
                <option>25</option>
            </form:select>
                email per page </td>
<%--            <form:input path=""type="checkbox" value="spams"> enable spams fillter--%>
        </tr>
        <tr>
            <th>spams fillter</th>
            <td><form:checkbox path="spams" />enable spams fillter</td>
        </tr>
        <tr>
            <th>singnature</th>
            <td>
                <form:textarea path="sign"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <button type="submit">Update</button>
                <button type="reset">cancel</button>
            </td>
        </tr>

    </table>

</form:form>
</body>
</html>
