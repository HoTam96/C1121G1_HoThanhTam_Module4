<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/29/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<form action="/dictionnary" method="post">
    <!-- Horizontal -->
    <div class="form-inline">
        <label for="myEmail">Tiếng anh</label>
        <input type="text" id="myEmail" class="form-control" placeholder="Englist" name="name">
        <label for="myPassword">Result</label>
        <input type="text" id="myPassword" class="form-control" placeholder="result" value="${dictionary}">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>
</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
