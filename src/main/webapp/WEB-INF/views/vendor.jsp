
<%@include file="shared/header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Add Vendor's Company</h1>
    <div class="col-md-4">
        <form method="post"> 
            <div class="form-group">
                <label for="exampleInputVendor">Company Name</label>
                <input type="vendor" class="form-control" name="name"  placeholder="Enter Company name ">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Email</label>
                <input type="email" class="form-control" name="email"  placeholder="Enter Email">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Contact Number</label>
                <input type="number" class="form-control" name="contactNo"  placeholder="Enter Number">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Website </label>
                <input type="website" class="form-control" name="website"  placeholder="Enter Website">
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Type</label>
                <select class="form-control" name="type" id="exampleFormControlSelect1">
                    <option>International</option>
                    <option>National</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Country </label>
                <input type="country" class="form-control" name="country"  placeholder="Enter Country">
            </div>               

            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>   
    <div class="col-md-8">
    </div>
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Comany Name</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Website</th>
            <th>Type</th>
            <th>Action</th>
        </tr>
        <c:forEach var="vendor" items="${vendors}">
            <tr>
                <td>${vendor.id}</td>
                <td>${vendor.name}</td>
                <td>${vendor.email}</td>
                <td>${vendor.contactNo}</td>
                <td>${vendor.website}</td>
                <td>${vendor.type}</td>
                <td>
                    <a href="/vendor/edit/${vendor.id}">Edit</a>
                    <a href="/vendor/delete/${vendor.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</html>
