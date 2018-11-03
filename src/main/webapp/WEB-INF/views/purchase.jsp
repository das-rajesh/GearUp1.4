<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase </title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

        <script type="text/javascript" src="js/script.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body>

        <div class="container">

            <div class="row">
                <nav class="navbar navbar-inverse navbar-fixed">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">Purchase Report</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="/admin/dash">HOME</a></li>
                                <li><a href="/admin/purchasereports">Download</a></li>


                            </ul>

                        </div>
                    </div>
                </nav>

                <h1></h1> 


                <div class="col-lg-12">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table tablesorter " id="table">
                                <thead class=" text-primary">
                                <th>S.No</th>
                                <th>Purchase Date</th>
                                <th>vendor</th>
                                <th>Category</th>
                                <th>Sub-Category</th>
                                <th>Child Sub-Category</th>
                                <th>Size</th>
                                <th>unit price</th>
                                <th>quantity</th>
                                <th>Total price</th>
                                </thead>
                                <tbody id="t-body">


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script>

            $(document).ready(function () {
                //your code here

                $.getJSON("/admin/api/purchasereport", function (res) {
                    $.each(res, function (i, resp) {
                        var $tr = $("<tr/>");
                        var $tbody = $("#t-body");
                        
                        
                        
                        $("<td/>").html(i + 1).appendTo($tr);
                        $("<td/>").html(resp.createdDate).appendTo($tr);
                        $("<td/>").html(resp.childSubCategoriesId.vendorId.name).appendTo($tr);
                        $("<td/>").html(resp.childSubCategoriesId.subCategoriesId.categoriesId.name).appendTo($tr);
                        $("<td/>").html(resp.childSubCategoriesId.subCategoriesId.name).appendTo($tr);
                        $("<td/>").html(resp.childSubCategoriesId.name).appendTo($tr);
                        $("<td/>").html(resp.size).appendTo($tr);
                        $("<td/>").html(resp.quantity).appendTo($tr);
                        $("<td/>").html(resp.childSubCategoriesId.price).appendTo($tr);
                        $("<td/>").html(resp.quantity * resp.childSubCategoriesId.price).appendTo($tr);

                        $tbody.append($tr);

                    });

                });


            });


        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>

</html>
