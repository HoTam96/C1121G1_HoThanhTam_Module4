<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<div align="center">
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>

        <tr>
            <th>name</th>
            <th>dateOfBirth</th>
            <th>gender</th>
            <th>nationality</th>
            <th>id_card</th>
            <th>travelInformation</th>
            <th>vehicleNumber</th>
            <th>seatingNumber</th>
            <th>startDate</th>
            <th>endDate</th>
            <th>description</th>
            <th>address</th>
            <th>phoneNumber</th>
            <th>email</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${list}">
            <tr>
                <td><c:out value="${i.name}"/></td>
                <td><c:out value="${i.dateOfBirth}"/></td>
                <td><c:out value="${i.gender}"/></td>
                <td><c:out value="${i.nationality}"/></td>
                <td><c:out value="${i.id_card}"/></td>
                <td><c:out value="${i.travelInformation}"/></td>
                <td><c:out value="${i.vehicleNumber}"/></td>
                <td><c:out value="${i.seatingNumber}"/></td>
                <td><c:out value="${i.startDate}"/></td>
                <td><c:out value="${i.endDate}"/></td>
                <td><c:out value="${i.description}"/></td>
                <td><c:out value="${i.address}"/></td>
                <td><c:out value="${i.phoneNumber}"/></td>
                <td><c:out value="${i.email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
<script>
    function getId(id) {
        document.getElementById("idDelete").value = id;
    }

</script>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</html>
