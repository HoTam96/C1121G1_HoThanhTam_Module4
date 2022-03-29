<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/29/2022
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/Currency" method="post" >
    <div class="form-check-input">
        <label for="exampleInputEmail1">add USD</label>
        <input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="a" placeholder="Enter email">
    </div>
    <p>giá chuyển đổi: 1 đô la = 23.000VND</p>
    <div class="form-check-input">
        <label for="exampleInputPassword1">result: VNĐ</label>
        <input class="form-control" id="exampleInputPassword1" value="${result}" placeholder="result">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
