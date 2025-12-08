<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
                <div class="col-12 mx-auto">
                    <div class="d-flex justify-content-between">
                        <h2>Table Users</h2>
                        <a href="/admin/user/create" class="btn btn-primary">
                            Create Users
                        </a>
                    </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Phone Numbers</th>
                    <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users1}">
                        <th>
                            <!-- <td>${user.id}</td>
                            <td>${user.fullName}</td>
                            <td>${user.address}</td>
                            <td>${user.phone}</td>
                            <td>
                                <button class="btn btn-primary">View</button>
                                <button class="btn btn-danger">Delete</button>
                                <button class="btn btn-warning">Edit</button>
                            </td> -->
                        </th>
                    </c:forEach>
                </tbody>
            </table>
            </div>
            </div>
        </div>
   </div>
</body>
</html>