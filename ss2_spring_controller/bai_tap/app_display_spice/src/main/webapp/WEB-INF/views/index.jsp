<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/30/2022
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${message}</p>
<form action="/sandWich" method="post">
    <input type="checkbox" name="condiment" value="lettuce"><span>lettuce</span>
    <input type="checkbox" name="condiment" value="tomato"><span>tomato</span>
    <input type="checkbox" name="condiment" value="mustart"><span>mustart</span>
    <input type="checkbox" name="condiment" value="Sporouts"><span>Sporouts</span><br>
    <input type="submit" value="save">
</form>


</body>
</html>
