<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Child Sub Category</title>

        <!-- Bootstrap core CSS -->
        <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="dashboard.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
        <script src="../../assests/js/dash.js"></script>

      
    </head>

    <body>
        <link rel="stylesheet" type="text/css" href="../../assests/css/dc.css">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Settings</a></li>
                        <li><a href="#">Sign in as admin</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li class="active"><a href=updateinventory>Update Inventory <span class="sr-only">(current)</span></a></li>
                        <li><a href=viewreport>View Report</a></li>
                        <li><a href=category>Category</a></li>
                        <li><a href=subcategory>Sub-Category</a></li>
                        <li><a href=childsubcategory>Child Sub-Category</a></li>
                        <li><a href=vendor>Vendor</a></li>
                        <li><a href=location>Location</a></li>
                        <li><a href=return>Return</a></li>
                        <li><a href=warranty>Warranty/Garranty</a></li>

                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Add Child Sub-Category</h1>
                    <div class="col-md-4">
                        <form> 
                            <div class="form-group">
                                <div class="form-row align-items-center">
                                    <div class="col-auto my-1">

                                        <select name="categoriesId" class="category-name" onchange="javascript:handleSelect(this)">
                                            <option value="${id}">${category}</option>
                                            <c:forEach var="category" items="${categories}"> 
                                                <option value="${category.id}">${category.name}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-row align-items-center">
                                    <div class="col-auto my-1">

                                        <select name="categoriesId" class="category-name" onchange="javascript:handleSelectchildsub(this)">
                                            <option value="${id}">${category}</option>
                                            <c:forEach var="subcategorie" items="${subCategories}"> 
                                                <option value="${subcategorie.id}">${subcategorie.name}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Child Sub-Category</label>
                                <input type="email" class="form-control"   placeholder="Enter Child Sub category ">
                            </div>
                            <button type="submit" class="btn btn-primary">Add</button>
                        </form>
                    </div>   
                    <div class="col-md-8">
                    </div>
                    <table class="table">
                        <tr>
                            <th>Id</th>
                            <th>Child Sub-Category Name</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="category" items="${childSubCategories}">
                            <tr>
                                <td>${category.id}</td>

                                <td>${ChildSubcategory.name}</td>

                                <td>${category.quantity}</td>

                                <td>
                                    <a href="/edit/${category.id}">Edit
                                    </a>
                                    <a href="/delete/${category.id}" onclick="return confir('Are you sure want to delete')">Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            var link1;
            function handleSelect(elm)
            {
                alert('s');
                link1 = elm.value;
                window.location = "/childsubcategory/subcategoryofcategory/" + elm.value;
            }
            function handleSelectchildsub(elm)
            {
                window.location = "/childsubcategory/ch/" + elm.value + "/" + ${categoryId};
            }
        </script>
        <script>
            document.querySelector($".category-name").value = "${category}";
        </script>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</html>
