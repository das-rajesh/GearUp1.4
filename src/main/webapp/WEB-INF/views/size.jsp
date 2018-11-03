<%@include file="shared/header.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h2 class="page-header">Size Entry Form</h2>
    <h3 class="page-header">General Data</h3>
    <div class="col-md-4">




        <form id="add-size" >
            <style type="text/css">
                .red option{
                    background-color:  red;
                }
            </style>
            <div class="form-group">
                <label for="exampleFormControlSelect1">ChildSubCategory</label>
                <select class="form-control red" id="select-child-sub-category-id" name="childSubCategoriesId.id" id="exampleFormControlSelect1">
                    <option>Select ChildSubCategory</option>

                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Size</label>
                <select class="form-control" id="select-size" name="size" id="exampleFormControlSelect1">
                    <option>Select Size</option>
                    <option>S</option>
                    <option>M</option>
                    <option>X</option>
                    <option>XL</option>
                    <option>XXL</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlFile1">Quantity</label>
                <input type="text" id="quantity-form" class="form-control" name="quantity"  >
            </div>
            <input type="hidden" id="select-size-id" name="id" />
            <button id="save-btn" type="submit" class="btn btn-fill btn-primary">Save</button>
        </form>
    </div>
    <div class="col-md-8">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table tablesorter " id="table">
                    <thead class=" text-primary">
                        <tr>
                            <th>
                                Id
                            </th>
                            <th>
                                Category
                            </th>  <th>
                                Sub-Category
                            </th>  <th>
                                Child-Sub-Category
                            </th> 
                            <th>
                                Size
                            </th>
                            <th>
                                Quantity
                            </th>
                            <th>
                                Action
                            </th>

                        </tr>
                    </thead>
                    <tbody id="t-body">


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    renderRow();

    var $childSubCatSelect = $("#select-child-sub-category-id");
    $childSubCatSelect.find('option').remove();
    $childSubCatSelect.append($('<option/>').html('Select ChildSubCategory'));
    $.getJSON("/admin/api/childSubcategory", function (res) {
     //   console.log(res);
        $.each(res, function (i, resp) {
               //  alert(resp.name);

            $opt = $('<option/>').val(resp.id).text(resp.name);
            $opt.appendTo($childSubCatSelect);

        });

    });
    function deleteB($deleteBtn) {
        if (confirm('Are You sure want to delete')) {
            $id = $deleteBtn.attr('data-id');
            $.post('/admin/size/delete', {id: $id}, function (res) {
                //   $(".table").dataTable().fnDestroy();
                if (res) {
                    // $(".table").dataTable().fnDestroy();
                    $('#t-body').empty();

                    renderRow();
                }
            });

        }
    }

    function editB($editeBtn) {
       // alert('edit');
        $id = $editeBtn.attr('data-id');
        $size = $editeBtn.attr('data-size');alert($size);
        $childSubCategoryid = $editeBtn.attr('data-childSubCategoriesId-id');
        $quantity = $editeBtn.attr('data-quantity');
       // alert($childSubCategoryid);
        $('#select-child-sub-category-id').val($childSubCategoryid);
        $('#quantity-form').val($quantity);
        $('#select-size').val($size);
        $('#select-size-id').val($id);




    }
    $("#save-btn").on('click', function () {
        // alert('hello');
        var $formData = $("#add-size").serialize();
        console.log($formData);

        $.post('/admin/size/add-data', $formData, function (res) {
            document.forms['add-size'].reset();
            console.log($formData);
            $('#t-body').empty();
            renderRow();
        });
        return false;
    });

    function  renderRow() {
        $.getJSON("/admin/api/size", function (res) {
            $.each(res, function (i, resp) {
                var $tr = $("<tr/>");
                var $tbody = $("#t-body");
                console.log(resp);
//                              
                //alert( resp.size1List.id);
                // console.log(resp.childSubCategoriesId);
                $("<td/>").html(i + 1).appendTo($tr);
                $("<td/>").html(resp.childSubCategoriesId.subCategoriesId.categoriesId.name).appendTo($tr);
                $("<td/>").html(resp.childSubCategoriesId.subCategoriesId.name).appendTo($tr);
                $("<td/>").html(resp.childSubCategoriesId.name).appendTo($tr);
                $("<td/>").html(resp.size).appendTo($tr);
                $("<td/>").html(resp.quantity).appendTo($tr);
                var $editeBtn = $('<a class="btn btn-sm btn-primary"/>')
                        .attr('data-childSubCategoriesId-id', resp.childSubCategoriesId.id)
                        .attr('data-id', resp.id)
                        .attr('data-size', resp.size)
                        .attr('data-quantity', resp.quantity)
                        .html('<span class="glyphicon glyphicon-trash"/>');

                var $deleteBtn = $('<a class="btn btn-sm btn-danger"/>')
                        .attr('data-id', resp.id)
                        .html('<span class="glyphicon glyphicon-trash"/>');
                $($editeBtn).html('Edit').appendTo($tr);
                $($deleteBtn).html('Delete').appendTo($tr);
                $tbody.append($tr);



                $deleteBtn.on('click', function () {
                    deleteB($deleteBtn);
                });
                $editeBtn.on('click', function () {
                    editB($editeBtn);
                });

            });

        });
    }

</script>

<%@include file="shared/footer.jsp" %>
