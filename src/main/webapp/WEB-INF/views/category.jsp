
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
    </head>
    <body>

        <table class="table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Photo</th>
                <th>Action</th>

            </tr>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.quantity}</td>
                    <td>
                            <img src="data:image/jpg;base64,${category.base64Image}" width="240" height="300"/>

                    </td>
                    <td>
                        <a href="/edit/${category.id}">Edit
                        </a>
                        <a  href="/delete/${category.id}">Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
