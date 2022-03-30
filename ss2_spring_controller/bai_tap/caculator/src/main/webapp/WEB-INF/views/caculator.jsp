<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/30/2022
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/caculator">
    <input type="text" placeholder="nhập vào" name="number1">
    <input type="text" placeholder="nhập vào" name="number2">
  <button type="submit" name="opera" value="plus">Cộng</button>
  <button type="submit" name="opera" value="minus">trừ</button>
  <button type="submit" name="opera" value="multiplication">nhân</button>
  <button type="submit" name="opera" value="division">chia</button>
</form>
kết qua : <input value="${result}" disabled>
<p>${message}</p>
</body>
</html>
