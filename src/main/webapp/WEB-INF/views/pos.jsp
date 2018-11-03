<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>gearup</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

        <!-- Latest compiled and minified CSS -->
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">

        <link href="../../assests/css/main_1.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <!-- navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">GearNepal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <div class="row w-100">
                    <div class="col-md-12 d-flex justify-content-between">
                        <ul class="navbar-nav nav-left">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Home
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                        </ul>
                        <ul class="navbar-nav nav-right">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Search</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="wrapper" id="landing">
            <div class="row">
                <div class="col-md-4">
                    <div class="row my-3">
                        <div class="col-md-12 card mb-2 p-3 list">
                            <table class="table table-hover table-striped">
                                <thead>
                                <th>SKU</th>
                                <th>Detail</th>
                                <th>Quantity</th>
                                <th>Size</th>
                                <th>Price</th>
                                <th>Remove</th>
                                </thead>
                                <tbody id="bill-body">

                                </tbody>

                            </table>



                        </div>
                        <div class="col-md-12 card p-3 total">
                            <div class="row">
                                <div class="col-md-6">
                                    <p>
                                        <strong >SubTotal</strong>
                                    </p>
                                    <p>Tax</p>
                                    <p>Items</p>
                                </div>
                                <div class="col-md-6">
                                    <p>
                                        <strong id="sub-total">6.98</strong>
                                    </p>
                                    <p>0.67</p>
                                    <p>1</p>
                                </div>
                                <div class="col-md-12">
                                    <button type="submit" id="purchase-btn" class="btn btn-info w-100">
                                        <i class="fas fa-shopping-cart" ></i> Purchase
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8 card m-3 p-3 products">
                    <ul class="nav nav-pills mb-3" id="category-tab" role="tablist">
                        <li class="nav-item mx-2">
                            <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#helmet" role="tab" aria-controls="helmet" aria-selected="true">Helmet</a>
                        </li>

                    </ul>
                    <hr>
                    <div class="tab-content" id="pills-tabContent">
                        <div class="tab-pane fade show active" id="sub-category-list" role="tabpanel" aria-labelledby="pills-home-tab">
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <script src="../../assests/js/main.js" type="text/javascript"></script>
        <script>

            $(document).ready(function () {

                var $tr = $("<tr/>");
                var $forBody = $("#form-test-data");

                $("<td/>").html('<form:input type="text" id = voteValue name="voteValue" value="1" />One').appendTo($tr);
                $("<td/>").html('<form:input type="text" id = voteValue name="voteValue" value="1" />Two').appendTo($tr);
                $("<td/>").html('<form:input type="text" id = voteValue name="voteValue" value="1" />THree').appendTo($tr);
                $forBody.append($tr);


                $.getJSON("/admin/api/category", function (res) {
                    var totalBillPrice = 0;
                    var totalBillQnt = 0;
                    $.each(res, function (i, resp) {
                        var $categoryBtn = $('<li class="nav-item mx-2"><a class="nav-link " id="pills-home-tab" data-toggle="pill" href="#helmet" role="tab" aria-controls="helmet" aria-selected="true">' + resp.name + '</a></li>')
                                .attr('data-childSubCategoriesId-id', resp.id)
                                .attr('data-id', resp.id)
                                .attr('data-sub-category-list', resp.subCategoryList);
                        $categoryBtn.appendTo('#category-tab');
                        $categoryBtn.on('click', function () {
                            //  alert('really ' + resp.name);
                            var $subCategoryListSelect = $('#sub-category-list');
                            $subCategoryListSelect.empty($subCategoryListSelect);

                            $.each(resp.subCategoryList, function (i, suncategory) {
                                //  alert(resp.name);
                                $('<button class="btn btn-info m-1">' + suncategory.name + '</button>').appendTo($subCategoryListSelect);
                                $subCategoryListSelect.on('click', function () {
                                    //   alert('clicked');
                                    $subCategoryListSelect.empty($subCategoryListSelect);
                                    var i = 2;
                                    var g = 4;
                                    var $totaltprice = 0;

                                    $.each(suncategory.childCategoryModelNameList, function (i, childSuncategory) {
                                        $('<button class="btn btn-info m-1">' + childSuncategory.name + '</button>').appendTo($subCategoryListSelect);
                                        $subCategoryListSelect.on('click', function () {
                                            $subCategoryListSelect.empty($subCategoryListSelect);
                                            var $childCategoryListSelect = $('#sub-category-list');

                                            $.each(childSuncategory.size1List, function (i, childsize) {
                                                var $childdata = $('<button class="btn btn-info m-1">' + childsize.size + '</button>');
                                                $childdata.appendTo($childCategoryListSelect);
                                                $childdata.on('click', function () {
                                                    $subCategoryListSelect.empty($subCategoryListSelect);
                                                    var $tr = $("<tr/>");
                                                    var $tbody = $("#bill-body");

                                                    $("<td/>").html((i + 1)).appendTo($tr);
                                                    $("<td/>").html(childSuncategory.name).appendTo($tr);
                                                    $("<td/>").html('<form > <input type="number" min="0" id="qty-id-' + i + '" class="form-control" name="qty" value="1"></form>').appendTo($tr);
                                                    $("<td/>").html(childsize.size).appendTo($tr);
                                                    $("<td/>").html('<p id="change-price-id-" class="price-change-class">' + childSuncategory.price + '</p>').appendTo($tr);
                                                    var $deleteBtn = $('<a class="btn btn-sm btn-danger"/>')
                                                            .attr('data-id', childSuncategory.id)
                                                            .attr('size-id', childsize.id)
                                                            .html('<span class="glyphicon glyphicon-trash"/>');
                                                    $("<td/>").html($deleteBtn).appendTo($tr);
                                                    // $('<form:form/>').append($tr);
                                                    $tbody.append($tr);

                                                    $deleteBtn.on('click', function () {
                                                        if (confirm('Are You sure want to remove')) {
                                                            $tr.remove();
                                                        }
                                                    });



                                                    var $unitprice = parseInt(childSuncategory.price);
                                                    var $quantity = $('#qty-id-' + (i));
                                                    $("input").change(function () {
                                                        if (parseInt($(this).val()) > childsize.quantity) {

                                                            alert('No quantity above ' + childsize.quantity);
                                                            $(this).val(childsize.quantity);
                                                        } else if ($(this).val() == '') {
                                                            $(this).val('0');
                                                            $(this).parent().parent().parent().css("border", "3px double red");
                                                            $(this).parent().parent().parent().children().find('p').css("border", "3px double red");
                                                            var $money = $(this).parent().parent().parent().children().find('p').text($totaltprice);

                                                        } else {
                                                            $totaltprice = $unitprice * parseInt($(this).val());
                                                            //     alert($totaltprice);
                                                            $(this).parent().parent().parent().css("border", "3px double red");
                                                            $(this).parent().parent().parent().children().find('p').css("border", "3px double red");
                                                            var $money = $(this).parent().parent().parent().children().find('p').text($totaltprice);
                                                            //   alert($(this).parent().parent().parent().children().find('p').text());

                                                        }
                                                        totalBillPrice = parseInt($(this).parent().parent().parent().children().find('p').text());
                                                        $('#sub-total').html(totalBillPrice);

                                                    });
                                                    $("input").mouseup(function () {
                                                    });


                                                });
                                            });




                                        });

                                    });

                                });
                            });
                        });

                    });
                });

                $('#purchase-btn').on('click', function () {
                    var listCustomers = [];
//                    var formSize = {
//                        quantity: 'rajesh',
//                        price: '23',
//                        sizeId: '121'
//
//                    }
//                    for (var i = 0; i < 5; i++) {
//                        listCustomers.push(formCustomer);
//
//                    }

                    $('#bill-body td p').each(function () {
                        // alert('yes it has');
                        alert($(this).parent().parent().find('a').attr('size-id'));

                        alert($(this).html());
                        alert($(this).parent().parent().find('form').find('input').val());
                        var $quantity = $(this).parent().parent().find('form').find('input').val();
                        var $price = $(this).html();
                        var $sizeId = $(this).parent().parent().find('a').attr('size-id');
                        var formSize = {
                            quantity: $quantity,
                            price: $price,
                            sizeId: $sizeId

                        };
                        listCustomers.push(formSize);

                    });
                    
                      $.ajax({type : "POST",
			contentType : "application/json",
			accept: 'text/plain',
			url :  "/admin/sellreport/save",
			data : listCustomers,
			dataType: 'text',
			success : function(result) {
				// clear customer body
				
				// re-set customer table list
				listCustomers = [];
				
				// fill successfully message on view
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
//                 listCustomers.pop('modelAttribute','resultData');
//                 
//                    //console.log(listCustomers);
//                     var $formData = new FormData(listCustomers);
//                       //console.log($formData.serialize());
//
//                    $.post('/admin/sellreport/save', listCustomers, function (res) {
//                        //document.forms['add-size'].reset();
//                        console.log(res);
//                        alert('posting');
//                        $('#bill-body').empty();
//                    });
//                    return false;
//
////                    var $formData = $("#form-test-data").serialize();
////                    console.log($formData);
                });



                function generateSunCategory($categoryBtn) {
                    alert('what');
                    console.log($categoryBtn);
                    $subCategoryList = $categoryBtn.attr('data-sub-category-list');
                    alert($subCategoryList.size);
                    $.each($subCategoryList, function (i, resp) {
                        alert(resp.name);
                        $('<button class="btn btn-info m-1">subCategory</button>').appendTo($subCategoryListSelect);
                        var $billItem = $('<td>1101</td> <td>Chicken breast</td><td><form action=""><input type="number" class="form-control" name="qty" value="1"></form></td><td>size</td><td>6.99</td>');
                        $billItem.appendTo('#bill-form');
                    });

                }
            });


        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </body>

</html>