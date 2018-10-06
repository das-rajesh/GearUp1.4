<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.gearupnepal.web.entity.TempChild"%>
<%@page import="java.util.List"%>
<%@page import="com.gearupnepal.web.service.impl.ChildSubCategoryServiceImpl"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.gearupnepal.web.service.ChildSubcategoryService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Home</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                </form>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Sign in as admin</a></li>
                        <li><a href="/logout" class="glyphicon glyphicon-off"></a></li>

                    </ul>

                </div>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</head>
<body id="pointofform">
    <link rel="stylesheet" type="text/css" href="../../assests/css/pos.css">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <% List<TempChild> eList = new ArrayList<TempChild>();
                    TempChild tempChild;
                    // eList.add(new TempChild(id, name, quantity, price))
                %>

                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">S.No</th>
                            <th scope="col">Name</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Price</th>
                            <th scope="col">Change</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="evenCount" value="${0}" />

                        <c:forEach var="tempChild" items="${tempChilds}">
                            <c:set var="evenCount" value="${evenCount+1}" />
                            <% tempChild = new TempChild(); %>
                            <tr>
                        <form method="post" action="/POS/change/${evenCount}">

                            <th scope="row">${evenCount}<%tempChild.setId(2);%></th>
                            <td>${tempChild.name}</td>  
                            <td><div class="quantity">
                                    <input type="number" name="quantity" min="1" max="${tempChild.quantity}" step="1" value="${tempChild.quantity}">
                                </div>
                            </td>                    
                            <td>${tempChild.price}</td>
                            <input type="hidden" name="name" value="${tempChild.name}" />
                            <input type="hidden" name="price" value="${tempChild.price}" />
                            <td> <button type="submit">change</button></td>
                        </form>


                        </tr>
                    </c:forEach>


                    <tr>
                        <td><form method="post" action="/POS/child/${id}">
                                <button type="button" id="${id}" onclick="javascript:buttonClick(this)"   class="btn btn-primary">All Total
                            </form></td>
                        <td></td>
                        <td></td>
                        <td>${totals}</td> 
                    <div class="name">
                        <input type="hidden" name="name"  value="${tempChild.name}">
                    </div>
                    </tr>

                    </tr>
                    <tr>

                        <td><form method="post" action="/POS/child/${id}">
                                <button type="button" id="${id}" onclick="javascript:purchase(this)"   class="btn btn-primary">Purchase
                            </form></td>
                    </tr>
                    </tbody>
                </table>
   <form:form method="post" action="/POS/update" modelAttribute="tempChildListWrapper">

                    <!--<button type="submit" id="${id}" class="btn btn-primary">Purchase</button>-->
                <input type="submit" value="Submit"/>
                </form:form>


            </div>
            <div class="col-md-8">
                <h2><span class="label label-primary">Product</span></h2>
                <div class="row">
                    <!-- Single button -->
                    <!-- Split button -->
                    <c:forEach  var="category" items="${categories}">
                        <div class="btn-group">
                            <button type="button" class="btn btn-warning">${category.name}</button>
                            <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="caret"></span>
                                <span class="sr-only">Toggle Dropdown</span>
                            </button>
                            <ul class="dropdown-menu">
                                <c:forEach var="subcategory" items="${category.subCategoryList}">
                                    <li value="${subcategory.id}"><a href="/POS/${subcategory.id}">${subcategory.name}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>


                    </c:forEach>
                    <div class="btn1" id="main">
                        <c:forEach var="childSubCategory" items="${childSubCategoriesbyId}">
                            <form method="get" action="/POS/child/${childSubCategory.id}">
                                <button  type="submit"  class="btn btn-danger"> ${childSubCategory.name}</button>

                            </form>
                        </c:forEach>
                    </div>



                </div>
            </div>
        </div>        
    </div>
    <script>
        var link1;
        function handleSubCategoryList(elm)
        {
            // alert('s');
            link1 = elm.value;
            window.location = "/updateinventory/subcategoryofcategory/" + elm.value;
        }</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>
        var link1;
        function purchase(elm)
        {
            alert('s');
            link1 = elm.value;


            //window.location = "/updateinventory/subcategoryofcategory/" + elm.value;
        }</script>
</body>
</html>
