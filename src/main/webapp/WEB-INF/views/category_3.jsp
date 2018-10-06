<%@include file="shared/header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

    <h1 class="page-header">Add Category</h1>
    <div class="col-md-4">
        <form method="post">
            <div class="form-group">
                <label for="exampleInputCategory">Category</label>
                <input type="text" class="form-control" name="name"   placeholder="Enter category">
            </div>
            <button type="submit" >Add</button>
        </form>


    </div>   
    <div class="col-md-8">
    </div>
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Action</th>

        </tr>

        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.quantity}</td>
                <td>
                    <a href="/category/edit/${category.id}">Edit</a>
                    <a href="/category/delete/${category.id}">Delete</a>
                </td>
            </tr>

        </c:forEach>


    </table>



</div>
</div>
</div>



</body>
</html>
