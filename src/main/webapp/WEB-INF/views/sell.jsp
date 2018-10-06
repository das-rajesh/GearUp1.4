

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sale Report </title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="css/catrep.css">
        <div class="container">
            <div class="row">
                <h1>Sale  Report</h1> 
                <c:set var="evenCount" value="${0}" />

                <table class="table">
                    <thead>
                        <tr>
                            <th>S.No</th>
                            <th>Purchase Date</th>
                            <th>Category</th>
                            <th>Sub-Category</th>
                            <th>Child Sub-Category</th>
                            <th>Image</th>
                            <th>unit price</th>
                            <th>quantity</th>
                            <th>Total price</th>
                        </tr>
                    </thead><tr>
                        <td>${category.id}</td>
                    </tr>
                    <c:forEach var="sale" items="${sales}">
                        <c:set var="evenCount" value="${evenCount+1}" />
                        <tr>
                            <td>${evenCount}</td>
                            <td>${sale.purchasedDate}</td>
                            <td>${sale.category}</td>
                            <td>${sale.subcategory}</td>
                            <td>${sale.childsubcategory}</td>
                            <td> 
                                    <img src="data:image/jpg;base64,${sale.base64Image}" width="100" height="100"/>
                            </td>
                            <td id="price" >${sale.unitprice}</d>
                            <td id="quantity">${sale.quantity}</td>
                            <td id="total">${sale.totalprice}</td>

                        </tr>
                    </c:forEach>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
        <script language="javascript">
// Parse your values
            var $val1 = parseInt($('#price', this).innerHTML);
            var $val2 = parseInt($('#quantity', this).innerHTML);
// Get your total
            var $total = $val1 * $val2
// Set your value
                    $('#total', this).val($total);
                    function multiply() {
            var ans = (document.getElementById("price").innerHTML) * document.getElementById("quantity").innerHTML);
            document.getElementById("total").innerHTML = ans;
            }
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>

</html>
